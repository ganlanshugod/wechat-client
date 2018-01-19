/**
* @Company 青鸟软通   
* @Title: CloseOrderClientTest.java 
* @Package org.bana.wechat.pay.order 
* @author Liu Wenjie   
* @date 2015-9-22 下午9:26:33 
* @version V1.0   
*/ 
package org.bana.wechat.pay.order;

import net.sf.json.JSONSerializer;

import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.BasePayTestCase;
import org.bana.wechat.pay.common.SignUtil;
import org.bana.wechat.pay.order.domain.CloseOrderResult;
import org.bana.wechat.pay.order.param.CloseOrderParam;
import org.junit.Assert;
import org.junit.Test;

/** 
 * @ClassName: CloseOrderClientTest 
 * @Description: 关闭订单的测试
 *  
 */
public class CloseOrderClientTest extends BasePayTestCase{

	/**
	 * Test method for {@link org.bana.wechat.pay.order.CloseOrderClient#closeOrder(org.bana.wechat.pay.order.param.CloseOrderParam)}.
	 */
	@Test
	public void testCloseOrder() {
		CloseOrderParam param = new CloseOrderParam();
		param.setAppid(appId);
		param.setMch_id(mch_id);
		param.setNonce_str(StringUtils.getRandomStr());
		param.setOut_trade_no("1217752501201407033233368018");
		param.setSign(SignUtil.getSign(param, apiKey));
		
		CloseOrderResult closeOrder = OrderClient.closeOrder(param);
		Assert.assertEquals("ORDERPAID", closeOrder.getErr_code());
		System.out.println(JSONSerializer.toJSON(closeOrder));
	}

}
