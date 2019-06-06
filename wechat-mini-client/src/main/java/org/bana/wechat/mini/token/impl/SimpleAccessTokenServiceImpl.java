/**
 * @Company JBINFO
 * @Title: AccessTokenServiceImpl.java
 * @Package org.bana.wechat.mp.token.impl
 * @author Liu Wenjie
 * @date 2018年5月15日 上午11:27:10
 * @version V1.0
 */
package org.bana.wechat.mini.token.impl;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mini.app.WechatMiniConfig;
import org.bana.wechat.mini.app.WechatMiniManager;
import org.bana.wechat.mini.common.Constants;
import org.bana.wechat.mini.common.WeChatMiniException;
import org.bana.wechat.mini.common.WechatMiniResultHandler;
import org.bana.wechat.mini.token.AccessTokenService;
import org.bana.wechat.mini.token.result.AccessToken;
import org.bana.wechat.mini.token.result.WebAuthAccessToken;
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
	
	private WechatMiniManager wechatMiniManager;
	
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
	public String getAccessToken(String appId) {
		LOG.info("=====调用了获取getAccessToken的方法===========,appId="+appId);
		if(StringUtils.isBlank(appId)){
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR,"获取小程序AccessToken时参数不能为空,appId="+appId);
		}
		WechatMiniConfig appConfig = wechatMiniManager.getAppConfig(appId);
		if(appConfig == null || appConfig.getSecret() == null){
			throw new WeChatMiniException(WeChatMiniException.APP_PARAM_ERROR1, "没有找到appID="+appId+"的应用配置");
		}
		StringBuffer sb = new StringBuffer(Constants.获取服务号access_token.getValue())
				.append("?grant_type=").append("client_credential")
				.append("&appid=").append(appId)
				.append("&secret=").append(appConfig.getSecret());
		
		JSONObject httpGet = httpHelper.httpGet(sb.toString());
		AccessToken handleResult = WechatMiniResultHandler.handleResult(httpGet,AccessToken.class);
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
	public WebAuthAccessToken getWebAuthAccessToken(String appId,String code) {
		LOG.info("=====调用了获取getAccessToken的方法===========,appId="+appId+",code="+code);
		if(StringUtils.isBlank(appId)){
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR,"获取小程序getWebAuthAccessToken时参数不能为空,appId,code=,"+appId+","+code);
		}
		WechatMiniConfig appConfig = wechatMiniManager.getAppConfig(appId);
		if(appConfig == null || appConfig.getSecret() == null){
			throw new WeChatMiniException(WeChatMiniException.APP_PARAM_ERROR1, "没有找到appID="+appId+"的应用配置");
		}
		StringBuffer sb = new StringBuffer(Constants.页面认证获取TOKEN.getValue())
				.append("?grant_type=").append("authorization_code")
				.append("&appid=").append(appId)
				.append("&secret=").append(appConfig.getSecret())
				.append("&code=").append(code);
		
		JSONObject httpGet = httpHelper.httpGet(sb.toString());
		WebAuthAccessToken handleResult = WechatMiniResultHandler.handleResult(httpGet,WebAuthAccessToken.class);
		return handleResult;
	}

	public void setWechatMiniManager(WechatMiniManager wechatMiniManager) {
		this.wechatMiniManager = wechatMiniManager;
	}

	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}
	
}
