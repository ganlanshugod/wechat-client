/**
* @Company 全域旅游
* @Title: WechatMpCallbackProperties.java 
* @Package org.bana.springboot.wechat.mp.callback 
* @author liuwenjie   
* @date Sep 29, 2020 11:58:52 AM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.callback;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** 
* @ClassName: WechatMpCallbackProperties 
* @Description: 回调方法对应的配置类
* @author liuwenjie   
*/
@ConfigurationProperties(prefix=WechatMpCallbackProperties.WECHAT_MP_CALLBACK_PREFIX)
public class WechatMpCallbackProperties {

	public static final String WECHAT_MP_CALLBACK_PREFIX = "wechat.mp.callback";
	
	private String enable;  // 决定是否开启第三方应用对应的支持功能

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	
}
