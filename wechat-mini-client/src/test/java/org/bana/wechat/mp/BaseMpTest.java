/**
 * @Company JBINFO
 * @Title: BaseMpTest.java
 * @Package org.bana.wechat.mp
 * @author Liu Wenjie
 * @date 2018年5月15日 下午12:31:42
 * @version V1.0
 */
package org.bana.wechat.mp;

import org.bana.wechat.mini.app.WechatMiniConfig;
import org.bana.wechat.mini.app.WechatMiniManager;
import org.bana.wechat.mini.app.impl.InmemeryWechatMiniManager;
import org.bana.wechat.mini.token.impl.SimpleAccessTokenServiceImpl;
import org.junit.BeforeClass;

/**
 * @ClassName: BaseMpTest
 * @Description: 
 * @author Liu Wenjie
 */
public class BaseMpTest {
	
	protected static SimpleAccessTokenServiceImpl tokenService;

	protected static String appId = "wxa7eeec1744e8d41e";

	protected static String secret = "d6fadb9f2aad175b7e2bcc35048b35ab";
	
	protected static WechatMiniManager wechatMiniManager;
	
	@BeforeClass
	public static void beforeClass(){
		InmemeryWechatMiniManager wechatMpManagerImpl = new InmemeryWechatMiniManager();
		WechatMiniConfig appConfig = new WechatMiniConfig();
		appConfig.setAppId(appId);
		appConfig.setSecret(secret);
		wechatMpManagerImpl.addAppConfig(appConfig);
		wechatMpManagerImpl.addAppConfig(appConfig);
		SimpleAccessTokenServiceImpl tokenServiceImpl =  new SimpleAccessTokenServiceImpl();
		tokenServiceImpl.setWechatMiniManager(wechatMpManagerImpl);
		
		tokenService = tokenServiceImpl;
		wechatMiniManager = wechatMpManagerImpl;
	}
}
