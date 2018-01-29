/**
 * @Company JBINFO
 * @Title: PermanentCode.java
 * @Package org.bana.wechat.cp.suite.result
 * @author Zhang Zhichao
 * @date 2018年1月29日 上午11:25:11
 * @version V1.0
 */
package org.bana.wechat.cp.suite.domain;

import org.bana.wechat.cp.token.domain.AccessToken;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: PermanentCode
 * @Description: 获取永久授权码时，返回的实体类
 * @author Zhang Zhichao
 */
public class PermanentCode extends AccessToken {
	
	private static final long serialVersionUID = 664260528534170098L;
	/**
	 * @Fields permanentCode : 永久授权码
	 */
	@JSONField(name="permanent_code")
	private String permanentCode;
	
	/**
	 * @Fields authCorpInfo : 授权方企业信息
	 */
	@JSONField(name="auth_corp_info")
	private AuthCorpInfo authCorpInfo;
	
	/**
	 * @Fields authInfo : 授权信息
	 */
	@JSONField(name="auth_info")
	private AuthInfo authInfo;
	
	/**
	 * @Fields authUserInfo : 授权管理员的信息
	 */
	@JSONField(name="auth_user_info")
	private AuthUserInfo authUserInfo;

	/**
	 * @Description: 属性 permanentCode 的get方法 
	 * @return permanentCode
	 */
	public String getPermanentCode() {
		return permanentCode;
	}

	/**
	 * @Description: 属性 permanentCode 的set方法 
	 * @param permanentCode
	 */
	public void setPermanentCode(String permanentCode) {
		this.permanentCode = permanentCode;
	}

	/**
	 * @Description: 属性 authCorpInfo 的get方法 
	 * @return authCorpInfo
	 */
	public AuthCorpInfo getAuthCorpInfo() {
		return authCorpInfo;
	}

	/**
	 * @Description: 属性 authCorpInfo 的set方法 
	 * @param authCorpInfo
	 */
	public void setAuthCorpInfo(AuthCorpInfo authCorpInfo) {
		this.authCorpInfo = authCorpInfo;
	}

	/**
	 * @Description: 属性 authInfo 的get方法 
	 * @return authInfo
	 */
	public AuthInfo getAuthInfo() {
		return authInfo;
	}

	/**
	 * @Description: 属性 authInfo 的set方法 
	 * @param authInfo
	 */
	public void setAuthInfo(AuthInfo authInfo) {
		this.authInfo = authInfo;
	}

	/**
	 * @Description: 属性 authUserInfo 的get方法 
	 * @return authUserInfo
	 */
	public AuthUserInfo getAuthUserInfo() {
		return authUserInfo;
	}

	/**
	 * @Description: 属性 authUserInfo 的set方法 
	 * @param authUserInfo
	 */
	public void setAuthUserInfo(AuthUserInfo authUserInfo) {
		this.authUserInfo = authUserInfo;
	}
	
}
