/**
* @Company Elink   
* @Title: MaterialPageParam.java 
* @Package org.bana.wechat.mp.message.param 
* @author zhangzhichao   
* @date Aug 18, 2019 1:49:57 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.message.param;

import org.bana.wechat.mp.common.WeChatMpParam;

/** 
* @ClassName: CustomMsgMpParam 
* @Description: 客服消息 
* @author zhangzhichao   
*/
public class CustomMsgMpParam extends WeChatMpParam {

	private static final long serialVersionUID = 2370368619260276419L;
	
	private String touser; // openID
	private String msgtype; // 类型
	private String content; // 内容
	private String mediaId; // 素材
	private String title; // 外链图文，标题
	private String description; // 外链图文，描述
	private String url; // 外链图文，链接
	private String picurl; // 外链图文，封面
	private String musicUrl; //音乐url
	private String hqMusicUrl; //音乐hq url
	private String cardId;//卡券id
	private String miniAppId;//小程序id
	
	
	
	public String getMiniAppId() {
		return miniAppId;
	}
	public void setMiniAppId(String miniAppId) {
		this.miniAppId = miniAppId;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getMusicUrl() {
		return musicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	public String getHqMusicUrl() {
		return hqMusicUrl;
	}
	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	@Override
	public String toString() {
		return "CustomMsgMpParam [touser=" + touser + ", msgtype=" + msgtype + ", content=" + content + ", mediaId="
				+ mediaId + ", title=" + title + ", description=" + description + ", url=" + url + ", picurl=" + picurl
				+ "]";
	}
}
