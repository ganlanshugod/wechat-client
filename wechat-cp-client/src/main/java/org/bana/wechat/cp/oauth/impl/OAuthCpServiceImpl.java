/**
 * @Company JBINFO
 * @Title: OAuthCpServiceImpl.java
 * @Package org.bana.wechat.cp.oauth.impl
 * @author Liu Wenjie
 * @date 2018年1月31日 下午5:51:24
 * @version V1.0
 */
package org.bana.wechat.cp.oauth.impl;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.common.WechatCpService;
import org.bana.wechat.cp.oauth.OAuthCpService;
import org.bana.wechat.cp.oauth.param.UserCpInfoParam;
import org.bana.wechat.cp.oauth.result.UserCpInfo;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: OAuthCpServiceImpl
 * @Description: 认证用户获取的Service方法
 * @author Liu Wenjie
 */
public class OAuthCpServiceImpl extends WechatCpService implements OAuthCpService {

	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月31日 下午5:51:24
	 * @param userInfoParam
	 * @return
	 * @see org.bana.wechat.cp.oauth.OAuthCpService#getUserInfo(org.bana.wechat.cp.oauth.param.UserCpInfoParam)
	 */
	@Override
	public UserCpInfo getUserInfo(UserCpInfoParam userInfoParam) {
		JSONObject post = this.get(Constants.根据code获取成员信息.getValue()+"?code="+userInfoParam.getCode(), userInfoParam);
		return WechatCpResultHandler.handleResult(post, UserCpInfo.class);
	}

}
