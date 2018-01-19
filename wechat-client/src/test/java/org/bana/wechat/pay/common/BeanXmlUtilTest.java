/**
* @Company 青鸟软通   
* @Title: BeanXmlUtilTest.java 
* @Package org.bana.wechat.pay.common 
* @author Liu Wenjie   
* @date 2015-9-17 下午7:27:46 
* @version V1.0   
*/ 
package org.bana.wechat.pay.common;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.sf.json.JSONObject;

import org.bana.wechat.pay.order.domain.UnifiedOrderDomain;
import org.junit.Test;

/** 
 * @ClassName: BeanXmlUtilTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class BeanXmlUtilTest {
	
	@Test
	public void testToBean() throws JAXBException{
		String xmlStr = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[缺少参数]]></return_msg></xml>";
		JAXBContext context = JAXBContext.newInstance(UnifiedOrderDomain.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		UnifiedOrderDomain result = (UnifiedOrderDomain)unmarshaller.unmarshal(new StringReader(xmlStr));
		System.out.println(result);
	}
	
	@Test
	public void testJson(){
		JSONObject json = JSONObject.fromObject("{'openId':'2342342','test':'2342'}");
		System.out.println(json.has("UserId"));
		System.out.println(json.has("openId"));
	}

}
