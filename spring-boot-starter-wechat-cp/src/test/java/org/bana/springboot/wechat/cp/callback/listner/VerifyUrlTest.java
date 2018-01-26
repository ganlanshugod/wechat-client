/**
 * @Company JBINFO
 * @Title: VerifyUrlTest.java
 * @Package org.bana.springboot.wechat.cp.callback.listner
 * @author Liu Wenjie
 * @date 2018年1月26日 下午7:48:24
 * @version V1.0
 */
package org.bana.springboot.wechat.cp.callback.listner;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.bana.springboot.wechat.cp.WechatCpAutoConfiguration;
import org.bana.springboot.wechat.cp.WechatCpProperties;
import org.bana.springboot.wechat.cp.WechatCpTestConfig;
import org.bana.wechat.cp.callback.BaseWechatCpCallbackHandler;
import org.bana.wechat.cp.callback.WechatCpCallbackHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: VerifyUrlTest
 * @Description: 
 * msg_signature=68abfd112fcff017079afeea9feeb0963fad92bf,
 * timestamp=1516967201,
 * nonce=666588474,
 * echostr=VmHeo9+hTbiGsic8QxnenSFRgoazUjKhF2g+47ylkSLZh/CEoBt82kWd4jFHrBryz6484AsV7IzYZUoE1wVVjg==
 * @author Liu Wenjie
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={WechatCpTestConfig.class,WechatCpAutoConfiguration.class})
public class VerifyUrlTest {

	@Autowired
	private WechatCpCallbackHandler callBackHandler;
	
	@Autowired WechatCpProperties wechatCpProperties;
	
	private String suiteId;
	
	@Before
	public void init(){
		suiteId = wechatCpProperties.getSuiteId();
	}
	
	private HttpServletRequest initRequest() throws IOException{
		MockHttpServletRequest request = new MockHttpServletRequest(); //创建Mock对象
		request.setCharacterEncoding("UTF-8");
		request.setParameter(BaseWechatCpCallbackHandler.PARAM_NONCE,"666588474");         //传入参数  
        request.setParameter(BaseWechatCpCallbackHandler.PARAM_SIGNATURE,"68abfd112fcff017079afeea9feeb0963fad92bf");   
        request.setParameter(BaseWechatCpCallbackHandler.PARAM_TIMESTAMP,"1516967201");   
        request.setParameter(BaseWechatCpCallbackHandler.PARAM_ECHOSTR, "VmHeo9+hTbiGsic8QxnenSFRgoazUjKhF2g+47ylkSLZh/CEoBt82kWd4jFHrBryz6484AsV7IzYZUoE1wVVjg==");
        return request;
	}
	
	@Test
	public void testHandleSuiteTieckt() throws IOException{
		callBackHandler.handleSuiteMessage(suiteId, initRequest());
	}
}
