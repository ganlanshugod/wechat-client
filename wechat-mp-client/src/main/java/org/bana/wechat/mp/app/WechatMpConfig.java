/**
 * @Company JBINFO
 * @Title: WechatMpConfig.java
 * @Package org.bana.wechat.mp.common
 * @author Liu Wenjie
 * @date 2018年5月15日 下午5:53:20
 * @version V1.0
 */
package org.bana.wechat.mp.app;

import java.io.Serializable;

/**
 * @ClassName: WechatMpConfig
 * @Description: Mp的配置信息
 * @author Liu Wenjie
 */
public class WechatMpConfig implements Serializable{

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -2747044207333259480L;
	private String appId;
	private String secret;
	
	/*=========getter and setter ==========*/
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
	@Override
	public String toString() {
		return "WechatMpConfig [appId=" + appId + ", secret=" + secret + "]";
	}
	

}
