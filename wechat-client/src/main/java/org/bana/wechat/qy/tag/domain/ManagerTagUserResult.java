/**
* @Company 青鸟软通   
* @Title: AddTagUserResult.java 
* @Package org.bana.wechat.qy.tag.domain 
* @author Liu Wenjie   
* @date 2015-5-11 下午11:18:19 
* @version V1.0   
*/ 
package org.bana.wechat.qy.tag.domain;

import java.util.List;

/** 
 * @ClassName: AddTagUserResult 
 * @Description: 增加标签用户的返回结果
 *  
 */
public class ManagerTagUserResult{

	private String invalidlist; //不在权限内的成员ID列表，以“|”分隔
	private List<Integer> invalidparty; //不在权限内的部门ID列表
	/**
	 * @Description: 属性 invalidlist 的get方法 
	 * @return invalidlist
	 */
	public String getInvalidlist() {
		return invalidlist;
	}
	/**
	 * @Description: 属性 invalidlist 的set方法 
	 * @param invalidlist 
	 */
	public void setInvalidlist(String invalidlist) {
		this.invalidlist = invalidlist;
	}
	/**
	 * @Description: 属性 invalidparty 的get方法 
	 * @return invalidparty
	 */
	public List<Integer> getInvalidparty() {
		return invalidparty;
	}
	/**
	 * @Description: 属性 invalidparty 的set方法 
	 * @param invalidparty 
	 */
	public void setInvalidparty(List<Integer> invalidparty) {
		this.invalidparty = invalidparty;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午11:28:12 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "ManagerTagUserResult [invalidlist=" + invalidlist + ", invalidparty=" + invalidparty + "]";
	}

}
