/**
* @Company 青鸟软通   
* @Title: UserInfoParam.java 
* @Package org.bana.wechat.mp.user 
* @author Liu Wenjie   
* @date 2015-8-20 下午4:28:55 
* @version V1.0   
*/ 
package org.bana.wechat.mp.user.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: UserInfoParam 
 * @Description: 获取用户信息的接口
 *  
 */
public class UserInfoParam extends WeChatParam {
	
	private String openid;
	private String lang;
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
	 * @Description: 属性 lang 的get方法 
	 * @return lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @Description: 属性 lang 的set方法 
	 * @param lang 
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	
}
