/**
 * @Company JBINFO
 * @Title: TokenServiceAutoConfig.java
 * @Package org.bana.springboot.wechat.mp.token.impl
 * @author Liu Wenjie
 * @date 2018年5月15日 下午4:35:08
 * @version V1.0
 */
package org.bana.springboot.wechat.mini.token;

import org.bana.springboot.wechat.mini.WechatMiniProperties;
import org.bana.springboot.wechat.mini.token.impl.CacheMiniAccessTokenServiceImpl;
import org.bana.wechat.mini.app.WechatMiniConfig;
import org.bana.wechat.mini.app.WechatMiniManager;
import org.bana.wechat.mini.app.impl.InmemeryWechatMiniManager;
import org.bana.wechat.mini.token.AccessTokenService;
import org.bana.wechat.mini.token.CodeSessionMiniService;
import org.bana.wechat.mini.token.impl.CodeSessionMiniServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.Assert;

/**
 * @ClassName: TokenServiceAutoConfig
 * @Description: 
 * @author Liu Wenjie
 */

@Configuration
@Import(MiniTokenCacheConfig.class)
public class MiniTokenServiceAutoConfig {
	
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
	public AccessTokenService miniAccessToken(WechatMiniManager wechatMiniManager){
		CacheMiniAccessTokenServiceImpl tokenService = new CacheMiniAccessTokenServiceImpl();
		tokenService.setWechatMiniManager(wechatMiniManager);
		return tokenService;
	}
	/**
	 * Description: 小程序相关service
	 * @author Zhang Zhichao
	 * @date 2019年6月3日 下午4:12:05
	 * @param wechatMpManager
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public CodeSessionMiniService codeSessionMiniService(WechatMiniManager wechatMiniManager){
		CodeSessionMiniServiceImpl csmService = new CodeSessionMiniServiceImpl();
		csmService.setWechatMiniManager(wechatMiniManager);
		return csmService;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public WechatMiniManager memeryMiniManager(WechatMiniProperties wechatMiniProperties){
		InmemeryWechatMiniManager wechatMiniManagerImpl = new InmemeryWechatMiniManager();
		WechatMiniConfig appConfig = new WechatMiniConfig();
		Assert.notNull(wechatMiniProperties, "wechat.mp必须配置");
		Assert.notNull(wechatMiniProperties.getAppId(),"wechat.mp.appId必须配置");
		Assert.notNull(wechatMiniProperties.getSecret(),"wechat.mp.secret必须配置");
		appConfig.setAppId(wechatMiniProperties.getAppId());
		appConfig.setSecret(wechatMiniProperties.getSecret());
		wechatMiniManagerImpl.addAppConfig(appConfig);
		String[] otherApp = wechatMiniProperties.getOtherApp();
		if(otherApp != null){
			for (String config : otherApp) {
				if(config.contains(":")){
					String[] split = config.split(":");
					WechatMiniConfig mpConfig = new WechatMiniConfig();
					mpConfig.setAppId(split[0]);
					mpConfig.setSecret(split[1]);
					wechatMiniManagerImpl.addAppConfig(mpConfig);
				}
			}
		}
		return wechatMiniManagerImpl;
	}

	
}
