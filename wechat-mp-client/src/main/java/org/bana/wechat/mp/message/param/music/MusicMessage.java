/**
* @Company 全域旅游
* @Title: MusiceMessage.java 
* @Package org.bana.wechat.mp.message.param 
* @author liuwenjie   
* @date Sep 28, 2020 3:27:48 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.message.param.music;

import javax.xml.bind.annotation.XmlElement;

import org.bana.wechat.mp.message.param.MessageParam;

/** 
* @ClassName: MusiceMessage 
* @Description: 音乐消息
* @author liuwenjie   
*/
public class MusicMessage extends MessageParam {

	private String title;
	private String description;
	private String musicUrl;
	private String hqMusicUrl;
	private String thumbMediaId;
	
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
	
	@XmlElement(name="MusicUrl")
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	
	@XmlElement(name="HQMusicUrl")
	public String getHqMusicUrl() {
		return hqMusicUrl;
	}
	
	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
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
		return "MusiceMessage [title=" + title + ", description=" + description + ", musicUrl=" + musicUrl
				+ ", hqMusicUrl=" + hqMusicUrl + ", thumbMediaId=" + thumbMediaId + "]";
	}

}
