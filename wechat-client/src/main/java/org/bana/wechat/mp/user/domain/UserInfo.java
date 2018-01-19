/**
* @Company 青鸟软通   
* @Title: UserInfo.java 
* @Package org.bana.wechat.mp.user.domain 
* @author Liu Wenjie   
* @date 2015-8-20 下午4:30:19 
* @version V1.0   
*/ 
package org.bana.wechat.mp.user.domain;

import java.io.Serializable;

/** 
 * @ClassName: UserInfo 
 * @Description: 用户信息
 *  
 */
public class UserInfo implements Serializable {

	/** 
	* @Fields serialVersionUID :  
	*/ 
	private static final long serialVersionUID = 767155357797791433L;

	private String subscribe;	//用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	private String openid;	//	用户的标识，对当前公众号唯一
	private String nickname	;	//用户的昵称
	private String sex	;	//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private String city	;	//用户所在城市
	private String country;	//	用户所在国家
	private String province	;	//用户所在省份
	private String language	;	//用户的语言，简体中文为zh_CN
	private String headimgurl	;	//用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	private String subscribe_time	;	//用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	private String unionid	;	//只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
	private String remark	;	//公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	private String groupid;	//
	/**
	 * @Description: 属性 subscribe 的get方法 
	 * @return subscribe
	 */
	public String getSubscribe() {
		return subscribe;
	}
	/**
	 * @Description: 属性 subscribe 的set方法 
	 * @param subscribe 
	 */
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	/**
	 * @Description: 属性 openid 的get方法 
	 * @return openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * @Description: 属性 openid 的set方法 
	 * @param openid 
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * @Description: 属性 nickname 的get方法 
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @Description: 属性 nickname 的set方法 
	 * @param nickname 
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @Description: 属性 sex 的get方法 
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @Description: 属性 sex 的set方法 
	 * @param sex 
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @Description: 属性 city 的get方法 
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @Description: 属性 city 的set方法 
	 * @param city 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @Description: 属性 country 的get方法 
	 * @return country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @Description: 属性 country 的set方法 
	 * @param country 
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @Description: 属性 province 的get方法 
	 * @return province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @Description: 属性 province 的set方法 
	 * @param province 
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @Description: 属性 language 的get方法 
	 * @return language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @Description: 属性 language 的set方法 
	 * @param language 
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @Description: 属性 headimgurl 的get方法 
	 * @return headimgurl
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}
	/**
	 * @Description: 属性 headimgurl 的set方法 
	 * @param headimgurl 
	 */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	/**
	 * @Description: 属性 subscribe_time 的get方法 
	 * @return subscribe_time
	 */
	public String getSubscribe_time() {
		return subscribe_time;
	}
	/**
	 * @Description: 属性 subscribe_time 的set方法 
	 * @param subscribe_time 
	 */
	public void setSubscribe_time(String subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	/**
	 * @Description: 属性 unionid 的get方法 
	 * @return unionid
	 */
	public String getUnionid() {
		return unionid;
	}
	/**
	 * @Description: 属性 unionid 的set方法 
	 * @param unionid 
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	/**
	 * @Description: 属性 remark 的get方法 
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @Description: 属性 remark 的set方法 
	 * @param remark 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @Description: 属性 groupid 的get方法 
	 * @return groupid
	 */
	public String getGroupid() {
		return groupid;
	}
	/**
	 * @Description: 属性 groupid 的set方法 
	 * @param groupid 
	 */
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	
}
