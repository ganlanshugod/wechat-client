/**
 * @Company JBINFO
 * @Title: AuthMpService.java
 * @Package org.bana.wechat.mp.auth
 * @author Liu Wenjie
 * @date 2018年5月15日 上午9:18:08
 * @version V1.0
 */
package org.bana.wechat.mp.auth;

import org.bana.wechat.mp.auth.param.UserMpInfoParam;
import org.bana.wechat.mp.auth.param.UserMpListParam;
import org.bana.wechat.mp.auth.param.UserPaidInfoParam;
import org.bana.wechat.mp.auth.result.UserMpInfo;
import org.bana.wechat.mp.auth.result.UserMpListResult;

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
	* Description: 获取用户列表
	* @author zhangzhichao   
	* @date 2020-11-17 18:19:32 
	* @param accessToken
	* @param nextOpenId
	* @return  
	*/ 
	UserMpListResult getUserList(UserMpListParam param);
	
	/**
	 * Description: 根据页面认证token拉取用户信息
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午1:35:37
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	UserMpInfo getUserInfo(String accessToken,String openId);
	
	/** 
	* @Description: 微信用户基本信息
	* @author Huang Nana   
	* @date 2018年7月10日 下午6:08:25 
	* @param accessToken
	* @param openId
	* @return  
	*/ 
	UserMpInfo getUserInfoAll(UserMpInfoParam param);
	
	/** 
	* Description: 用户支付完成后，获取该用户的 UnionId
	* @author zhangzhichao   
	* @date 2020-07-31 09:19:50 
	* @param param
	* @return  
	*/ 
	UserMpInfo getPaidUserInfo(UserPaidInfoParam param);
}
