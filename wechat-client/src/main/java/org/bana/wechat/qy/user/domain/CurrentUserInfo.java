/**
* @Company 青鸟软通   
* @Title: CurrentUserInfo.java 
* @Package org.bana.wechat.qy.user.domain 
* @author Liu Wenjie   
* @date 2015-5-16 下午5:31:23 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.domain;

import java.io.Serializable;

/** 
 * @ClassName: CurrentUserInfo 
 * @Description: 当前用户信息 
 *  
 */
public class CurrentUserInfo implements Serializable{
	
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 983270852586156199L;
	private String userId;
	private String deviceId;
	private String openId;
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
	 * @Description: 属性 deviceId 的get方法 
	 * @return deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * @Description: 属性 deviceId 的set方法 
	 * @param deviceId 
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	/**
	 * @Description: 属性 openId 的get方法 
	 * @return openId
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * @Description: 属性 openId 的set方法 
	 * @param openId 
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-21 下午4:31:46 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CurrentUserInfo [userId=" + userId + ", deviceId=" + deviceId + ", openId=" + openId + "]";
	}

	
	
}
