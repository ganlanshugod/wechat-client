/**
* @Company 青鸟软通   
* @Title: DepartmentDeleteParam.java 
* @Package org.bana.wechat.qy.department.domain 
* @author Liu Wenjie   
* @date 2015-5-9 下午7:56:29 
* @version V1.0   
*/ 
package org.bana.wechat.qy.department.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: DepartmentDeleteParam 
 * @Description: 部门表删除的方法
 *  
 */
public class DepartmentDeleteParam extends WeChatParam{
	
	private Integer id; //部门id

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
	* @date 2015-5-9 下午7:57:33 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "DepartmentDeleteParam [id=" + id + ", access_token=" + access_token + "]";
	}
	
}
