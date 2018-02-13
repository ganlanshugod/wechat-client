/**
 * @Company JBINFO
 * @Title: DepartmentCreateParam.java
 * @Package org.bana.wechat.cp.department.param
 * @author Zhang Zhichao
 * @date 2018年2月11日 下午3:00:01
 * @version V1.0
 */
package org.bana.wechat.cp.department.param;

import org.bana.wechat.cp.common.WeChatCPParam;

/**
 * @ClassName: DepartmentCreateParam
 * @Description: 创建部门的参数
 * @author Zhang Zhichao
 */
public class DepartmentCreateParam extends WeChatCPParam {

	private static final long serialVersionUID = -6897507734358756434L;
	
	private String name; // 部门名称
	private Integer parentid; // 父部门
	private Integer order; // 排序值
	private Integer id; // 部门id
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
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年2月11日 下午3:03:30
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DepartmentCreateParam [name=" + name + ", parentid=" + parentid + ", order=" + order + ", id=" + id
				+ "]";
	}
	
}
