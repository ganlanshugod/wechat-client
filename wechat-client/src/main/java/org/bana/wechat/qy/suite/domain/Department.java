/**
* @Company 青鸟软通   
* @Title: Department.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 下午12:24:31 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

/** 
 * @ClassName: Department 
 * @Description: 授权的通讯录部门
 *  
 */
public class Department {

	private String id; //部门id
	private String name;//部门名称
	private String parentid;//父部门id
	private String writable;//是否具有该部门的写权限
	/**
	 * @Description: 属性 id 的get方法 
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @Description: 属性 id 的set方法 
	 * @param id 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @Description: 属性 name 的get方法 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @Description: 属性 name 的set方法 
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @Description: 属性 parentid 的get方法 
	 * @return parentid
	 */
	public String getParentid() {
		return parentid;
	}
	/**
	 * @Description: 属性 parentid 的set方法 
	 * @param parentid 
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	/**
	 * @Description: 属性 writable 的get方法 
	 * @return writable
	 */
	public String getWritable() {
		return writable;
	}
	/**
	 * @Description: 属性 writable 的set方法 
	 * @param writable 
	 */
	public void setWritable(String writable) {
		this.writable = writable;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 下午1:10:34 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", parentid=" + parentid + ", writable=" + writable + "]";
	}
	
}
