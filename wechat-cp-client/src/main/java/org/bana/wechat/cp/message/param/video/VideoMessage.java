/**
* @Company 青鸟软通   
* @Title: VideoMessage.java 
* @Package org.bana.wechat.qy.message.param.video 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:25:22 
* @version V1.0   
*/ 
package org.bana.wechat.cp.message.param.video;

/** 
 * @ClassName: VideoMessage 
 * @Description: video消息
 *  
 */
public class VideoMessage {

	private String media_id; //	是	视频媒体文件id，可以调用上传媒体文件接口获取
	private String title	; //否	视频消息的标题
	private String description; //	否	视频消息的描述
	/**
	 * @Description: 属性 media_id 的get方法 
	 * @return media_id
	 */
	public String getMedia_id() {
		return media_id;
	}
	/**
	 * @Description: 属性 media_id 的set方法 
	 * @param media_id 
	 */
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
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
	 * @Description: 属性 description 的get方法 
	 * @return description
	 */
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
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:26:08 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "VideoMessage [media_id=" + media_id + ", title=" + title + ", description=" + description + "]";
	}
	
}
