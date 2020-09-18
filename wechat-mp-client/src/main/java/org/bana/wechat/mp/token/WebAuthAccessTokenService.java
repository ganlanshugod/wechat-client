/**
* @Company 全域旅游
* @Title: WebAuthAccessTokenService.java 
* @Package org.bana.wechat.mp.token 
* @author liuwenjie   
* @date Sep 18, 2020 2:40:33 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.token;

import org.bana.wechat.mp.token.result.WebAuthAccessToken;

/** 
* @ClassName: WebAuthAccessTokenService 
* @Description: 
* @author liuwenjie   
*/
public interface WebAuthAccessTokenService {

	/**
	 * Description: 获取网页端授权的authToken，authToken中包含openId字段
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午12:59:40
	 * @param appId
	 * @return
	 */
	WebAuthAccessToken getWebAuthAccessToken(String appId,String code);
}
