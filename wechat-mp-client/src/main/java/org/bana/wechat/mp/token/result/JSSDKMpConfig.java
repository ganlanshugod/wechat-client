/**
 * @Company Elink
 * @Title: JSSDKMpConfig.java
 * @Package org.bana.wechat.mp.token.result
 * @author Huang Nana
 * @date 2018年5月16日 上午9:45:39
 * @version V1.0
 */
package org.bana.wechat.mp.token.result;

import java.io.Serializable;

/**
 * @ClassName: JSSDKMpConfig
 * @Description: jssdkconfig
 * @author Huang Nana
 */
public class JSSDKMpConfig implements Serializable {
	private static final long serialVersionUID = -8408578271961487574L;

	private String appId;// '', // 必填，公众号的appid
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
		return "JSSDKMpConfig [appId=" + appId + ", timestamp=" + timestamp + ", nonceStr=" + nonceStr + ", signature="
				+ signature + "]";
	}
}
