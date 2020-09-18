/**
* @Company 全域旅游
* @Title: WechatMpComponentProperties.java 
* @Package org.bana.springboot.wechat.mp.component 
* @author liuwenjie   
* @date Sep 17, 2020 12:51:59 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.component;

import java.util.List;

import org.bana.wechat.mp.component.common.WechatMpComponentConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** 
* @ClassName: WechatMpComponentProperties 
* @Description: 服务号对应的第三方授权功能配置
* @author liuwenjie   
*/
@ConfigurationProperties(prefix=WechatMpComponentProperties.WECHAT_MP_COMP_PREFIX)
public class WechatMpComponentProperties {

	public static final String WECHAT_MP_COMP_PREFIX = "wechat.mp.component";
	
	private String enable;  // 决定是否开启第三方应用对应的支持功能
	
	private List<WechatMpComponentConfig> config;

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public List<WechatMpComponentConfig> getConfig() {
		return config;
	}

	public void setConfig(List<WechatMpComponentConfig> config) {
		this.config = config;
	}

	@Override
	public String toString() {
		return "WechatMpComponentProperties [enable=" + enable + ", config=" + config + "]";
	}
	
}
