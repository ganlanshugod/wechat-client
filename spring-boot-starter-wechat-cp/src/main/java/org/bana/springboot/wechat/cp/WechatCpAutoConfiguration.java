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
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.cp.app.CorpAppType;
import org.bana.wechat.cp.app.WechatAppManager;
import org.bana.wechat.cp.app.WechatCorpAppConfig;
import org.bana.wechat.cp.app.WechatCorpSuiteConfig;
import org.bana.wechat.cp.app.impl.MemoryWechatAppManager;
import org.bana.wechat.cp.callback.BaseWechatCpCallbackHandler;
import org.bana.wechat.cp.callback.WechatCpCallbackHandler;
import org.bana.wechat.cp.callback.WechatCpEventPublisher;
import org.bana.wechat.cp.common.WechatCpException;
import org.bana.wechat.cp.token.AccessTokenService;
import org.bana.wechat.cp.token.impl.SimpleAccessTokenServiceImpl;
import org.bana.wechat.cp.user.UserCPService;
import org.bana.wechat.cp.user.impl.UserCPServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: WechatCpAutoConfiguration
 * @Description: 微信企业号的自动注入类
 * @author Liu Wenjie
 */

@Configuration
@EnableConfigurationProperties(WechatCpProperties.class)
public class WechatCpAutoConfiguration {
	
	
	@Bean
	@ConditionalOnMissingBean(AccessTokenService.class)
	public AccessTokenService accessToken(WechatAppManager wechatAppManager){
		SimpleAccessTokenServiceImpl tokenService = new SimpleAccessTokenServiceImpl();
		tokenService.setWechatAppManager(wechatAppManager);
		return tokenService;
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
		manager.addSuiteConfig(suiteConfig);
		
		manager.setSuiteTicket(wechatCpProperties.getSuiteTicket());
		return manager;
	}
	
	@Bean
	@ConditionalOnMissingBean(UserCPService.class)
	public UserCPService userCpService(AccessTokenService accessTokenService){
		UserCPServiceImpl userService = new UserCPServiceImpl();
		userService.setAccessTokenService(accessTokenService);
		return userService;
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
