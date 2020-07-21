/**
* @Company 全域旅游
* @Title: WechatMpRedisCacheManagerBuilderCustomizer.java 
* @Package com.elink.wdt 
* @author liuwenjie   
* @date Jul 7, 2020 3:46:03 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.token;

import java.time.Duration;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;

/** 
* @ClassName: WechatMpRedisCacheManagerBuilderCustomizer 
* @Description: 微信Mp的redisCache配置
* @author liuwenjie   
*/
public class WechatMpRedisCacheManagerBuilderCustomizer implements RedisCacheManagerBuilderCustomizer {

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
				.entryTtl(Duration.ofHours(1)).prefixKeysWith("MPToken");
        builder.withCacheConfiguration("MPToken", config);
	}

}
