/**
 * @Company JBINFO
 * @Title: WechatCpAutoConfiguration.java
 * @Package org.bana.springboot.wechat.cp
 * @author Liu Wenjie
 * @date 2018年1月19日 下午5:23:52
 * @version V1.0
 */
package org.bana.springboot.wechat.cp;

import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.common.WechatCpException;
import org.bana.wechat.cp.app.CorpAppType;
import org.bana.wechat.cp.app.WechatAppManager;
import org.bana.wechat.cp.app.WechatCorpAppConfig;
import org.bana.wechat.cp.app.WechatCorpSuiteConfig;
import org.bana.wechat.cp.app.impl.MemoryWechatAppManager;
import org.bana.wechat.cp.token.AccessTokenService;
import org.bana.wechat.cp.token.impl.SimpleAccessTokenServiceImpl;
import org.bana.wechat.cp.user.UserCPService;
import org.bana.wechat.cp.user.impl.UserCPServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
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
@ConditionalOnWebApplication
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
		// 默认套件信息
		String suiteId = wechatCpProperties.getSuiteId();
		String suiteSecret = wechatCpProperties.getSuiteSecret();
		String suiteTicket = wechatCpProperties.getSuiteTicket();
		if(StringUtils.isBlank(suiteId,suiteSecret,suiteTicket)){
			throw new WechatCpException(WechatCpException.SUITE_PARAM_ERROR1, "suiteId,suiteSecret,suiteTicket配置不能为空"+suiteId +","+suiteSecret+","+suiteTicket);
		}
		WechatCorpSuiteConfig suiteConfig = new WechatCorpSuiteConfig();
		suiteConfig.setSuiteId(suiteId);
		suiteConfig.setSuiteSecret(suiteSecret);
		suiteConfig.setSuiteTicket(suiteTicket);
		manager.addSuiteConfig(suiteConfig);
		return manager;
	}
	
	@Bean
	@ConditionalOnMissingBean(UserCPService.class)
	public UserCPService userCpService(AccessTokenService accessTokenService){
		UserCPServiceImpl userService = new UserCPServiceImpl();
		userService.setAccessTokenService(accessTokenService);
		return userService;
	}
	
}
