/**
 * @Company JBINFO
 * @Title: AuthUserInfo.java
 * @Package org.bana.wechat.cp.suite.domain
 * @author Zhang Zhichao
 * @date 2018年1月29日 下午12:57:50
 * @version V1.0
 */
package org.bana.wechat.cp.suite.domain;

import java.io.Serializable;

/**
 * @ClassName: AuthUserInfo
 * @Description: 授权管理员的信息
 * @author Zhang Zhichao
 */
public class AuthUserInfo implements Serializable {

	private static final long serialVersionUID = -4977755733629217635L;

	private String email; // 授权管理员的邮箱，可能为空（外部管理员一定有，不可更改）
	private String mobile; // 授权管理员的手机号，可能为空（内部管理员一定有，可更改）
	private String userid; // 授权管理员的userid，可能为空（内部管理员一定有，不可更改）
	private String name; // 授权管理员的name，可能为空（内部管理员一定有，不可更改）
	private String avatar; // 授权管理员的头像url
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
	 * @Description: 属性 mobile 的get方法 
	 * @return mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @Description: 属性 mobile 的set方法 
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
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
	
}
