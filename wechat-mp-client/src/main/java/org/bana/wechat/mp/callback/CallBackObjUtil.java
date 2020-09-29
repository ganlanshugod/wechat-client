/**
* @Company 全域旅游
* @Title: CallBackObjUtil.java 
* @Package org.bana.wechat.mp.common 
* @author liuwenjie   
* @date Sep 28, 2020 10:52:01 AM 
* @version V1.0   
*/
package org.bana.wechat.mp.callback;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.bana.wechat.common.util.BeanXmlUtil;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.callback.event.CallBackEvent;
import org.bana.wechat.mp.callback.event.ClickCallBackEvent;
import org.bana.wechat.mp.callback.event.LocationCallBackEvent;
import org.bana.wechat.mp.callback.event.ScanCallBackEvent;
import org.bana.wechat.mp.callback.event.SubscribeCallBackEvent;
import org.bana.wechat.mp.callback.event.UnsubscribeCallBackEvent;
import org.bana.wechat.mp.callback.event.ViewCallBackEvent;
import org.bana.wechat.mp.callback.msg.ImageCallBackMessage;
import org.bana.wechat.mp.callback.msg.LinkCallBackMessage;
import org.bana.wechat.mp.callback.msg.LocationCallBackMessage;
import org.bana.wechat.mp.callback.msg.ShortVideoCallBackMessage;
import org.bana.wechat.mp.callback.msg.TextCallBackMessage;
import org.bana.wechat.mp.callback.msg.VideoCallBackMessage;
import org.bana.wechat.mp.callback.msg.VoiceCallBackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @ClassName: CallBackObjUtil
 * @Description: 公众号消息和时间的回调方法内容解析
 * @author liuwenjie
 */
public class CallBackObjUtil {

	private static final Logger LOG = LoggerFactory.getLogger(CallBackObjUtil.class);
	/**
	 * @Description:
	 * @author liuwenjie
	 * @date Sep 28, 2020 10:53:43 AM
	 * @param xmlStr
	 * @return
	 */
	public static CallBackObj parseXML(String xmlStr) {
		if (StringUtils.isBlank(xmlStr)) {
			return null;
		}
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			StringReader sr = new StringReader(xmlStr);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);
			Element root = document.getDocumentElement();
			NodeList infoNodeList = root.getElementsByTagName("MsgType");
			String msgTypeStr = infoNodeList.item(0).getTextContent();
			CallBackMsgType msgType = CallBackMsgType.instance(msgTypeStr);
			switch(msgType) {
			case 文本:
				TextCallBackMessage textMsg = BeanXmlUtil.xmlToBean(xmlStr, TextCallBackMessage.class);
				return textMsg;
			case 图片:
				return BeanXmlUtil.xmlToBean(xmlStr, ImageCallBackMessage.class);
			case 语音:
				return BeanXmlUtil.xmlToBean(xmlStr, VoiceCallBackMessage.class);
			case 视频:
				return BeanXmlUtil.xmlToBean(xmlStr, VideoCallBackMessage.class);
			case 小视频:
				return  BeanXmlUtil.xmlToBean(xmlStr, ShortVideoCallBackMessage.class);
			case 地理位置:
				return  BeanXmlUtil.xmlToBean(xmlStr, LocationCallBackMessage.class);
			case 连接:
				return  BeanXmlUtil.xmlToBean(xmlStr, LinkCallBackMessage.class);
			case 事件:
				NodeList eventNode = root.getElementsByTagName("Event");
				String eventStr = eventNode.item(0).getTextContent();
				return parseEventCallBackObj(xmlStr,eventStr);
			default:
				LOG.warn("不支持的MSGType:"+msgTypeStr + xmlStr);
				throw new RuntimeException("不合法的接受的MsgType内容" + msgTypeStr + xmlStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("解析xml对象失败" + xmlStr, e);
		}
	}
	/** 
	* @Description: 解析事件类型的callback对象
	* @author liuwenjie   
	* @date Sep 29, 2020 10:38:06 AM 
	* @param xmlStr
	* @param eventStr
	* @return  
	*/ 
	private static CallBackEvent parseEventCallBackObj(String xmlStr, String eventStr) {
		CallBackEventType eventType = CallBackEventType.instance(eventStr);
		switch(eventType) {
		case 关注_含扫码:
			return BeanXmlUtil.xmlToBean(xmlStr, SubscribeCallBackEvent.class);
		case 取消关注:
			return BeanXmlUtil.xmlToBean(xmlStr, UnsubscribeCallBackEvent.class);
		case 扫码事件_已关注扫码:
			return BeanXmlUtil.xmlToBean(xmlStr, ScanCallBackEvent.class);
		case 上报位置:
			return BeanXmlUtil.xmlToBean(xmlStr, LocationCallBackEvent.class);
		case 点击自定义菜单事件:
			return BeanXmlUtil.xmlToBean(xmlStr, ClickCallBackEvent.class);
		case 点击自定义的连接菜单:
			return BeanXmlUtil.xmlToBean(xmlStr, ViewCallBackEvent.class);
		default:
			LOG.warn("不支持的事件类型:"+eventStr + xmlStr);
			throw new RuntimeException("不支持的callback事件类型:"+eventStr + xmlStr);
		}
	}
}
