/**
 * @Company JBINFO
 * @Title: UserMpInfo.java
 * @Package org.bana.wechat.mp.auth.result
 * @author Liu Wenjie
 * @date 2018年5月15日 上午10:40:09
 * @version V1.0
 */
package org.bana.wechat.mp.auth.result;

import java.io.Serializable;
import java.util.Arrays;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: UserMpInfo
 * @Description: 用户服务号用户信息
 * @author Liu Wenjie
 * {    "openid":" OPENID",
		"nickname": NICKNAME,
		"sex":"1",
		"province":"PROVINCE"
		"city":"CITY",
		"country":"COUNTRY",
		"headimgurl":    "http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
		"privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],
		"unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
		}
 */
public class UserMpInfo implements Serializable {

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -3288259055976677365L;
	
	@JSONField(name="openid")
	private String openId;//: OPENID,
	private String nickname;//: NICKNAME,
	private String sex;//:1,
	private String province;//:PROVINCE
	private String city;//:CITY,
	private String country;//:COUNTRY,
	private String headimgurl;//:    http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46,
	private String[] privilege;//:[ PRIVILEGE1 PRIVILEGE2     ],
	@JSONField(name="unionid")
	private String unionId;//: o6_bmasdasdsad6_2sgVt7hMZOPfL;
	private String subscribe;
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String[] getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String[] privilege) {
		this.privilege = privilege;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	@Override
	public String toString() {
		return "UserMpInfo [openId=" + openId + ", nickname=" + nickname + ", sex=" + sex + ", province=" + province
				+ ", city=" + city + ", country=" + country + ", headimgurl=" + headimgurl + ", privilege="
				+ Arrays.toString(privilege) + ", unionId=" + unionId + "]";
	}
	
}
