/**
* @Company 全域旅游
* @Title: WechatPayService.java 
* @Package org.bana.wechat.pay 
* @author liuwenjie   
* @date May 15, 2020 5:18:32 PM 
* @version V1.0   
*/ 
package org.bana.wechat.pay;

import java.util.Map;

import org.bana.wechat.pay.app.WxPayParam;

/** 
* @ClassName: WechatPayService 
* @Description: WxPayService 封装的执行微信支付的方法
* @author liuwenjie   
*/
public interface WechatPayService {

	/** 
	* @Description: 统一下单接口
	* @author liuwenjie   
	* @date May 15, 2020 5:42:33 PM 
	* @param payParam 执行微信支付的payParam，包括appId和mchId
	* @param reqData 请求数据Map对象
	* @return
	* @throws Exception  
	*/ 
	public Map<String, String> unifiedOrder(WxPayParam payParam,Map<String, String> reqData) throws Exception;
	
	/** 
	* @Description: 付款码支付
	* @author zhangzhichao   
	* @date 2022年2月23日 下午3:09:58 
	* @param payParam
	* @param reqData
	* @return
	* @throws Exception  
	*/ 
	public Map<String, String> microPay(WxPayParam payParam,Map<String, String> reqData) throws Exception;
	
	/** 
	* @Description: 退款
	* @author zhangzhichao   
	* @date May 20, 2020 5:41:36 PM 
	* @param payParam
	* @param reqData
	* @return
	* @throws Exception  
	*/ 
	public Map<String, String> refund(WxPayParam payParam,Map<String, String> reqData) throws Exception;
	
	/** 
	* @Description: 查询支付单
	* @author zhangzhichao   
	* @date Jul 3, 2020 2:48:44 PM 
	* @param payParam
	* @param reqData
	* @return
	* @throws Exception  
	*/ 
	public Map<String, String> orderQuery(WxPayParam payParam,Map<String, String> reqData) throws Exception;
	
	/** 
	* @Description: 查询退款单
	* @author zhangzhichao   
	* @date Jul 6, 2020 9:24:55 AM 
	* @param payParam
	* @param reqData
	* @return
	* @throws Exception  
	*/ 
	public Map<String, String> refundQuery(WxPayParam payParam,Map<String, String> reqData) throws Exception;
	
	/** 
	* @Description: 验证签名
	* @author zhangzhichao   
	* @date May 20, 2020 5:45:01 PM 
	* @param payParam
	* @param reqData
	* @return
	* @throws Exception  
	*/ 
	public boolean isPayResultNotifySignatureValid(WxPayParam payParam,Map<String, String> reqData) throws Exception;
}
