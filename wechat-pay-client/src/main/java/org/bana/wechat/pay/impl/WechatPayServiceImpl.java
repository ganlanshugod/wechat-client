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
	
	
	public void setWxPayFactory(WxPayFactory wxPayFactory) {
		this.wxPayFactory = wxPayFactory;
	}
	
}
