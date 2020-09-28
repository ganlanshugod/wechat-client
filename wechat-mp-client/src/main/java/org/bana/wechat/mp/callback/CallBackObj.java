/**
* @Company 全域旅游
* @Title: CallBackObj.java 
* @Package org.bana.wechat.mp.common 
* @author liuwenjie   
* @date Sep 28, 2020 10:54:03 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

/** 
* @ClassName: CallBackObj 
* @Description: 回调方法的请求参数对象
* @author liuwenjie   
*/
public abstract class CallBackObj implements Serializable{

	/** 
	* @Fields serialVersionUID 
	*/ 
	private static final long serialVersionUID = 1874000396417085914L;

	private String msgType;

	@XmlElement(name="MsgType")
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	
	
}
