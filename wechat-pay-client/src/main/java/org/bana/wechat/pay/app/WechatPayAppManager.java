/**
* @Company 全域旅游
* @Title: WechatPayAppManager.java 
* @Package org.bana.wechat.pay.app 
* @author liuwenjie   
* @date May 15, 2020 5:46:28 PM 
* @version V1.0   
*/ 
package org.bana.wechat.pay.app;

import org.bana.wechat.pay.common.WechatPayConfig;

/** 
* @ClassName: WechatPayAppManager 
* @Description: 管理wechatPay的方法
* @author liuwenjie   
*/
public interface WechatPayAppManager {

	/** 
	* @Description: 根据WxPayParam参数获取WxApp的方法
	* @author liuwenjie   
	* @date May 15, 2020 5:48:08 PM 
	* @param param
	* @return  
	*/ 
	public WechatPayConfig getWechatPayConfig(WxPayParam param);
}
