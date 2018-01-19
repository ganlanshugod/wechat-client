/**
* @Company 青鸟软通   
* @Title: VoiceMessage.java 
* @Package org.bana.wechat.qy.message.param.voice 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:23:35 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message.param.voice;

/** 
 * @ClassName: VoiceMessage 
 * @Description: voice消息 体
 *  
 */
public class VoiceMessage {

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
	* @date 2015-5-27 下午9:24:05 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "VoiceMessage [media_id=" + media_id + "]";
	}
	
}
