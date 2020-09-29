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

import org.bana.wechat.mp.component.common.ReceiveObjUtil;
import org.bana.wechat.mp.component.common.WXMpCompBizMsgCryptFactory;
import org.bana.wechat.mp.component.common.WechatMpComponentTicketStore;
import org.bana.wechat.mp.component.handler.ReceiveMsgHandler;
import org.bana.wechat.mp.component.param.ReceiveAuthChange;
import org.bana.wechat.mp.component.param.ReceiveComponentTicket;
import org.bana.wechat.mp.component.param.ReceiveObj;
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
public class WechatMpCompReceiveController {
	
	private static final String PARAM_TIMESTAMP = "timestamp";
	private static final String PARAM_NONCE = "nonce";
	private static final String PARAM_ENCRYPT_TYPE = "encrypt_type";
	private static final String PARAM_MSG_SIGNATURE = "msg_signature";
	
	private static final Logger LOG = LoggerFactory.getLogger(WechatMpCompReceiveController.class);
	
	
	@Autowired 
	private WXMpCompBizMsgCryptFactory wxMpCompBizMsgCryptFactory;
	
	@Autowired
	private WechatMpComponentTicketStore wechatMpComponentTicketStore;
	
	@Autowired
	private ReceiveMsgHandler receiveMsgHandler;
	
	@RequestMapping("receive/{componentAppId}")
	@ResponseBody
	public String receive(HttpServletRequest request,@RequestBody String postData,@PathVariable("componentAppId") String componentAppId){
		String timestamp = request.getParameter(PARAM_TIMESTAMP);
		String nonce = request.getParameter(PARAM_NONCE);
		String encryptType = request.getParameter(PARAM_ENCRYPT_TYPE);
		String msgSignature = request.getParameter(PARAM_MSG_SIGNATURE);
		LOG.info("======收到推送消息== timestamp=" + timestamp
				+ "\n nonce=" + nonce
				+ "\n encryptType=" + encryptType
				+ "\n msgSignature=" + msgSignature
				+ "\n postData=" + postData
				+ "\n componentAppId=" + componentAppId);
		
		// 解密对应的推送消息
		WXBizMsgCrypt wxBizMsgCrypt = wxMpCompBizMsgCryptFactory.getWxBizMsgCrypt(componentAppId);
		String decryptMsg = wxBizMsgCrypt.decryptMsg(msgSignature, timestamp, nonce, postData);
		LOG.info("=====解密收到的消息为===" + decryptMsg);
		
		ReceiveObj receiveObj = ReceiveObjUtil.parseXML(decryptMsg);
		if(receiveObj != null) {
			if(receiveObj instanceof ReceiveComponentTicket) {
				ReceiveComponentTicket ticket = (ReceiveComponentTicket)receiveObj;
				wechatMpComponentTicketStore.putComponentVerifyTicket(componentAppId, ticket.getComponentVerifyTicket());
			}else if(receiveObj instanceof ReceiveAuthChange) {
				ReceiveAuthChange authChange = (ReceiveAuthChange)receiveObj;
				receiveMsgHandler.handleReceiveAuthChange(authChange);
			}
		}
		
//		<xml><AppId><![CDATA[wxe35ec229c4f65cd9]]></AppId>
//		<CreateTime>1600327988</CreateTime>
//		<InfoType><![CDATA[component_verify_ticket]]></InfoType>
//		<ComponentVerifyTicket><![CDATA[ticket@@@vYbvOZp4ViRUuqnlO54dKH-DftgoBdkrHTHKbdB1rZIv4u8LDyBL2G3Nz1O2oxeW0Pm7zr0JG3fMObROA_rZFg]]></ComponentVerifyTicket>
//		</xml>
		return "success";
	}
	
}
