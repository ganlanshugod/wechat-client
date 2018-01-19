package org.bana.wechat.qy.suite.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <xml>
    <SuiteId><![CDATA[tj4asffe99e54c0f4c]]></SuiteId>
    <AuthCorpId><![CDATA[wxf8b4f85f3a794e77]]></AuthCorpId>
    <InfoType><![CDATA[change_contact]]></InfoType>
    <TimeStamp>1403610513</TimeStamp>
    <ChangeType><![CDATA[create_user]]></ChangeType>
    <UserID><![CDATA[zhangsan]]></UserID>
    <Name><![CDATA[张三]]></Name>
    <Department><![CDATA[1,2,3]]></Department>
    <Mobile><![CDATA[15913215421]]></Mobile>
    <Position><![CDATA[产品经理]]></Position>
    <Gender>1</Gender>
    <Email><![CDATA[zhangsan@gzdev.com]]></Email>
    <Avatar><![CDATA[http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/0]]></Avatar>
    <EnglishName><![CDATA[zhangsan]]></EnglishName>
    <IsLeader>1</IsLeader>
    <Telephone><![CDATA[020-3456788]]></Telephone>
    <ExtAttr>
        <Item>
        <Name><![CDATA[爱好]]></Name>
        <Value><![CDATA[旅游]]></Value>
        </Item>
        <Item>
        <Name><![CDATA[卡号]]></Name>
        <Value><![CDATA[1234567234]]></Value>
        </Item>
    </ExtAttr>
</xml>
 * @author liuwenjie
 *
 */
@XmlRootElement(name="xml")
public class ContactChangeResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4031367225478527448L;
	
	//  SuiteId	套件ID
	private String suiteId;
		//授权企业的CorpID
	private String authCorpId;
		//固定为change_contact
	private String infoType;
 //	时间戳
	private String timeStamp;
//	//		固定为create_user
	private String changeType;
//	//	成员UserID
	private String userId;
//	//	成员名称
	private String name;
	
	private String deparmentListStr;
//	//	手机号码，仅通讯录套件可获取
	private String mobile;
//	//	职位信息。长度为0~64个字节
	private String position;
//	//性别。1表示男性，2表示女性
	private String gender;
//	//	邮箱，仅通讯录套件可获取
	private String email;
//	//激活状态：1=已激活 2=已禁用
	private String status;	
//	//EnglishName	英文名
	private String englishName;
	//	上级字段，标识是否为上级。0表示普通成员，1表示上级
	private String isLeader;
	 //	座机，仅通讯录套件可获取
	private String telephone;
	
	private String avatar;
		//扩展属性，仅通讯录套件可获取
	private ExtAttr extAttr;
	
	@XmlElement(name="SuiteId")
	public String getSuiteId() {
		return suiteId;
	}
	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}
	@XmlElement(name="AuthCorpId")
	public String getAuthCorpId() {
		return authCorpId;
	}
	public void setAuthCorpId(String authCorpId) {
		this.authCorpId = authCorpId;
	}
	@XmlElement(name="InfoType")
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	@XmlElement(name="TimeStamp")
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	@XmlElement(name="ChangeType")
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	@XmlElement(name="UserID")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@XmlElement(name="Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="Department")//	成员部门列表
	public String getDeparmentListStr() {
		return deparmentListStr;
	}
	public void setDeparmentListStr(String deparmentListStr) {
		this.deparmentListStr = deparmentListStr;
	}
	@XmlElement(name="Mobile")
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@XmlElement(name="Position")
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@XmlElement(name="Gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@XmlElement(name="Email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement(name="Status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@XmlElement(name="EnglishName")
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	@XmlElement(name="IsLeader")
	public String getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(String isLeader) {
		this.isLeader = isLeader;
	}
	@XmlElement(name="Telephone")
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@XmlElement(name="ExtAttr")
	public ExtAttr getExtAttr() {
		return extAttr;
	}
	public void setExtAttr(ExtAttr extAttr) {
		this.extAttr = extAttr;
	}
	@XmlElement(name="Avatar")
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "ContactChangeResult [suiteId=" + suiteId + ", authCorpId=" + authCorpId + ", infoType=" + infoType
				+ ", timeStamp=" + timeStamp + ", changeType=" + changeType + ", userId=" + userId + ", name=" + name
				+ ", deparmentListStr=" + deparmentListStr + ", mobile=" + mobile + ", position=" + position
				+ ", gender=" + gender + ", email=" + email + ", status=" + status + ", englishName=" + englishName
				+ ", isLeader=" + isLeader + ", telephone=" + telephone + ", avatar=" + avatar + ", extAttr=" + extAttr
				+ "]";
	}

}
