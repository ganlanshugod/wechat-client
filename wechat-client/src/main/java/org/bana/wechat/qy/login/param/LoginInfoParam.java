/**
* @Company 青鸟软通   
* @Title: LoginInfoParam.java 
* @Package org.bana.wechat.qy.login.param 
* @author Richard Core   
* @date 2016-3-18 下午3:44:28 
* @version V1.0   
*/ 
package org.bana.wechat.qy.login.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: LoginInfoParam 
 * @Description: 用户登录信息
 *  
 */
public class LoginInfoParam extends WeChatParam {
	// 本参数里access_token有特殊要求:
	/**
	 * 授权登录服务商的网站时，使用应用提供商的provider_access_token;
	 * 授权登录企业的网站时，使用企业管理组的access_token
	 */
	private String auth_code;//oauth2.0授权企业号管理员登录产生的code

	/**
	 * @Description: 属性 auth_code 的get方法 
	 * @return auth_code
	 */
	public String getAuth_code() {
		return auth_code;
	}

	/**
	 * @Description: 属性 auth_code 的set方法 
	 * @param auth_code 
	 */
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}

	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-3-18 下午3:51:20 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "LoginInfoParam [auth_code=" + auth_code + "]";
	}
}
