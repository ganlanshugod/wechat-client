/**
* @Company 全域旅游
* @Title: WxPayFactory.java 
* @Package org.bana.wechat.pay.app 
* @author liuwenjie   
* @date May 15, 2020 5:43:33 PM 
* @version V1.0   
*/ 
package org.bana.wechat.pay.app;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.pay.common.WeChatPayException;
import org.bana.wechat.pay.common.WechatPayConfig;

import com.github.wxpay.sdk.WXPay;

/** 
* @ClassName: WxPayFactory 
* @Description: WxPay的工厂类方法
* @author liuwenjie   
*/
public class WxPayFactory {

	private WechatPayAppManager wechatPayAppManager;
	
	private WxPayCache wxPayCache;
	
	
	/** 
	* @Description: 工厂类生产wxPay的方法
	* @author liuwenjie   
	* @date May 18, 2020 1:23:18 PM 
	* @param param
	* @return  
	*/ 
	public WXPay getWxPay(WxPayParam param) {
		if(param == null || StringUtils.isAnyBlank(param.getAppId(),param.getMchId())) {
			throw new WeChatPayException(WeChatPayException.PARAM_ERROR,"错误的微信Pay参数"+param);
		}
		if(wxPayCache == null) {
			return this.getInstance(param);
		}else {
			WXPay wxPay = wxPayCache.get(param);
			if(wxPay == null) {
				wxPay = this.getInstance(param);
				wxPayCache.put(param, wxPay);
			}
			return wxPay;
		}
	}
	/**
	* @Description: 实例化方法
	* @author liuwenjie   
	* @date May 18, 2020 1:23:02 PM 
	* @param wechatPayConfig
	* @return
	 */
	protected  WXPay instance(WechatPayConfig wechatPayConfig) {
		return new WXPay(wechatPayConfig);
	}
	
	private WXPay getInstance(WxPayParam param) {
		WechatPayConfig wechatPayConfig = wechatPayAppManager.getWechatPayConfig(param);
		if(wechatPayConfig == null) {
			throw new WeChatPayException(WeChatPayException.APP_PARAM_ERROR1,"没有获取到"+param+"对应的支付配置");
		}
		return this.instance(wechatPayConfig);
	}
	
	
	

	public void setWechatPayAppManager(WechatPayAppManager wechatPayAppManager) {
		this.wechatPayAppManager = wechatPayAppManager;
	}

	public void setWxPayCache(WxPayCache wxPayCache) {
		this.wxPayCache = wxPayCache;
	}
	
}
