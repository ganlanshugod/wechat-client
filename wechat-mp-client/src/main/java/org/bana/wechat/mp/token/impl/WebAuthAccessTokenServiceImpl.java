/**
* @Company 全域旅游
* @Title: WebAuthAccessTokenServiceImpl.java 
* @Package org.bana.wechat.mp.token.impl 
* @author liuwenjie   
* @date Sep 18, 2020 2:41:20 PM 
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
import org.bana.wechat.mp.token.WebAuthAccessTokenService;
import org.bana.wechat.mp.token.result.WebAuthAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/** 
* @ClassName: WebAuthAccessTokenServiceImpl 
* @Description: 
* @author liuwenjie   
*/
public class WebAuthAccessTokenServiceImpl extends HttpHelperService implements WebAuthAccessTokenService{

	private static final Logger LOG = LoggerFactory.getLogger(WebAuthAccessTokenServiceImpl.class);
	
	private WechatMpManager wechatMpManager;
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
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"获取服务号getWebAuthAccessToken时参数不能为空,appId,code=,"+appId+","+code);
		}
		WechatMpConfig appConfig = wechatMpManager.getAppConfig(appId);
		if(appConfig == null || appConfig.getSecret() == null){
			throw new WeChatMpException(WeChatMpException.APP_PARAM_ERROR1, "没有找到appID="+appId+"的应用配置");
		}
		StringBuffer sb = new StringBuffer(Constants.页面认证获取TOKEN.getValue())
				.append("?grant_type=").append("authorization_code")
				.append("&appid=").append(appId)
				.append("&secret=").append(appConfig.getSecret())
				.append("&code=").append(code);
		
		JSONObject httpGet = this.getHttpHelper().httpGet(sb.toString());
		WebAuthAccessToken handleResult = WechatMpResultHandler.handleResult(httpGet,WebAuthAccessToken.class);
		return handleResult;
	}
	
	public void setWechatMpManager(WechatMpManager wechatMpManager) {
		this.wechatMpManager = wechatMpManager;
	}


}
