/**
 * @Company JBINFO
 * @Title: TokenServiceAutoConfig.java
 * @Package org.bana.springboot.wechat.mp.token.impl
 * @author Liu Wenjie
 * @date 2018年5月15日 下午4:35:08
 * @version V1.0
 */
package org.bana.springboot.wechat.mp.token;

import org.bana.springboot.wechat.mp.WechatMpProperties;
import org.bana.springboot.wechat.mp.component.WechatMpComponentProperties;
import org.bana.springboot.wechat.mp.component.cache.CacheComponentAccessTokenServiceImpl;
import org.bana.springboot.wechat.mp.token.impl.CacheJsApiTicketMpServiceImpl;
import org.bana.springboot.wechat.mp.token.impl.CacheMpAccessTokenServiceImpl;
import org.bana.wechat.mp.app.WechatMpConfig;
import org.bana.wechat.mp.app.WechatMpManager;
import org.bana.wechat.mp.app.impl.InmemeryWechatMpManager;
import org.bana.wechat.mp.component.ComponentTokenService;
import org.bana.wechat.mp.component.impl.WebAuthAccessTokenComponentServiceImpl;
import org.bana.wechat.mp.token.AccessTokenService;
import org.bana.wechat.mp.token.JSApiMpService;
import org.bana.wechat.mp.token.JsApiTicketMpService;
import org.bana.wechat.mp.token.WebAuthAccessTokenService;
import org.bana.wechat.mp.token.impl.JSApiMpServiceImpl;
import org.bana.wechat.mp.token.impl.WebAuthAccessTokenServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
@Import(MpTokenCacheConfig.class)
public class MpTokenServiceAutoConfig {
	
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnProperty(prefix=WechatMpComponentProperties.WECHAT_MP_COMP_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
	public AccessTokenService mpComponentAccessToken(WechatMpManager wechatMpManager,ComponentTokenService componentTokenService){
		CacheComponentAccessTokenServiceImpl tokenService = new CacheComponentAccessTokenServiceImpl();
		tokenService.setWechatMpManager(wechatMpManager);
		tokenService.setComponentTokenService(componentTokenService);
		return tokenService;
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
		appConfig.setToken(wechatMpProperties.getToken());
		appConfig.setEncodingAESKey(wechatMpProperties.getEncodingAESKey());
		wechatMpManagerImpl.addAppConfig(appConfig);
		String[] otherApp = wechatMpProperties.getOtherApp();
		if(otherApp != null){
			for (String config : otherApp) {
				if(config.contains(":")){
					String[] split = config.split(":");
					WechatMpConfig mpConfig = new WechatMpConfig();
					mpConfig.setAppId(split[0]);
					mpConfig.setSecret(split[1]);
					wechatMpManagerImpl.addAppConfig(mpConfig);
				}
			}
		}
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
	
	
	
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnProperty(prefix=WechatMpComponentProperties.WECHAT_MP_COMP_PREFIX,name="enable",havingValue="true",matchIfMissing=false)
	public WebAuthAccessTokenService webAuthComponentAccessToken(WechatMpManager wechatMpManager,ComponentTokenService componentTokenService){
		WebAuthAccessTokenComponentServiceImpl tokenService = new WebAuthAccessTokenComponentServiceImpl();
		tokenService.setWechatMpManager(wechatMpManager);
		tokenService.setComponentTokenService(componentTokenService);
		return tokenService;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public WebAuthAccessTokenService webAuthAccessToken(WechatMpManager wechatMpManager){
		WebAuthAccessTokenServiceImpl tokenService = new WebAuthAccessTokenServiceImpl();
		tokenService.setWechatMpManager(wechatMpManager);
		return tokenService;
	}
	
}
