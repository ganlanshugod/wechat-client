/**
* @Company 青鸟软通   
* @Title: AccessToken.java 
* @Package org.bana.wechat.qy.connection.domain 
* @author Liu Wenjie   
* @date 2015-5-9 下午4:07:37 
* @version V1.0   
*/ 
package org.bana.wechat.cp.token.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

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
	@JSONField(name="access_token")
	private String accessToken;
	/** 
	* @Fields expiresIn : 过期时间，单位为”秒“
	*/
	@JSONField(name="expires_in")
	private String expiresIn;
	
	
	/*=================getter and setter and equals and hashCode===============*/
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月25日 下午2:01:16
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessToken == null) ? 0 : accessToken.hashCode());
		return result;
	}
	/**
	 * @Description: 属性 accessToken 的get方法 
	 * @return accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @Description: 属性 accessToken 的set方法 
	 * @param accessToken
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @Description: 属性 expiresIn 的get方法 
	 * @return expiresIn
	 */
	public String getExpiresIn() {
		return expiresIn;
	}
	/**
	 * @Description: 属性 expiresIn 的set方法 
	 * @param expiresIn
	 */
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月25日 下午2:01:16
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
		if (accessToken == null) {
			if (other.accessToken != null)
				return false;
		} else if (!accessToken.equals(other.accessToken))
			return false;
		return true;
	}
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月25日 下午2:02:05
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccessToken [accessToken=" + accessToken + ", expiresIn=" + expiresIn + "]";
	}
}
