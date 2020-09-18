package org.bana.wechat.mp.component.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.app.MpType;
import org.bana.wechat.mp.app.WechatMpConfig;
import org.bana.wechat.mp.app.WechatMpManager;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.component.common.WechatMpComponentBaseService;
import org.bana.wechat.mp.token.AccessTokenService;
import org.bana.wechat.mp.token.result.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: AccessTokenServiceImpl
 * @Description: AccessToken的实现类
 * @author Liu Wenjie
 */
public class SimpleComponentAccessTokenServiceImpl extends WechatMpComponentBaseService implements AccessTokenService{

	private static final Logger LOG = LoggerFactory.getLogger(SimpleComponentAccessTokenServiceImpl.class);
	
//	private HttpHelper httpHelper = new HttpHelper();
	
	private WechatMpManager wechatMpManager;
	
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
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"获取服务号AccessToken时参数不能为空,appId="+appId);
		}
		WechatMpConfig appConfig = wechatMpManager.getAppConfig(appId);
		if(appConfig == null ){
			throw new WeChatMpException(WeChatMpException.APP_PARAM_ERROR1, "没有找到appID="+appId+"的应用配置");
		}
		// 使用第三方授权的方式获取微信公众号的accessToken参数
		if(MpType.第三方授权.getValue().equals(appConfig.getMpType())){
			String compAppId = appConfig.getComponentAppid();
			String freshToken = appConfig.getAuthorizerRefreshToken(); // 永久授权码
			if(StringUtils.isBlank(freshToken,compAppId)) {
				throw new WeChatMpException(WeChatMpException.APP_PARAM_ERROR1, "没有找到appID="+appId+"的合法第三方授权应用配置"+appConfig);
			}
//			{
//				  "component_appid": "appid_value",
//				  "authorizer_appid": "auth_appid_value",
//				  "authorizer_refresh_token": "refresh_token_value"
//				}
			Map<String,String> param = new HashMap<>();
			param.put("component_appid", compAppId);
			param.put("authorizer_appid", appId);
			param.put("authorizer_refresh_token", freshToken);
			JSONObject jsonObject = this.post(Constants.第三方获取服务号AccessToken.getValue(), compAppId, param);
			WechatMpResultHandler.handleResult(jsonObject);
//			{
//				  "authorizer_access_token": "some-access-token",
//				  "expires_in": 7200,
//				  "authorizer_refresh_token": "refresh_token_value"
//				}
			return jsonObject.getString("authorizer_access_token");
		}else {
			// 使用自建应用的配置参数获取对应的公众号token
			if(StringUtils.isBlank(appConfig.getSecret())) {
				throw new WeChatMpException(WeChatMpException.APP_PARAM_ERROR1, "没有找到appID="+appId+"的自建应用配置"+appConfig);
			}
			StringBuffer sb = new StringBuffer(Constants.获取服务号access_token.getValue())
					.append("?grant_type=").append("client_credential")
					.append("&appid=").append(appId)
					.append("&secret=").append(appConfig.getSecret());
			
			JSONObject httpGet = this.getHttpHelper().httpGet(sb.toString());
			AccessToken handleResult = WechatMpResultHandler.handleResult(httpGet,AccessToken.class);
			return handleResult.getAccessToken();
		}
	}


	public void setWechatMpManager(WechatMpManager wechatMpManager) {
		this.wechatMpManager = wechatMpManager;
	}

}
