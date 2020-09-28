/**
* @Company 全域旅游
* @Title: LinkCallBackMessage.java 
* @Package org.bana.wechat.mp.callback.msg 
* @author liuwenjie   
* @date Sep 28, 2020 1:14:27 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: LinkCallBackMessage 
* @Description: 
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class LinkCallBackMessage extends CallBackMessage{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 8454018320370656543L;

	private String title; //<Title><![CDATA[公众平台官网链接]]></Title>
	private String description; //<Description><![CDATA[公众平台官网链接]]></Description>
	private String url; //<Url><![CDATA[url]]></Url>
	
	@XmlElement(name="Title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlElement(name="Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElement(name="Url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "LinkCallBackMessage [title=" + title + ", description=" + description + ", url=" + url + ", getAppId()="
				+ getAppId() + ", getOpenId()=" + getOpenId() + ", getCreateTime()=" + getCreateTime() + ", getMsgId()="
				+ getMsgId() + ", getMsgType()=" + getMsgType() + "]";
	}
	
}
