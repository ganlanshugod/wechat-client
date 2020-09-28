/**
* @Company 全域旅游
* @Title: DemoWechatMpCallBackHandler.java 
* @Package org.bana.springboot.wechat.mp.callback 
* @author liuwenjie   
* @date Sep 28, 2020 4:44:36 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.callback;

import org.bana.wechat.mp.callback.msg.CallBackMessage;
import org.bana.wechat.mp.callback.msg.TextCallBackMessage;
import org.bana.wechat.mp.message.param.MessageParam;
import org.bana.wechat.mp.message.param.text.TextMessage;

/** 
* @ClassName: DemoWechatMpCallBackHandler 
* @Description: 一个用于测试的CallBackHandler的实现类
* @author liuwenjie   
*/
public class DemoWechatMpCallBackHandler implements WechatMpCallBackHandler{

	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 28, 2020 4:45:11 PM 
	* @param message
	* @return 
	* @see org.bana.springboot.wechat.mp.callback.WechatMpCallBackHandler#handleCallBackMessage(org.bana.wechat.mp.callback.msg.CallBackMessage) 
	*/ 
	@Override
	public MessageParam handleCallBackMessage(CallBackMessage message) {
		if(message instanceof TextCallBackMessage) {
			TextCallBackMessage textMessage = (TextCallBackMessage)message;
			String content = textMessage.getContent();
			if("test".equalsIgnoreCase(content)) {
				TextMessage result = new TextMessage();
				result.setContent("hello test");
				return result;
			}
		}
		return null;
	}

}
