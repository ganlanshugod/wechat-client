/**
 * @Company JBINFO
 * @Title: WechatCpAutoConfiguration.java
 * @Package org.bana.springboot.wechat.cp
 * @author Liu Wenjie
 * @date 2018年1月19日 下午5:23:52
 * @version V1.0
 */
package org.bana.springboot.wechat.cp;

import org.bana.springboot.wechat.cp.callback.listener.WechatSpringCpEventPublisher;
import org.bana.springboot.wechat.cp.token.TokenServiceAutoConfig;
import org.bana.wechat.cp.app.WechatAppManager;
import org.bana.wechat.cp.callback.BaseWechatCpCallbackHandler;
import org.bana.wechat.cp.callback.WechatCpCallbackHandler;
import org.bana.wechat.cp.callback.WechatCpEventPublisher;
import org.bana.wechat.cp.oauth.OAuthCpService;
import org.bana.wechat.cp.oauth.impl.OAuthCpServiceImpl;
import org.bana.wechat.cp.suite.SuiteCPService;
import org.bana.wechat.cp.suite.impl.SuiteCPServiceImpl;
import org.bana.wechat.cp.token.AccessTokenService;
import org.bana.wechat.cp.token.SuiteAccessTokenService;
import org.bana.wechat.cp.user.UserCPService;
import org.bana.wechat.cp.user.impl.UserCPServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName: WechatCpAutoConfiguration
 * @Description: 微信企业号的自动注入类
 * @author Liu Wenjie
 */

@Configuration
@EnableConfigurationProperties(WechatCpProperties.class)
@EnableCaching
@AutoConfigureAfter(RedisAutoConfiguration.class)
@ConditionalOnBean(RedisTemplate.class)
@Import(TokenServiceAutoConfig.class)
public class WechatCpAutoConfiguration {
	
	@Bean
	@ConditionalOnMissingBean(OAuthCpService.class)
	public OAuthCpService oauthCpService(AccessTokenService accessTokenService,SuiteAccessTokenService suiteAccessTokenService){
		OAuthCpServiceImpl oauthCpService = new OAuthCpServiceImpl();
		oauthCpService.setAccessTokenService(accessTokenService);
		oauthCpService.setSuiteAccessTokenService(suiteAccessTokenService);
		return oauthCpService;
	}
	
	
	@Bean
	@ConditionalOnMissingBean(UserCPService.class)
	public UserCPService userCpService(AccessTokenService accessTokenService,SuiteAccessTokenService suiteTokenService){
		UserCPServiceImpl userService = new UserCPServiceImpl();
		userService.setAccessTokenService(accessTokenService);
		userService.setSuiteAccessTokenService(suiteTokenService);
		return userService;
	}
	
	@Bean
	@ConditionalOnMissingBean(SuiteCPService.class)
	public SuiteCPService suiteCPService(AccessTokenService accessTokenService,SuiteAccessTokenService suiteTokenService){
		SuiteCPServiceImpl suiteCPService = new SuiteCPServiceImpl();
		suiteCPService.setAccessTokenService(accessTokenService);
		suiteCPService.setSuiteAccessTokenService(suiteTokenService);
		return suiteCPService;
	}
	
	/**
	 * Description: 各监听器的配置
	 * @author Liu Wenjie
	 * @date 2018年1月26日 下午6:16:35
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(WechatCpEventPublisher.class)
	public WechatCpEventPublisher wechatEventPublish(){
		return new WechatSpringCpEventPublisher();
	}
	
	/**
	 * Description: 默认的回调类配置
	 * @author Liu Wenjie
	 * @date 2018年1月26日 下午6:16:01
	 * @param wechatAppManager
	 * @param wechatEventPublisher
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(WechatCpCallbackHandler.class)
	public WechatCpCallbackHandler wechatCpCallbackHandler(WechatAppManager wechatAppManager,WechatCpEventPublisher wechatEventPublisher){
		BaseWechatCpCallbackHandler callBackHandlerImpl = new BaseWechatCpCallbackHandler();
		callBackHandlerImpl.setWechatAppManager(wechatAppManager);
		callBackHandlerImpl.setWechatEventPublisher(wechatEventPublisher);
		return callBackHandlerImpl;
	}
	
	
	
}
