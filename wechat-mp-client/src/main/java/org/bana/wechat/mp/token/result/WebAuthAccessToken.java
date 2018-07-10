/**
 * @Company JBINFO
 * @Title: WebAccessToken.java
 * @Package org.bana.wechat.mp.token.result
 * @author Liu Wenjie
 * @date 2018年5月15日 下午12:54:19
 * @version V1.0
 */
package org.bana.wechat.mp.token.result;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: WebAccessToken
 * @Description: 网页授权AccessToken
 * @author Liu Wenjie
 */
public class WebAuthAccessToken extends AccessToken {

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = 4801765338269937641L;

	@JSONField(name="refresh_token")
	private String refreshToken; // 用户刷新access_token
	@JSONField(name="openid")
	private String openId; // 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
	private String scope; //
	@JSONField(name="unionid")
	private String unionId; // 用户在开发平台上的unionId字段
	
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	@Override
	public String toString() {
		return "WebAuthAccessToken [refreshToken=" + refreshToken + ", openId=" + openId + ", scope=" + scope
				+ ", toString()=" + super.toString() + "]";
	}
	
}
