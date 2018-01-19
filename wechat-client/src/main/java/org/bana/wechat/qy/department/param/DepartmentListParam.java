/**
* @Company 青鸟软通   
* @Title: DepartmentWeChatParam.java 
* @Package org.bana.wechat.qy.department.domain 
* @author Liu Wenjie   
* @date 2015-5-9 下午5:18:54 
* @version V1.0   
*/ 
package org.bana.wechat.qy.department.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: 微信插叙集合时的参数
 * @Description: 
 *  
 */
public class DepartmentListParam extends WeChatParam {

	private Integer id;//部门id。获取指定部门id下的子部门

	
	/*=========getter and setter =============*/
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
	* @author Liu Wenjie   
	* @date 2015-5-9 下午5:21:10 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "DepartmentListParam [id=" + id + ", access_token=" + access_token + "]";
	}
	
}
