package org.bana.wechat.mp.message.param.news;

import javax.xml.bind.annotation.XmlElement;

/** 
* @ClassName: Article 
* @Description: 图文消息
*  
*/ 
public class Article {
	/**
	 * 图文消息名称
	 */
	private String title;

	/**
	 * 图文消息描述
	 */
	private String description;

	/**
	 * 图片链接，支持JPG、PNG格式，<br>
	 * 较好的效果为大图640*320，小图80*80
	 */
	private String picUrl;

	/**
	 * 点击图文消息跳转链接
	 */
	private String url;

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

	@XmlElement(name="PicUrl")
	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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
		return "Article [title=" + title + ", description=" + description + ", picUrl=" + picUrl + ", url=" + url + "]";
	}

}