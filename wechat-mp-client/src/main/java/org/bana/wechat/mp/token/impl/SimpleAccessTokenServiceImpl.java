/**
 * @Company JBINFO
 * @Title: AccessTokenServiceImpl.java
 * @Package org.bana.wechat.mp.token.impl
 * @author Liu Wenjie
 * @date 2018年5月15日 上午11:27:10
 * @version V1.0
 */
package org.bana.wechat.mp.token.impl;

import org.bana.wechat.common.http.HttpHelperService;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.app.WechatMpConfig;
import org.bana.wechat.mp.app.WechatMpManager;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.common.WechatMpResultHandler;
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
public class SimpleAccessTokenServiceImpl extends HttpHelperService implements AccessTokenService{

	private static final Logger LOG = LoggerFactory.getLogger(SimpleAccessTokenServiceImpl.class);
	
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
		if(appConfig == null || appConfig.getSecret() == null){
			throw new WeChatMpException(WeChatMpException.APP_PARAM_ERROR1, "没有找到appID="+appId+"的应用配置");
		}
		StringBuffer sb = new StringBuffer(Constants.获取服务号access_token.getValue())
				.append("?grant_type=").append("client_credential")
				.append("&appid=").append(appId)
				.append("&secret=").append(appConfig.getSecret());
		
		JSONObject httpGet = this.getHttpHelper().httpGet(sb.toString());
		AccessToken handleResult = WechatMpResultHandler.handleResult(httpGet,AccessToken.class);
		return handleResult.getAccessToken();
	}


	public void setWechatMpManager(WechatMpManager wechatMpManager) {
		this.wechatMpManager = wechatMpManager;
	}

}
