/**
* @Company 全域旅游
* @Title: WechatMpCallBackConfig.java 
* @Package org.bana.springboot.wechat.mp.callback 
* @author liuwenjie   
* @date Sep 29, 2020 12:01:40 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.callback;

import org.bana.springboot.wechat.mp.callback.controller.CallBackController;
import org.bana.wechat.mp.app.WechatMpManager;
import org.bana.wechat.mp.callback.CallBackHandler;
import org.bana.wechat.mp.common.WXMpBizMsgCryptFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 
* @ClassName: WechatMpCallBackConfig 
* @Description: 
* @author liuwenjie   
*/
@Configuration
@ConditionalOnProperty(prefix=WechatMpCallbackProperties.WECHAT_MP_CALLBACK_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
public class WechatMpCallBackConfig {
	
	@Bean
	@ConditionalOnProperty(prefix=WechatMpCallbackProperties.WECHAT_MP_CALLBACK_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
	@ConditionalOnMissingBean
	public WechatMpCallBackHandler wechatMpCallBackHandler() {
		DemoWechatMpCallBackHandler WechatMpCallBackHandler = new DemoWechatMpCallBackHandler();
		return WechatMpCallBackHandler;
	}
	
	
	@Bean
	@ConditionalOnProperty(prefix=WechatMpCallbackProperties.WECHAT_MP_CALLBACK_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
	@ConditionalOnMissingBean
	public CallBackHandler callBackHandler() {
		BasicCallBackHandler basicCallBackHandler = new BasicCallBackHandler();
		return basicCallBackHandler;
	}
	

	@Bean
	@ConditionalOnMissingBean
	public WXMpBizMsgCryptFactory wxMpBizMsgCryptFactory(WechatMpManager wechatMpManager) {
		WXMpBizMsgCryptFactory factory = new WXMpBizMsgCryptFactory();
		factory.setWechatMpManager(wechatMpManager);
		return factory;
	}
	
	@Bean
	@ConditionalOnProperty(prefix=WechatMpCallbackProperties.WECHAT_MP_CALLBACK_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
	public CallBackController wechatMpCallbackController() {
		CallBackController callBackController = new CallBackController();
		return callBackController;
	}
}
