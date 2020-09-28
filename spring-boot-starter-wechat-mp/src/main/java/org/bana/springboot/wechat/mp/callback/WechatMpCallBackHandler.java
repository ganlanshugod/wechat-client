/**
* @Company 全域旅游
* @Title: WechatMpCallBackHandler.java 
* @Package org.bana.springboot.wechat.mp.callback 
* @author liuwenjie   
* @date Sep 28, 2020 3:49:30 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.callback;

import org.bana.wechat.mp.callback.msg.CallBackMessage;
import org.bana.wechat.mp.message.param.MessageParam;

/** 
* @ClassName: WechatMpCallBackHandler 
* @Description: 
* @author liuwenjie   
*/
public interface WechatMpCallBackHandler {

	/** 
	* @Description: 处理回调的消息时间
	* @author liuwenjie   
	* @date Sep 28, 2020 3:53:59 PM 
	* @param message  回调的消息内容
	* @return 返回的是回调消息的类型
	*/ 
	MessageParam handleCallBackMessage(CallBackMessage message);

	
}
