/**
 * @Company JBINFO
 * @Title: AccessTokenService.java
 * @Package org.bana.wechat.mp.token
 * @author Liu Wenjie
 * @date 2018年5月15日 上午10:59:59
 * @version V1.0
 */
package org.bana.wechat.mp.token;

import org.bana.wechat.mp.token.result.WebAuthAccessToken;

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
	String getAccessToken(String appId,String secret);
	
	/**
	 * Description: 获取网页端授权的authToken，authToken中包含openId字段
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午12:59:40
	 * @param appId
	 * @return
	 */
	WebAuthAccessToken getWebAuthAccessToken(String appId,String secret,String code);
}
