/**
* @Company 青鸟软通   
* @Title: AllowUsers.java 
* @Package org.bana.wechat.qy.agent.domain 
* @author Liu Wenjie   
* @date 2015-5-15 下午5:47:27 
* @version V1.0   
*/ 
package org.bana.wechat.qy.agent.domain;

import java.util.List;

/** 
 * @ClassName: AllowUsers 
 * @Description: 允许访问的用户对象
 *  
 */
public class AllowUsers {
	
	private List<User> user;

	/**
	 * @Description: 属性 user 的get方法 
	 * @return user
	 */
	public List<User> getUser() {
		return user;
	}

	/**
	 * @Description: 属性 user 的set方法 
	 * @param user 
	 */
	public void setUser(List<User> user) {
		this.user = user;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-15 下午5:48:13 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AllowUsers [user=" + user + "]";
	}
	
}
