/**
* @Company 全域旅游
* @Title: WechatMpController.java 
* @Package org.bana.springboot.wechat.mp.controller 
* @author liuwenjie   
* @date Sep 17, 2020 9:16:32 AM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.component.controller;

import javax.servlet.http.HttpServletRequest;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.callback.CallBackHandler;
import org.bana.wechat.mp.callback.CallBackObj;
import org.bana.wechat.mp.callback.CallBackObjUtil;
import org.bana.wechat.mp.callback.event.CallBackEvent;
import org.bana.wechat.mp.callback.msg.CallBackMessage;
import org.bana.wechat.mp.component.common.WXMpCompBizMsgCryptFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/** 
* @ClassName: WechatMpController 
* @Description: 
* @author liuwenjie   
*/
//@Controller
@RequestMapping("wechat/mpComponent")
public class WechatMpCompCallbackController {
	
	private static final String PARAM_TIMESTAMP = "timestamp";
	private static final String PARAM_NONCE = "nonce";
	private static final String PARAM_ENCRYPT_TYPE = "encrypt_type";
	private static final String PARAM_MSG_SIGNATURE = "msg_signature";
	private static final String PARAM_SIGNATURE = "signature";
	private static final String PARAM_OPENID = "openid";
	
	private static final Logger LOG = LoggerFactory.getLogger(WechatMpCompCallbackController.class);
	
	@Autowired 
	private WXMpCompBizMsgCryptFactory wxMpCompBizMsgCryptFactory;
	
	@Autowired
	private CallBackHandler callBackHandler;

	
	@RequestMapping("callback/{componentAppId}/{APPID}")
	@ResponseBody
	public String callBack(HttpServletRequest request,@PathVariable("componentAppId")String componentAppId,@PathVariable("APPID")String appId,@RequestBody String postData) {
		LOG.info("====callback 获取到的事件方法====="
				+ "request的参数");
		String timestamp = request.getParameter(PARAM_TIMESTAMP);
		String nonce = request.getParameter(PARAM_NONCE);
		String encryptType = request.getParameter(PARAM_ENCRYPT_TYPE);
		String msgSignature = request.getParameter(PARAM_MSG_SIGNATURE);
		String signature = request.getParameter(PARAM_SIGNATURE);
		String openId = request.getParameter(PARAM_OPENID);
		LOG.info("======收到推送消息== timestamp=" + timestamp //[1601258242]
				+ "\n nonce=" + nonce //[1468299776]
				+ "\n encryptType=" + encryptType   // [aes]
				+ "\n msgSignature=" + msgSignature //[1753a985c230ae83b916abcb2b2bb7c3efeee945]
				+"\n signature=" + signature //[9ad3978410c79eb5022b7bf87bad11dc8434143a]
				+"\n openId=" + openId //[oTNO107-p12Cg05fnzL1-mccHzb4]
				+ "\n AppID=" + appId //null
				+ "\n postData=" + postData); 
		//<xml><ToUserName><![CDATA[gh_d1fb40c6be3b]]></ToUserName>
//	    <Encrypt><![CDATA[MXnOlgkDzLthzUuGhF+jAxOPxUEN2BxPsCrOC8dDkd7LGH+fv4vuNj1bHSuoCNgKn6YxGERkS84bu20ux8si1K0ieXrIHX4oftm5V0602oQw9YEH3ov/Iiq56E3jDqp7pAJ/qvQ9gOHS4Dr9QX8qM8I37d6MQzoBcLhWyazhQ5qOBpT3+jWPCHoW96wG6nNZxfYuRp2jrU9oGaFqw7y9n+BQif8aq8gumHWzxp+fAQuctRGRdiIppIvowU1Rd9jD92tXHG2TKEsG6yDktAJ7NEWuHWr8GCponA9SXn/Rzm+IDcEFP4k/vPmd1kyf9l4ZFMXKstTIDAfDY4iIqb8UHMmbFbPCs+OST4qN5/7k+3gtvNoJLpQG5QkstHbhTy+FpdhEqPv86dBXFIB1glJFtfQf/wCVOMVaujV8vcdacr4=]]></Encrypt>
//	</xml>
		WXBizMsgCrypt wxBizMsgCrypt = wxMpCompBizMsgCryptFactory.getWxBizMsgCrypt(componentAppId);
		String decryptMsg = wxBizMsgCrypt.decryptMsg(msgSignature, timestamp, nonce, postData);
		LOG.info("=====解密收到的消息为===" + decryptMsg);
		/*<xml><ToUserName><![CDATA[gh_d1fb40c6be3b]]></ToUserName>
		<FromUserName><![CDATA[oTNO107-p12Cg05fnzL1-mccHzb4]]></FromUserName>
		<CreateTime>1601258242</CreateTime>
		<MsgType><![CDATA[text]]></MsgType>
		<Content><![CDATA[nsjna]]></Content>
		<MsgId>22924507975161625</MsgId>
		</xml>*/
		// TODO 这里为了防止多个应用同时处理请求，应该根据MsgId的值进行分布式加锁，防止并发处理
		CallBackObj callBackObj = CallBackObjUtil.parseXML(decryptMsg);
		String resultStr = "success";
		if(callBackObj != null) {
			String result = null;
			callBackObj.setAppId(appId);
			if(callBackObj instanceof CallBackMessage) {
				CallBackMessage msg = (CallBackMessage)callBackObj;
				result = callBackHandler.handleCallBackMessage(msg);
			}else if(callBackObj instanceof CallBackEvent) {
				CallBackEvent event = (CallBackEvent)callBackObj;
				result = callBackHandler.handleCallBackEvent(event);
			}
			if(!StringUtils.isBlank(result)) {
//				String beanToXml = BeanXmlUtil.beanToXml(result);
				long time = System.currentTimeMillis()/1000;
				String newtimeStamp = String.valueOf(time);
				String newNonce = StringUtils.getRandomStr();
				resultStr = wxBizMsgCrypt.encryptMsg(result, newtimeStamp, newNonce);
			}
		}
		
		return resultStr;
	}
}
