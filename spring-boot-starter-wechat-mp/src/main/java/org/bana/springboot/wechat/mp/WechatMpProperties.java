/**
 * @Company JBINFO
 * @Title: WechatCpProperties.java
 * @Package org.bana.springboot.wechat.cp
 * @author Liu Wenjie
 * @date 2018年1月22日 上午10:06:28
 * @version V1.0
 */
package org.bana.springboot.wechat.mp;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: WechatCpProperties
 * @Description: 微信的配置项
 * @author Liu Wenjie
 */
@ConfigurationProperties(prefix=WechatMpProperties.WECHAT_MP_PREFIX)
public class WechatMpProperties {

	public static final String WECHAT_MP_PREFIX = "wechat.mp";
	
	private String appId;
	
	private String secret;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
}
