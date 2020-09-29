/**
* @Company 全域旅游
* @Title: WechatMpComponetConfig.java 
* @Package org.bana.springboot.wechat.mp.component 
* @author liuwenjie   
* @date Sep 17, 2020 12:57:18 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.component;

import java.util.List;

import org.bana.springboot.wechat.mp.callback.WechatMpCallbackProperties;
import org.bana.springboot.wechat.mp.component.cache.CacheComponentTokenServiceImpl;
import org.bana.springboot.wechat.mp.component.cache.CacheWechatMpComponentServiceImpl;
import org.bana.springboot.wechat.mp.component.cache.CacheWechatMpComponentTicketStoreImpl;
import org.bana.springboot.wechat.mp.component.controller.WechatMpCompCallbackController;
import org.bana.springboot.wechat.mp.component.controller.WechatMpCompReceiveController;
import org.bana.springboot.wechat.mp.component.handler.impl.BasicReceiveMsgHandler;
import org.bana.wechat.mp.component.ComponentService;
import org.bana.wechat.mp.component.ComponentTokenService;
import org.bana.wechat.mp.component.common.WXMpCompBizMsgCryptFactory;
import org.bana.wechat.mp.component.common.WechatMpComponentConfig;
import org.bana.wechat.mp.component.common.WechatMpComponentManager;
import org.bana.wechat.mp.component.common.WechatMpComponentTicketStore;
import org.bana.wechat.mp.component.common.impl.InMermeryWechatMpComponentManager;
import org.bana.wechat.mp.component.handler.ReceiveMsgHandler;
import org.bana.wechat.mp.component.impl.WechatMpComponentServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/** 
* @ClassName: WechatMpComponetConfig 
* @Description: 
* @author liuwenjie   
*/
@Configuration
@EnableConfigurationProperties(WechatMpComponentProperties.class)
@ConditionalOnProperty(prefix=WechatMpComponentProperties.WECHAT_MP_COMP_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
public class WechatMpComponetConfig {

	@Bean
	@ConditionalOnProperty(prefix=WechatMpComponentProperties.WECHAT_MP_COMP_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
	public WechatMpCompReceiveController wechatMpCompReceiveController() {
		WechatMpCompReceiveController wechatMpController = new WechatMpCompReceiveController();
		return wechatMpController;
	}
	
	@Bean
	@ConditionalOnProperty(prefix=WechatMpCallbackProperties.WECHAT_MP_CALLBACK_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
	public WechatMpCompCallbackController wechatMpCompCallbackController() {
		WechatMpCompCallbackController wechatMpController = new WechatMpCompCallbackController();
		return wechatMpController;
	}
	
	@Bean
	@ConditionalOnProperty(prefix=WechatMpComponentProperties.WECHAT_MP_COMP_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
	@ConditionalOnMissingBean
	public ReceiveMsgHandler receiveMsgHandler() {
		BasicReceiveMsgHandler componentService = new BasicReceiveMsgHandler();
		return componentService;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public WechatMpComponentManager wechatMpComponentManager(WechatMpComponentProperties wechatMpComponentProperties) {
		InMermeryWechatMpComponentManager inMermeryWechatMpComponentManager = new InMermeryWechatMpComponentManager();
		List<WechatMpComponentConfig> config = wechatMpComponentProperties.getConfig();
		if(config != null) {
			config.forEach(item -> {
				if(item.isAvailable()) {
					inMermeryWechatMpComponentManager.add(item);
				}else {
					throw new RuntimeException("不合法的微信第三方平台配置信息" + item);
				}
			});
		}
		return inMermeryWechatMpComponentManager;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public WXMpCompBizMsgCryptFactory wxMpCompBizMsgCryptFactory(WechatMpComponentManager wechatMpComponentManager) {
		WXMpCompBizMsgCryptFactory factory = new WXMpCompBizMsgCryptFactory();
		factory.setWechatMpComponentManager(wechatMpComponentManager);
		return factory;
	}
	
	@Bean
	@ConditionalOnClass(RedisConnectionFactory.class)
	public WechatMpComponentTicketStore  cacheWechatMpComponentTicketStore() {
		CacheWechatMpComponentTicketStoreImpl store = new CacheWechatMpComponentTicketStoreImpl();
		return store;
	}
	
	@Bean
	@ConditionalOnClass(RedisConnectionFactory.class)
	@ConditionalOnMissingBean
	public ComponentTokenService componentTokenService(WechatMpComponentManager wechatMpComponentManager,WechatMpComponentTicketStore wechatMpComponentTicketStore) {
		CacheComponentTokenServiceImpl componentTokenService = new CacheComponentTokenServiceImpl();
		componentTokenService.setWechatMpComponentManager(wechatMpComponentManager);
		componentTokenService.setWechatMpComponentTicketStore(wechatMpComponentTicketStore);
		return componentTokenService;
	}
	
	@Bean
	@ConditionalOnClass(RedisConnectionFactory.class)
	@ConditionalOnMissingBean
	public ComponentService cacheComponentService(ComponentTokenService componentTokenService) {
		CacheWechatMpComponentServiceImpl componentService = new CacheWechatMpComponentServiceImpl();
		componentService.setComponentTokenService(componentTokenService);
		return componentService;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public ComponentService componentService(ComponentTokenService componentTokenService) {
		WechatMpComponentServiceImpl componentService = new WechatMpComponentServiceImpl();
		componentService.setComponentTokenService(componentTokenService);
		return componentService;
	}
	
	
}
