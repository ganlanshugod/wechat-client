/**
* @Company 青鸟软通   
* @Title: FileMessage.java 
* @Package org.bana.wechat.qy.message.param.file 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:27:53 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message.param.file;

/** 
 * @ClassName: FileMessage 
 * @Description: file消息
 *  
 */
public class FileMessage {

	private String media_id;

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
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:28:13 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "FileMessage [media_id=" + media_id + "]";
	}
	
}
