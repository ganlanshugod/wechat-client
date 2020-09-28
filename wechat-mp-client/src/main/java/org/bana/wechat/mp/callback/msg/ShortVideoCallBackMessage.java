/**
* @Company 全域旅游
* @Title: ShortVideoCallBackMessage.java 
* @Package org.bana.wechat.mp.callback.msg 
* @author liuwenjie   
* @date Sep 28, 2020 12:20:58 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: ShortVideoCallBackMessage 
* @Description: 
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class ShortVideoCallBackMessage extends CallBackMessage {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 7535272760970811248L;

	private String mediaId; // MediaId	视频消息媒体id，可以调用获取临时素材接口拉取数据。
	private String thumbMediaId; //ThumbMediaId	视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	
	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@XmlElement(name="ThumbMediaId")
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
	@Override
	public String toString() {
		return "VideoCallBackMessage [mediaId=" + mediaId + ", thumbMediaId=" + thumbMediaId + ", getAppId()="
				+ getAppId() + ", getOpenId()=" + getOpenId() + ", getCreateTime()=" + getCreateTime() + ", getMsgId()="
				+ getMsgId() + ", getMsgType()=" + getMsgType() + "]";
	}
}
