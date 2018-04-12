/**
 * @Company JBINFO
 * @Title: CreateUpdateUserEvent.java
 * @Package org.bana.wechat.cp.callback.result.event
 * @author Zhang Zhichao
 * @date 2018年4月11日 上午9:39:14
 * @version V1.0
 */
package org.bana.wechat.cp.callback.result.event;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: CreateUpdateUserEvent
 * @Description: 通讯录变更事件：添加、修改用户事件消息体
 * @author Zhang Zhichao
 */
@XmlRootElement(name="xml")
public class CreateUpdateUser implements Serializable{

	private static final long serialVersionUID = 3162478952441322413L;
	
	/**
	 * @Fields toUserName : 企业微信CorpID
	 */
	private String toUserName;
	/**
	 * @Fields fromUserName : 成员UserID
	 */
	private String fromUserName;
	/**
	 * @Fields createTime : 消息创建时间（整型）
	 */
	private Integer createTime;
	/**
	 * @Fields msgType : 消息类型
	 */
	private String msgType;
	/**
	 * @Fields event : 事件类型
	 */
	private String event;
	/**
	 * @Fields changeType : create_user或者delete_user
	 */
	private String changeType;
	/**
	 * @Fields userID : 成员UserID
	 */
	private String userID;
	/**
	 * @Fields newUserID : 新的UserID，变更时推送（userid由系统生成时可更改一次）
	 */
	private String newUserID;
	/**
	 * @Fields name : 成员名称
	 */
	private String name;
	/**
	 * @Fields department : 部门列表
	 */
	private String department;
	/**
	 * @Fields mobile : 手机号
	 */
	private String mobile;
	/**
	 * @Fields position : 职位信息。长度为0~64个字节
	 */
	private String position;
	/**
	 * @Fields gender : 性别，1表示男性，2表示女性
	 */
	private Integer gender;
	/**
	 * @Fields email : 邮箱
	 */
	private String email;
	/**
	 * @Fields status : 激活状态：1=已激活 2=已禁用
	 */
	private Integer status;
	/**
	 * @Fields avatar : 头像url。注：如果要获取小图将url最后的”/0”改成”/100”即可。
	 */
	private String avatar;
	/**
	 * @Fields englishName :英文名
	 */
	private String englishName;
	/**
	 * @Fields isLeader : 上级字段，标识是否为上级。0表示普通成员，1表示上级
	 */
	private Integer isLeader;
	/**
	 * @Fields telephone : 座机
	 */
	private String telephone;
	/**
	 * @Fields extAttr : 扩展属性
	 */
	private List<ExtAttrMsg> extAttr;
	
	/*=======================get,set=========================================*/
	/**
	 * @Description: 属性 toUserName 的get方法 
	 * @return toUserName
	 */
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return toUserName;
	}
	/**
	 * @Description: 属性 toUserName 的set方法 
	 * @param toUserName
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	/**
	 * @Description: 属性 fromUserName 的get方法 
	 * @return fromUserName
	 */
	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}
	/**
	 * @Description: 属性 fromUserName 的set方法 
	 * @param fromUserName
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	/**
	 * @Description: 属性 createTime 的get方法 
	 * @return createTime
	 */
	@XmlElement(name="CreateTime")
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * @Description: 属性 createTime 的set方法 
	 * @param createTime
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * @Description: 属性 msgType 的get方法 
	 * @return msgType
	 */
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return msgType;
	}
	/**
	 * @Description: 属性 msgType 的set方法 
	 * @param msgType
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	/**
	 * @Description: 属性 event 的get方法 
	 * @return event
	 */
	@XmlElement(name="Event")
	public String getEvent() {
		return event;
	}
	/**
	 * @Description: 属性 event 的set方法 
	 * @param event
	 */
	public void setEvent(String event) {
		this.event = event;
	}
	/**
	 * @Description: 属性 changeType 的get方法 
	 * @return changeType
	 */
	@XmlElement(name="ChangeType")
	public String getChangeType() {
		return changeType;
	}
	/**
	 * @Description: 属性 changeType 的set方法 
	 * @param changeType
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	/**
	 * @Description: 属性 userID 的get方法 
	 * @return userID
	 */
	@XmlElement(name="UserID")
	public String getUserID() {
		return userID;
	}
	/**
	 * @Description: 属性 userID 的set方法 
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @Description: 属性 newUserID 的get方法 
	 * @return newUserID
	 */
	@XmlElement(name="NewUserID")
	public String getNewUserID() {
		return newUserID;
	}
	/**
	 * @Description: 属性 newUserID 的set方法 
	 * @param newUserID
	 */
	public void setNewUserID(String newUserID) {
		this.newUserID = newUserID;
	}
	/**
	 * @Description: 属性 name 的get方法 
	 * @return name
	 */
	@XmlElement(name="Name")
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
	@XmlElement(name="Department")
	public String getDepartment() {
		return department;
	}
	/**
	 * @Description: 属性 department 的set方法 
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @Description: 属性 mobile 的get方法 
	 * @return mobile
	 */
	@XmlElement(name="Mobile")
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
	 * @Description: 属性 position 的get方法 
	 * @return position
	 */
	@XmlElement(name="Position")
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
	@XmlElement(name="Gender")
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
	 * @Description: 属性 email 的get方法 
	 * @return email
	 */
	@XmlElement(name="Email")
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
	 * @Description: 属性 status 的get方法 
	 * @return status
	 */
	@XmlElement(name="Status")
	public Integer getStatus() {
		return status;
	}
	/**
	 * @Description: 属性 status 的set方法 
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @Description: 属性 avatar 的get方法 
	 * @return avatar
	 */
	@XmlElement(name="Avatar")
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
	 * @Description: 属性 englishName 的get方法 
	 * @return englishName
	 */
	@XmlElement(name="EnglishName")
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
	 * @Description: 属性 isLeader 的get方法 
	 * @return isLeader
	 */
	@XmlElement(name="IsLeader")
	public Integer getIsLeader() {
		return isLeader;
	}
	/**
	 * @Description: 属性 isLeader 的set方法 
	 * @param isLeader
	 */
	public void setIsLeader(Integer isLeader) {
		this.isLeader = isLeader;
	}
	/**
	 * @Description: 属性 telephone 的get方法 
	 * @return telephone
	 */
	@XmlElement(name="Telephone")
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
	 * @Description: 属性 extAttr 的get方法 
	 * @return extAttr
	 */
	@XmlElement(name="ExtAttr")
	public List<ExtAttrMsg> getExtAttr() {
		return extAttr;
	}
	/**
	 * @Description: 属性 extAttr 的set方法 
	 * @param extAttr
	 */
	public void setExtAttr(List<ExtAttrMsg> extAttr) {
		this.extAttr = extAttr;
	}
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月12日 上午9:30:07
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CreateUpdateUser [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime="
				+ createTime + ", msgType=" + msgType + ", event=" + event + ", changeType=" + changeType + ", userID="
				+ userID + ", newUserID=" + newUserID + ", name=" + name + ", department=" + department + ", mobile="
				+ mobile + ", position=" + position + ", gender=" + gender + ", email=" + email + ", status=" + status
				+ ", avatar=" + avatar + ", englishName=" + englishName + ", isLeader=" + isLeader + ", telephone="
				+ telephone + ", extAttr=" + extAttr + "]";
	}
	
}
