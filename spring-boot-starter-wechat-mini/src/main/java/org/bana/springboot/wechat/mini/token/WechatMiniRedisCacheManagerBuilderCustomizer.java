package org.bana.springboot.wechat.mini.token;

import java.time.Duration;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;

public class WechatMiniRedisCacheManagerBuilderCustomizer implements RedisCacheManagerBuilderCustomizer {

	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Jul 7, 2020 3:46:34 PM 
	* @param builder 
	* @see org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer#customize(org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder) 
	*/ 
	@Override
	public void customize(RedisCacheManagerBuilder builder) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofHours(1)).prefixKeysWith("MINIToken");
        builder.withCacheConfiguration("MINIToken", config);
	}

}