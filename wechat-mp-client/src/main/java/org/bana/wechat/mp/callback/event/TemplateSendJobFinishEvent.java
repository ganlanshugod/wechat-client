/**
* @Company 全域旅游
* @Title: TemplateSendJobFinishEvent.java 
* @Package org.bana.wechat.mp.callback.event 
* @author liuwenjie   
* @date 2020年11月27日 下午12:10:38 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: TemplateSendJobFinishEvent 
* @Description: 在模版消息发送任务完成后，微信服务器会将是否送达成功作为通知，发送到开发者中心中填写的服务器配置地址中。
* @author liuwenjie   
*/
@XmlRootElement(name = "xml")
public class TemplateSendJobFinishEvent extends CallBackEvent{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 4649294479519265770L;
	
	private String msgId; // 
	private String status; // success, failed:user block, failed: system failed]
	
	@XmlElement(name="MsgID")
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	@XmlElement(name="Status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "TemplateSendJobFinishEvent [msgId=" + msgId + ", status=" + status + ", toString()=" + super.toString()
				+ "]";
	}
	
//	<MsgID>200163836</MsgID>  
//	<Status><![CDATA[success]]></Status> 
	
}
