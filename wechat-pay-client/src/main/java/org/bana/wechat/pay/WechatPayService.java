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
	 
	 
}
