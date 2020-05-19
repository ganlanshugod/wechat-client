/**
* @Company 全域旅游
* @Title: WxPayCache.java 
* @Package org.bana.wechat.pay.app 
* @author liuwenjie   
* @date May 15, 2020 5:55:13 PM 
* @version V1.0   
*/ 
package org.bana.wechat.pay.app;

import com.github.wxpay.sdk.WXPay;

/** 
* @ClassName: WxPayCache 
* @Description: wxPay对象的缓存存储
* @author liuwenjie   
*/
public interface WxPayCache {

	WXPay get(WxPayParam param);
	
	void put(WxPayParam param,WXPay wxpay);
	
}
