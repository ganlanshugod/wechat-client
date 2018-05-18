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

import org.bana.springboot.wechat.mp.WechatMpProperties;
import org.bana.springboot.wechat.mp.token.impl.CacheJsApiTicketMpServiceImpl;
import org.bana.springboot.wechat.mp.token.impl.CacheMpAccessTokenServiceImpl;
import org.bana.wechat.mp.app.WechatMpConfig;
import org.bana.wechat.mp.app.WechatMpManager;
import org.bana.wechat.mp.app.impl.InmemeryWechatMpManager;
import org.bana.wechat.mp.token.AccessTokenService;
import org.bana.wechat.mp.token.JSApiMpService;
import org.bana.wechat.mp.token.JsApiTicketMpService;
import org.bana.wechat.mp.token.impl.JSApiMpServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

/**
 * @ClassName: TokenServiceAutoConfig
 * @Description: 
 * @author Liu Wenjie
 */

@Configuration
public class MpTokenServiceAutoConfig {
	
	/*@Bean
	@ConditionalOnMissingBean(CacheManager.class)
	public CacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
	    RedisCacheManager cacheManager= new RedisCacheManager(redisTemplate);
	    cacheManager.setDefaultExpiration(60); //单位秒
	    Map<String,Long> expiresMap=new HashMap<String,Long>();
	    expiresMap.put("MPToken",3600L);
	    cacheManager.setExpires(expiresMap);
	    return cacheManager;
	}*/

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
	public AccessTokenService mpAccessToken(WechatMpManager wechatMpManager){
		CacheMpAccessTokenServiceImpl tokenService = new CacheMpAccessTokenServiceImpl();
		tokenService.setWechatMpManager(wechatMpManager);
		return tokenService;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public WechatMpManager memeryMpManager(WechatMpProperties wechatMpProperties){
		InmemeryWechatMpManager wechatMpManagerImpl = new InmemeryWechatMpManager();
		WechatMpConfig appConfig = new WechatMpConfig();
		Assert.notNull(wechatMpProperties, "wechat.mp必须配置");
		Assert.notNull(wechatMpProperties.getAppId(),"wechat.mp.appId必须配置");
		Assert.notNull(wechatMpProperties.getSecret(),"wechat.mp.secret必须配置");
		appConfig.setAppId(wechatMpProperties.getAppId());
		appConfig.setSecret(wechatMpProperties.getSecret());
		wechatMpManagerImpl.addAppConfig(appConfig);
		return wechatMpManagerImpl;
	}

	@Bean
	@ConditionalOnMissingBean
	public JsApiTicketMpService jsApiTicketMpService(AccessTokenService accessTokenService){
		CacheJsApiTicketMpServiceImpl jsApiTicket = new CacheJsApiTicketMpServiceImpl();
		jsApiTicket.setAccessTokenService(accessTokenService);
		return jsApiTicket;
	}
	
	
	@Bean
	@ConditionalOnMissingBean(JSApiMpService.class)
	public JSApiMpService jSApiMpService(JsApiTicketMpService jsApiTicketService){
		JSApiMpServiceImpl jSApiMpServiceImpl = new JSApiMpServiceImpl();
		jSApiMpServiceImpl.setJsApiTicketMpService(jsApiTicketService);;
		return jSApiMpServiceImpl;
	}
	
}
