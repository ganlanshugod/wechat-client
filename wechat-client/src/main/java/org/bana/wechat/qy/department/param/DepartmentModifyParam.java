/**
* @Company 青鸟软通   
* @Title: DepartmentCreateParam.java 
* @Package org.bana.wechat.qy.department.domain 
* @author Liu Wenjie   
* @date 2015-5-9 下午7:36:59 
* @version V1.0   
*/ 
package org.bana.wechat.qy.department.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: DepartmentCreateParam 
 * @Description: 创建部门时需要传入的参数
 *  
 */
public class DepartmentModifyParam extends WeChatParam{
	
	private Integer id; // 部门id
	private String name; // 部门名称
	private Integer parentid; // 父亲部门id。根部门为1
	private Integer order;// 在父部门中的次序值。order值小的排序靠前。

	/* ===========getter setter toString hashCode equals =========== */

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
	public Integer getParentid() {
		return parentid;
	}

	/**
	 * @Description: 属性 parentid 的set方法
	 * @param parentid
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	/**
	 * @Description: 属性 order 的get方法
	 * @return order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @Description: 属性 order 的set方法
	 * @param order
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-9 下午7:46:39 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "DepartmentModifyParam [id=" + id + ", name=" + name + ", parentid=" + parentid + ", order=" + order + ", access_token=" + access_token + "]";
	}

}
