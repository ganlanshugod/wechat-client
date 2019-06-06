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
import org.bana.wechat.mini.token.CodeSessionMiniService;
import org.bana.wechat.mini.token.result.Code2SessionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: CodeSessionMiniServiceImpl
 * @Description: CodeSessionMiniService的实现类
 * @author Liu Wenjie
 */
public class CodeSessionMiniServiceImpl implements CodeSessionMiniService{

	private static final Logger LOG = LoggerFactory.getLogger(CodeSessionMiniServiceImpl.class);
	
	private HttpHelper httpHelper = new HttpHelper();
	
	private WechatMiniManager wechatMiniManager;
	
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
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR,"获取小程序getSessionInfo时参数不能为空,appId,code=,"+appId+","+code);
		}
		WechatMiniConfig appConfig = wechatMiniManager.getAppConfig(appId);
		if(appConfig == null || appConfig.getSecret() == null){
			throw new WeChatMiniException(WeChatMiniException.APP_PARAM_ERROR1, "没有找到appID="+appId+"的应用配置");
		}
		StringBuffer sb = new StringBuffer(Constants.小程序登录凭证校验.getValue())
				.append("?appid=").append(appId)
				.append("&secret=").append(appConfig.getSecret())
				.append("&js_code=").append(code)
				.append("&grant_type=").append("authorization_code");
		
		JSONObject httpGet = httpHelper.httpGet(sb.toString());
		Code2SessionInfo handleResult = WechatMiniResultHandler.handleResult(httpGet,Code2SessionInfo.class);
		return handleResult;
	}

	public void setWechatMiniManager(WechatMiniManager wechatMiniManager) {
		this.wechatMiniManager = wechatMiniManager;
	}

	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}

}
