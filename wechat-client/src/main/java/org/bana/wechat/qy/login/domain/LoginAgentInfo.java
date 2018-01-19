/**
* @Company 青鸟软通   
* @Title: LoginAgentInfo.java 
* @Package org.bana.wechat.qy.login.domain 
* @author Richard Core   
* @date 2016-3-18 下午5:10:30 
* @version V1.0   
*/ 
package org.bana.wechat.qy.login.domain;

/** 
 * @ClassName: LoginAgentInfo 
 * @Description: 
 *  
 */
public class LoginAgentInfo {
	private Integer agentid;//	应用id
	private Integer auth_type;//	该管理员对应用的权限：1.管理权限，0.使用权限
	/**
	 * @Description: 属性 agentid 的get方法 
	 * @return agentid
	 */
	public Integer getAgentid() {
		return agentid;
	}
	/**
	 * @Description: 属性 agentid 的set方法 
	 * @param agentid 
	 */
	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}
	/**
	 * @Description: 属性 auth_type 的get方法 
	 * @return auth_type
	 */
	public Integer getAuth_type() {
		return auth_type;
	}
	/**
	 * @Description: 属性 auth_type 的set方法 
	 * @param auth_type 
	 */
	public void setAuth_type(Integer auth_type) {
		this.auth_type = auth_type;
	}
	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-3-18 下午5:11:27 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "LoginAgentInfo [agentid=" + agentid + ", auth_type="
				+ auth_type + "]";
	}
}
