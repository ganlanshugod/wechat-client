/**
* @Company 全域旅游
* @Title: CallBackResult.java 
* @Package org.bana.wechat.mp.callback.result 
* @author liuwenjie   
* @date Sep 28, 2020 1:46:31 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.mp.message.param.image.ImageMessage;
import org.bana.wechat.mp.message.param.music.MusicMessage;
import org.bana.wechat.mp.message.param.video.VideoMessage;
import org.bana.wechat.mp.message.param.voice.VoiceMessage;

/** 
* @ClassName: CallBackResult 
* @Description: 被动回复消息的基类
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class CallBackResult implements Serializable{
	
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -3666404480663148052L;
	private String toUserName; // ToUserName><![CDATA[toUser]]></ToUserName>
	private String fromUserName; // FromUserName><![CDATA[fromUser]]></FromUserName>
	private String createTime; //>12345678</CreateTime>

	private String msgType; // 被动回复消息的类型
	
	private Object result;
	
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	@XmlElements({
		@XmlElement(name="Content",type=String.class),
		@XmlElement(name="Image",type=ImageMessage.class),
		@XmlElement(name="Voice",type=VoiceMessage.class),
		@XmlElement(name="Video",type=VideoMessage.class),
		@XmlElement(name="Music",type=MusicMessage.class),
	})
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	@XmlElement(name="CreateTime")
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
