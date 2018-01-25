/**
* @Company 青鸟软通   
* @Title: ShakeAroundClientTest.java 
* @Package org.bana.wechat.qy.shakearound 
* @author Liu Wenjie   
* @date 2015-9-16 下午12:02:15 
* @version V1.0   
*/ 
package org.bana.wechat.qy.shakearound;

import org.bana.wechat.BaseTestCase;
import org.bana.wechat.cp.token.domain.AccessToken;
import org.bana.wechat.qy.connection.GetToken;
import org.bana.wechat.qy.shakearound.domain.ShakeInfoDomain;
import org.bana.wechat.qy.shakearound.param.GetShakeInfoParam;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** 
 * @ClassName: ShakeAroundClientTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class ShakeAroundClientTest extends BaseTestCase{
	 
	private AccessToken accessToken;
	private String ticket;
	
	@Before
	public void init(){
		accessToken = GetToken.getAccessToken(cropId, secret);
		ticket = "5766df7bbb5697a255d9e1784da2cde0";
	}
	
	/**
	 * Test method for {@link org.bana.wechat.qy.shakearound.ShakeAroundClient#getShakeInfo(org.bana.wechat.qy.shakearound.param.GetShakeInfoParam)}.
	 http://manager.i3618.com.cn/i3618-web/pages/i3618/downloadFile.html?ticket=285fdb821da8ee34822518a6f9a4e6d1&activityid=486684
	 http://manager.i3618.com.cn/i3618-web/pages/i3618/downloadFile.html?ticket=5766df7bbb5697a255d9e1784da2cde0&activityid=486684
	 */
	@Test
	public void testGetShakeInfo() {
		accessToken.getAccessToken();
		GetShakeInfoParam param = new GetShakeInfoParam();
		param.setAccess_token(accessToken.getAccessToken());
		param.setTicket(ticket);
		ShakeInfoDomain shakeInfo = ShakeAroundClient.getShakeInfo(param);
		Assert.assertNotNull(shakeInfo);
	}

}
