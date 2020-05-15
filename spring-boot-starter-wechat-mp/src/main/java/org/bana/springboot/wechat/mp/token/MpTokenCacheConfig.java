package org.bana.springboot.wechat.mp.token;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@ConditionalOnClass(RedisConnectionFactory.class)
public class MpTokenCacheConfig {

	@Bean
	@ConditionalOnBean(RedisConnectionFactory.class)
	@ConditionalOnMissingBean(CacheManager.class)
	public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//	    RedisCacheManager cacheManager= new RedisCacheManager(redisTemplate);
//	    cacheManager.setDefaultExpiration(60); //单位秒
//	    Map<String,Long> expiresMap=new HashMap<String,Long>();
//	    expiresMap.put("MPToken",3600L);
//	    cacheManager.setExpires(expiresMap);
	    
	    
	    RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        // 默认配置，过期时间指定是30分钟
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
        defaultCacheConfig.entryTtl(Duration.ofMinutes(10)); // 单位分钟

        // redisExpire1h cache配置，过期时间指定是1小时，缓存key的前缀指定成prefixaaa_（存到redis的key会自动添加这个前缀）
        RedisCacheConfiguration userCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().
                entryTtl(Duration.ofHours(1)).prefixKeysWith("MPToken");
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put("redisExpire1h", userCacheConfiguration);

        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig, redisCacheConfigurationMap);
        return cacheManager;
	}
}
