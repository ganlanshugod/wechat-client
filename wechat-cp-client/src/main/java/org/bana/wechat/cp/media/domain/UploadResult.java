/**
* @Company 青鸟软通   
* @Title: UploadResult.java 
* @Package org.bana.wechat.qy.media.result 
* @author Liu Wenjie   
* @date 2015-7-20 下午5:20:08 
* @version V1.0   
*/ 
package org.bana.wechat.cp.media.domain;

import java.io.Serializable;

/** 
 * @ClassName: UploadResult 
 * @Description: 上传后的返回结果
 *  
 */
public class UploadResult implements Serializable{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 3987762202248360505L;
	
	private String type;//媒体文件类型，分别有图片（image）、语音（voice）、视频（video）,普通文件(file)
	
	private String media_id;//媒体文件上传后获取的唯一标识
	
	private String created_at;//媒体文件上传时间戳

	/**
	 * @Description: 属性 type 的get方法 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @Description: 属性 type 的set方法 
	 * @param type 
	 */
	public void setType(String type) {
		this.type = type;
	}

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
	 * @Description: 属性 created_at 的get方法 
	 * @return created_at
	 */
	public String getCreated_at() {
		return created_at;
	}

	/**
	 * @Description: 属性 created_at 的set方法 
	 * @param created_at 
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-7-20 下午5:22:06 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "UploadResult [type=" + type + ", media_id=" + media_id + ", created_at=" + created_at + "]";
	}

}
