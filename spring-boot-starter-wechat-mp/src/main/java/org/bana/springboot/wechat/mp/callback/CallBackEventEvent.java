/**
* @Company 全域旅游
* @Title: CallBackEventEvent.java 
* @Package org.bana.springboot.wechat.mp.callback 
* @author liuwenjie   
* @date Sep 29, 2020 10:52:21 AM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.callback;

import org.bana.wechat.mp.callback.event.CallBackEvent;
import org.springframework.context.ApplicationEvent;

/** 
* @ClassName: CallBackEventEvent 
* @Description: 回调事件发出的spring环境的Event事件
* @author liuwenjie   
*/
public class CallBackEventEvent  extends ApplicationEvent{
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 3961328700386232701L;
	

	private CallBackEvent callBackEvent;
	
	/** 
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 29, 2020 10:53:12 AM 
	* @param source 
	*/ 
	public CallBackEventEvent(Object source,CallBackEvent callbackEventObj) {
		super(source);
		this.callBackEvent = callbackEventObj;
	}

	public CallBackEvent getCallBackEvent() {
		return callBackEvent;
	}

	public void setCallBackEvent(CallBackEvent callBackEvent) {
		this.callBackEvent = callBackEvent;
	}


}
