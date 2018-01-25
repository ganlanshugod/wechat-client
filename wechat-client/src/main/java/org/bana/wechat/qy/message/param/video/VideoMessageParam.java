/**
* @Company 青鸟软通   
* @Title: VideoMessageParam.java 
* @Package org.bana.wechat.qy.message.param.video 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:25:00 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message.param.video;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.qy.message.param.MessageParam;

/** 
 * @ClassName: VideoMessageParam 
 * @Description: video消息
 *  
 */
public class VideoMessageParam extends MessageParam {

	private VideoMessage video;
	
	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2015-5-27 下午9:43:40  
	 */
	public VideoMessageParam() {
		setMsgtype(Constants.video消息.getValue());
	}

	/**
	 * @Description: 属性 video 的get方法 
	 * @return video
	 */
	public VideoMessage getVideo() {
		return video;
	}

	/**
	 * @Description: 属性 video 的set方法 
	 * @param video 
	 */
	public void setVideo(VideoMessage video) {
		this.video = video;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:26:22 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "VideoMessageParam [video=" + video + ", touser=" + touser + ", toparty=" + toparty + ", totag=" + totag + ", msgtype=" + msgtype + ", agentid=" + agentid
				+ ", safe=" + safe + ", access_token=" + access_token + "]";
	}
	
	
}
