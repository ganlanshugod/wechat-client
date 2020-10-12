/**
* @Company 全域旅游
* @Title: CallBackController.java 
* @Package org.bana.springboot.wechat.mp.callback.controller 
* @author liuwenjie   
* @date Sep 29, 2020 11:06:55 AM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.callback.controller;

import javax.servlet.http.HttpServletRequest;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.callback.CallBackHandler;
import org.bana.wechat.mp.callback.CallBackObj;
import org.bana.wechat.mp.callback.CallBackObjUtil;
import org.bana.wechat.mp.callback.event.CallBackEvent;
import org.bana.wechat.mp.callback.msg.CallBackMessage;
import org.bana.wechat.mp.common.WXMpBizMsgCryptFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/** 
* @ClassName: CallBackController 
* @Description: 微信的公众号回调事件的处理接口
* @author liuwenjie   
*/
@RequestMapping("wechat/mp")
public class CallBackController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CallBackController.class);
	
	private static final String PARAM_TIMESTAMP = "timestamp";
	private static final String PARAM_NONCE = "nonce";
	private static final String PARAM_ENCRYPT_TYPE = "encrypt_type";
	private static final String PARAM_MSG_SIGNATURE = "msg_signature";
	private static final String PARAM_SIGNATURE = "signature";
	private static final String PARAM_OPENID = "openid";
	private static final String PARAM_ECHOSTR = "echostr";
	
	@Autowired
	private WXMpBizMsgCryptFactory wxMpBizMsgCryptFactory;
	
	@Autowired
	private CallBackHandler callBackHandler;

	
	@RequestMapping("callback/{APPID}")
	@ResponseBody
	public String callBack(HttpServletRequest request,@PathVariable("APPID")String appId,@RequestBody(required=false) String postData) {
		String timestamp = request.getParameter(PARAM_TIMESTAMP);
		String nonce = request.getParameter(PARAM_NONCE);
		String encryptType = request.getParameter(PARAM_ENCRYPT_TYPE);
		String msgSignature = request.getParameter(PARAM_MSG_SIGNATURE);
		String signature = request.getParameter(PARAM_SIGNATURE);
		String openId = request.getParameter(PARAM_OPENID);
		String echoStr = request.getParameter(PARAM_ECHOSTR);
		LOG.info("======收到自建类型的推送消息== timestamp=" + timestamp //[1601258242]
				+ "\n nonce=" + nonce //[1468299776]
				+ "\n encryptType=" + encryptType   // [aes]
				+ "\n msgSignature=" + msgSignature //[1753a985c230ae83b916abcb2b2bb7c3efeee945]
				+"\n signature=" + signature //[9ad3978410c79eb5022b7bf87bad11dc8434143a]
				+"\n openId=" + openId //[oTNO107-p12Cg05fnzL1-mccHzb4]
				+ "\n AppID=" + appId //null
				+ "\n postData=" + postData
				+ "\n echoStr=" + echoStr); 
		
		WXBizMsgCrypt wxBizMsgCrypt = null;
		if(StringUtils.isNoneBlank(encryptType)) {
			wxBizMsgCrypt = wxMpBizMsgCryptFactory.getWxBizMsgCrypt(appId);
		}
		
		
		// 验证url可访问
		if(StringUtils.isNoneBlank(echoStr)) {
			if(StringUtils.isNoneBlank(encryptType)) {
				return wxBizMsgCrypt.verifyUrl(signature, timestamp, nonce, echoStr);
			}else {
				return echoStr;
			}
		}
		
		
		// 如果解密参数不为空，则需要解密
		String decryptMsg = postData;
		if(StringUtils.isNoneBlank(encryptType)) {
			decryptMsg = wxMpBizMsgCryptFactory.getWxBizMsgCrypt(appId).decryptMsg(msgSignature, timestamp, nonce, postData);
			LOG.info("=====解密收到的消息为===" + decryptMsg);
		}
		
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
			if(StringUtils.isNoneBlank(result)) {
				if(StringUtils.isNoneBlank(encryptType)){
					long time = System.currentTimeMillis()/1000;
					String newtimeStamp = String.valueOf(time);
					String newNonce = StringUtils.getRandomStr();
					resultStr = wxBizMsgCrypt.encryptMsg(result, newtimeStamp, newNonce);
				}else {
					resultStr = result;
				}
			}
		}
		
		return resultStr;
	}
	
	
	
}
