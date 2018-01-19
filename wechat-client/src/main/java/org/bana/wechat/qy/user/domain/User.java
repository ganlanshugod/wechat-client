/**
 * @Company 青鸟软通   
 * @Title: User.java 
 * @Package org.bana.wechat.qy.user.domain 
 * @author Liu Wenjie   
 * @date 2015-5-11 下午8:40:21 
 * @version V1.0   
 */
package org.bana.wechat.qy.user.domain;

import java.util.List;

import org.bana.wechat.cp.common.WeChatExtAttr;

/**
 * @ClassName: User
 * @Description: 用户信息
 * 
 */
public class User {
	
	public static final String SEX_MALE = "1";
	public static final String SEX_FEMALE = "2";
	public static final String SEX_NO_SIGN = "0";

	private String userid;
	private String name;
	private List<Integer> department;
	private String position;
	private String mobile;
	/** 
	* @Fields gender : 	性别。0表示未定义，1表示男性，2表示女性
	*/ 
	private String gender; //gender	性别。0表示未定义，1表示男性，2表示女性
	private String email;
	private String weixinid;
	private String avatar;
	private String status;
	private String isleader;
	private WeChatExtAttr extattr;
	
	private String english_name;
	private String telephone;
	private List<Integer> order;// 部门内的排序值
	
	private List<String> department_position;
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
	 * @Description: 属性 gender 的get方法 
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @Description: 属性 gender 的set方法 
	 * @param gender 
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * @Description: 属性 department 的get方法
	 * @return department
	 */
	public List<Integer> getDepartment() {
		return department;
	}

	/**
	 * @Description: 属性 department 的set方法
	 * @param department
	 */
	public void setDepartment(List<Integer> department) {
		this.department = department;
	}

	/**
	 * @Description: 属性 position 的get方法
	 * @return position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @Description: 属性 position 的set方法
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
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
	 * @Description: 属性 weixinid 的get方法
	 * @return weixinid
	 */
	public String getWeixinid() {
		return weixinid;
	}

	/**
	 * @Description: 属性 weixinid 的set方法
	 * @param weixinid
	 */
	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
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

	/**
	 * @Description: 属性 extattr 的get方法
	 * @return extattr
	 */
	public WeChatExtAttr getExtattr() {
		return extattr;
	}

	/**
	 * @Description: 属性 extattr 的set方法
	 * @param extattr
	 */
	public void setExtattr(WeChatExtAttr extattr) {
		this.extattr = extattr;
	}

	/**
	 * @Description: 属性 order 的get方法 
	 * @return order
	 */
	public List<Integer> getOrder() {
		return order;
	}

	/**
	 * @Description: 属性 order 的set方法 
	 * @param order 
	 */
	public void setOrder(List<Integer> order) {
		this.order = order;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午8:42:38
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
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午8:42:38
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
		User other = (User) obj;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	

	public String getEnglish_name() {
		return english_name;
	}

	public void setEnglish_name(String english_name) {
		this.english_name = english_name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<String> getDepartment_position() {
		return department_position;
	}

	public void setDepartment_position(List<String> department_position) {
		this.department_position = department_position;
	}
	

	public String getIsleader() {
		return isleader;
	}

	public void setIsleader(String isleader) {
		this.isleader = isleader;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", department=" + department + ", position=" + position
				+ ", mobile=" + mobile + ", gender=" + gender + ", email=" + email + ", weixinid=" + weixinid
				+ ", avatar=" + avatar + ", status=" + status + ", isleader=" + isleader + ", extattr=" + extattr
				+ ", english_name=" + english_name + ", telephone=" + telephone + ", order=" + order
				+ ", department_position=" + department_position + "]";
	}
	
	
}
