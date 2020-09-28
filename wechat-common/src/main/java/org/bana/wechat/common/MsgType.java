/**
* @Company 全域旅游
* @Title: MsgType.java 
* @Package org.bana.wechat.common 
* @author liuwenjie   
* @date Sep 28, 2020 2:55:02 PM 
* @version V1.0   
*/ 
package org.bana.wechat.common;

/** 
* @ClassName: MsgType 
* @Description: 消息类型
* @author liuwenjie   
*/
public enum MsgType {

	文本("text"),
	图片("image"),
	语音("voice"),
	视频("video"),
	音乐("music"),
	图文("news");
	
	private String value;
	private MsgType(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
