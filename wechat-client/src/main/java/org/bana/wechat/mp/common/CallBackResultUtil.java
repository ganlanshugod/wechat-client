/**
* @Company 青鸟软通   
* @Title: CallBackResultUtil.java 
* @Package org.bana.wechat.mp.common 
* @author Liu Wenjie   
* @date 2015-8-20 下午4:03:42 
* @version V1.0   
*/ 
package org.bana.wechat.mp.common;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.suite.SuiteResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/** 
 * @ClassName: CallBackResultUtil 
 * @Description: 解析回掉的结果
 *  
 */
public class CallBackResultUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(SuiteResultUtil.class);
	/** 
	* @ClassName: ReulstType 
	* @Description:返回值结果类型
	*  
	*/ 
	public static enum ResultType{
		取消授权的通知("cancel_auth"),
		触发的事件("event"),
		不支持("");
		
		private String type;
		private ResultType(String type){
			this.type = type;
		}
		/**
		 * @Description: 属性 type 的get方法 
		 * @return type
		 */
		public String getType() {
			return type;
		}
		
		public static ResultType getInstance(String type){
			ResultType[] values = ResultType.values();
			for (ResultType resultType : values) {
				if(resultType.getType().equalsIgnoreCase(type)){
					return resultType;
				}
			}
			return ResultType.不支持;
		}
		
	}

	/** 
	* @Description: 解析回调的结果
	* @author Liu Wenjie   
	* @date 2015-8-20 下午4:04:41 
	* @param msgBody
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
			case 取消授权的通知:
				break;
			case 触发的事件:
				suiteResult = parseResultToEventCallBack(root);
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
	* @Description: 构造返回值结果
	* @author Liu Wenjie   
	* @date 2015-6-11 下午12:08:00 
	* @param root
	* @return  
	*/ 
	private static Object parseResultToEventCallBack(Element root) {
		Map<String,String> result = new HashMap<String,String>();
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
	private static void initDefaultCallBackResult(Map<String,String> result, Element root) {
		//FromUserName
		NodeList fromUserNodeList = root.getElementsByTagName("FromUserName");
		if(fromUserNodeList != null && fromUserNodeList.getLength() > 0){
			result.put("FromUserName",StringUtils.trim(fromUserNodeList.item(0).getTextContent()));
		}
		//CreateTime
		NodeList createTimeNodeList = root.getElementsByTagName("CreateTime");
		if(createTimeNodeList != null && createTimeNodeList.getLength() > 0){
			result.put("CreateTime",StringUtils.trim(createTimeNodeList.item(0).getTextContent()));
		}
		//MsgType
		NodeList msgTypeNodeList = root.getElementsByTagName("MsgType");
		if(msgTypeNodeList != null && msgTypeNodeList.getLength() > 0){
			result.put("MsgType",StringUtils.trim(msgTypeNodeList.item(0).getTextContent()));
		}
		//Event
		NodeList eventNodeList = root.getElementsByTagName("Event");
		if(eventNodeList != null && eventNodeList.getLength() > 0){
			result.put("Event",StringUtils.trim(eventNodeList.item(0).getTextContent()));
		}
		//ToUserName
		NodeList toUserNodeList = root.getElementsByTagName("ToUserName");
		if(toUserNodeList != null && toUserNodeList.getLength() > 0){
			result.put("ToUserName",StringUtils.trim(toUserNodeList.item(0).getTextContent()));
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
}
