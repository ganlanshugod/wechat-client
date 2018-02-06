/**
 * @Company JBINFO
 * @Title: UserFindListParam.java
 * @Package org.bana.wechat.cp.user.param
 * @author Zhang Zhichao
 * @date 2018年2月2日 下午2:06:44
 * @version V1.0
 */
package org.bana.wechat.cp.user.param;

import org.bana.wechat.cp.common.WeChatCPParam;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: UserFindListParam
 * @Description: 获取用户列表
 * @author Zhang Zhichao
 */
public class UserListParam extends WeChatCPParam {
	
	private static final long serialVersionUID = 2589236773271709381L;

	/**
	 * @Fields departmentId : 获取的部门id
	 */
	@JSONField(name="department_id")
	private Integer departmentId;
	
	/**
	 * @Fields fetchChild : 1/0：是否递归获取子部门下面的成员
	 */
	@JSONField(name="fetch_child")
	private Integer fetchChild;

	/**
	 * @Description: 属性 departmentId 的get方法 
	 * @return departmentId
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}

	/**
	 * @Description: 属性 departmentId 的set方法 
	 * @param departmentId
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @Description: 属性 fetchChild 的get方法 
	 * @return fetchChild
	 */
	public Integer getFetchChild() {
		return fetchChild;
	}

	/**
	 * @Description: 属性 fetchChild 的set方法 
	 * @param fetchChild
	 */
	public void setFetchChild(Integer fetchChild) {
		this.fetchChild = fetchChild;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年2月2日 下午2:15:37
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserListParam [departmentId=" + departmentId + ", fetchChild=" + fetchChild + "]";
	}
	
}
