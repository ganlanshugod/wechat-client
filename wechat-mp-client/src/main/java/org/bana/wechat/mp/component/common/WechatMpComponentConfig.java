/**
* @Company 全域旅游
* @Title: WechatMpComponentConfig.java 
* @Package org.bana.wechat.mp.component.common 
* @author liuwenjie   
* @date Sep 17, 2020 9:42:49 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.common;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

/** 
* @ClassName: WechatMpComponentConfig 
* @Description: 微信第三方服务商对应的配置信息
* @author liuwenjie   
*/
public class WechatMpComponentConfig implements Serializable {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -4924170215629310129L;
	
	
	private String componentAppid ; //":  "appid_value" ,
	private String componentAppsecret; //:  "appsecret_value",
//	private String componentVerifyTicket; //": "ticket_value" 这个是需要定时收到微信的推送数据并进行存储的
	
	private String componentToken ; // 消息校验Token sdqylyelink20200513lkkqsxlLLsdk
	private String encodingAESKey ; // 消息加解密Key sdqylyelink20200513msgkeylklxhslKDswksdwdgs
	
	private String domain; //套件对应的业务域名
	
	public String getComponentAppid() {
		return componentAppid;
	}
	public void setComponentAppid(String componentAppid) {
		this.componentAppid = componentAppid;
	}
	public String getComponentAppsecret() {
		return componentAppsecret;
	}
	public void setComponentAppsecret(String componentAppsecret) {
		this.componentAppsecret = componentAppsecret;
	}
	
	public String getComponentToken() {
		return componentToken;
	}
	public void setComponentToken(String componentToken) {
		this.componentToken = componentToken;
	}
	public String getEncodingAESKey() {
		return encodingAESKey;
	}
	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	@Override
	public String toString() {
		return "WechatMpComponentConfig [componentAppid=" + componentAppid + ", componentAppsecret="
				+ componentAppsecret + ", componentToken=" + componentToken + ", encodingAESKey=" + encodingAESKey
				+ ", domain=" + domain + "]";
	}
	
	public boolean isAvailable() {
		return !StringUtils.isAnyBlank(componentAppid,componentAppsecret,componentToken,encodingAESKey);
	}

}
