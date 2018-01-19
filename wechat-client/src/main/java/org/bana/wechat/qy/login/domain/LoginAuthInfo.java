/**
* @Company 青鸟软通   
* @Title: LoginAuthInfo.java 
* @Package org.bana.wechat.qy.login.domain 
* @author Richard Core   
* @date 2016-3-18 下午5:13:47 
* @version V1.0   
*/ 
package org.bana.wechat.qy.login.domain;

/** 
 * @ClassName: LoginAuthInfo 
 * @Description: 
 *  
 */
public class LoginAuthInfo {
	private LoginDepartment[] department;


	/**
	 * @Description: 属性 department 的get方法 
	 * @return department
	 */
	public LoginDepartment[] getDepartment() {
		return department;
	}


	/**
	 * @Description: 属性 department 的set方法 
	 * @param department 
	 */
	public void setDepartment(LoginDepartment[] department) {
		this.department = department;
	}


	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-3-18 下午5:15:58 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "LoginAuthInfo [department=" + department + "]";
	}
}
