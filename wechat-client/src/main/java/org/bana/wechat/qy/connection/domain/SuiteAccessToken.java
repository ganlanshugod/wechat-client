/**
* @Company 青鸟软通   
* @Title: SuiteToken.java 
* @Package org.bana.wechat.qy.connection.domain 
* @author Liu Wenjie   
* @date 2015-5-12 下午9:09:45 
* @version V1.0   
*/ 
package org.bana.wechat.qy.connection.domain;

import java.io.Serializable;

/** 
 * @ClassName: SuiteToken 
 * @Description: 套件的访问令牌
 *  
 */
public class SuiteAccessToken implements Serializable{
	
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -6707769228520196018L;
	private String suite_access_token; //应用套件access_token
	private String expires_in; //有效期
	/**
	 * @Description: 属性 suite_access_token 的get方法 
	 * @return suite_access_token
	 */
	public String getSuite_access_token() {
		return suite_access_token;
	}
	/**
	 * @Description: 属性 suite_access_token 的set方法 
	 * @param suite_access_token 
	 */
	public void setSuite_access_token(String suite_access_token) {
		this.suite_access_token = suite_access_token;
	}
	/**
	 * @Description: 属性 expires_in 的get方法 
	 * @return expires_in
	 */
	public String getExpires_in() {
		return expires_in;
	}
	/**
	 * @Description: 属性 expires_in 的set方法 
	 * @param expires_in 
	 */
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-12 下午9:10:58 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "SuiteToken [suite_access_token=" + suite_access_token + ", expires_in=" + expires_in + "]";
	}
	
}
