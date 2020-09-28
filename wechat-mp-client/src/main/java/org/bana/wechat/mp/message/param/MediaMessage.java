package org.bana.wechat.mp.message.param;

import javax.xml.bind.annotation.XmlElement;

/** 
* @ClassName: MediaMessage 
* @Description: 多媒体消息<br> 图片消息、语音消息直接用此类
*  
*/ 
public abstract class MediaMessage extends MessageParam{
	/**
	 * 通过上传多媒体文件，得到的id
	 */
	private String mediaId;

	
	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String toString() {
		return "MediaMessage [mediaId=" + mediaId + "]";
	}
	
}
