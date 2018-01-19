/**
* @Company 青鸟软通   
* @Title: AuthUserInfo.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 下午12:16:33 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

/** 
 * @ClassName: AuthUserInfo 
 * @Description: 授权的用户信息
 *  
 */
public class AuthUserInfo {

	private String email;
	private String mobile;
	/**
	 * @Description: 属性 email 的get方法 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @Description: 属性 email 的set方法 
	 * @param email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @Description: 属性 mobile 的get方法 
	 * @return mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @Description: 属性 mobile 的set方法 
	 * @param mobile 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 下午12:17:23 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AuthUserInfo [email=" + email + ", mobile=" + mobile + "]";
	}
	
}
