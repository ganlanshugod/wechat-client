/**
* @Company 青鸟软通   
* @Title: RefundClientTest.java 
* @Package org.bana.wechat.pay.refund 
* @author Liu Wenjie   
* @date 2015-9-23 下午3:58:59 
* @version V1.0   
*/ 
package org.bana.wechat.pay.refund;

import net.sf.json.JSONSerializer;

import org.bana.wechat.BasePayTestCase;
import org.bana.wechat.pay.common.SignUtil;
import org.bana.wechat.pay.refund.param.RefundParam;
import org.bana.wechat.pay.refund.param.RefundQueryParam;
import org.bana.wechat.pay.refund.result.RefundQueryResult;
import org.bana.wechat.pay.refund.result.RefundResult;
import org.bana.wechat.qy.common.WeChatConnection;
import org.junit.Test;

/** 
 * @ClassName: RefundClientTest 
 * @Description: 
 *  
 */
public class RefundClientTest extends BasePayTestCase{

	/**
	 * Test method for {@link org.bana.wechat.pay.refund.RefundClient#refund(org.bana.wechat.pay.refund.param.RefundParam)}.
	 */
	@Test
	public void testRefund() {
		WeChatConnection.setCertPassword(certPassword);
		RefundParam param = new RefundParam();
		initPayParam(param);
		param.setDevice_info("device_info");
		param.setOp_user_id("liuwenjie");
		param.setOut_refund_no("121775250120134023233368019");
		//param.setTransaction_id(transaction_id);
		param.setOut_trade_no("1217752501201407033233368018");
		param.setRefund_fee(880);
		param.setRefund_fee_type("CNY");
		param.setTotal_fee(880);
		param.setSign(SignUtil.getSign(param, apiKey));
		RefundResult refund = RefundClient.refund(param);
		System.out.println(JSONSerializer.toJSON(refund));
	}
	
	@Test
	public void testQueryRefund(){
		RefundQueryParam param = new RefundQueryParam();
		initPayParam(param);
		param.setDevice_info("device_info");
		param.setOut_trade_no("1217752501201407033233368018");
		param.setSign(SignUtil.getSign(param, apiKey));
		RefundQueryResult queryRefund = RefundClient.queryRefund(param);
		System.out.println(JSONSerializer.toJSON(queryRefund));
	}

}
