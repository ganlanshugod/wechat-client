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
			default:
				LOG.warn("不支持的MSGType:"+msgTypeStr + xmlStr);
				throw new RuntimeException("不合法的接受的MsgType内容" + msgTypeStr + xmlStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("解析xml对象失败" + xmlStr, e);
		}
	}
}
