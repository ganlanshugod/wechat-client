/**
 * @Company JBINFO
 * @Title: AccessTokenServiceImpl.java
 * @Package org.bana.wechat.mp.token.impl
 * @author Liu Wenjie
 * @date 2018年5月15日 上午11:27:10
 * @version V1.0
 */
package org.bana.wechat.mp.token.impl;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.token.AccessTokenService;
import org.bana.wechat.mp.token.result.AccessToken;
import org.bana.wechat.mp.token.result.WebAuthAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: AccessTokenServiceImpl
 * @Description: AccessToken的实现类
 * @author Liu Wenjie
 */
public class SimpleAccessTokenServiceImpl implements AccessTokenService{

	private static final Logger LOG = LoggerFactory.getLogger(SimpleAccessTokenServiceImpl.class);
	
	private HttpHelper httpHelper = new HttpHelper();
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年5月15日 上午11:27:32
	 * @param appId
	 * @param secret
	 * @return
	 * @see org.bana.wechat.mp.token.AccessTokenService#getAccessToken(java.lang.String, java.lang.String)
	 */
	@Override
	public String getAccessToken(String appId, String secret) {
		LOG.info("=====调用了获取getAccessToken的方法===========,appId="+appId+",secret="+secret);
		if(StringUtils.isBlank(appId,secret)){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"获取服务号AccessToken时参数不能为空,appId,secret=,"+appId+","+secret);
		}
		StringBuffer sb = new StringBuffer(Constants.获取服务号access_token.getValue())
				.append("?grant_type=").append("client_credential")
				.append("&appid=").append(appId)
				.append("&secret=").append(secret);
		
		JSONObject httpGet = httpHelper.httpGet(sb.toString());
		AccessToken handleResult = WechatMpResultHandler.handleResult(httpGet,AccessToken.class);
		return handleResult.getAccessToken();
	}

	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午1:00:59
	 * @param appId
	 * @param secret
	 * @param code
	 * @return
	 * @see org.bana.wechat.mp.token.AccessTokenService#getWebAuthAccessToken(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public WebAuthAccessToken getWebAuthAccessToken(String appId, String secret, String code) {
		LOG.info("=====调用了获取getAccessToken的方法===========,appId="+appId+",secret="+secret+",code="+code);
		if(StringUtils.isBlank(appId,secret)){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"获取服务号getWebAuthAccessToken时参数不能为空,appId,secret,code=,"+appId+","+secret+","+code);
		}
		StringBuffer sb = new StringBuffer(Constants.页面认证获取TOKEN.getValue())
				.append("?grant_type=").append("authorization_code")
				.append("&appid=").append(appId)
				.append("&secret=").append(secret)
				.append("&code=").append(code);
		
		JSONObject httpGet = httpHelper.httpGet(sb.toString());
		WebAuthAccessToken handleResult = WechatMpResultHandler.handleResult(httpGet,WebAuthAccessToken.class);
		return handleResult;
	}

}
