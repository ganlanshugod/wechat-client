/**
 * @Company JBINFO
 * @Title: AuthMpService.java
 * @Package org.bana.wechat.mp.auth
 * @author Liu Wenjie
 * @date 2018年5月15日 上午9:18:08
 * @version V1.0
 */
package org.bana.wechat.mp.auth;

import org.bana.wechat.mp.auth.result.UserMpInfo;

/**
 * @ClassName: AuthMpService
 * @Description: 
 * @author Liu Wenjie
 */
public interface OAuthMpService {

	/**
	 * Description: 根据页面认证token拉取用户信息
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午1:34:27
	 * @param accessToken 页面的token 
	 * @param openId 必填
	 * @param lang 默认是zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 */
	UserMpInfo getUserInfo(String accessToken,String openId,String lang);
	
	/**
	 * Description: 根据页面认证token拉取用户信息
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午1:35:37
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	UserMpInfo getUserInfo(String accessToken,String openId);
}
