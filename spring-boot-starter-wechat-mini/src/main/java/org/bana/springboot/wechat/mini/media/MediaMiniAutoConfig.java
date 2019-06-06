package org.bana.springboot.wechat.mini.media;

import org.bana.wechat.mini.media.MediaMiniService;
import org.bana.wechat.mini.media.impl.MediaMiniServiceImpl;
import org.bana.wechat.mini.token.AccessTokenService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MediaMiniAutoConfig {

	/**
	 * media上传需要使用的ServiceBean自动注入
	 * @param accessTokenService
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public MediaMiniService mediaMiniService(AccessTokenService accessTokenService){
		MediaMiniServiceImpl impl = new MediaMiniServiceImpl();
		impl.setAccessTokenService(accessTokenService);
		return impl;
	}
}
