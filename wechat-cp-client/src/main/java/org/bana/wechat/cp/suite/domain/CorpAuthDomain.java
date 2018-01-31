/**
 * @Company JBINFO
 * @Title: CorpAuthDomain.java
 * @Package org.bana.wechat.cp.suite.domain
 * @author Zhang Zhichao
 * @date 2018年1月31日 下午12:59:59
 * @version V1.0
 */
package org.bana.wechat.cp.suite.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: CorpAuthDomain
 * @Description: 企业授权信息
 * @author Zhang Zhichao
 */
public class CorpAuthDomain implements Serializable {

	private static final long serialVersionUID = -4591323549303571441L;
	
	@JSONField(name="auth_corp_info")
	private AuthCorpInfo authCorpInfo;
	
	@JSONField(name="auth_info")
	private AuthInfo authInfo;

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
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月31日 下午1:03:11
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CorpAuthDomain [authCorpInfo=" + authCorpInfo + ", authInfo=" + authInfo + "]";
	}
	
}
