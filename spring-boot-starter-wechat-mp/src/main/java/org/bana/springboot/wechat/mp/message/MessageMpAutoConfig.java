package org.bana.springboot.wechat.mp.message;

import org.bana.wechat.mp.message.MessageMpService;
import org.bana.wechat.mp.message.impl.MessageMpServiceImpl;
import org.bana.wechat.mp.token.AccessTokenService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageMpAutoConfig {

	/**
	 * 发消息使用的ServiceBean自动注入
	 * @param accessTokenService
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public MessageMpService messageMpService(AccessTokenService accessTokenService){
		MessageMpServiceImpl impl = new MessageMpServiceImpl();
		impl.setAccessTokenService(accessTokenService);
		return impl;
	}
}
