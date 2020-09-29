/**
* @Company 全域旅游
* @Title: CallBackMsg.java 
* @Package org.bana.wechat.mp.callback.msg 
* @author liuwenjie   
* @date Sep 28, 2020 11:48:04 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.msg;

import javax.xml.bind.annotation.XmlElement;

import org.bana.wechat.mp.callback.CallBackObj;

/** 
* @ClassName: CallBackMsg 
* @Description: 接受到消息通知
* @author liuwenjie   
*/
public abstract class CallBackMessage extends CallBackObj{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 148693760885119044L;
	
	private long createTime;
	private String msgId;
	
	
	@XmlElement(name="CreateTime")
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	@XmlElement(name="MsgId")
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}


}
