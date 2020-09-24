/**
* @Company 全域旅游
* @Title: SimpleAuthorizer.java 
* @Package org.bana.wechat.mp.component.result 
* @author liuwenjie   
* @date Sep 23, 2020 12:14:47 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.result;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/** 
* @ClassName: SimpleAuthorizer 
* @Description: 一个简单的授权公众号对象列表
* @author liuwenjie   
*/
public class SimpleAuthorizer implements Serializable{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -8053151957936217337L;

	@JSONField(name="authorizer_appid")
	private String authorizerAppid; //": "authorizer_appid_1",
	
	@JSONField(name="refresh_token")
	private String refreshToken;
	
	@JSONField(name="auth_time")
	private String authTime; //": 1558000607

	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getAuthTime() {
		return authTime;
	}

	public void setAuthTime(String authTime) {
		this.authTime = authTime;
	}

	@Override
	public String toString() {
		return "SimpleAuthorizer [authorizerAppid=" + authorizerAppid + ", refreshToken=" + refreshToken + ", authTime="
				+ authTime + "]";
	}
	
	
}
