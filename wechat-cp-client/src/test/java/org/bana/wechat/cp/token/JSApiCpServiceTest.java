/**
 * @Company JBINFO
 * @Title: JSApiCpServiceTest.java
 * @Package org.bana.wechat.cp.token
 * @author Liu Wenjie
 * @date 2018年1月30日 下午4:09:13
 * @version V1.0
 */
package org.bana.wechat.cp.token;

import org.bana.wechat.cp.BaseCPTest;
import org.bana.wechat.cp.token.domain.JSSDKCpConfig;
import org.bana.wechat.cp.token.impl.JSApiCpServiceImpl;
import org.bana.wechat.cp.token.param.JsSdkParam;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName: JSApiCpServiceTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Liu Wenjie
 */
public class JSApiCpServiceTest extends BaseCPTest{
	
	private JSApiCpService jsApiCpService;
	
	@Before
	public void init(){
		JSApiCpServiceImpl jsApiCpServiceImpl = new JSApiCpServiceImpl();
		jsApiCpServiceImpl.setJsApiTicketService(jsApiTicketService);
		jsApiCpService = jsApiCpServiceImpl;
	}

	/**
	 * Test method for {@link org.bana.wechat.cp.token.JSApiCpService#getJsSdkConfig(org.bana.wechat.cp.token.param.JsSdkParam)}.
	 */
	@Test
	public void testGetJsSdkConfig() {
		String url = "http://local.oasis.com/wx/?corpId=1234";
		JsSdkParam param = new JsSdkParam();
		param.setCorpId(corpId);
		param.setAgentId(agentId);
		param.setUrl(url);
		JSSDKCpConfig jsSdkConfig = jsApiCpService.getJsSdkConfig(param);
		System.out.println(jsSdkConfig);
	}

}
