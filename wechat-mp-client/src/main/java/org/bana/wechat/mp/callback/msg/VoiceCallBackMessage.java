/**
* @Company 全域旅游
* @Title: VoiceCallBackMessage.java 
* @Package org.bana.wechat.mp.callback.msg 
* @author liuwenjie   
* @date Sep 28, 2020 12:11:57 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: VoiceCallBackMessage 
* @Description: 
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class VoiceCallBackMessage extends CallBackMessage {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -6138469518040891519L;
	
    private String mediaId;  //语音消息媒体id，可以调用获取临时素材接口拉取数据。
	private String format; //语音格式，如amr，speex等
	private String recognition; //语音识别结果，UTF8编码,只有开启语音识别的才会有这个节点
	
	
	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@XmlElement(name="Format")
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	
	@XmlElement(name="Recognition")
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	@Override
	public String toString() {
		return "VoiceCallBackMessage [mediaId=" + mediaId + ", format=" + format + ", recognition=" + recognition + ", getAppId()=" + getAppId()
				+ ", getOpenId()=" + getOpenId() + ", getCreateTime()=" + getCreateTime() + ", getMsgId()=" + getMsgId()
				+ ", getMsgType()=" + getMsgType() + "]";
	} 
	
}
