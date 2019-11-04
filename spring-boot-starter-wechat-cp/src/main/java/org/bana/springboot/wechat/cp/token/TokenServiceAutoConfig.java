/**
 * @Company JBINFO
 * @Title: TokenServiceAutoConfig.java
 * @Package org.bana.springboot.wechat.cp.token
 * @author Liu Wenjie
 * @date 2018年1月31日 下午1:09:12
 * @version V1.0
 */
package org.bana.springboot.wechat.cp.token;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.bana.springboot.wechat.cp.WechatCpProperties;
import org.bana.springboot.wechat.cp.token.impl.CacheAccessTokenServiceImpl;
import org.bana.springboot.wechat.cp.token.impl.CacheJsApiTicketServiceImpl;
import org.bana.springboot.wechat.cp.token.impl.CacheSuiteAccessTokenServiceImpl;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.cp.app.CorpAppType;
import org.bana.wechat.cp.app.WechatAppManager;
import org.bana.wechat.cp.app.WechatCorpAppConfig;
import org.bana.wechat.cp.app.WechatCorpSuiteConfig;
import org.bana.wechat.cp.app.impl.MemoryWechatAppManager;
import org.bana.wechat.cp.common.WechatCpException;
import org.bana.wechat.cp.token.AccessTokenService;
import org.bana.wechat.cp.token.JSApiCpService;
import org.bana.wechat.cp.token.JsApiTicketService;
import org.bana.wechat.cp.token.SuiteAccessTokenService;
import org.bana.wechat.cp.token.impl.JSApiCpServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName: TokenServiceAutoConfig
 * @Description: TokenService的配置类
 * @author Liu Wenjie
 */
@Configuration
public class TokenServiceAutoConfig {

//	@Bean
//	@ConditionalOnMissingBean(CacheManager.class)
//	public CacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
//	    RedisCacheManager cacheManager= new RedisCacheManager(redisTemplate);
//	    cacheManager.setDefaultExpiration(60); //单位秒
//	    Map<String,Long> expiresMap=new HashMap<String,Long>();
//	    expiresMap.put("CPToken",3600L);
//	    cacheManager.setExpires(expiresMap);
//	    return cacheManager;
//	}
	
	@Bean
	@ConditionalOnBean(RedisConnectionFactory.class)
	@ConditionalOnMissingBean(CacheManager.class)
	public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
	    RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        // 默认配置，过期时间指定是30分钟
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
        defaultCacheConfig.entryTtl(Duration.ofMinutes(10)); // 单位分钟

        // redisExpire1h cache配置，过期时间指定是1小时，缓存key的前缀指定成prefixaaa_（存到redis的key会自动添加这个前缀）
        RedisCacheConfiguration userCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().
                entryTtl(Duration.ofHours(1)).prefixKeysWith("CPToken");
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put("redisExpire1h", userCacheConfiguration);

        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig, redisCacheConfigurationMap);
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
	@ConditionalOnMissingBean(AccessTokenService.class)
	public AccessTokenService accessToken(WechatAppManager wechatAppManager,SuiteAccessTokenService suiteAccessTokenService){
		CacheAccessTokenServiceImpl tokenService = new CacheAccessTokenServiceImpl();
		tokenService.setWechatAppManager(wechatAppManager);
		tokenService.setSuiteAccessTokenService(suiteAccessTokenService);
		return tokenService;
	}
	
	/**
	 * Description: SuiteTokenService
	 * @author Liu Wenjie
	 * @date 2018年1月31日 下午1:13:00
	 * @param wechatAppManager
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(SuiteAccessTokenService.class)
	public SuiteAccessTokenService suiteAccessToken(WechatAppManager wechatAppManager){
		CacheSuiteAccessTokenServiceImpl tokenService = new CacheSuiteAccessTokenServiceImpl();
		tokenService.setWechatAppManager(wechatAppManager);
		return tokenService;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public JsApiTicketService jsapiTicket(AccessTokenService accessTokenService){
		CacheJsApiTicketServiceImpl jsApiTicket = new CacheJsApiTicketServiceImpl();
		jsApiTicket.setAccessTokenService(accessTokenService);
		return jsApiTicket;
	}
	
	
	@Bean
	@ConditionalOnMissingBean(JSApiCpService.class)
	public JSApiCpService jsapiTicketService(JsApiTicketService jsApiTicketService){
		JSApiCpServiceImpl jSApiCpServiceImpl = new JSApiCpServiceImpl();
		jSApiCpServiceImpl.setJsApiTicketService(jsApiTicketService);
		return jSApiCpServiceImpl;
	}
	
	
	@Bean
	@ConditionalOnMissingBean(WechatAppManager.class)
	public WechatAppManager memoryWechatAppManager(WechatCpProperties wechatCpProperties){
		String corpId = wechatCpProperties.getCorpId();
		String agentId = wechatCpProperties.getAgentId();
		String secret = wechatCpProperties.getSecret();
		if(StringUtils.isBlank(corpId,agentId,secret)){
			throw new WechatCpException(WechatCpException.APP_PARAM_ERROR3, "corpId,agentId,secert配置不能为空"+corpId +","+agentId+","+secret);
		}
		MemoryWechatAppManager manager = new MemoryWechatAppManager();
		WechatCorpAppConfig wechatCorpConfig = new WechatCorpAppConfig();
		if("-1".equals(agentId)){
			wechatCorpConfig.setCorpAppType(CorpAppType.通讯录管理API);
		}else{
			wechatCorpConfig.setCorpAppType(CorpAppType.自建应用);
		}
		wechatCorpConfig.setAgentId(agentId);
		wechatCorpConfig.setCorpId(corpId);
		wechatCorpConfig.setSecret(secret);
		manager.addAppConfig(wechatCorpConfig);
		
		WechatCorpSuiteConfig suiteConfig = new WechatCorpSuiteConfig();
		suiteConfig.setSuiteId(wechatCpProperties.getSuiteId());
		suiteConfig.setEncodingAesKey(wechatCpProperties.getEncodingAesKey());
		suiteConfig.setSuiteSecret(wechatCpProperties.getSuiteSecret());
		suiteConfig.setToken(wechatCpProperties.getSuiteToken());
		suiteConfig.setCorpId(corpId);
		manager.addSuiteConfig(suiteConfig);
		
		manager.setSuiteTicket(wechatCpProperties.getSuiteTicket());
		return manager;
	}
}
