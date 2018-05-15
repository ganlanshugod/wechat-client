/**
 * @Company JBINFO
 * @Title: AccessTokenServiceTest.java
 * @Package org.bana.wechat.mp.token
 * @author Liu Wenjie
 * @date 2018年5月15日 下午1:05:04
 * @version V1.0
 */
package org.bana.wechat.mp.token;

import static org.junit.Assert.*;

import org.bana.wechat.mp.BaseMpTest;
import org.bana.wechat.mp.token.result.WebAuthAccessToken;
import org.junit.Test;

/**
 * @ClassName: AccessTokenServiceTest
 * @Description: 
 * @author Liu Wenjie
 */
public class AccessTokenServiceTest extends BaseMpTest{

	/**
	 * Test method for {@link org.bana.wechat.mp.token.AccessTokenService#getAccessToken(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetAccessToken() {
		String accessToken = tokenService.getAccessToken(appId, secret);
		System.out.println(accessToken);
	}

	/**
	 * Test method for {@link org.bana.wechat.mp.token.AccessTokenService#getWebAuthAccessToken(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetWebAuthAccessToken() {
		String code = "071TbACV1i5zCW0pC7CV19izCV1TbACe";
		WebAuthAccessToken webAuthAccessToken = tokenService.getWebAuthAccessToken(appId, secret, code);
		System.out.println(webAuthAccessToken);
	}

}
