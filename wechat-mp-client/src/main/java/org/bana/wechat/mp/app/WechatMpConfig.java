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
	private String appId; //必填
	private String secret; // 应用是自己按类型的时候，必填此项
	private String token; // 如果配置自建类型的回调地址时，如果启用加密配置，则必须配置此信息
	private String encodingAESKey; //如果配置自建类型的回调地址时，如果启用加密配置，则必须配置此信息
	private String mpType = MpType.自建类型.getValue();
	private String authorizerRefreshToken;  // 应用是第三方授权类型时，必填此项
	private String componentAppid; // 应用是第三方授权类型时，必填此项
	
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
	
	public String getMpType() {
		return mpType;
	}
	public void setMpType(String mpType) {
		this.mpType = mpType;
	}
	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}
	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}
	public String getComponentAppid() {
		return componentAppid;
	}
	public void setComponentAppid(String componentAppid) {
		this.componentAppid = componentAppid;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEncodingAESKey() {
		return encodingAESKey;
	}
	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}
	
	@Override
	public String toString() {
		return "WechatMpConfig [appId=" + appId + ", secret=" + secret + ", token=" + token + ", encodingAESKey="
				+ encodingAESKey + ", mpType=" + mpType + ", authorizerRefreshToken=" + authorizerRefreshToken
				+ ", componentAppid=" + componentAppid + "]";
	}

}
