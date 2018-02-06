/**
 * @Company JBINFO
 * @Title: DepartmentParam.java
 * @Package org.bana.wechat.cp.department.param
 * @author Zhang Zhichao
 * @date 2018年2月1日 下午4:24:57
 * @version V1.0
 */
package org.bana.wechat.cp.department.param;

import org.bana.wechat.cp.common.WeChatCPParam;

/**
 * @ClassName: DepartmentParam
 * @Description: 查询部门列表参数
 * @author Zhang Zhichao
 */
public class DepartmentListParam extends WeChatCPParam {

	private static final long serialVersionUID = -628194413275357341L;
	
	private Integer id; // 部门id
	
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
	 * @date 2018年2月1日 下午4:35:48
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DepartmentListParam [id=" + id + "]";
	}
	
}
