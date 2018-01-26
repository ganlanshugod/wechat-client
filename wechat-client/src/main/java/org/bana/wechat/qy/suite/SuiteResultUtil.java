/**
* @Company 青鸟软通   
* @Title: SuiteResultUtil.java 
* @Package org.bana.wechat.qy.suite 
* @author Liu Wenjie   
* @date 2015-5-13 上午11:41:36 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite;

import java.io.StringReader;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.bana.common.util.basic.BeanXmlUtil;
import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.cp.suite.domain.ReceiveSuitResult;
import org.bana.wechat.cp.suite.domain.ReceiveSuiteTicket;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.kefu.param.Receiver;
import org.bana.wechat.qy.suite.domain.CallBackResult;
import org.bana.wechat.qy.suite.domain.ContactChangeResult;
import org.bana.wechat.qy.suite.domain.ContactSyncResult;
import org.bana.wechat.qy.suite.domain.KefuCallBackResult;
import org.bana.wechat.qy.suite.domain.MessageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


/** 
 * @ClassName: SuiteResultUtil 
 * @Description: 微信返回的结果在解密之后，是xml的格式，此方法的结果
 *  
 */
public class SuiteResultUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(SuiteResultUtil.class);
	/** 
	* @ClassName: ReulstType 
	* @Description:返回值结果类型
	*  
	*/ 
	public static enum ResultType{
		通讯录变更通知("contact_sync"),
		企业微信通讯录变更通知("change_contact"),
		推送suite_ticket协议("suite_ticket"),
		变更授权的通知("change_auth"),
		取消授权的通知("cancel_auth"),
		触发的事件("event"),
		推送授权回调("create_auth"),
		普通消息("text","image","voice","video","shortvideo","location","link"),
		不支持("");
		
		private String[] type;
		private ResultType(String... type){
			this.type = type;
		}
		/**
		 * @Description: 属性 type 的get方法 
		 * @return type
		 */
		public String[] getType() {
			return type;
		}
		
		public static ResultType getInstance(String type){
			ResultType[] values = ResultType.values();
			for (ResultType resultType : values) {
				if(Arrays.asList(resultType.getType()).contains(type)){
					return resultType;
				}
			}
			return ResultType.不支持;
		}
		
	}
	
	/** 
	* @Description: 解析推送信息，返回接口
	* @author Liu Wenjie   
	* @date 2015-5-13 上午11:55:36 
	* @return  
	*/ 
	public static Object parseXmlToObject(String msgBody){
		if(StringUtils.isBlank(msgBody)){
			return null;
		}
		//判断消息体格式符合那个结果集，根据结果集进行不同对象的转化
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		StringReader sr = new StringReader(msgBody);
		InputSource is = new InputSource(sr);
		Document document;
		try {
			db = dbf.newDocumentBuilder();
			document = db.parse(is);
			Element root = document.getDocumentElement();
			ResultType msgType = getMsgType(root);
			Object suiteResult = null;
			switch (msgType) {
			case 推送suite_ticket协议:
				suiteResult = parseResultToReceiveSuiteToken(root);
				break;
			case 变更授权的通知:
			case 取消授权的通知:
				suiteResult = parseResultToReceiveSuiteResult(msgBody);
				break;
			case 触发的事件:
				suiteResult = parseResultToEventCallBack(root);
				break;
			case 通讯录变更通知:
				suiteResult = parseResultToContactSyncCallBack(root);
				break;
			case 企业微信通讯录变更通知:
				suiteResult = parseResultToContactChangeCallBack(msgBody);
				break;
			case 普通消息:
				suiteResult = parseResultToMessageCallBack(msgBody);
				break;
			case 推送授权回调:
				suiteResult = BeanXmlUtil.xmlToBean(msgBody, ReceiveSuitResult.class);
				break;
			default:
				throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"解析微信返回结果时，还不支持的类型，内容为"+msgBody);
			}
			LOG.info("微信推送的消息解析后的结果为" + suiteResult);
			return suiteResult;
		} catch (Exception e) {
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"解析微信返回结果时，出现异常",e);
		}
	}

	/**
	 * 新的企业微信通讯录变更通知
	 * @param msgBody
	 * @return
	 */
	private static Object parseResultToContactChangeCallBack(String msgBody) {
		ContactChangeResult callBackResult = BeanXmlUtil.xmlToBean(msgBody, ContactChangeResult.class);
		return callBackResult;
	}


	/** 
	* @Description:解析通讯录变更
	* @author Richard Core   
	* @date 2016-4-19 下午4:48:49 
	* @param root
	* @return  
	*/ 
	private static Object parseResultToContactSyncCallBack(Element root) {
		ContactSyncResult result = new ContactSyncResult();
		NodeList suiteIdList = root.getElementsByTagName("SuiteId");
		if(suiteIdList != null && suiteIdList.getLength() > 0){
			result.setSuiteId(StringUtils.trim(suiteIdList.item(0).getTextContent()));
		}
		//InfoType
		NodeList typeNodeList = root.getElementsByTagName("InfoType");
		if(typeNodeList != null && typeNodeList.getLength() > 0){
			result.setInfoType(StringUtils.trim(typeNodeList.item(0).getTextContent()));
		}
		//TimeStamp
		NodeList timeNodeList = root.getElementsByTagName("TimeStamp");
		if(timeNodeList != null && timeNodeList.getLength() > 0){
			result.setTimeStamp(Long.parseLong(timeNodeList.item(0).getTextContent()));
		}
		NodeList seqList = root.getElementsByTagName("Seq");
		if(seqList != null && seqList.getLength() > 0){
			result.setSeq(Integer.valueOf(StringUtils.trim(seqList.item(0).getTextContent())));
		}
		NodeList authCorpIdList = root.getElementsByTagName("AuthCorpId");
		if(authCorpIdList != null && authCorpIdList.getLength() > 0){
			result.setAuthCorpId(StringUtils.trim(authCorpIdList.item(0).getTextContent()));
		}
		return result;
	}


	/** 
	* @Description: 把消息体内容转化为对象
	* @author Liu Wenjie   
	* @date 2015-10-9 下午1:53:34 
	* @param msgBody
	* @return  
	*/ 
	private static CallBackResult parseResultToMessageCallBack(String msgBody) {
		CallBackResult callBackResult = BeanXmlUtil.xmlToBean(msgBody, CallBackResult.class);
		return callBackResult;
	}


	/** 
	* @Description: 将变更授权的方法转化为ReceiveSuiteResult对象
	* @author Liu Wenjie   
	* @date 2015-10-8 下午3:12:56 
	* @param msgBody
	* @return  
	*/ 
	private static ReceiveSuitResult parseResultToReceiveSuiteResult(String msgBody) {
		ReceiveSuitResult receiveResult = BeanXmlUtil.xmlToBean(msgBody, ReceiveSuitResult.class);
		return receiveResult;
	}


	/** 
	* @Description: 构造返回值结果
	* @author Liu Wenjie   
	* @date 2015-6-11 下午12:08:00 
	* @param root
	* @return  
	*/ 
	private static CallBackResult parseResultToEventCallBack(Element root) {
		CallBackResult result = new CallBackResult();
		initDefaultCallBackResult(result,root);
		return result;
	}


	/** 
	* @Description: 构造默认的几个属性
	* @author Liu Wenjie   
	* @date 2015-6-11 下午12:09:29 
	* @param result
	* @param root  
	*/ 
	private static void initDefaultCallBackResult(CallBackResult result, Element root) {
		//EventKey
		NodeList eventKeyNodeList = root.getElementsByTagName("EventKey");
		if(eventKeyNodeList != null && eventKeyNodeList.getLength() > 0){
			result.setEventKey(StringUtils.trim(eventKeyNodeList.item(0).getTextContent()));
		}
		//FromUserName
		NodeList fromUserNodeList = root.getElementsByTagName("FromUserName");
		if(fromUserNodeList != null && fromUserNodeList.getLength() > 0){
			result.setFromUserName(StringUtils.trim(fromUserNodeList.item(0).getTextContent()));
		}
		//CreateTime
		NodeList createTimeNodeList = root.getElementsByTagName("CreateTime");
		if(createTimeNodeList != null && createTimeNodeList.getLength() > 0){
			result.setCreateTime(Long.parseLong(StringUtils.trim(createTimeNodeList.item(0).getTextContent())));
		}
		//MsgType
		NodeList msgTypeNodeList = root.getElementsByTagName("MsgType");
		if(msgTypeNodeList != null && msgTypeNodeList.getLength() > 0){
			result.setMsgType(StringUtils.trim(msgTypeNodeList.item(0).getTextContent()));
		}
		//Event
		NodeList eventNodeList = root.getElementsByTagName("Event");
		if(eventNodeList != null && eventNodeList.getLength() > 0){
			result.setEvent(StringUtils.trim(eventNodeList.item(0).getTextContent()));
		}
		//AgentID
		NodeList agentIdNodeList = root.getElementsByTagName("AgentID");
		if(agentIdNodeList != null && agentIdNodeList.getLength() > 0){
			result.setAgentId(StringUtils.trim(agentIdNodeList.item(0).getTextContent()));
		}
		//ToUserName
		NodeList toUserNodeList = root.getElementsByTagName("ToUserName");
		if(toUserNodeList != null && toUserNodeList.getLength() > 0){
			result.setToUserName(StringUtils.trim(toUserNodeList.item(0).getTextContent()));
		}
	}

	/** 
	* @Description: 解析对应的返回值结果
	* @author Liu Wenjie   
	* @date 2015-5-13 下午2:38:05 
	* @param root
	* @return  
	*/ 
	private static ReceiveSuitResult parseResultToReceiveSuiteToken(Element root) {
		ReceiveSuiteTicket result = new ReceiveSuiteTicket();
		initDefaultResult(root,result);
		
		//SuiteTicket
		NodeList ticketNodeList = root.getElementsByTagName("SuiteTicket");
		if(ticketNodeList != null && ticketNodeList.getLength() > 0){
			result.setSuiteTicket(StringUtils.trim(ticketNodeList.item(0).getTextContent()));
		}
		return result;
	}

	/** 
	* @Description: 初始化公共的返回值结果
	* @author Liu Wenjie   
	* @date 2015-5-13 下午2:45:05 
	* @param root
	* @param result  
	*/ 
	private static void initDefaultResult(Element root, ReceiveSuitResult result) {
		//SuiteId
		NodeList idNodeList = root.getElementsByTagName("SuiteId");
		if(idNodeList != null && idNodeList.getLength() > 0){
			result.setSuiteId(StringUtils.trim(idNodeList.item(0).getTextContent()));
		}
		//InfoType
		NodeList typeNodeList = root.getElementsByTagName("InfoType");
		if(typeNodeList != null && typeNodeList.getLength() > 0){
			result.setInfoType(StringUtils.trim(typeNodeList.item(0).getTextContent()));
		}
		//TimeStamp
		//InfoType
		NodeList timeNodeList = root.getElementsByTagName("TimeStamp");
		if(timeNodeList != null && timeNodeList.getLength() > 0){
			result.setTimeStamp(Long.parseLong(timeNodeList.item(0).getTextContent()));
		}
	}

	/**
	* @Description: 获取消息体的类型返回值
	* @author Liu Wenjie   
	* @date 2015-5-13 下午1:29:57 
	* @param msgBody
	* @return
	 */
	private static ResultType getMsgType(Element root){
		if(root == null){
			return ResultType.不支持;
		}
		NodeList nodelist1 = root.getElementsByTagName("InfoType");
		if(nodelist1 == null || nodelist1.getLength() == 0 ){
			nodelist1 = root.getElementsByTagName("MsgType");
			if(nodelist1 == null || nodelist1.getLength() == 0){
				return ResultType.不支持;
			}
		}
		String textContent = nodelist1.item(0).getTextContent();
		return ResultType.getInstance(StringUtils.trim(textContent));
	}

	/**
	* @Description: 解析客服消息对应的返回值结果
	* @author Yang Shuangshuang   
	* @date 2016-5-6 下午3:27:13 
	* @param clearPostData
	* @return
	 */
	public static KefuCallBackResult parseXmlToKefuCallBack(String clearPostData) {
		KefuCallBackResult result = new KefuCallBackResult();
		if(StringUtils.isBlank(clearPostData)){
			return null;
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		StringReader sr = new StringReader(clearPostData);
		InputSource is = new InputSource(sr);
		Document document;
		try {
			db = dbf.newDocumentBuilder();
			document = db.parse(is);
			Element root = document.getDocumentElement();
			//toUserName
			NodeList userNodeList = root.getElementsByTagName("ToUserName");
			if(userNodeList != null && userNodeList.getLength() > 0){
				result.setToUserName(StringUtils.trim(userNodeList.item(0).getTextContent()));
			}
			//AgentType
			NodeList agentNodeList = root.getElementsByTagName("AgentType");
			if(agentNodeList != null && agentNodeList.getLength() > 0){
				result.setAgentType(StringUtils.trim(agentNodeList.item(0).getTextContent()));
			}
			//PackageId
			NodeList packNodeList = root.getElementsByTagName("PackageId");
			if(packNodeList != null && packNodeList.getLength() > 0){
				result.setPackageId(StringUtils.trim(packNodeList.item(0).getTextContent()));
			}
			
			//ItemCount
			NodeList countNodeList = root.getElementsByTagName("ItemCount");
			if(countNodeList != null && countNodeList.getLength() > 0){
				result.setItemCount(Long.parseLong(countNodeList.item(0).getTextContent()));
			}
			
			MessageItem item=new MessageItem();
			//FromUserName
			NodeList fromUserNodeList = root.getElementsByTagName("FromUserName");
			if(fromUserNodeList != null && fromUserNodeList.getLength() > 0){
				item.setFromUserName(StringUtils.trim(fromUserNodeList.item(0).getTextContent()));
			}
			//time
			NodeList timeNodeList = root.getElementsByTagName("CreateTime");
			if(timeNodeList != null && timeNodeList.getLength() > 0){
				item.setCreateTime(Long.parseLong(timeNodeList.item(0).getTextContent()));
			}
			
			//msgType
			NodeList msgTypeNodeList = root.getElementsByTagName("MsgType");
			if(msgTypeNodeList != null && msgTypeNodeList.getLength() > 0){
				item.setMsgType(StringUtils.trim(msgTypeNodeList.item(0).getTextContent()));
			}
			
			//content
			NodeList contentNodeList = root.getElementsByTagName("Content");
			if(contentNodeList != null && contentNodeList.getLength() > 0){
				item.setContent(StringUtils.trim(contentNodeList.item(0).getTextContent()));
			}
			//msgId
			NodeList msgNodeList = root.getElementsByTagName("MsgId");
			if(msgNodeList != null && msgNodeList.getLength() > 0){
				item.setMsgId(StringUtils.trim(msgNodeList.item(0).getTextContent()));
			}
			
			//type
			Receiver receiver=new Receiver();
			NodeList typeNodeList = root.getElementsByTagName("Type");
			if(typeNodeList != null && typeNodeList.getLength() > 0){
				receiver.setType(StringUtils.trim(typeNodeList.item(0).getTextContent()));
			}
			//id
			NodeList idNodeList = root.getElementsByTagName("Id");
			if(idNodeList != null && idNodeList.getLength() > 0){
				receiver.setId(StringUtils.trim(idNodeList.item(0).getTextContent()));
			}
			item.setReceiver(receiver);
			//mediaId
			NodeList mediaNodeList = root.getElementsByTagName("MediaId");
			if(mediaNodeList != null && mediaNodeList.getLength() > 0){
				item.setMediaId(StringUtils.trim(mediaNodeList.item(0).getTextContent()));
			}
			result.setItem(item);
			return result;
		}catch (Exception e) {
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"解析微信返回结果时，出现异常",e);
		}
	}


	/**
	* @Description: 解析客服推送消息，返回结果
	* @author Yang Shuangshuang   
	* @date 2016-5-11 下午12:51:57 
	* @param postData
	* @return
	 */
	public static Object parseXmlToReceiveSuiteResult(String msgBody) {
		if(StringUtils.isBlank(msgBody)){
			return null;
		}
		//判断消息体格式符合那个结果集，根据结果集进行不同对象的转化
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		StringReader sr = new StringReader(msgBody);
		InputSource is = new InputSource(sr);
		Document document;
		try {
			db = dbf.newDocumentBuilder();
			document = db.parse(is);
			Element root = document.getDocumentElement();
			ResultType msgType = getMsgType(root);
			Object suiteResult = null;
			switch (msgType) {
			case 推送suite_ticket协议:
				suiteResult = parseResultToReceiveSuiteToken(root);
				break;
			case 变更授权的通知:
			case 取消授权的通知:
				suiteResult = parseResultToReceiveSuiteResult(msgBody);
				break;
			case 通讯录变更通知:
				suiteResult = parseResultToContactSyncSuiteResult(root);
				break;
			default:
				throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"解析微信返回结果时，还不支持的类型，内容为"+msgBody);
			}
			LOG.info("微信推送的消息解析后的结果为" + suiteResult);
			return suiteResult;
		} catch (Exception e) {
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"解析微信返回结果时，出现异常",e);
		}
	}


	/**
	* @Description:解析通讯录变更
	* @author Yang Shuangshuang   
	* @date 2016-5-11 下午2:18:46 
	* @param root
	* @return
	 */
	private static ReceiveSuitResult parseResultToContactSyncSuiteResult(Element root) {
		ReceiveSuitResult result = new ReceiveSuitResult();
		initDefaultResult(root,result);
		
        NodeList authCorpIdList = root.getElementsByTagName("AuthCorpId");
        if(authCorpIdList != null && authCorpIdList.getLength() > 0){
            result.setAuthCorpId(StringUtils.trim(authCorpIdList.item(0).getTextContent()));
        }
        return result;
	}
}
