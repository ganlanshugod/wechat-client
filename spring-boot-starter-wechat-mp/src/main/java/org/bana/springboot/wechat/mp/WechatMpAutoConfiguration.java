/**
 * @Company JBINFO
 * @Title: WechatMpAutoConfiguration.java
 * @Package org.bana.springboot.wechat.mp
 * @author Liu Wenjie
 * @date 2018年5月15日 下午4:30:11
 * @version V1.0
 */
package org.bana.springboot.wechat.mp;

import java.util.HashMap;
import java.util.Map;

import org.bana.springboot.wechat.mp.media.MediaMpAutoConfig;
import org.bana.springboot.wechat.mp.oauth.OAuthAutoConfig;
import org.bana.springboot.wechat.mp.token.MpTokenServiceAutoConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName: WechatMpAutoConfiguration
 * @Description: Mp的自动控制类
 * @author Liu Wenjie
 */
@Configuration
@EnableCaching
@Import({MpTokenServiceAutoConfig.class,OAuthAutoConfig.class,MediaMpAutoConfig.class})
@EnableConfigurationProperties(WechatMpProperties.class)
public class WechatMpAutoConfiguration {

	/**
	 * @param redisTemplate
	 * @return
	 * 如果环境中存在redis环境则使用redis加载cache方法
	 */
	@ConditionalOnClass(RedisCacheManager.class)
	@ConditionalOnBean(RedisTemplate.class)
	@ConditionalOnMissingBean(CacheManager.class)
	public CacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
	    RedisCacheManager cacheManager= new RedisCacheManager(redisTemplate);
	    cacheManager.setDefaultExpiration(60); //单位秒
	    Map<String,Long> expiresMap=new HashMap<String,Long>();
	    expiresMap.put("MPToken",3600L);
	    cacheManager.setExpires(expiresMap);
	    return cacheManager;
	}
	
}
