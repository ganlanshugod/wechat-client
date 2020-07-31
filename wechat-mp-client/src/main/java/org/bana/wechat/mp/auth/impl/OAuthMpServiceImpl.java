/**
 * @Company JBINFO
 * @Title: OAuthMpServiceImpl.java
 * @Package org.bana.wechat.mp.auth.impl
 * @author Liu Wenjie
 * @date 2018年5月15日 上午10:48:20
 * @version V1.0
 */
package org.bana.wechat.mp.auth.impl;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.auth.OAuthMpService;
import org.bana.wechat.mp.auth.param.UserMpInfoParam;
import org.bana.wechat.mp.auth.param.UserPaidInfoParam;
import org.bana.wechat.mp.auth.result.UserMpInfo;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.common.WechatMpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: OAuthMpServiceImpl
 * @Description: 
 * @author Liu Wenjie
 */
public class OAuthMpServiceImpl extends WechatMpService implements OAuthMpService {

	private static final Logger LOG = LoggerFactory.getLogger(OAuthMpServiceImpl.class);
	
	private HttpHelper httpHelper = new HttpHelper();
	
	private static final String DEFAULT_LANG = "zh_CN";
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年5月15日 上午10:48:20
	 * @param userInfoParam
	 * @return
	 * @see org.bana.wechat.mp.auth.OAuthMpService#getUserInfo(org.bana.wechat.mp.auth.param.UserMpInfoParam)
	 */
	@Override
	public UserMpInfo getUserInfo(String accessToken,String openId,String lang) {
		LOG.info("=====调用了获取getUserInfo的方法===========,accessToken="+accessToken+",openId="+openId+",lang="+lang);
		if(StringUtils.isBlank(lang)){
			lang = DEFAULT_LANG;
		}
		if(StringUtils.isBlank(accessToken,openId)){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"getUserInfo时参数不能为空,accessToken,openId=,"+accessToken+","+openId);
		}
		StringBuffer url = new StringBuffer(Constants.页面认证拉取用户信息.getValue())
				.append("?access_token=").append(accessToken)
				.append("&openid=").append(openId)
				.append("&lang=").append(lang);
		JSONObject post = httpHelper.httpGet(url.toString());
		return WechatMpResultHandler.handleResult(post, UserMpInfo.class);
	}
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午1:36:07
	 * @param accessToken
	 * @param openId
	 * @return
	 * @see org.bana.wechat.mp.auth.OAuthMpService#getUserInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public UserMpInfo getUserInfo(String accessToken, String openId) {
		return this.getUserInfo(accessToken, openId, DEFAULT_LANG);
	}
	
	@Override
	public UserMpInfo getUserInfoAll(UserMpInfoParam param) {
		if(param == null || StringUtils.isBlank(param.getAppId(),param.getOpenId())){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"getUserInfoAll时参数不能为空 param=," + param);
		}
		param.setLang(DEFAULT_LANG);
		JSONObject post = this.get(Constants.获取用户基本信息.getValue(), param);
		return WechatMpResultHandler.handleResult(post, UserMpInfo.class);
	}
	/**
	* <p>Description: 用户支付完成后，获取该用户的 UnionId</p> 
	* @author zhangzhichao   
	* @date Jul 31, 2020 9:20:12 AM 
	* @param param
	* @return 
	* @see org.bana.wechat.mp.auth.OAuthMpService#getPaidUserInfo(org.bana.wechat.mp.auth.param.UserPaidInfoParam) 
	*/ 
	@Override
	public UserMpInfo getPaidUserInfo(UserPaidInfoParam param) {
		if(param == null || StringUtils.isBlank(param.getAppId(),param.getOpenId())){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"getPaidUserInfo时参数不能为空 param=," + param);
		}
		JSONObject post = this.get(Constants.支付完成后获取用户信息.getValue(), param);
		return WechatMpResultHandler.handleResult(post, UserMpInfo.class);
	}

}
