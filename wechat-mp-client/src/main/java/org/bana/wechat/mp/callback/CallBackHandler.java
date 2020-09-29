/**
* @Company 全域旅游
* @Title: CallBackHandler.java 
* @Package org.bana.springboot.wechat.mp 
* @author liuwenjie   
* @date Sep 28, 2020 1:25:01 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback;

import org.bana.wechat.mp.callback.event.CallBackEvent;
import org.bana.wechat.mp.callback.msg.CallBackMessage;

/** 
* @ClassName: CallBackHandler 
* @Description: 处理消息的回调通知
* @author liuwenjie   
*/
public interface CallBackHandler {
	
	/** 
	* @Description: 处理callback方法，根据回调消息处理对应的类
	* @author liuwenjie   
	* @date Sep 28, 2020 1:47:09 PM 
	* @param message
	* @return  返回结果，可以返回被动回复的消息类，也可以返回null，返回null是不进行被动回复消息的处理
	*/ 
	public String handleCallBackMessage(CallBackMessage message);

	/** 
	* @Description:  处理callback的事件类型的回调内容，也可以返回对应的消息
	* @author liuwenjie   
	* @date Sep 29, 2020 10:49:56 AM 
	* @param event
	* @return  
	*/ 
	public String handleCallBackEvent(CallBackEvent event);
}
