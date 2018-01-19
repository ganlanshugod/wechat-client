/**
* @Company 青鸟软通   
* @Title: SignUtilTest.java 
* @Package org.bana.wechat.pay.common 
* @author Liu Wenjie   
* @date 2015-9-22 上午11:57:51 
* @version V1.0   
*/ 
package org.bana.wechat.pay.common;

import org.bana.wechat.BasePayTestCase;
import org.bana.wechat.pay.order.param.UnifiedOrderParam;
import org.junit.Assert;
import org.junit.Test;

/** 
 * @ClassName: SignUtilTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class SignUtilTest extends BasePayTestCase{

	/**
	 * Test method for {@link org.bana.wechat.pay.common.SignUtil#getSign(java.lang.Object, java.lang.String)}.
	 */
	@Test
	public void testGetSign() {
//		fail("Not yet implemented");
		UnifiedOrderParam param = new UnifiedOrderParam();
		param.setAppid("wxd930ea5d5a258f4f");
		param.setMch_id("10000100");
		param.setDevice_info("1000");
		param.setBody("test");
		param.setNonce_str("ibuaiVcKdpRxkhJA");
		String sign = SignUtil.getSign(param, "192006250b4c09247ec02edce69f6a2d");
		Assert.assertEquals("9A0A8659F005D6984697E2CA0A9CF3B7", sign);
	}

}
