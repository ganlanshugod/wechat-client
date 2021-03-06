/**
 * @Company JBINFO
 * @Title: BaseWechatCpCallbackHandler.java
 * @Package org.bana.wechat.cp.callback
 * @author Liu Wenjie
 * @date 2018年1月25日 下午7:43:41
 * @version V1.0
 */
package org.bana.wechat.cp.callback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.bana.wechat.common.util.BeanXmlUtil;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.cp.app.WechatAppManager;
import org.bana.wechat.cp.app.WechatCorpAppConfig;
import org.bana.wechat.cp.app.WechatCorpSuiteConfig;
import org.bana.wechat.cp.callback.event.AuthCancelEvent;
import org.bana.wechat.cp.callback.event.AuthChangeEvent;
import org.bana.wechat.cp.callback.event.AuthCreateEvent;
import org.bana.wechat.cp.callback.event.CreateUpdateUserEvent;
import org.bana.wechat.cp.callback.event.SubscribeEvent;
import org.bana.wechat.cp.callback.event.SuiteTicketEvent;
import org.bana.wechat.cp.callback.event.UnsubscribeEvent;
import org.bana.wechat.cp.callback.result.auth.AuthChange;
import org.bana.wechat.cp.callback.result.auth.AuthCreate;
import org.bana.wechat.cp.callback.result.event.AgentMsg;
import org.bana.wechat.cp.callback.result.event.CreateUpdateUser;
import org.bana.wechat.cp.callback.result.ticket.SuiteTicket;
import org.bana.wechat.cp.common.WechatCpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/**
 * @ClassName: BaseWechatCpCallbackHandler
 * @Description: 微信回调消息的处理类
 * @author Liu Wenjie
 */
