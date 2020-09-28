/**
* @Company 全域旅游
* @Title: TextCallBackMessage.java 
* @Package org.bana.wechat.mp.callback.msg 
* @author liuwenjie   
* @date Sep 28, 2020 11:55:10 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: TextCallBackMessage 
* @Description: 
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class TextCallBackMessage extends CallBackMessage{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -1266507474505841331L;

	
	private String content;

	@XmlElement(name="Content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TextCallBackMessage [content=" + content + ", getAppId()=" + getAppId() + ", getOpenId()=" + getOpenId()
				+ ", getCreateTime()=" + getCreateTime() + ", getMsgId()=" + getMsgId() + ", getMsgType()="
				+ getMsgType() + "]";
	}
	
}
