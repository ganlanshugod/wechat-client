/**
* @Company 全域旅游
* @Title: CallBackMessageEvent.java 
* @Package org.bana.springboot.wechat.mp.callback 
* @author liuwenjie   
* @date Sep 28, 2020 4:22:12 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.callback;

import org.bana.wechat.mp.callback.msg.CallBackMessage;
import org.springframework.context.ApplicationEvent;

/** 
* @ClassName: CallBackMessageEvent 
* @Description: 回调消息时间
* @author liuwenjie   
*/
public class CallBackMessageEvent extends ApplicationEvent{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -8773134632320942606L;
	
	private CallBackMessage callBackMessage;

	/** 
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 23, 2020 2:10:02 PM 
	* @param source 
	*/ 
	public CallBackMessageEvent(Object source,CallBackMessage callBackMessage) {
		super(source);
		this.callBackMessage = callBackMessage;
	}

	public CallBackMessage getCallBackMessage() {
		return callBackMessage;
	}

	public void setCallBackMessage(CallBackMessage callBackMessage) {
		this.callBackMessage = callBackMessage;
	}
	
}
