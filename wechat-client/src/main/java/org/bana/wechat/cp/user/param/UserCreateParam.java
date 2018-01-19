package org.bana.wechat.cp.user.param;

import java.util.List;

import org.bana.wechat.cp.common.WeChatCPParam;
import org.bana.wechat.cp.common.WeChatExtAttr;

import com.alibaba.fastjson.annotation.JSONField;

/** 
 * @ClassName: UserCreateParam 
 * @Description: 创建用户时的参数对象
 *  
 */
public class UserCreateParam extends WeChatCPParam {
	
	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = 8935210522271665264L;
	
	@JSONField(name="userid")
	private String userId;//成员UserID。对应管理端的帐号，企业内必须唯一。长度为1~64个字符
	private String  name;//成员名称。长度为1~64个字符
	private List<Integer>  department;//成员所属部门id列表。注意，每个部门的直属成员上限为1000个
	private String   position;//职位信息。长度为0~64个字符
	private String   mobile;//手机号码。企业内必须唯一，mobile/weixinid/email三者不能同时为空
	private String   email;//邮箱。长度为0~64个字符。企业内必须唯一
	private WeChatExtAttr extattr;//扩展属性。扩展属性需要在WEB管理端创建后才生效，否则忽略未知属性的赋值
	@JSONField(name="english_name")
	private String englishName; //: "jackzhang",//英文名。长度为1-64个字节。
	private List<Integer> order;//":[10,40], //部门内的排序值，默认为0，成员次序以创建时间从小到大排列。数量必须和department一致，数值越大排序越前面。有效的值范围是[0, 2^32)
	private String gender; //": "1",//性别。1表示男性，2表示女性
	private String isleader;//": 1,//上级字段，标识是否为上级。在审批等应用里可以用来标识上级审批人
	private String enable; //":1,//启用/禁用成员。1表示启用成员，0表示禁用成员
	@JSONField(name="avatar_mediaid")
	private String avatarMediaId;//": "2-G6nrLmr5EC3MNb_-zL1dDdzkd0p7cNliYu9V5w7o8K0",//成员头像的mediaid，通过素材管理接口上传图片获得的mediaid
	private String telephone;//": "020-123456"，	//座机。由1-64位的纯数字或’-‘号组成。
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getDepartment() {
		return department;
	}
	public void setDepartment(List<Integer> department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public WeChatExtAttr getExtattr() {
		return extattr;
	}
	public void setExtattr(WeChatExtAttr extattr) {
		this.extattr = extattr;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public List<Integer> getOrder() {
		return order;
	}
	public void setOrder(List<Integer> order) {
		this.order = order;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIsleader() {
		return isleader;
	}
	public void setIsleader(String isleader) {
		this.isleader = isleader;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getAvatarMediaId() {
		return avatarMediaId;
	}
	public void setAvatarMediaId(String avatarMediaId) {
		this.avatarMediaId = avatarMediaId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "UserCreateParam [userId=" + userId + ", name=" + name + ", department=" + department + ", position="
				+ position + ", mobile=" + mobile + ", email=" + email + ", extattr=" + extattr + ", englishName="
				+ englishName + ", order=" + order + ", gender=" + gender + ", isleader=" + isleader + ", enable="
				+ enable + ", avatarMediaId=" + avatarMediaId + ", telephone=" + telephone + ", corpId=" + corpId
				+ ", agentId=" + agentId + "]";
	}
	
}
