/**
* @Company 青鸟软通   
* @Title: LoginDepartment.java 
* @Package org.bana.wechat.qy.login.domain 
* @author Richard Core   
* @date 2016-3-18 下午5:14:44 
* @version V1.0   
*/ 
package org.bana.wechat.qy.login.domain;

/** 
 * @ClassName: LoginDepartment 
 * @Description:  
 *  
 */
public class LoginDepartment {
	private Integer id;
	private Boolean writable;
	/**
	 * @Description: 属性 id 的get方法 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @Description: 属性 id 的set方法 
	 * @param id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @Description: 属性 writable 的get方法 
	 * @return writable
	 */
	public Boolean getWritable() {
		return writable;
	}
	/**
	 * @Description: 属性 writable 的set方法 
	 * @param writable 
	 */
	public void setWritable(Boolean writable) {
		this.writable = writable;
	}
	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-3-18 下午5:15:31 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "LoginDepartment [id=" + id + ", writable=" + writable + "]";
	}
	
}
