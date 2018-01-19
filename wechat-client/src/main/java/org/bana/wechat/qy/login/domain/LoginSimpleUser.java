/**
* @Company 青鸟软通   
* @Title: LoginSimpleUser.java 
* @Package org.bana.wechat.qy.login.domain 
* @author Richard Core   
* @date 2016-3-18 下午5:07:17 
* @version V1.0   
*/ 
package org.bana.wechat.qy.login.domain;


/** 
 * @ClassName: LoginSimpleUser 
 * @Description: 
 *  
 */
public class LoginSimpleUser {
	private String userid;
	private String name;
	private String avatar;
	private String email;//	管理员邮箱
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
	 * @Description: 属性 avatar 的get方法 
	 * @return avatar
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * @Description: 属性 avatar 的set方法 
	 * @param avatar 
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * @Description: 属性 email 的get方法 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @Description: 属性 email 的set方法 
	 * @param email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-3-18 下午5:08:45 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "LoginSimpleUser [userid=" + userid + ", name=" + name
				+ ", avatar=" + avatar + ", email=" + email + "]";
	}
	
}
