/**
* @Company 青鸟软通   
* @Title: PreAuthCode.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 上午9:51:07 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

/** 
 * @ClassName: PreAuthCode 
 * @Description: 
 *  
 */
public class PreAuthCode {
	
	private String pre_auth_code;
	private Integer expires_in;
	
	
	
	/**
	 * @Description: 属性 pre_auth_code 的get方法 
	 * @return pre_auth_code
	 */
	public String getPre_auth_code() {
		return pre_auth_code;
	}
	/**
	 * @Description: 属性 pre_auth_code 的set方法 
	 * @param pre_auth_code 
	 */
	public void setPre_auth_code(String pre_auth_code) {
		this.pre_auth_code = pre_auth_code;
	}
	/**
	 * @Description: 属性 expires_in 的get方法 
	 * @return expires_in
	 */
	public Integer getExpires_in() {
		return expires_in;
	}
	/**
	 * @Description: 属性 expires_in 的set方法 
	 * @param expires_in 
	 */
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 上午9:54:06 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "PreAuthCode [pre_auth_code=" + pre_auth_code + ", expires_in=" + expires_in + "]";
	}
	
}
