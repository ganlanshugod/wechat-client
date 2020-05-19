/**
* @Company 全域旅游
* @Title: WxPayProxyFactory.java 
* @Package org.bana.springboot.wechat.pay.factory 
* @author liuwenjie   
* @date May 19, 2020 2:27:47 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.pay.factory;

import org.bana.wechat.pay.app.WxPayFactory;
import org.bana.wechat.pay.common.WechatPayConfig;

import com.github.wxpay.sdk.WXPay;

/** 
* @ClassName: WxPayProxyFactory 
* @Description: 针对wxPayFactory增加的带有日志的工厂类
* @author liuwenjie   
*/
public class WxPayProxyFactory extends WxPayFactory {

	/**
	* <p>Description: </p> 
	* @author liuwenjie 
	* @date May 19, 2020 2:28:40 PM 
	* @param wechatPayConfig
	* @return 
	* @see org.bana.wechat.pay.app.WxPayFactory#instance(org.bana.wechat.pay.common.WechatPayConfig) 
	*/ 
	@Override
	protected WXPay instance(WechatPayConfig wechatPayConfig) {
		WXPay wxPayProxy = (WXPay)WxPayLogProxy.getWxPayProxy(new WXPay(wechatPayConfig),wechatPayConfig);
		return wxPayProxy;
	}
	
}
