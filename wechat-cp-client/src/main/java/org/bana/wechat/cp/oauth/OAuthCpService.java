/**
 * @Company JBINFO
 * @Title: OAuthCpService.java
 * @Package org.bana.wechat.cp.oauth
 * @author Liu Wenjie
 * @date 2018年1月31日 下午5:33:38
 * @version V1.0
 */
package org.bana.wechat.cp.oauth;

import org.bana.wechat.cp.oauth.param.UserCpInfoParam;
import org.bana.wechat.cp.oauth.result.UserCpInfo;

/**
 * @ClassName: OAuthCpService
 * @Description: Oauth的接口方法
 * @author Liu Wenjie
 */
public interface OAuthCpService {

	
	/**
	 * Description: 根据code获取用户的登录信息
	 * @author Liu Wenjie
	 * @date 2018年1月31日 下午5:49:55
	 * @param userInfoParam
	 * @return
	 */
	UserCpInfo getUserInfo(UserCpInfoParam userInfoParam); 
}
