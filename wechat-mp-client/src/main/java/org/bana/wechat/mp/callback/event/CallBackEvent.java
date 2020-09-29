/**
* @Company 全域旅游
* @Title: CallBackEvent.java 
* @Package org.bana.wechat.mp.callback.event 
* @author liuwenjie   
* @date Sep 29, 2020 9:51:04 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.event;

import javax.xml.bind.annotation.XmlElement;

import org.bana.wechat.mp.callback.CallBackObj;

/** 
* @ClassName: CallBackEvent 
* @Description: 回调方法里的时间
* @author liuwenjie   
*/
public abstract class CallBackEvent extends CallBackObj{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -1216865436063190625L;
	
	private long createTime;
	private String event;
	
	@XmlElement(name="CreateTime")
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	@XmlElement(name="Event")
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	@Override
	public String toString() {
		return "CallBackEvent [createTime=" + createTime + ", event=" + event + ", getMsgType()=" + getMsgType()
				+ ", getAppId()=" + getAppId() + ", getOpenId()=" + getOpenId() + "]";
	}
	
	
}
