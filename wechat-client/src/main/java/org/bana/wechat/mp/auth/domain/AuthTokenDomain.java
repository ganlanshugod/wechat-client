/**
 * @Company 青鸟软通   
 * @Title: AuthTokenDomain.java 
 * @Package org.bana.wechat.mp.auth.domain 
 * @author Han Tongyang   
 * @date 2015-8-26 下午8:00:00 
 * @version V1.0   
 */
package org.bana.wechat.mp.auth.domain;

import org.bana.wechat.mp.token.domain.AccessToken;

/**
 * @ClassName: AuthTokenDomain
 * @Description: 页面认证Token对象
 * 
 */
public class AuthTokenDomain extends AccessToken {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 1597051433702674137L;

	private String refresh_token; // 用户刷新access_token
	private String openid; // 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
	private String scope; // 用户授权的作用域，使用逗号（,）分隔
	private String unionid; // 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。

	/**
	 * @Description: 属性 refresh_token 的get方法
	 * @return refresh_token
	 */
	public String getRefresh_token() {
		return refresh_token;
	}

	/**
	 * @Description: 属性 refresh_token 的set方法
	 * @param refresh_token
	 */
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	/**
	 * @Description: 属性 openid 的get方法
	 * @return openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @Description: 属性 openid 的set方法
	 * @param openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @Description: 属性 scope 的get方法
	 * @return scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * @Description: 属性 scope 的set方法
	 * @param scope
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * @Description: 属性 unionid 的get方法
	 * @return unionid
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * @Description: 属性 unionid 的set方法
	 * @param unionid
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Han Tongyang
	 * @date 2015-8-26 下午8:02:58
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthTokenDomain [refresh_token=" + refresh_token + ", openid="
				+ openid + ", scope=" + scope + ", unionid=" + unionid + "]";
	}

}
