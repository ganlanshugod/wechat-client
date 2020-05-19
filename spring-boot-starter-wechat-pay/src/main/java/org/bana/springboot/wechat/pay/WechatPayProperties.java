/**
* @Company 全域旅游
* @Title: WechatPayPropertes.java 
* @Package org.bana.springboot.wechat.pay 
* @author liuwenjie   
* @date May 18, 2020 2:18:36 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.pay;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** 
* @ClassName: WechatPayPropertes 
* @Description: 微信支付的自动配置参数
* @author liuwenjie   
*/
@ConfigurationProperties(prefix=WechatPayProperties.WECHAT_PAY_PREFIX)
public class WechatPayProperties {

	public static final String WECHAT_PAY_PREFIX = "wechat.pay";
	
	
}
