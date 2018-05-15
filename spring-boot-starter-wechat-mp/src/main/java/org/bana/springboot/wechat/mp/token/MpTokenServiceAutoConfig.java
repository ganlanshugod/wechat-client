/**
 * @Company JBINFO
 * @Title: TokenServiceAutoConfig.java
 * @Package org.bana.springboot.wechat.mp.token.impl
 * @author Liu Wenjie
 * @date 2018年5月15日 下午4:35:08
 * @version V1.0
 */
package org.bana.springboot.wechat.mp.token;

import java.util.HashMap;
import java.util.Map;

import org.bana.springboot.wechat.mp.token.impl.CacheMpAccessTokenServiceImpl;
import org.bana.wechat.mp.token.AccessTokenService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName: TokenServiceAutoConfig
 * @Description: 
 * @author Liu Wenjie
 */

@Configuration
public class MpTokenServiceAutoConfig {
	
	@Bean
	@ConditionalOnMissingBean(CacheManager.class)
	public CacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
	    RedisCacheManager cacheManager= new RedisCacheManager(redisTemplate);
	    cacheManager.setDefaultExpiration(60); //单位秒
	    Map<String,Long> expiresMap=new HashMap<String,Long>();
	    expiresMap.put("MPToken",3600L);
	    cacheManager.setExpires(expiresMap);
	    return cacheManager;
	}

	/**
	 * Description: AcsseccTOkenService
	 * @author Liu Wenjie
	 * @date 2018年1月31日 下午1:10:48
	 * @param wechatAppManager
	 * @param suiteAccessTokenService
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public AccessTokenService mpAccessToken(){
		CacheMpAccessTokenServiceImpl tokenService = new CacheMpAccessTokenServiceImpl();
		return tokenService;
	}
}
