/**
* @Company 全域旅游
* @Title: ReceiveAuthChange.java 
* @Package org.bana.wechat.mp.component.param 
* @author liuwenjie   
* @date Sep 18, 2020 4:37:17 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.param;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: ReceiveAuthChange 
* @Description: 推送的时间是授权变更相关的事件类型
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class ReceiveAuthChange extends ReceiveObj{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 7876655543918493251L;

	private String appId; //>第三方平台appid</AppId>
	private long createTime; //>1413192760</CreateTime>
	private String authorizerAppid; //>公众号appid</AuthorizerAppid>
	private String authorizationCode; //>授权码</AuthorizationCode>
	private long  authorizationCodeExpiredTime;
	private String preAuthCode; //>预授权码</PreAuthCode>
	
	@XmlElement(name="AuthorizationCode")
	public String getAuthorizationCode() {
		return authorizationCode;
	}
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}
	
	@XmlElement(name="AuthorizationCodeExpiredTime")
	public long getAuthorizationCodeExpiredTime() {
		return authorizationCodeExpiredTime;
	}
	public void setAuthorizationCodeExpiredTime(long authorizationCodeExpiredTime) {
		this.authorizationCodeExpiredTime = authorizationCodeExpiredTime;
	}
	
	@XmlElement(name="PreAuthCode")
	public String getPreAuthCode() {
		return preAuthCode;
	}
	public void setPreAuthCode(String preAuthCode) {
		this.preAuthCode = preAuthCode;
	}

	@XmlElement(name="AppId")
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@XmlElement(name="CreateTime")
	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	@XmlElement(name="AuthorizerAppid")
	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

	@Override
	public String toString() {
		return "ReceiveAuthChange [AppId=" + appId + ", CreateTime=" + createTime + ", AuthorizerAppid="
				+ authorizerAppid + ", getInfoType()=" + getInfoType() + "]";
	}

	
}
