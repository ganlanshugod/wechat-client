package org.bana.wechat.mp.message.param.image;

import org.bana.wechat.mp.message.param.MediaMessage;

/** 
* @ClassName: MediaMessage 
* @Description: 多媒体消息<br> 图片消息、语音消息直接用此类
*  
*/ 
public class ImageMessage extends MediaMessage{

	@Override
	public String toString() {
		return "ImageMessage [getMediaId()=" + getMediaId() + "]";
	}
	
}
