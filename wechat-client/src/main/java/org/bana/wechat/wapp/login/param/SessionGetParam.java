/**
* @Company 成长伴行   
* @Title: LoginClient.java 
* @Package org.bana.wechat.wapp.login.param 
* @author Yang Shuangshuang   
* @date 2017-1-5 13:42:14 
* @version V1.0   
*/ 
package org.bana.wechat.wapp.login.param;


/** 
 * @ClassName: SessionGetParam 
 * @Description: 获取微信小程序的信息
 *  
 */
public class SessionGetParam{
	
	private String appid;
	private String secret;
	private String js_code;
	private String grant_type;
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getJs_code() {
		return js_code;
	}
	public void setJs_code(String js_code) {
		this.js_code = js_code;
	}
	public String getGrant_type() {
		return grant_type;
	}
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
	
}
