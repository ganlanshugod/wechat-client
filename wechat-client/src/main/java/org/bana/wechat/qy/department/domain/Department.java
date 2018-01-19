/**
 * @Company 青鸟软通   
 * @Title: Department.java 
 * @Package org.bana.wechat.qy.department.domain 
 * @author Liu Wenjie   
 * @date 2015-5-9 下午5:53:30 
 * @version V1.0   
 */
package org.bana.wechat.qy.department.domain;

/**
 * @ClassName: Department
 * @Description: 微信部门信息
 * 
 */
public class Department {

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
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Liu Wenjie
	 * @date 2015-5-9 下午6:02:41
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", parentid=" + parentid + ", order=" + order + "]";
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Liu Wenjie
	 * @date 2015-5-9 下午6:02:51
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Liu Wenjie
	 * @date 2015-5-9 下午6:02:51
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
		Department other = (Department) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
