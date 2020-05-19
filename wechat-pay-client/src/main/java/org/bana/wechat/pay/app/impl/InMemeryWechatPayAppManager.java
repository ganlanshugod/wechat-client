/**
* @Company 全域旅游
* @Title: InMemeryWechatPayAppManager.java 
* @Package org.bana.wechat.pay.app.impl 
* @author liuwenjie   
* @date May 18, 2020 1:45:23 PM 
* @version V1.0   
*/ 
package org.bana.wechat.pay.app.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.pay.app.WechatPayAppManager;
import org.bana.wechat.pay.app.WxPayParam;
import org.bana.wechat.pay.common.WeChatPayException;
import org.bana.wechat.pay.common.WechatPayConfig;

/** 
* @ClassName: InMemeryWechatPayAppManager 
* @Description: 使用内存存储的WechatPayAppManager实现类
* @author liuwenjie   
*/
public class InMemeryWechatPayAppManager implements WechatPayAppManager {

	private Map<WxPayParam,WechatPayConfig> payConfigCache = new HashMap<>();
	
	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date May 18, 2020 1:45:23 PM 
	* @param param
	* @return 
	* @see org.bana.wechat.pay.app.WechatPayAppManager#getWechatPayConfig(org.bana.wechat.pay.app.WxPayParam) 
	*/
	@Override
	public WechatPayConfig getWechatPayConfig(WxPayParam param) {
		return payConfigCache.get(param);
	}
	
	
	public void addWechatPayConfig(WechatPayConfig payConfig) {
		if(payConfig == null || StringUtils.isAnyBlank(payConfig.getAppID(),payConfig.getMchID(),payConfig.getKey())|| payConfig.getCertData() == null){
			throw new WeChatPayException(WeChatPayException.PARAM_ERROR, "错误的微信支付配置"+payConfig);
		}
		WxPayParam param = new WxPayParam(payConfig.getAppID(), payConfig.getMchID());
		payConfigCache.put(param, payConfig);
	}

}
