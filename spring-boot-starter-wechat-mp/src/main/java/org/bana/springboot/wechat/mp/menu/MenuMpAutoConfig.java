package org.bana.springboot.wechat.mp.menu;

import org.bana.wechat.mp.menu.MenuMpService;
import org.bana.wechat.mp.menu.impl.MenuMpServiceImpl;
import org.bana.wechat.mp.token.AccessTokenService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuMpAutoConfig {

	/**
	 * 发消息使用的ServiceBean自动注入
	 * @param accessTokenService
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public MenuMpService menuMpService(AccessTokenService accessTokenService){
		MenuMpServiceImpl impl = new MenuMpServiceImpl();
		impl.setAccessTokenService(accessTokenService);
		return impl;
	}
}
