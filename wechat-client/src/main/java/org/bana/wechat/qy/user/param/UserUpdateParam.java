/**
* @Company 青鸟软通   
* @Title: UserUpdateParam.java 
* @Package org.bana.wechat.qy.user.domain 
* @author Liu Wenjie   
* @date 2015-5-11 下午6:17:42 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.param;

import java.util.List;

import org.bana.wechat.cp.common.WeChatExtAttr;
import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: UserUpdateParam 
 * @Description: 修改用户的参数
 *  
 */
public class UserUpdateParam extends WeChatParam{
	
	private String userid;//成员UserID。对应管理端的帐号，企业内必须唯一。长度为1~64个字符
	private String  name;//成员名称。长度为1~64个字符
	private List<Integer>  department;//成员所属部门id列表。注意，每个部门的直属成员上限为1000个
	private String   position;//职位信息。长度为0~64个字符
	private String   mobile;//手机号码。企业内必须唯一，mobile/weixinid/email三者不能同时为空
	private String   email;//邮箱。长度为0~64个字符。企业内必须唯一
	private String   weixinid;//微信号。企业内必须唯一。（注意：是微信号，不是微信的名字）
	private WeChatExtAttr extattr;//扩展属性。扩展属性需要在WEB管理端创建后才生效，否则忽略未知属性的赋值
	private Integer enable;//启用/禁用成员。1表示启用成员，0表示禁用成员
	private Integer gender;//性别。1表示男性，2表示女性
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
	 * @Description: 属性 enable 的get方法 
	 * @return enable
	 */
	public Integer getEnable() {
		return enable;
	}
	/**
	 * @Description: 属性 enable 的set方法 
	 * @param enable 
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
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
	 * @Description: 属性 gender 的get方法 
	 * @return gender
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * @Description: 属性 gender 的set方法 
	 * @param gender 
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午6:22:35 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "UserUpdateParam [userid=" + userid + ", name=" + name + ", department=" + department + ", position=" + position + ", mobile=" + mobile + ", email=" + email
				+ ", weixinid=" + weixinid + ", enable=" + enable + ", extattr=" + extattr + ", access_token=" + access_token + "]";
	}
	
	
}
