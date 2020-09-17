/**
* @Company 全域旅游
* @Title: ReceiveObjUtilTest.java 
* @Package org.bana.wechat.mp.component.common 
* @author liuwenjie   
* @date Sep 17, 2020 6:23:28 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.common;

import org.bana.wechat.mp.component.param.ReceiveObj;
import org.junit.Test;

/** 
* @ClassName: ReceiveObjUtilTest 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author liuwenjie   
*/
public class ReceiveObjUtilTest {

	@Test
	public void testParse() {
		
		String xmlStr = "<xml><AppId><![CDATA[wxe35ec229c4f65cd9]]></AppId>\n" + 
				"<CreateTime>1600327988</CreateTime>\n" + 
				"<InfoType><![CDATA[component_verify_ticket]]></InfoType>\n" + 
				"<ComponentVerifyTicket><![CDATA[ticket@@@vYbvOZp4ViRUuqnlO54dKH-DftgoBdkrHTHKbdB1rZIv4u8LDyBL2G3Nz1O2oxeW0Pm7zr0JG3fMObROA_rZFg]]></ComponentVerifyTicket>\n" + 
				"</xml>";
		ReceiveObj parseXML = ReceiveObjUtil.parseXML(xmlStr);
		System.out.println(parseXML);
	}

}
