package org.bana.springboot.wechat.mp.media;

import org.bana.wechat.mp.media.MaterialMpService;
import org.bana.wechat.mp.media.MediaMpService;
import org.bana.wechat.mp.media.impl.MaterialMpServiceImpl;
import org.bana.wechat.mp.media.impl.MediaMpServiceImpl;
import org.bana.wechat.mp.token.AccessTokenService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MediaMpAutoConfig {

	/**
	 * media上传需要使用的ServiceBean自动注入
	 * @param accessTokenService
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public MediaMpService mediaMpService(AccessTokenService accessTokenService){
		MediaMpServiceImpl impl = new MediaMpServiceImpl();
		impl.setAccessTokenService(accessTokenService);
		return impl;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public MaterialMpService materialMpService(AccessTokenService accessTokenService){
		MaterialMpServiceImpl impl = new MaterialMpServiceImpl();
		impl.setAccessTokenService(accessTokenService);
		return impl;
	}
}
