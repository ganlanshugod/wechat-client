/**
 * @Company JBINFO
 * @Title: ReceiveSuiteTicketTest.java
 * @Package org.bana.wechat.cp.callback.result.ticket
 * @author Liu Wenjie
 * @date 2018年1月26日 上午10:36:39
 * @version V1.0
 */
package org.bana.springboot.wechat.cp.callback.listner;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.bana.springboot.wechat.cp.WechatCpAutoConfiguration;
import org.bana.springboot.wechat.cp.WechatCpProperties;
import org.bana.springboot.wechat.cp.WechatCpTestConfig;
import org.bana.wechat.common.util.BeanXmlUtil;
import org.bana.wechat.cp.app.WechatAppManager;
import org.bana.wechat.cp.app.WechatCorpSuiteConfig;
import org.bana.wechat.cp.callback.BaseWechatCpCallbackHandler;
import org.bana.wechat.cp.callback.WechatCpCallbackHandler;
import org.bana.wechat.cp.callback.result.ticket.SuiteTicket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/**
 * @ClassName: ReceiveSuiteTicketTest
 * @Description: 测试suiteTicket回调的处理方法
 * @author Liu Wenjie
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={WechatCpTestConfig.class,WechatCpAutoConfiguration.class})
public class ReceiveSuiteTicketTest {
	
	private String callBackStr = "<xml>"+
        "<SuiteId><![CDATA[ww4asffe99e54c0f4c]]></SuiteId>"+
       " <InfoType> <![CDATA[suite_ticket]]></InfoType>"+
       " <TimeStamp>1403610513</TimeStamp>"+
       "<SuiteTicket><![CDATA[asdfasfdasdfasdf]]></SuiteTicket>"+
    "</xml>";
	
	@Autowired
	private WechatCpCallbackHandler callBackHandler;
	
	@Autowired
	private WechatAppManager wechatAppManager;
	
	@Autowired WechatCpProperties wechatCpProperties;
	
	private WXBizMsgCrypt wxCrypt;
	
	private String suiteId;
	
	@Before
	public void init(){
		suiteId = wechatCpProperties.getSuiteId();
		WechatCorpSuiteConfig suiteConfig = wechatAppManager.getSuiteConfig(suiteId);
		wxCrypt = new WXBizMsgCrypt(suiteConfig.getToken(), suiteConfig.getEncodingAesKey(), suiteId);
	}

	@Test
	public void test() {
		System.out.println(BeanXmlUtil.xmlToBean(callBackStr, SuiteTicket.class));
	}
	
	private HttpServletRequest initRequest() throws IOException{
		MockHttpServletRequest request = new MockHttpServletRequest(); //创建Mock对象
		String postData = "<xml>"+
				"<Encrypt><![CDATA[3TEt0eaGYmA9WYHRFsmWwrZPWyxXZMPQKkhNjvwd0Kh9Dh19bSsUBo7hj+a1RjQuK25akVqLkg3WVajHFlnQYEkNTlkN0050mpdrazglchvzMncU8QmsoAnpp6Uj5iw9HZhwDzDBBiWdebSb56QNUtSS6bFPyiSnk/j5mmVjZYurAY9VMxQ45cQxOod7jRZM0UW73PZslK+ve28AbasGErNnMC0V3rBsDWkIo/tGzbF+7q49wuEXY0VoD2n51Lu0zvX36Q2E+5fRysqmXOtI1z0jKd/IDeZm8kaL/KZHudQuhRXQ8BLx6/6WqAt4BRSNjSIiUkI6l/GZ8BZzTX5ROg==]]></Encrypt>"+
				"<ToUserName><![CDATA[ww4asffe99e54c0f4c]]></ToUserName>"+
				"<AgentID><![CDATA[toAgentID]]></AgentID>"+
				"</xml>";
		request.setContent(postData.getBytes("UTF-8")); //设置流的内容
		request.setCharacterEncoding("UTF-8");
		request.setParameter(BaseWechatCpCallbackHandler.PARAM_NONCE,"741159830");         //传入参数  
        request.setParameter(BaseWechatCpCallbackHandler.PARAM_SIGNATURE,"3d058933c288a128ce644094a795b7337f2d1985");   
        request.setParameter(BaseWechatCpCallbackHandler.PARAM_TIMESTAMP,"1403610513");   
        return request;
	}
	
	@Test
	public void testEncrypt(){
		String nonce = getRandomStr(9);
		String encryptMsg = wxCrypt.EncryptMsg(callBackStr, "1403610513", nonce);
		System.out.println(encryptMsg);
//		System.out.println(wxCrypt.DecryptMsg(msgSignature, timeStamp, nonce, postData));
	}
	
	@Test
	public void testDecrypt(){
		String postData = "<xml>"+
"<Encrypt><![CDATA[3TEt0eaGYmA9WYHRFsmWwrZPWyxXZMPQKkhNjvwd0Kh9Dh19bSsUBo7hj+a1RjQuK25akVqLkg3WVajHFlnQYEkNTlkN0050mpdrazglchvzMncU8QmsoAnpp6Uj5iw9HZhwDzDBBiWdebSb56QNUtSS6bFPyiSnk/j5mmVjZYurAY9VMxQ45cQxOod7jRZM0UW73PZslK+ve28AbasGErNnMC0V3rBsDWkIo/tGzbF+7q49wuEXY0VoD2n51Lu0zvX36Q2E+5fRysqmXOtI1z0jKd/IDeZm8kaL/KZHudQuhRXQ8BLx6/6WqAt4BRSNjSIiUkI6l/GZ8BZzTX5ROg==]]></Encrypt>"+
"<ToUserName><![CDATA[ww4asffe99e54c0f4c]]></ToUserName>"+
"<AgentID><![CDATA[toAgentID]]></AgentID>"+
"</xml>";
		String decryptMsg = wxCrypt.DecryptMsg("3d058933c288a128ce644094a795b7337f2d1985", "1403610513", "741159830", postData);
		System.out.println(decryptMsg);
	}
	
	@Test
	public void testHandleSuiteTieckt() throws IOException{
		callBackHandler.handleSuiteMessage(suiteId, initRequest());
	}
	
	public static String getRandomStr(int num){
		if(num <= 0){
			num = 16;
		}
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

}