public class BaseWechatCpCallbackHandler implements WechatCpCallbackHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(BaseWechatCpCallbackHandler.class);

	private WechatAppManager wechatAppManager;
	
	private WechatCpEventPublisher wechatEventPublisher;
	
	public static final String PARAM_SIGNATURE = "msg_signature";
	
	public static final String PARAM_TIMESTAMP = "timestamp";

	public static final String PARAM_NONCE = "nonce";
	
	public static final String PARAM_ECHOSTR = "echostr";
	
	public static final String EVENT = "Event";
	public static final String CHANGE_TYPE = "ChangeType";
	
	
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月25日 下午7:43:41
	 * @param suiteId
	 * @param request
	 * @return
	 * @see org.bana.wechat.cp.callback.WechatCpCallbackHandler#handleSuiteMessage(java.lang.String, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String handleSuiteMessage(String suiteId, HttpServletRequest request) {
		if(StringUtils.isBlank(suiteId)){
			throw new WechatCpException(WechatCpException.CALLBACK_NO_SUITE,"没有指定suiteId对应");
		}
		WechatCorpSuiteConfig suiteConfig = wechatAppManager.getSuiteConfig(suiteId);
		if(suiteConfig == null){
			throw new WechatCpException(WechatCpException.CALLBACK_NO_SUITE_CONFIG,"没有找到suiteId="+suiteId+" 对应的配置信息");
		}
		String msgSignature = request.getParameter(PARAM_SIGNATURE);
		String timeStamp = request.getParameter(PARAM_TIMESTAMP);
		String nonce = request.getParameter(PARAM_NONCE);
		String echoStr = request.getParameter(PARAM_ECHOSTR);
		LOG.info("推送参数为msgSignature=" + msgSignature
				+",timeStamp="+timeStamp
				+",nonce="+nonce
				+",echoStr="+echoStr);
		if(StringUtils.isNotBlank(echoStr)){
			WXBizMsgCrypt wxcpt = getFirstWxcpt(suiteConfig);
			LOG.warn("suite" + suiteId + "首次推送成功");
			return wxcpt.verifyUrl(msgSignature, timeStamp, nonce, echoStr);
		}
		
		WXBizMsgCrypt wxcpt = getWxcpt(suiteConfig);
		
		try {
			InputStream is = request.getInputStream();
			String postData = getPostData(is);
			LOG.info("解密前的解密字符串为：" + postData);
			String decryptMsg = wxcpt.decryptMsg(msgSignature, timeStamp, nonce, postData);
			LOG.info("获取到的解密字符串为：" + decryptMsg);
			ResultType msgType = getMsgType(decryptMsg);
			return handleMessage(msgType,decryptMsg);
		} catch (IOException e) {
			e.printStackTrace();
			throw new WechatCpException(WechatCpException.CALLBACK_GETPOST, "获取回调内的postData异常",e);
		}
	}
	
	/**
	 * <p>Description: 企业微信自建应用回调消息内容</p>
	 * @author Zhang Zhichao
	 * @date 2018年4月9日 下午1:40:54
	 * @param corpId
	 * @param agentId
	 * @param request
	 * @return
	 * @see org.bana.wechat.cp.callback.WechatCpCallbackHandler#handleCorpMessage(java.lang.String, java.lang.String, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String handleCorpMessage(String corpId, String agentId, HttpServletRequest request) {
		// 非空校验
		if(StringUtils.isBlank(corpId)){
			throw new WechatCpException(WechatCpException.CALLBACK_NO_CORPID,"没有指定对应的corpId");
		}
		if(StringUtils.isBlank(agentId)){
			throw new WechatCpException(WechatCpException.CALLBACK_NO_AGENTID,"没有指定对应的agentId");
		}
		// 查询应用信息
		WechatCorpAppConfig corpAppConfig = wechatAppManager.getAppConfig(corpId, agentId);
		if(corpAppConfig==null){
			throw new WechatCpException(WechatCpException.CALLBACK_NO_APP_CONFIG,"没有找到corpId="+corpId+"，agentId="+agentId+" 对应的配置信息");
		}
		String msgSignature = request.getParameter(PARAM_SIGNATURE);
		String timeStamp = request.getParameter(PARAM_TIMESTAMP);
		String nonce = request.getParameter(PARAM_NONCE);
		String echoStr = request.getParameter(PARAM_ECHOSTR);
		LOG.info("自建应用接收消息：推送参数为msgSignature=" + msgSignature
				+",timeStamp="+timeStamp
				+",nonce="+nonce
				+",echoStr="+echoStr);
		if(StringUtils.isNotBlank(echoStr)){
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(corpAppConfig.getToken(), corpAppConfig.getEncodingAeskey(), corpId);
			LOG.warn("自建应用接收消息：corpId=" + corpId + "，agentId="+agentId+"首次推送成功");
			return wxcpt.verifyUrl(msgSignature, timeStamp, nonce, echoStr);
		}
		
		WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(corpAppConfig.getToken(), corpAppConfig.getEncodingAeskey(), corpId);
		
		try {
			InputStream is = request.getInputStream();
			String postData = getPostData(is);
			LOG.info("自建应用接收消息：解密前的解密字符串为：" + postData);
			String decryptMsg = wxcpt.decryptMsg(msgSignature, timeStamp, nonce, postData);
			LOG.info("自建应用接收消息：获取到的解密字符串为：" + decryptMsg);
			// 消息类型MsgType，此时固定为：event，通过Event区分不同的事件
			ResultType msgType = getDecryptMsgInfo(decryptMsg,CHANGE_TYPE);
			return handleMessage(msgType,decryptMsg);
		} catch (IOException e) {
			e.printStackTrace();
			throw new WechatCpException(WechatCpException.CALLBACK_GETPOST, "获取回调内的postData异常",e);
		}
	}
	
	/**
	 * Description: TODO (这里用一句话描述这个方法的作用)
	 * @author Liu Wenjie
	 * @date 2018年1月26日 下午8:12:16
	 * @param suiteConfig
	 * @return
	 */
	private WXBizMsgCrypt getFirstWxcpt(WechatCorpSuiteConfig suiteConfig) {
		return new WXBizMsgCrypt(suiteConfig.getToken(), suiteConfig.getEncodingAesKey(), suiteConfig.getCorpId());
	}

	/**
	 * Description: 实际处理返回结果数据
	 * @author Liu Wenjie
	 * @date 2018年1月26日 上午10:03:17
	 * @param msgType
	 * @param decryptMsg
	 * @return
	 */
	private String handleMessage(ResultType msgType, String decryptMsg) {
		switch (msgType) {
		case 推送suite_ticket协议:
			SuiteTicket suiteTicket = BeanXmlUtil.xmlToBean(decryptMsg, SuiteTicket.class);
			wechatEventPublisher.publishEvent(new SuiteTicketEvent(suiteTicket));
			break;
		case 推送授权回调:
			AuthCreate authCreate = BeanXmlUtil.xmlToBean(decryptMsg, AuthCreate.class);
			wechatEventPublisher.publishEvent(new AuthCreateEvent(authCreate));
			break;
		case 变更授权的通知:
			AuthChange authChange = BeanXmlUtil.xmlToBean(decryptMsg, AuthChange.class);
			wechatEventPublisher.publishEvent(new AuthChangeEvent(authChange));
			break;
		case 取消授权的通知:
			AuthChange authCancel = BeanXmlUtil.xmlToBean(decryptMsg, AuthChange.class);
			wechatEventPublisher.publishEvent(new AuthCancelEvent(authCancel));
			break;
		case 成员关注:
			AgentMsg subscribe = BeanXmlUtil.xmlToBean(decryptMsg, AgentMsg.class);
			wechatEventPublisher.publishEvent(new SubscribeEvent(subscribe));
			break;
		case 成员取消关注:
			AgentMsg unsubscribe = BeanXmlUtil.xmlToBean(decryptMsg, AgentMsg.class);
			wechatEventPublisher.publishEvent(new UnsubscribeEvent(unsubscribe));
			break;
		case 新增成员事件:
		case 更新成员事件:
			CreateUpdateUser createUpdateUser = BeanXmlUtil.xmlToBean(decryptMsg, CreateUpdateUser.class);
			wechatEventPublisher.publishEvent(new CreateUpdateUserEvent(createUpdateUser));
			break;
		default:
			throw new WechatCpException(WechatCpException.CALLBACK_HandleException,"没有实现的msgType类型["+msgType.getType()+"]");
		}
		return "success";
	}

	/**
	* @Description: 获取消息体的类型返回值
	* @author Liu Wenjie   
	* @date 2015-5-13 下午1:29:57 
	* @param msgBody
	* @return
	 */
	private static ResultType getMsgType(String decryptMsg){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(new InputSource(new StringReader(decryptMsg)));
			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("InfoType");
			if(nodelist1 == null || nodelist1.getLength() == 0 ){
				nodelist1 = root.getElementsByTagName("MsgType");
				if(nodelist1 == null || nodelist1.getLength() == 0){
					return ResultType.不支持;
				}
			}
			String textContent = nodelist1.item(0).getTextContent();
			return ResultType.getInstance(StringUtils.trim(textContent));
		} catch (Exception e) {
			e.printStackTrace();
			throw new WechatCpException(WechatCpException.CALLBACK_ParseTypeException, "解析返回值的类型异常",e);
		} 
	}
	
	/**
	 * Description: 根据解码的消息体获取对应xml节点的信息
	 * @author Zhang Zhichao
	 * @date 2018年4月9日 下午3:41:52
	 * @param decryptMsg
	 * @param msgNode
	 * @return
	 */
	private static ResultType getDecryptMsgInfo(String decryptMsg,String msgNode){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(new InputSource(new StringReader(decryptMsg)));
			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName(msgNode);
			if(nodelist1 == null || nodelist1.getLength() == 0 ){
				// 查找event信息
				nodelist1 = root.getElementsByTagName(EVENT);
				if(nodelist1 == null || nodelist1.getLength() == 0){
					// 查找MsgType信息
					nodelist1 = root.getElementsByTagName("MsgType");
					if(nodelist1 == null || nodelist1.getLength() == 0){
						return ResultType.不支持;
					}
				}
			}
			String textContent = nodelist1.item(0).getTextContent();
			return ResultType.getInstance(StringUtils.trim(textContent));
		} catch (Exception e) {
			e.printStackTrace();
			throw new WechatCpException(WechatCpException.CALLBACK_ParseTypeException, "解析返回值的类型异常",e);
		} 
	}
	
	private static String getPostData(InputStream is) throws IOException {
		StringBuilder responseBuilder = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String input;
		while ((input = in.readLine()) != null) {
			responseBuilder.append(input);
		}
		return responseBuilder.toString();
    }
	
	
	private WXBizMsgCrypt getWxcpt(WechatCorpSuiteConfig suiteConfig) {
		return new WXBizMsgCrypt(suiteConfig.getToken(), suiteConfig.getEncodingAesKey(), suiteConfig.getSuiteId());
	}
	
	/*=========getter and setter ============*/
	
	public void setWechatAppManager(WechatAppManager wechatAppManager) {
		this.wechatAppManager = wechatAppManager;
	}

	public void setWechatEventPublisher(WechatCpEventPublisher wechatEventPublisher) {
		this.wechatEventPublisher = wechatEventPublisher;
	}
	
	
}
