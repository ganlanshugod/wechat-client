/**
* @Company 全域旅游
* @Title: ImageCallBackMessage.java 
* @Package org.bana.wechat.mp.callback.msg 
* @author liuwenjie   
* @date Sep 28, 2020 12:07:38 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: ImageCallBackMessage 
* @Description: 
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class ImageCallBackMessage extends CallBackMessage {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 3166471609875564997L;

	private String picUrl;
	private String mediaId;
	
	
	@XmlElement(name="PicUrl")
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@Override
	public String toString() {
		return "ImageCallBackMessage [picUrl=" + picUrl + ", mediaId=" + mediaId + ", getAppId()=" + getAppId()
				+ ", getOpenId()=" + getOpenId() + ", getCreateTime()=" + getCreateTime() + ", getMsgId()=" + getMsgId()
				+ ", getMsgType()=" + getMsgType() + "]";
	}

	
}
