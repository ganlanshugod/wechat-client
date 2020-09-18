/**
 * @Company JBINFO
 * @Title: AccessTokenService.java
 * @Package org.bana.wechat.mp.token
 * @author Liu Wenjie
 * @date 2018年5月15日 上午10:59:59
 * @version V1.0
 */
package org.bana.wechat.mp.token;

/**
 * @ClassName: AccessTokenService
 * @Description: 服务号的tokenService
 * @author Liu Wenjie
 */
public interface AccessTokenService {

	/** 
	* @Description: 获取公众号的Token
	* @author Han Tongyang   
	* @date 2015-9-6 上午10:00:34 
	* @param grantType
	* @param appId
	* @param secret
	* @return  
	*/ 
	String getAccessToken(String appId);
}
	
