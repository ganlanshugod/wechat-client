package org.bana.springboot.wechat.mini.message;

import org.bana.wechat.mini.message.MessageMiniService;
import org.bana.wechat.mini.message.impl.MessageMiniServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageMiniAutoConfig {

	/**
	 * 使用的ServiceBean自动注入
	 * @param 
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public MessageMiniService messageMiniService(){
		MessageMiniServiceImpl impl = new MessageMiniServiceImpl();
		return impl;
	}
}
