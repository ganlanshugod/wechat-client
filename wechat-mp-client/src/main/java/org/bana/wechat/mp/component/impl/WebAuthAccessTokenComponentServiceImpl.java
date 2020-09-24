package org.bana.wechat.mp.component.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.bana.wechat.mp.app.MpType;
import org.bana.wechat.mp.app.WechatMpConfig;
import org.bana.wechat.mp.app.WechatMpManager;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.component.common.WechatMpComponentBaseService;
import org.bana.wechat.mp.token.WebAuthAccessTokenService;
import org.bana.wechat.mp.token.impl.WebAuthAccessTokenServiceImpl;
import org.bana.wechat.mp.token.result.WebAuthAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: WebAuthAccessTokenComponentServiceImpl
 * @Description:
 * @author liuwenjie
 */
public class WebAuthAccessTokenComponentServiceImpl extends WechatMpComponentBaseService
		implements WebAuthAccessTokenService {

	private static final Logger LOG = LoggerFactory.getLogger(WebAuthAccessTokenServiceImpl.class);

	private WechatMpManager wechatMpManager;

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午1:00:59
	 * @param appId
	 * @param secret
	 * @param code
	 * @return
	 * @see org.bana.wechat.mp.token.AccessTokenService#getWebAuthAccessToken(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public WebAuthAccessToken getWebAuthAccessToken(String appId, String code) {
		LOG.info("=====调用了获取getAccessToken的方法===========,appId=" + appId + ",code=" + code);
		if (StringUtils.isAnyBlank(appId, code)) {
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,
					"获取服务号getWebAuthAccessToken时参数不能为空,appId,code=," + appId + "," + code);
		}
		WechatMpConfig appConfig = wechatMpManager.getAppConfig(appId);
		if (appConfig == null) {
			throw new WeChatMpException(WeChatMpException.APP_PARAM_ERROR1, "没有找到appID=" + appId + "的应用配置");
		}
		if (MpType.第三方授权.getValue().equals(appConfig.getMpType())) {
			String compAppId = appConfig.getComponentAppid();
//			appid=APPID&code=CODE&grant_type=authorization_code&component_appid=COMPONENT_APPID&component_access_token=COMPONENT_ACCESS_TOKEN
			if (StringUtils.isBlank(compAppId)) {
				throw new WeChatMpException(WeChatMpException.APP_PARAM_ERROR1,
						"没有找到appID=" + appId + "的合法第三方授权应用配置" + appConfig);
			}
			Map<String, String> param = new HashMap<>();
			param.put("appid", appId);
			param.put("code", code);
			param.put("grant_type", "authorization_code");
			param.put("component_appid", compAppId);
			JSONObject jsonObject = this.get(Constants.第三方获取页面认证token的接口.getValue(), compAppId, param);
			WebAuthAccessToken handleResult = WechatMpResultHandler.handleResult(jsonObject, WebAuthAccessToken.class);
			return handleResult;
		} else {
			// 使用自建应用的配置参数获取对应的公众号token
			if (StringUtils.isBlank(appConfig.getSecret())) {
				throw new WeChatMpException(WeChatMpException.APP_PARAM_ERROR1,
						"没有找到appID=" + appId + "的自建应用配置" + appConfig);
			}
			StringBuffer sb = new StringBuffer(Constants.页面认证获取TOKEN.getValue()).append("?grant_type=")
					.append("authorization_code").append("&appid=").append(appId).append("&secret=")
					.append(appConfig.getSecret()).append("&code=").append(code);

			JSONObject httpGet = this.getHttpHelper().httpGet(sb.toString());
			WebAuthAccessToken handleResult = WechatMpResultHandler.handleResult(httpGet, WebAuthAccessToken.class);
			return handleResult;
		}
	}

	public void setWechatMpManager(WechatMpManager wechatMpManager) {
		this.wechatMpManager = wechatMpManager;
	}
}
