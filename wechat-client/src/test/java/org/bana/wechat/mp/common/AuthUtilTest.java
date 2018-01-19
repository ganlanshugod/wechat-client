/**
* @Company 青鸟软通   
* @Title: AuthUtilTest.java 
* @Package org.bana.wechat.mp.common 
* @author Liu Wenjie   
* @date 2015-9-21 下午6:18:49 
* @version V1.0   
*/ 
package org.bana.wechat.mp.common;

import org.bana.wechat.BasePayTestCase;
import org.bana.wechat.mp.common.AuthUtil.AuthType;
import org.junit.Test;

/** 
 * @ClassName: AuthUtilTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class AuthUtilTest extends BasePayTestCase{

	/**
	 * Test method for {@link org.bana.wechat.mp.common.AuthUtil#initAuditCodeUrl(java.lang.String, java.lang.String, java.lang.String, org.bana.wechat.mp.common.AuthUtil.AuthType)}.
	 */
	@Test
	public void testInitAuditCodeUrl() {
		String currentUrl = "http://testshop.i3618.com.cn/wechat-shop/wechatshop/test/login";
		String url = AuthUtil.initAuditCodeUrl(currentUrl, appId, "mp", AuthType.snsapi_userinfo);
		System.out.println(url);
	}

}
