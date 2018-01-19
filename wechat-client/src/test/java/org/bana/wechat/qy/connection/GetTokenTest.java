/**
* @Company 青鸟软通   
* @Title: GetTokenTest.java 
* @Package org.bana.wechat.qy.connection 
* @author Liu Wenjie   
* @date 2015-5-9 下午3:55:01 
* @version V1.0   
*/ 
package org.bana.wechat.qy.connection;

import org.bana.wechat.BaseTestCase;
import org.bana.wechat.qy.connection.domain.AccessToken;
import org.bana.wechat.qy.connection.domain.JsApiTicket;
import org.bana.wechat.qy.connection.domain.ProviderAccessToken;
import org.bana.wechat.qy.connection.domain.SuiteAccessToken;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** 
 * @ClassName: GetTokenTest 
 * @Description: 测试获取AccessToken的方法
 *  
 */
public class GetTokenTest extends BaseTestCase{
	
	private String suite_ticket;
	
	@Before 
	public void init(){
		suite_ticket = "P0E0nM1Zqq9i4i4H-nnwvvUlxr5Ars-Q_vC-oT34cL65ZsWtiUAIenXqqzxLJ9D-";
	}

	@Test
	public void testGetToken() {
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		Assert.assertNotNull(accessToken);
		Assert.assertNotNull(accessToken.getAccess_token());
	}

	@Test
	public void testGetSuiteToken() {
		SuiteAccessToken suiteToken = GetToken.getSuiteToken(suite_id, suite_secret, suite_ticket);
		Assert.assertNotNull(suiteToken);
		Assert.assertNotNull(suiteToken.getSuite_access_token());
	}
	
	@Test
	public void testGetJsApiTicket(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		JsApiTicket jsApiTicket = GetToken.getJsApiTicket(accessToken.getAccess_token());
		System.out.println(jsApiTicket);
	}
	@Test
	public void testGetProviderAccessToken(){
		ProviderAccessToken accessToken = GetToken.getProviderAccessToken("wx92c9ef63da1f3d62", "j99lo36akAflvETJzMHsBe-_Jvo6flxG4nNRYwAZ2uG6zNA3VvgzEEkPdYrEaCx3");
		System.out.println(accessToken);
	}
}
