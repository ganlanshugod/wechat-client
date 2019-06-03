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
import org.bana.wechat.mp.app.WechatMpConfig;
import org.bana.wechat.mp.app.WechatMpManager;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.token.CodeSessionMiniService;
import org.bana.wechat.mp.token.result.Code2SessionInfo;
import org.bana.wechat.mp.token.result.WebAuthAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: AccessTokenServiceImpl
 * @Description: AccessToken的实现类
 * @author Liu Wenjie
 */
public class CodeSessionMiniServiceImpl implements CodeSessionMiniService{

	private static final Logger LOG = LoggerFactory.getLogger(CodeSessionMiniServiceImpl.class);
	
	private HttpHelper httpHelper = new HttpHelper();
	
	private WechatMpManager wechatMpManager;
	
	/**
	 * <p>Description: 小程序：根据登录时获取的 code，获取session_key等信息</p>
	 * @author Zhang Zhichao
	 * @date 2019年6月3日 下午4:05:11
	 * @param code
	 * @return
	 * @see org.bana.wechat.mp.token.CodeSessionMiniService#getSessionInfo(java.lang.String)
	 */
	@Override
	public Code2SessionInfo getSessionInfo(String appId,String code) {
		LOG.info("=====调用了获取getSessionInfo的方法===========,appId="+appId+",code="+code);
		if(StringUtils.isBlank(appId)){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"获取小程序getSessionInfo时参数不能为空,appId,code=,"+appId+","+code);
		}
		WechatMpConfig appConfig = wechatMpManager.getAppConfig(appId);
		if(appConfig == null || appConfig.getSecret() == null){
			throw new WeChatMpException(WeChatMpException.APP_PARAM_ERROR1, "没有找到appID="+appId+"的应用配置");
		}
		StringBuffer sb = new StringBuffer(Constants.小程序登录凭证校验.getValue())
				.append("?appid=").append(appId)
				.append("&secret=").append(appConfig.getSecret())
				.append("&js_code=").append(code)
				.append("&grant_type=").append("authorization_code");
		
		JSONObject httpGet = httpHelper.httpGet(sb.toString());
		Code2SessionInfo handleResult = WechatMpResultHandler.handleResult(httpGet,Code2SessionInfo.class);
		return handleResult;
	}

	public void setWechatMpManager(WechatMpManager wechatMpManager) {
		this.wechatMpManager = wechatMpManager;
	}

	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}

}
