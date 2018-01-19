/**
* @Company 青鸟软通   
* @Title: Article.java 
* @Package org.bana.wechat.qy.message.param.mpnews 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:36:05 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message.param.mpnews;

/** 
 * @ClassName: Article 
 * @Description: mpnews消息
 *  
 */
public class Article {

	private String title;//	是	图文消息的标题
	private String thumb_media_id;//	是	图文消息缩略图的media_id, 可以在上传多媒体文件接口中获得。此处thumb_media_id即上传接口返回的media_id
	private String author;//	否	图文消息的作者
	private String content_source_url;//	否	图文消息点击“阅读原文”之后的页面链接
	private String content;//	是	图文消息的内容，支持html标签
	private String digest;//	否	图文消息的描述
	private String show_cover_pic;//	否	是否显示封面，1为显示，0为不显示
	/**
	 * @Description: 属性 title 的get方法 
	 * @return title
	 */
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
	 * @Description: 属性 thumb_media_id 的get方法 
	 * @return thumb_media_id
	 */
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	/**
	 * @Description: 属性 thumb_media_id 的set方法 
	 * @param thumb_media_id 
	 */
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	/**
	 * @Description: 属性 author 的get方法 
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @Description: 属性 author 的set方法 
	 * @param author 
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @Description: 属性 content_source_url 的get方法 
	 * @return content_source_url
	 */
	public String getContent_source_url() {
		return content_source_url;
	}
	/**
	 * @Description: 属性 content_source_url 的set方法 
	 * @param content_source_url 
	 */
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}
	/**
	 * @Description: 属性 content 的get方法 
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @Description: 属性 content 的set方法 
	 * @param content 
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @Description: 属性 digest 的get方法 
	 * @return digest
	 */
	public String getDigest() {
		return digest;
	}
	/**
	 * @Description: 属性 digest 的set方法 
	 * @param digest 
	 */
	public void setDigest(String digest) {
		this.digest = digest;
	}
	/**
	 * @Description: 属性 show_cover_pic 的get方法 
	 * @return show_cover_pic
	 */
	public String getShow_cover_pic() {
		return show_cover_pic;
	}
	/**
	 * @Description: 属性 show_cover_pic 的set方法 
	 * @param show_cover_pic 
	 */
	public void setShow_cover_pic(String show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:38:06 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "Article [title=" + title + ", thumb_media_id=" + thumb_media_id + ", author=" + author + ", content_source_url=" + content_source_url + ", content=" + content
				+ ", digest=" + digest + ", show_cover_pic=" + show_cover_pic + "]";
	}
	

}
