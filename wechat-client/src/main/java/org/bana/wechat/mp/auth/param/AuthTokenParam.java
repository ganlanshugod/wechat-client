/**
 * @Company 青鸟软通   
 * @Title: AuthTokenParam.java 
 * @Package org.bana.wechat.mp.auth.param 
 * @author Han Tongyang   
 * @date 2015-8-26 下午7:56:39 
 * @version V1.0   
 */
package org.bana.wechat.mp.auth.param;

import org.bana.wechat.qy.common.WeChatParam;

/**
 * @ClassName: AuthTokenParam
 * @Description: 页面认证获取token接口参数
 * 
 */
public class AuthTokenParam extends WeChatParam {

	private String appid;
	private String secret;
	private String code;
	private String grant_type;

	/**
	 * @Description: 属性 appid 的get方法
	 * @return appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * @Description: 属性 appid 的set方法
	 * @param appid
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * @Description: 属性 secret 的get方法
	 * @return secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @Description: 属性 secret 的set方法
	 * @param secret
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * @Description: 属性 code 的get方法
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @Description: 属性 code 的set方法
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @Description: 属性 grant_type 的get方法
	 * @return grant_type
	 */
	public String getGrant_type() {
		return grant_type;
	}

	/**
	 * @Description: 属性 grant_type 的set方法
	 * @param grant_type
	 */
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Han Tongyang
	 * @date 2015-8-26 下午7:58:31
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthTokenParam [appid=" + appid + ", secret=" + secret
				+ ", code=" + code + ", grant_type=" + grant_type + "]";
	}

}
