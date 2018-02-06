/**
* @Company 青鸟软通   
* @Title: SuiteToken.java 
* @Package org.bana.wechat.qy.connection.domain 
* @author Liu Wenjie   
* @date 2015-5-12 下午9:09:45 
* @version V1.0   
*/ 
package org.bana.wechat.cp.token.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

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
	
	@JSONField(name="suite_access_token")
	private String suiteAccessToken; //应用套件access_token
	@JSONField(name="expires_in")
	private String expiresIn; //有效期
	
	
	/**
	 * @Description: 属性 suiteAccessToken 的get方法 
	 * @return suiteAccessToken
	 */
	public String getSuiteAccessToken() {
		return suiteAccessToken;
	}
	/**
	 * @Description: 属性 suiteAccessToken 的set方法 
	 * @param suiteAccessToken
	 */
	public void setSuiteAccessToken(String suiteAccessToken) {
		this.suiteAccessToken = suiteAccessToken;
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
	 * @date 2018年1月31日 下午5:35:04
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suiteAccessToken == null) ? 0 : suiteAccessToken.hashCode());
		return result;
	}
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月31日 下午5:35:04
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
		SuiteAccessToken other = (SuiteAccessToken) obj;
		if (suiteAccessToken == null) {
			if (other.suiteAccessToken != null)
				return false;
		} else if (!suiteAccessToken.equals(other.suiteAccessToken))
			return false;
		return true;
	}
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月25日 下午2:27:39
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuiteAccessToken [suiteAccessToken=" + suiteAccessToken + ", expiresIn=" + expiresIn + "]";
	}
	
}
