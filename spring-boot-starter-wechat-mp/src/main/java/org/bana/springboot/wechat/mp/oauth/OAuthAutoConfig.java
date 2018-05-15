/**
 * @Company JBINFO
 * @Title: OAuthAutoConfig.java
 * @Package org.bana.springboot.wechat.mp.oauth
 * @author Liu Wenjie
 * @date 2018年5月15日 下午4:40:31
 * @version V1.0
 */
package org.bana.springboot.wechat.mp.oauth;

import org.bana.wechat.mp.auth.OAuthMpService;
import org.bana.wechat.mp.auth.impl.OAuthMpServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: OAuthAutoConfig
 * @Description: 
 * @author Liu Wenjie
 */
@Configuration
public class OAuthAutoConfig {

	@Bean
	@ConditionalOnMissingBean
	public OAuthMpService oauthMpService(){
		OAuthMpServiceImpl oauthMpService = new OAuthMpServiceImpl();
		return oauthMpService;
	}
}
