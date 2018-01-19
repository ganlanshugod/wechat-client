/**
* @Company 青鸟软通   
* @Title: UnifiedOrderClientTest.java 
* @Package org.bana.wechat.pay.unifiedorder 
* @author Liu Wenjie   
* @date 2015-9-17 下午5:49:00 
* @version V1.0   
*/ 
package org.bana.wechat.pay.unifiedorder;

import org.bana.common.util.basic.CodeUtil;
import org.bana.common.util.basic.DateUtil;
import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.BasePayTestCase;
import org.bana.wechat.pay.common.SignUtil;
import org.bana.wechat.pay.order.OrderClient;
import org.bana.wechat.pay.order.domain.UnifiedOrderDomain;
import org.bana.wechat.pay.order.param.UnifiedOrderParam;
import org.junit.Test;

/** 
 * @ClassName: UnifiedOrderClientTest 
 * @Description: 统一下单的接口
 *  
 */
public class UnifiedOrderClientTest extends BasePayTestCase{

	/**
	 * Test method for {@link org.bana.wechat.pay.unifiedorder.UnifiedOrderClient#unifiedOrder(org.bana.wechat.pay.unifiedorder.param.UnifiedOrderParam)}.
	 */
	@Test
	public void testUnifiedOrder() {
		UnifiedOrderParam param = new UnifiedOrderParam();
		param.setNonce_str(StringUtils.getRandomStr());
		param.setBody("话费充值的测试");
		param.setDetail("话费充值的测试方式，我们绝对不会真的给你冲话费的，如果你通过任何其他途径访问到了此链接的付款，我们概不负责，也不退款，谢谢。");
		param.setAttach("附加说明，商户自己定义，会原样返回");
		param.setOut_trade_no(CodeUtil.generatorNumberCode());
		param.setFee_type("CNY");
		param.setTotal_fee(88);//单位是分
		param.setSpbill_create_ip("192.168.31.205");
		param.setTime_start(DateUtil.getNowString("yyyyMMddHHmmss"));
		param.setTime_expire(DateUtil.toString(DateUtil.nextDay(),"yyyyMMddHHmmss"));
		param.setGoods_tag("WXG");
		param.setNotify_url("http://www.baidu.com");
		param.setTrade_type("JSAPI");
		param.setProduct_id("12235413214070356458058");
		param.setLimit_pay("no_credit");
//		param.setOpenid("oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");
		param.setOpenid("o5gixt1iegc8Bjqdd9yytlYWD6Ow");
		param.setAppid(appId);
		param.setMch_id(mch_id);
		param.setDevice_info("Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Mobile/12B440 MicroMessenger/6.2.7 NetType/WIFI Language/zh_CNs");
		param.setNonce_str(StringUtils.getRandomStr());
		//                     150929111924215-5398318542
		param.setOut_trade_no("12177525012014-07033233368018");
		String sign = SignUtil.getSign(param, apiKey);
		param.setSign(sign);
		UnifiedOrderDomain unifiedOrder = OrderClient.unifiedOrder(param);
		//UnifiedOrderDomain [appid=wx9ea95f1dc1ba973f, mch_id=1265342501, device_info=WEB, nonce_str=PmJ6nRTRA0emYuD9, sign=65ECB04B6A6AABFF04CE3A6816539C3A, result_code=SUCCESS, err_code=null, err_code_des=null, trade_type=JSAPI, prepay_id=wx2015092212154962c6857a0b0583399874, code_url=null, return_code=SUCCESS, return_msg=OK]
	}

}
