/**
* @Company 青鸟软通   
* @Title: UserSimpleListParam.java 
* @Package org.bana.wechat.qy.user.param 
* @author Liu Wenjie   
* @date 2015-5-11 下午9:16:05 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: UserSimpleListParam 
 * @Description: 获取简单集合对象的参数
 *  
 */
public class UserListParam extends WeChatParam {

	private Integer department_id;//获取的部门id
	private String fetch_child;//1/0：是否递归获取子部门下面的成员
	private String status;//0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加
	/**
	 * @Description: 属性 department_id 的get方法 
	 * @return department_id
	 */
	public Integer getDepartment_id() {
		return department_id;
	}
	/**
	 * @Description: 属性 department_id 的set方法 
	 * @param department_id 
	 */
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	/**
	 * @Description: 属性 fetch_child 的get方法 
	 * @return fetch_child
	 */
	public String getFetch_child() {
		return fetch_child;
	}
	/**
	 * @Description: 属性 fetch_child 的set方法 
	 * @param fetch_child 
	 */
	public void setFetch_child(String fetch_child) {
		this.fetch_child = fetch_child;
	}
	/**
	 * @Description: 属性 status 的get方法 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @Description: 属性 status 的set方法 
	 * @param status 
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
