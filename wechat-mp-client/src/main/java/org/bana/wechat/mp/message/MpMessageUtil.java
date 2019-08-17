/**
* @Company Elink   
* @Title: MpMessageUtil.java 
* @Package org.bana.wechat.mp.message 
* @author zhangzhichao   
* @date Aug 17, 2019 12:33:57 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.message;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/** 
* @ClassName: MpMessageUtil 
* @Description: 服务号消息工具类
* @author zhangzhichao   
*/
public class MpMessageUtil {
	/** 
	* @Description: xml转对象
	* @author zhangzhichao   
	* @date 2019-08-17 12:40:16 
	* @param <T>
	* @param xmlStr
	* @param clazz
	* @return  
	*/ 
	public static <T> T getFromXml(String xmlStr,Class<T> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            T xmlObject = (T)unmarshaller.unmarshal(sr);
            return xmlObject;
        } catch (JAXBException e) {
        	e.printStackTrace();
        }
        return null;
	}
	/** 
	* @Description: 对象转xml字符串
	* @author zhangzhichao   
	* @date 2019-08-17 12:40:59 
	* @param clazz
	* @param obj
	* @return  
	*/ 
	public static String getXmlFromObj(Class clazz,Object obj) {
        try {
        	JAXBContext context = JAXBContext.newInstance(clazz);    // 获取上下文对象  
            Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象  
              
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进  
              
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
			marshaller.marshal(obj, baos);
			String xmlObj = new String(baos.toByteArray());         // 生成XML字符串  
			xmlObj = xmlObj.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n", "");
		    return xmlObj;
		} catch (JAXBException e) {
			e.printStackTrace();
		} 
        return null;
	}
}
