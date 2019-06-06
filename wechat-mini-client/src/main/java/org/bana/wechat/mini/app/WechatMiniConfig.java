/**
 * @Company Elink
 * @Title: WechatMiniConfig.java
 * @Package org.bana.wechat.mp.common
 * @author Liu Wenjie
 * @date 2018年5月15日 下午5:53:20
 * @version V1.0
 */
package org.bana.wechat.mini.app;

import java.io.Serializable;

/**
 * @ClassName: WechatMiniConfig
 * @Description: Mini的配置信息
 * @author Liu Wenjie
 */
public class WechatMiniConfig implements Serializable{

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 7639458152535981525L;
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
		return "WechatMiniConfig [appId=" + appId + ", secret=" + secret + "]";
	}
	

}
