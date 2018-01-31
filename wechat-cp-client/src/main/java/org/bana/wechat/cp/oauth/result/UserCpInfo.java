/**
 * @Company JBINFO
 * @Title: UserCpInfo.java
 * @Package org.bana.wechat.cp.oauth.result
 * @author Liu Wenjie
 * @date 2018年1月31日 下午5:45:21
 * @version V1.0
 */
package org.bana.wechat.cp.oauth.result;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: UserCpInfo
 * @Description: 当前登录用户的信息
 * @author Liu Wenjie
 */
public class UserCpInfo {

	@JSONField(name="UserId")
	private String userId;//"UserId":"USERID",
	@JSONField(name="DeviceId")
	private String deviceId; //"DeviceId":"DEVICEID",
	@JSONField(name="user_ticket")
	private String userTicket;   // "user_ticket": "USER_TICKET"，
	@JSONField(name="expires_in")
	private String expires;   // "expires_in":7200
	@JSONField(name="OpenId")
	private String openId;   // "OpenId":"OPENID",
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public String getUserTicket() {
		return userTicket;
	}
	public void setUserTicket(String userTicket) {
		this.userTicket = userTicket;
	}
	public String getExpires() {
		return expires;
	}
	public void setExpires(String expires) {
		this.expires = expires;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	@Override
	public String toString() {
		return "UserCpInfo [userId=" + userId + ", deviceId=" + deviceId + ", userTicket=" + userTicket + ", expires="
				+ expires + ", openId=" + openId + "]";
	}
	
}
