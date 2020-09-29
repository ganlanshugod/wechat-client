/**
* @Company 全域旅游
* @Title: DemoWechatMpCallBackHandler.java 
* @Package org.bana.springboot.wechat.mp.callback 
* @author liuwenjie   
* @date Sep 28, 2020 4:44:36 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.callback;

import org.bana.wechat.mp.callback.event.CallBackEvent;
import org.bana.wechat.mp.callback.msg.CallBackMessage;
import org.bana.wechat.mp.callback.msg.TextCallBackMessage;
import org.bana.wechat.mp.message.param.MessageParam;
import org.bana.wechat.mp.message.param.text.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
* @ClassName: DemoWechatMpCallBackHandler 
* @Description: 一个用于测试的CallBackHandler的实现类
* @author liuwenjie   
*/
public class DemoWechatMpCallBackHandler implements WechatMpCallBackHandler{
	
	private static final Logger LOG = LoggerFactory.getLogger(DemoWechatMpCallBackHandler.class);

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
		LOG.info("==处理回调消息===" + message);
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

	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 29, 2020 10:59:41 AM 
	* @param event
	* @return 
	* @see org.bana.springboot.wechat.mp.callback.WechatMpCallBackHandler#handleCallBackEvent(org.bana.wechat.mp.callback.event.CallBackEvent) 
	*/ 
	@Override
	public MessageParam handleCallBackEvent(CallBackEvent event) {
		LOG.info("==处理回调事件===" + event);
		return null;
	}

}
