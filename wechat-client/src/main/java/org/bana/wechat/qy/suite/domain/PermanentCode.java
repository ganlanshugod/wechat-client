/**
* @Company 青鸟软通   
* @Title: PermanentCode.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 上午11:57:11 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

import org.bana.wechat.qy.connection.domain.AccessToken;

/** 
 * @ClassName: PermanentCode 
 * @Description: 永久授权码
 *  
 */
public class PermanentCode extends AccessToken{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -6897856165713034419L;
	private String permanent_code;
	private AuthCorpInfo auth_corp_info;
	private AuthInfo auth_info;
	private AuthUserInfo auth_user_info;
	/**
	 * @Description: 属性 permanent_code 的get方法 
	 * @return permanent_code
	 */
	public String getPermanent_code() {
		return permanent_code;
	}
	/**
	 * @Description: 属性 permanent_code 的set方法 
	 * @param permanent_code 
	 */
	public void setPermanent_code(String permanent_code) {
		this.permanent_code = permanent_code;
	}
	/**
	 * @Description: 属性 auth_corp_info 的get方法 
	 * @return auth_corp_info
	 */
	public AuthCorpInfo getAuth_corp_info() {
		return auth_corp_info;
	}
	/**
	 * @Description: 属性 auth_corp_info 的set方法 
	 * @param auth_corp_info 
	 */
	public void setAuth_corp_info(AuthCorpInfo auth_corp_info) {
		this.auth_corp_info = auth_corp_info;
	}
	/**
	 * @Description: 属性 auth_info 的get方法 
	 * @return auth_info
	 */
	public AuthInfo getAuth_info() {
		return auth_info;
	}
	/**
	 * @Description: 属性 auth_info 的set方法 
	 * @param auth_info 
	 */
	public void setAuth_info(AuthInfo auth_info) {
		this.auth_info = auth_info;
	}
	/**
	 * @Description: 属性 auth_user_info 的get方法 
	 * @return auth_user_info
	 */
	public AuthUserInfo getAuth_user_info() {
		return auth_user_info;
	}
	/**
	 * @Description: 属性 auth_user_info 的set方法 
	 * @param auth_user_info 
	 */
	public void setAuth_user_info(AuthUserInfo auth_user_info) {
		this.auth_user_info = auth_user_info;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 下午1:14:39 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "PermanentCode [permanent_code=" + permanent_code + ", auth_corp_info=" + auth_corp_info + ", auth_info=" + auth_info + ", auth_user_info=" + auth_user_info + "]";
	}
	
}
