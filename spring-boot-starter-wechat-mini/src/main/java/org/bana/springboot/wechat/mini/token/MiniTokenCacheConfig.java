package org.bana.springboot.wechat.mini.token;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class MiniTokenCacheConfig {

	@Bean
	@ConditionalOnBean(RedisTemplate.class)
	@ConditionalOnMissingBean(CacheManager.class)
	public CacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
	    RedisCacheManager cacheManager= new RedisCacheManager(redisTemplate);
	    cacheManager.setDefaultExpiration(60); //单位秒
	    Map<String,Long> expiresMap=new HashMap<String,Long>();
	    expiresMap.put("MINIToken",3600L);
	    cacheManager.setExpires(expiresMap);
	    return cacheManager;
	}
}
