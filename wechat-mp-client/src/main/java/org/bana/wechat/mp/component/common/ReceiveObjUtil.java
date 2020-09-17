/**
* @Company 全域旅游
* @Title: ReciveObjUtil.java 
* @Package org.bana.wechat.mp.component.common 
* @author liuwenjie   
* @date Sep 17, 2020 4:10:38 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.common;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.bana.wechat.common.util.BeanXmlUtil;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.component.param.ReceiveComponentTicket;
import org.bana.wechat.mp.component.param.ReceiveObj;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/** 
* @ClassName: ReciveObjUtil 
* @Description: 
* @author liuwenjie   
*/
public class ReceiveObjUtil {

	/**
	* @Description: 推送接收到信息方法
	* @author liuwenjie   
	* @date Sep 17, 2020 4:27:39 PM 
	* @param xmlStr
	* @return
	 */
	public static ReceiveObj parseXML(String xmlStr) {
		if(StringUtils.isBlank(xmlStr)) {
			return null;
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
		
			StringReader sr = new StringReader(xmlStr);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);
			Element root = document.getDocumentElement();
			NodeList infoNodeList = root.getElementsByTagName("InfoType");
			String infoType = infoNodeList.item(0).getTextContent();
			if("component_verify_ticket".equals(infoType)) {
				return BeanXmlUtil.xmlToBean(xmlStr, ReceiveComponentTicket.class);
			}else {
				throw new RuntimeException("不合法的接受的InfoType内容" + infoType);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new RuntimeException("解析失败xml数据失败",e);
		} catch (SAXException e) {
			e.printStackTrace();
			throw new RuntimeException("解析失败xml数据失败",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("解析失败xml数据失败",e);
		}
	}
}
