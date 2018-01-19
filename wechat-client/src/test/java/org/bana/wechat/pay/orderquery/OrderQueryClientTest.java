/**
* @Company 青鸟软通   
* @Title: OrderQueryClientTest.java 
* @Package org.bana.wechat.pay.orderquery 
* @author Liu Wenjie   
* @date 2015-9-22 下午8:59:15 
* @version V1.0   
*/ 
package org.bana.wechat.pay.orderquery;

import net.sf.json.JSONSerializer;

import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.BasePayTestCase;
import org.bana.wechat.pay.common.SignUtil;
import org.bana.wechat.pay.order.OrderClient;
import org.bana.wechat.pay.order.domain.OrderQueryDomain;
import org.bana.wechat.pay.order.param.OrderQueryParam;
import org.junit.Test;

/** 
 * @ClassName: OrderQueryClientTest 
 * @Description: 
 *  
 */
public class OrderQueryClientTest extends BasePayTestCase{

	/**
	 * Test method for {@link org.bana.wechat.pay.orderquery.OrderQueryClient#queryOrder(org.bana.wechat.pay.orderquery.param.OrderQueryParam)}.
	 */
	@Test
	public void testQueryOrder() {
		OrderQueryParam param = new OrderQueryParam();
		param.setAppid(appId);
		param.setMch_id(mch_id);
		param.setNonce_str(StringUtils.getRandomStr());
		param.setOut_trade_no("1217752501201407033233368018");
//		param.setTransaction_id(transaction_id);
		param.setSign(SignUtil.getSign(param, apiKey));
		OrderQueryDomain queryOrder = OrderClient.queryOrder(param);
		System.out.println(JSONSerializer.toJSON(queryOrder));
	}

}
