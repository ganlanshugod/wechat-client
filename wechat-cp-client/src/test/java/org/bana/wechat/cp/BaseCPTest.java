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
import org.bana.wechat.cp.app.WechatCorpSuiteConfig;
import org.bana.wechat.cp.app.impl.MemoryWechatAppManager;
import org.bana.wechat.cp.token.impl.SimpleAccessTokenServiceImpl;
import org.bana.wechat.cp.token.impl.SimpleJsApiTicketService;
import org.junit.BeforeClass;

/**
 * @ClassName: BaseTest
 * @Description: 抽象类
 * @author Liu Wenjie
 */
public class BaseCPTest {
	
	protected static SimpleAccessTokenServiceImpl tokenService;
	protected static SimpleJsApiTicketService jsApiTicketService ;
	protected static MemoryWechatAppManager wechatAppManager;
	
	protected static String corpId = "ww3dd9e376336105bf";

	protected static String agentId = "-1";
	
	protected static String suiteId = "wwc4869e05df46f0d5";
	
	@BeforeClass
	public static void beforeClass(){
		WechatCorpAppConfig appConfig = new WechatCorpAppConfig();
		appConfig.setCorpId(corpId);
		appConfig.setAgentId(agentId);
		appConfig.setCorpAppType(CorpAppType.通讯录管理API);
		appConfig.setSecret("MXBIDelnTGVfItVno8UdO7JxSS9sicviwfXeRbUbZPg");
		wechatAppManager = new MemoryWechatAppManager();
		wechatAppManager.addAppConfig(appConfig);
		tokenService = new SimpleAccessTokenServiceImpl();
		tokenService.setWechatAppManager(wechatAppManager);
		
		jsApiTicketService = new SimpleJsApiTicketService();
		jsApiTicketService.setAccessTokenService(tokenService);
		
		WechatCorpSuiteConfig suiteConfig = new WechatCorpSuiteConfig();
		suiteConfig.setSuiteId(suiteId);
		suiteConfig.setEncodingAesKey("vx8rQi8dXszcyU9WBimSFLNdc3AAEL1Kn3twYnybd1U");
		suiteConfig.setSuiteSecret("SqI67zMSSyi2uhY6_weE6UEykwjC0Qlus_BBJfVjwck");
		suiteConfig.setToken("VDwLCrGDTJVWledn");
		wechatAppManager.addSuiteConfig(suiteConfig);
	}
	
	
}
