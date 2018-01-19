/**
* @Company 青鸟软通   
* @Title: AuthClientTest.java 
* @Package org.bana.wechat.mp.auth 
* @author Han Tongyang   
* @date 2015-8-26 下午5:50:05 
* @version V1.0   
*/ 
package org.bana.wechat.mp.auth;

import org.bana.wechat.BaseMPTestCase;
import org.bana.wechat.mp.auth.domain.AuthTokenDomain;
import org.bana.wechat.mp.auth.param.AuthTokenParam;
import org.junit.Test;

/** 
 * @ClassName: AuthClientTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class AuthClientTest extends BaseMPTestCase{

	@Test
	public void testGetToken() {
		AuthTokenParam param = new AuthTokenParam();
		param.setAppid(appId);
		param.setSecret(secret);
		param.setCode("021fc87790c66b3402b22996e632e9e0"); //点击登陆时request、log中获得
		AuthTokenDomain domain = AuthClient.getToken(param);
		System.out.println(domain);
	}
}
