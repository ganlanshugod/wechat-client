/**
* @Company 青鸟软通   
* @Title: Article.java 
* @Package org.bana.wechat.qy.message.param.news 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:32:03 
* @version V1.0   
*/ 
package org.bana.wechat.cp.message.param.news;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @ClassName: Article 
 * @Description: 
 *  
 */
@XmlRootElement(name="item")
public class Article {

	private String title;//	否	标题
	private String description;//	否	描述
	private String url;//	否	点击后跳转的链接。
	private String picurl;//	否	图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80。如不填，在客户端不显示图片
	/**
	 * @Description: 属性 title 的get方法 
	 * @return title
	 */
	@XmlElement(name="Title")
	public String getTitle() {
		return title;
	}
	/**
	 * @Description: 属性 title 的set方法 
	 * @param title 
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @Description: 属性 description 的get方法 
	 * @return description
	 */
	@XmlElement(name="Description")
	public String getDescription() {
		return description;
	}
	/**
	 * @Description: 属性 description 的set方法 
	 * @param description 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @Description: 属性 url 的get方法 
	 * @return url
	 */
	@XmlElement(name="Url")
	public String getUrl() {
		return url;
	}
	/**
	 * @Description: 属性 url 的set方法 
	 * @param url 
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @Description: 属性 picurl 的get方法 
	 * @return picurl
	 */
	@XmlElement(name="PicUrl")
	public String getPicurl() {
		return picurl;
	}
	/**
	 * @Description: 属性 picurl 的set方法 
	 * @param picurl 
	 */
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:32:55 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "Article [title=" + title + ", description=" + description + ", url=" + url + ", picurl=" + picurl + "]";
	}
	
}
