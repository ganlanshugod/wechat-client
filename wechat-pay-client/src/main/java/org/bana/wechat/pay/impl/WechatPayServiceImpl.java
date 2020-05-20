/**
* @Company 全域旅游
* @Title: WechatPayServiceImpl.java 
* @Package org.bana.wechat.pay.impl 
* @author liuwenjie   
* @date May 15, 2020 5:26:47 PM 
* @version V1.0   
*/ 
package org.bana.wechat.pay.impl;

import java.util.Map;

import org.bana.wechat.pay.WechatPayService;
import org.bana.wechat.pay.app.WxPayFactory;
import org.bana.wechat.pay.app.WxPayParam;

/** 
* @ClassName: WechatPayServiceImpl 
* @Description: wechatImpl配置
* @author liuwenjie   
*/
public class WechatPayServiceImpl implements WechatPayService{

	
	private WxPayFactory wxPayFactory;
	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date May 15, 2020 5:42:56 PM 
	* @param payConfig
	* @param reqData
	* @return
	* @throws Exception 
	* @see org.bana.wechat.pay.WechatPayService#unifiedOrder(org.bana.wechat.pay.app.WxPayParam, java.util.Map) 
	*/ 
	@Override
	public Map<String, String> unifiedOrder(WxPayParam payParam, Map<String, String> reqData) throws Exception {
		return wxPayFactory.getWxPay(payParam).unifiedOrder(reqData);
	}
	/**
	* <p>Description: 退款</p> 
	* @author zhangzhichao   
	* @date May 20, 2020 5:41:58 PM 
	* @param payParam
	* @param reqData
	* @return
	* @throws Exception 
	* @see org.bana.wechat.pay.WechatPayService#refund(org.bana.wechat.pay.app.WxPayParam, java.util.Map) 
	*/ 
	@Override
	public Map<String, String> refund(WxPayParam payParam, Map<String, String> reqData) throws Exception {
		return wxPayFactory.getWxPay(payParam).refund(reqData);
	}
	/**
	* <p>Description: 验证签名</p> 
	* @author zhangzhichao   
	* @date May 20, 2020 5:45:25 PM 
	* @param payParam
	* @param reqData
	* @return
	* @throws Exception 
	* @see org.bana.wechat.pay.WechatPayService#isPayResultNotifySignatureValid(org.bana.wechat.pay.app.WxPayParam, java.util.Map) 
	*/ 
	@Override
	public boolean isPayResultNotifySignatureValid(WxPayParam payParam, Map<String, String> reqData) throws Exception {
		return wxPayFactory.getWxPay(payParam).isPayResultNotifySignatureValid(reqData);
	}
	
	public void setWxPayFactory(WxPayFactory wxPayFactory) {
		this.wxPayFactory = wxPayFactory;
	}
	
}
