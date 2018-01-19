/**
* @Company 艾美伴行   
* @Title: OrderClientTest.java 
* @Package org.bana.wechat.mp.merchant 
* @author liuwenjie   
* @date 2016-6-16 下午7:16:55 
* @version V1.0   
*/ 
package org.bana.wechat.mp.merchant;

import org.bana.wechat.BaseMPTestCase;
import org.bana.wechat.mp.merchant.domain.Order;
import org.junit.Test;

/** 
 * @ClassName: OrderClientTest 
 * @Description: 
 *  
 */
public class OrderClientTest extends BaseMPTestCase{

	/**
	 * Test method for {@link org.bana.wechat.mp.merchant.OrderClient#getById(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetById() {
		Order byId = OrderClient.getById(accessToken.getAccess_token(), "13236370564158612628");
	}

}
