/**
 * @Company JBINFO
 * @Title: WechatMpAutoConfiguration.java
 * @Package org.bana.springboot.wechat.mp
 * @author Liu Wenjie
 * @date 2018年5月15日 下午4:30:11
 * @version V1.0
 */
package org.bana.springboot.wechat.mini;

import org.bana.springboot.wechat.mini.media.MediaMiniAutoConfig;
import org.bana.springboot.wechat.mini.token.MiniTokenCacheConfig;
import org.bana.springboot.wechat.mini.token.MiniTokenServiceAutoConfig;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName: WechatMiniAutoConfiguration
 * @Description: Mini的自动控制类
 * @author Liu Wenjie
 */
@Configuration
@EnableCaching
@AutoConfigureAfter(RedisAutoConfiguration.class)
@Import({MiniTokenServiceAutoConfig.class,MediaMiniAutoConfig.class})
@EnableConfigurationProperties(WechatMiniProperties.class)
public class WechatMiniAutoConfiguration {

	/**
	 * @param redisTemplate
	 * @return
	 * 如果环境中存在redis环境则使用redis加载cache方法
	 */
	@ConditionalOnClass(name="org.springframework.data.redis.cacheRedisCacheManager")
	@Configuration
	@Import(MiniTokenCacheConfig.class)
	public class CacheConfig {
		
	}
	
}
