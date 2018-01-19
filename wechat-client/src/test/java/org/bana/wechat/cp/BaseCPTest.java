/**
 * @Company JBINFO
 * @Title: BaseTest.java
 * @Package org.bana.wechat.cp.user
 * @author Liu Wenjie
 * @date 2018年1月19日 下午3:33:45
 * @version V1.0
 */
package org.bana.wechat.cp;

import org.bana.wechat.cp.app.CorpAppType;
import org.bana.wechat.cp.app.WechatCorpAppConfig;
import org.bana.wechat.cp.app.impl.MemoryWechatAppManager;
import org.bana.wechat.cp.token.impl.SimpleAccessTokenServiceImpl;
import org.junit.BeforeClass;

/**
 * @ClassName: BaseTest
 * @Description: 抽象类
 * @author Liu Wenjie
 */
public class BaseCPTest {
	
	protected static SimpleAccessTokenServiceImpl tokenService;
	
	protected static String corpId = "ww3dd9e376336105bf";

	protected static String agentId = "-1";
	
	@BeforeClass
	public static void beforeClass(){
		WechatCorpAppConfig appConfig = new WechatCorpAppConfig();
		appConfig.setCorpId(corpId);
		appConfig.setAgentId(agentId);
		appConfig.setCorpAppType(CorpAppType.通讯录管理API);
		appConfig.setSecret("MXBIDelnTGVfItVno8UdO7JxSS9sicviwfXeRbUbZPg");
		MemoryWechatAppManager wechatAppManager = new MemoryWechatAppManager();
		wechatAppManager.addAppConfig(appConfig);
		tokenService = new SimpleAccessTokenServiceImpl();
		tokenService.setWechatAppManager(wechatAppManager);
	}
	
}
