/**
 * @Company JBINFO
 * @Title: JSSDKCpConfig.java
 * @Package org.bana.wechat.cp.token.domain
 * @author Liu Wenjie
 * @date 2018年1月30日 下午3:17:26
 * @version V1.0
 */
package org.bana.wechat.cp.token.domain;

import java.io.Serializable;

/**
 * @ClassName: JSSDKCpConfig
 * @Description: 企业号的JSsdk配置对象
 * @author Liu Wenjie
 */
public class JSSDKCpConfig implements Serializable{

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -8408578271961487574L;

	private String appId;// '', // 必填，企业微信的corpID
	private String timestamp;//: , // 必填，生成签名的时间戳
    private String nonceStr;//: '', // 必填，生成签名的随机串
    private String signature;//: '',// 必填，签名，见[附录1](#11974)
    
    
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@Override
	public String toString() {
		return "JSSDKCpConfig [appId=" + appId + ", timestamp=" + timestamp + ", nonceStr=" + nonceStr + ", signature="
				+ signature + "]";
	}
    
}
