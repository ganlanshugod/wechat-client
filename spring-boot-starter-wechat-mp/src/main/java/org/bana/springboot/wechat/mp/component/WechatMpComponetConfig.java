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

import org.bana.springboot.wechat.mp.component.controller.WechatMpCompController;
import org.bana.wechat.mp.component.ComponentTokenService;
import org.bana.wechat.mp.component.common.WXMpBizMsgCryptFactory;
import org.bana.wechat.mp.component.common.WechatMpComponentConfig;
import org.bana.wechat.mp.component.common.WechatMpComponentManager;
import org.bana.wechat.mp.component.common.WechatMpComponentTicketStore;
import org.bana.wechat.mp.component.common.impl.InMermeryWechatMpComponentManager;
import org.bana.wechat.mp.component.common.impl.InMermeryWechatMpComponentTicketStore;
import org.bana.wechat.mp.component.impl.SimpleComponentTokenServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 
* @ClassName: WechatMpComponetConfig 
* @Description: 
* @author liuwenjie   
*/
@Configuration
@EnableConfigurationProperties(WechatMpComponentProperties.class)
public class WechatMpComponetConfig {

	@Bean
	@ConditionalOnProperty(prefix=WechatMpComponentProperties.WECHAT_MP_COMP_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
	public WechatMpCompController wechatMpController() {
		WechatMpCompController wechatMpController = new WechatMpCompController();
		return wechatMpController;
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
	public WechatMpComponentTicketStore wechatMpComponentTicketStore() {
		InMermeryWechatMpComponentTicketStore store = new InMermeryWechatMpComponentTicketStore();
		return store;
	}
	

	@Bean
	@ConditionalOnMissingBean
	public ComponentTokenService componentTokenService(WechatMpComponentManager wechatMpComponentManager,WechatMpComponentTicketStore wechatMpComponentTicketStore) {
		SimpleComponentTokenServiceImpl componentTokenService = new SimpleComponentTokenServiceImpl();
		componentTokenService.setWechatMpComponentManager(wechatMpComponentManager);
		componentTokenService.setWechatMpComponentTicketStore(wechatMpComponentTicketStore);
		return componentTokenService;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public WXMpBizMsgCryptFactory wxMpBizMsgCryptFactory(WechatMpComponentManager wechatMpComponentManager) {
		WXMpBizMsgCryptFactory factory = new WXMpBizMsgCryptFactory();
		factory.setWechatMpComponentManager(wechatMpComponentManager);
		return factory;
	}
	
	
}
