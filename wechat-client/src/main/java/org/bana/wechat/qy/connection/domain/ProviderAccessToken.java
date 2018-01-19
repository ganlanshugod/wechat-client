/**
* @Company 青鸟软通   
* @Title: ProviderAccessToken.java 
* @Package org.bana.wechat.qy.connection.domain 
* @author R.Core
* @date 2016-3-22 下午4:07:37 
* @version V1.0   
*/ 
package org.bana.wechat.qy.connection.domain;

import java.io.Serializable;

/** 
 * @ClassName: ProviderAccessToken 
 * @Description: 服务商令牌对象
 *  
 */
public class ProviderAccessToken implements Serializable{
	
	/** 
	* @Fields serialVersionUID :  
	*/ 
	private static final long serialVersionUID = 7591726493800805415L;

	/** 
	* @Fields accessToken : 登录令牌 
	*/
	private String provider_access_token;
	
	/** 
	* @Fields expiresIn : 过期时间，单位为”秒“
	*/ 
	private String expires_in;

	/*=================getter and setter and equals and hashCode===============*/
	/**
	 * @Description: 属性 provider_access_token 的get方法 
	 * @return provider_access_token
	 */
	public String getProvider_access_token() {
		return provider_access_token;
	}

	/**
	 * @Description: 属性 provider_access_token 的set方法 
	 * @param provider_access_token 
	 */
	public void setProvider_access_token(String provider_access_token) {
		this.provider_access_token = provider_access_token;
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
	* @author Richard Core   
	* @date 2016-3-22 下午2:42:05 
	* @return 
	* @see java.lang.Object#hashCode() 
	*/ 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((provider_access_token == null) ? 0 : provider_access_token
						.hashCode());
		return result;
	}

	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-3-22 下午2:42:05 
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
		ProviderAccessToken other = (ProviderAccessToken) obj;
		if (provider_access_token == null) {
			if (other.provider_access_token != null)
				return false;
		} else if (!provider_access_token.equals(other.provider_access_token))
			return false;
		return true;
	}

	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-3-22 下午2:42:11 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "ProviderAccessToken [provider_access_token="
				+ provider_access_token + ", expires_in=" + expires_in + "]";
	}
	
	
	
	

	
}
