/**
* @Company 全域旅游
* @Title: ReceiveObj.java 
* @Package org.bana.wechat.mp.component.param 
* @author liuwenjie   
* @date Sep 17, 2020 4:13:18 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.param;

import javax.xml.bind.annotation.XmlElement;

/** 
* @ClassName: ReceiveObj 
* @Description: 收到的消息对象
* @author liuwenjie   
*/
public class ReceiveObj {

	private String infoType;

	@XmlElement(name="InfoType")
	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	
}
