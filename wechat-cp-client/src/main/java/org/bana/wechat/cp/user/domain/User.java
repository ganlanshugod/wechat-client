/**
 * @Company JBINFO
 * @Title: User.java
 * @Package org.bana.wechat.cp.user.domain
 * @author Zhang Zhichao
 * @date 2018年2月2日 下午2:17:31
 * @version V1.0
 */
package org.bana.wechat.cp.user.domain;

import java.io.Serializable;
import java.util.List;

import org.bana.wechat.cp.common.WeChatExtAttr;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: User
 * @Description: 微信用户信息
 * @author Zhang Zhichao
 */
public class User implements Serializable {

	private static final long serialVersionUID = -1596469514434386555L;
	
	/**
	 * @Fields userid : 成员UserID
	 */
	@JSONField(name="userid")
	private String userId;
	/**
	 * @Fields name : 成员名称
	 */
	private String name;
	/**
	 * @Fields mobile : 手机号
	 */
	private String mobile;
	/**
	 * @Fields department : 成员所属部门id列表
	 */
	private List<Integer> department;
	/**
	 * @Fields order : 部门内的排序值，默认为0。数量必须和department一致，数值越大排序越前面
	 */
	private List<Integer> order;
	/**
	 * @Fields position : 职位
	 */
	private String position;
	/**
	 * @Fields gender : 性别。0表示未定义，1表示男性，2表示女性
	 */
	private String gender;
	/**
	 * @Fields email : 邮箱，第三方仅通讯录套件可获取
	 */
	private String email;
	/**
	 * @Fields isleader : 标示是否为上级。
	 */
	private Boolean isleader;
	/**
	 * @Fields avatar : 头像url。注：如果要获取小图将url最后的”/0”改成”/100”即可
	 */
	private String avatar;
	/**
	 * @Fields telephone : 座机
	 */
	private String telephone;
	/**
	 * @Fields englishName : 英文名
	 */
	@JSONField(name="english_name")
	private String englishName;
	/**
	 * @Fields status : 激活状态: 1=已激活，2=已禁用，4=未激活 
	 * 已激活代表已激活企业微信或已关注微信插件。未激活代表既未激活企业微信又未关注微信插件。
	 */
	private String status;
	/**
	 * @Fields extattr : 扩展属性，第三方仅通讯录套件可获取
	 */
	private WeChatExtAttr extattr;
	/**
	 * @Description: 属性 userId 的get方法 
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @Description: 属性 userId 的set方法 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @Description: 属性 isleader 的get方法 
	 * @return isleader
	 */
	public Boolean getIsleader() {
		return isleader;
	}
	/**
	 * @Description: 属性 isleader 的set方法 
	 * @param isleader
	 */
	public void setIsleader(Boolean isleader) {
		this.isleader = isleader;
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
	 * @Description: 属性 telephone 的get方法 
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @Description: 属性 telephone 的set方法 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @Description: 属性 englishName 的get方法 
	 * @return englishName
	 */
	public String getEnglishName() {
		return englishName;
	}
	/**
	 * @Description: 属性 englishName 的set方法 
	 * @param englishName
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
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
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年2月2日 下午2:29:50
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", mobile=" + mobile + ", department=" + department
				+ ", order=" + order + ", position=" + position + ", gender=" + gender + ", email=" + email
				+ ", isleader=" + isleader + ", avatar=" + avatar + ", telephone=" + telephone + ", englishName="
				+ englishName + ", status=" + status + ", extattr=" + extattr + "]";
	}
	
}
