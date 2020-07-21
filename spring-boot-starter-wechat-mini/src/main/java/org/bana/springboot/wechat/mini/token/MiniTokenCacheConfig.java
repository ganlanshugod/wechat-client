package org.bana.springboot.wechat.mini.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiniTokenCacheConfig {

//	@Bean
//	@ConditionalOnBean(RedisTemplate.class)
//	@ConditionalOnMissingBean(CacheManager.class)
//	public CacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
//	    RedisCacheManager cacheManager= new RedisCacheManager(redisTemplate);
//	    cacheManager.setDefaultExpiration(60); //单位秒
//	    Map<String,Long> expiresMap=new HashMap<String,Long>();
//	    expiresMap.put("MINIToken",3600L);
//	    cacheManager.setExpires(expiresMap);
//	    return cacheManager;
//	}
	
//	@Bean
//	@ConditionalOnMissingBean(CacheManager.class)
//	public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//	    RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
//        // 默认配置，过期时间指定是30分钟
//	    RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
//	    		.entryTtl(Duration.ofMinutes(10)); // 单位分钟
//
//        // redisExpire1h cache配置，过期时间指定是1小时，缓存key的前缀指定成prefixaaa_（存到redis的key会自动添加这个前缀）
//        RedisCacheConfiguration userCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().
//                entryTtl(Duration.ofHours(1)).prefixKeysWith("MINIToken");
//        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
//        redisCacheConfigurationMap.put("redisExpire1h", userCacheConfiguration);
//
//        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig, redisCacheConfigurationMap);
//        return cacheManager;
//	}
	
	/** 
	* @Description:  小程序 的token 缓存新的形式
	* @author liuwenjie   
	* @date Jul 7, 2020 4:07:52 PM 
	* @return  
	*/ 
	@Bean
	public WechatMiniRedisCacheManagerBuilderCustomizer wechatMiniRedisCacheManagerBuilderCustomizer() {
		return new WechatMiniRedisCacheManagerBuilderCustomizer();
	}
}
