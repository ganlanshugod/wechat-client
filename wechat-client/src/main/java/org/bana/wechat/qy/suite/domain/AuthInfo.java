/**
* @Company 青鸟软通   
* @Title: AuthInfo.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 下午12:17:55 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

import java.util.List;

/** 
 * @ClassName: AuthInfo 
 * @Description: 授权信息
 *  
 */
public class AuthInfo {

	private List<Agent> agent;
	
	/**
	 * @since 20170503 新的通讯录权限体系都是新的，返回值的组织不再这个组织内部了
	 */
	@Deprecated
	private List<Department> department;
	
	/** 
	* @Fields is_new_auth : 新通讯录增加的字段，是否是新通讯录权限的标示
	* @Deprecated @since 2017-05-03 企业微信的接口中，已经没有了这个字段的标识
	*/ 
	@Deprecated
	private boolean is_new_auth;

	/**
	 * @Description: 属性 agent 的get方法 
	 * @return agent
	 */
	public List<Agent> getAgent() {
		return agent;
	}

	/**
	 * @Description: 属性 agent 的set方法 
	 * @param agent 
	 */
	public void setAgent(List<Agent> agent) {
		this.agent = agent;
	}

	/**
	 * @Description: 属性 department 的get方法 
	 * @return department
	 */
	@Deprecated
	public List<Department> getDepartment() {
		return department;
	}

	/**
	 * @Description: 属性 department 的set方法 
	 * @param department 
	 */
	@Deprecated
	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	

	/**
	 * @Description: 属性 is_new_auth 的get方法 
	 * @return is_new_auth
	 */
	@Deprecated
	public boolean isIs_new_auth() {
		return is_new_auth;
	}

	/**
	 * @Description: 属性 is_new_auth 的set方法 
	 * @param is_new_auth 
	 */
	@Deprecated
	public void setIs_new_auth(boolean is_new_auth) {
		this.is_new_auth = is_new_auth;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-12-16 下午12:31:31 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AuthInfo [agent=" + agent + ", department=" + department + ", is_new_auth=" + is_new_auth + "]";
	}

}
