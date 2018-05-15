/**
 * @Company JBINFO
 * @Title: OAuthMpServiceTest.java
 * @Package org.bana.wechat.mp.auth
 * @author Liu Wenjie
 * @date 2018年5月15日 下午12:30:58
 * @version V1.0
 */
package org.bana.wechat.mp.auth;

import org.bana.wechat.mp.BaseMpTest;
import org.bana.wechat.mp.auth.impl.OAuthMpServiceImpl;
import org.bana.wechat.mp.auth.result.UserMpInfo;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName: OAuthMpServiceTest
 * @Description: 
 * WebAuthAccessToken [
 * refreshToken=9_cIT1emOgVEBiJ8qMT-6Kg-xndexunUewBs20w9RG0T90vlKBKGcLuU7DllhZDgPij1kq0yBeoFIAhWuw08yyHw, 
 * openId=oePQEwDdy6vTpLqIxI_tehD3qE9s, 
 * scope=snsapi_userinfo, toString()=AccessToken [
 * accessToken=9_nG2il5yOxaWi49xWTGjsNMFkNP6JigOrZ4zieRmajIpG7ZeZB_3BCG6MPL6-4eULmQBq15eA3fykCazRWd8Ppw, 
 * expiresIn=7200]]
* @author Liu Wenjie
 */
public class OAuthMpServiceTest extends BaseMpTest{
	
	private OAuthMpService oauthMpService;
	
	@Before
	public void init(){
		OAuthMpServiceImpl impl = new OAuthMpServiceImpl();
		oauthMpService = impl;
	}

	/**
	 * Test method for {@link org.bana.wechat.mp.auth.OAuthMpService#getUserInfo(org.bana.wechat.mp.auth.param.UserMpInfoParam)}.
	 */
	@Test
	public void testGetUserInfo() {
		String accessToken = "9_nG2il5yOxaWi49xWTGjsNMFkNP6JigOrZ4zieRmajIpG7ZeZB_3BCG6MPL6-4eULmQBq15eA3fykCazRWd8Ppw";
		String openId = "oePQEwDdy6vTpLqIxI_tehD3qE9s";
		UserMpInfo userInfo = oauthMpService.getUserInfo(accessToken,openId,"en");
		System.out.println(userInfo);
	}

}
