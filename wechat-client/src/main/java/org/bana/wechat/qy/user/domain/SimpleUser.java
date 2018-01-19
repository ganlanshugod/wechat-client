/**
* @Company 青鸟软通   
* @Title: SimpleUser.java 
* @Package org.bana.wechat.qy.user.domain 
* @author Liu Wenjie   
* @date 2015-5-11 下午9:11:11 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.domain;

/** 
 * @ClassName: SimpleUser 
 * @Description: 简单的用户对象
 *  
 */
public class SimpleUser {

	private String userid;
	private String name;
	/**
	 * @Description: 属性 userid 的get方法 
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @Description: 属性 userid 的set方法 
	 * @param userid 
	 */
	public void setUserid(String userid) {
		this.userid = userid;
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
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午9:13:08 
	* @return 
	* @see java.lang.Object#hashCode() 
	*/ 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午9:13:08 
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
		SimpleUser other = (SimpleUser) obj;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午9:13:13 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "SimpleUser [userid=" + userid + ", name=" + name + "]";
	}
	
}
