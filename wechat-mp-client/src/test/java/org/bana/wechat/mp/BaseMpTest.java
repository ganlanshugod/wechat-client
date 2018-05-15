/**
 * @Company JBINFO
 * @Title: BaseMpTest.java
 * @Package org.bana.wechat.mp
 * @author Liu Wenjie
 * @date 2018年5月15日 下午12:31:42
 * @version V1.0
 */
package org.bana.wechat.mp;

import org.bana.wechat.mp.app.WechatMpConfig;
import org.bana.wechat.mp.app.WechatMpManager;
import org.bana.wechat.mp.app.impl.InmemeryWechatMpManager;
import org.bana.wechat.mp.token.impl.SimpleAccessTokenServiceImpl;
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
	
	protected static WechatMpManager wechatMpManager;
	
	@BeforeClass
	public static void beforeClass(){
		InmemeryWechatMpManager wechatMpManagerImpl = new InmemeryWechatMpManager();
		WechatMpConfig appConfig = new WechatMpConfig();
		appConfig.setAppId(appId);
		appConfig.setSecret(secret);
		wechatMpManagerImpl.addAppConfig(appConfig);
		wechatMpManagerImpl.addAppConfig(appConfig);
		SimpleAccessTokenServiceImpl tokenServiceImpl =  new SimpleAccessTokenServiceImpl();
		tokenServiceImpl.setWechatMpManager(wechatMpManagerImpl);
		
		tokenService = tokenServiceImpl;
		wechatMpManager = wechatMpManagerImpl;
	}
}
