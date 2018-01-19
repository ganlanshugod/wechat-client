/**
* @Company 青鸟软通   
* @Title: AccessToken.java 
* @Package org.bana.wechat.qy.connection.domain 
* @author Liu Wenjie   
* @date 2015-5-9 下午4:07:37 
* @version V1.0   
*/ 
package org.bana.wechat.mp.token.domain;

import java.io.Serializable;

/** 
 * @ClassName: AccessToken 
 * @Description: 令牌对象
 *  
 */
public class AccessToken implements Serializable{
	
	/** 
	* @Fields serialVersionUID :  
	*/ 
	private static final long serialVersionUID = 7591726493800805415L;

	/** 
	* @Fields accessToken : 登录令牌 
	*/
	private String access_token;
	
	/** 
	* @Fields expiresIn : 过期时间，单位为”秒“
	*/ 
	private String expires_in;
	
	
	
	/*=================getter and setter and equals and hashCode===============*/
	
	
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-9 下午4:09:26 
	* @return 
	* @see java.lang.Object#hashCode() 
	*/ 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access_token == null) ? 0 : access_token.hashCode());
		return result;
	}
	/**
	 * @Description: 属性 access_token 的get方法 
	 * @return access_token
	 */
	public String getAccess_token() {
		return access_token;
	}
	/**
	 * @Description: 属性 access_token 的set方法 
	 * @param access_token 
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
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
	* @date 2015-5-9 下午4:09:26 
	* @param obj
	* @return 
	* @see java.lang.Object#equals(java.lang.Object) 
	*/ 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccessToken other = (AccessToken) obj;
		if (access_token == null) {
			if (other.access_token != null)
				return false;
		} else if (!access_token.equals(other.access_token))
			return false;
		return true;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-9 下午4:09:08 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AccessToken [access_token=" + access_token + ", expires_in=" + expires_in + "]";
	}
	
}
