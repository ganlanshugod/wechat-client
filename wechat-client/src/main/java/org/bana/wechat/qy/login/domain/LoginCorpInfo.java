/**
* @Company 青鸟软通   
* @Title: LoginCorpInfo.java 
* @Package org.bana.wechat.qy.login.domain 
* @author Richard Core   
* @date 2016-3-18 下午5:09:19 
* @version V1.0   
*/ 
package org.bana.wechat.qy.login.domain;

/** 
 * @ClassName: LoginCorpInfo 
 * @Description: 
 *  
 */
public class LoginCorpInfo {
	private String corpid;//	授权方企业号id

	/**
	 * @Description: 属性 corpid 的get方法 
	 * @return corpid
	 */
	public String getCorpid() {
		return corpid;
	}

	/**
	 * @Description: 属性 corpid 的set方法 
	 * @param corpid 
	 */
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-3-18 下午5:09:51 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "LoginCorpInfo [corpid=" + corpid + "]";
	}
	
}
