/**
* @Company 青鸟软通   
* @Title: TokenClientTest.java 
* @Package org.bana.wechat.mp.token 
* @author Liu Wenjie   
* @date 2015-8-18 下午5:25:38 
* @version V1.0   
*/ 
package org.bana.wechat.mp.token;

import org.bana.wechat.BaseMPTestCase;
import org.bana.wechat.mp.token.domain.AccessToken;
import org.bana.wechat.qy.connection.domain.JsApiTicket;
import org.junit.Test;

/** 
 * @ClassName: TokenClientTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class TokenClientTest extends BaseMPTestCase{

	/**
	 * Test method for {@link org.bana.wechat.mp.token.TokenClient#token(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testToken() {
		//三创服务号
		AccessToken token = TokenClient.token(grantType, appId, secret);
		System.out.println(token);
	}

	@Test
	public void testToken2() {
		AccessToken token = TokenClient.token(grantType, "wx9ea95f1dc1ba973f", "bb86f79741416891f06880753cfab210");
		System.out.println(token);
	}
	
	@Test
	public void testTicket(){
		AccessToken token = TokenClient.token(grantType, "wx8c8fcb328afb4728", "a9385277a8a3e61c7f02b330e85bbd76");
		JsApiTicket ticket = TokenClient.getTicket(token.getAccess_token());
		System.out.println(ticket);
	}

}
