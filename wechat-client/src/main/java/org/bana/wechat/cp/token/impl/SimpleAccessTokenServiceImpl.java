/**
 * @Company JBINFO
 * @Title: AccessTokenServiceImpl.java
 * @Package AccessTokenService
 * @author Liu Wenjie
 * @date 2018年1月19日 下午2:04:25
 * @version V1.0
 */
package org.bana.wechat.cp.token.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.WechatCpException;
import org.bana.wechat.cp.app.CorpAppType;
import org.bana.wechat.cp.app.WechatAppManager;
import org.bana.wechat.cp.app.WechatCorpAppConfig;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.token.AccessTokenService;
import org.bana.wechat.qy.common.Constants;
import org.bana.wechat.qy.connection.domain.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: AccessTokenServiceImpl
 * @Description: 本地化的AccessTokenService
 * @author Liu Wenjie
 */
public class SimpleAccessTokenServiceImpl implements AccessTokenService {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleAccessTokenServiceImpl.class);
	
	private HttpHelper httpHelper = new HttpHelper();
	
	private WechatAppManager wechatAppManager;
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午2:04:25
	 * @param corpId
	 * @param agentId
	 * @return
	 * @see org.bana.wechat.cp.common.AccessTokenService#getAccessToken(java.lang.String, java.lang.String)
	 */
	@Override
	public String getAccessToken(String corpId, String agentId) {
		WechatCorpAppConfig appConfig = wechatAppManager.getAppConfig(corpId, agentId);
		if(appConfig == null){
			throw new WechatCpException(WechatCpException.APP_PARAM_ERROR1, "没有找到corpId="+corpId+",agentId=" + agentId +"的应用配置");
		}
		CorpAppType corpAppType = appConfig.getCorpAppType();
		if(corpAppType == null){
			throw new WechatCpException(WechatCpException.APP_PARAM_ERROR2, "corpId="+corpId+",agentId=" + agentId +"的应用没有指定CorpAppType");
		}
		switch(corpAppType){
			case 自建应用:
			case 通讯录管理API:
				String secret = appConfig.getSecret();
				AccessToken accessToken = getAccessTokenBySecret(corpId, secret);
				return accessToken.getAccess_token();
			case 第三方托管:
			case 第三方通讯录:
				throw new RuntimeException("不支持第三方的应用的token获取方式");
			default:
				throw new RuntimeException("位置的AppType"+corpAppType);
		}
		
	}
	
	/**
	 * Description: 通过corpId和secret来获取AccessToken对象
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午2:15:55
	 * @param cropId
	 * @param secret
	 * @return
	 */
	public AccessToken getAccessTokenBySecret(String corpId,String secret){
		if(StringUtils.isBlank(corpId,secret)){
			throw new WechatCpException(WechatCpException.PARAM_ERROR,"获取AccessToken时参数不能为空,corpId="+corpId+",secret="+secret);
		}
		Map<String,Object> mapParam = new HashMap<String, Object>();
		mapParam.put("corpid", corpId);
		mapParam.put("corpsecret", secret);
		StringBuffer sb = new StringBuffer(Constants.获取AccessToken.getValue())
				.append("?corpid=").append(corpId)
				.append("&corpsecret=").append(secret);
		JSONObject httpGet = httpHelper.httpGet(sb.toString());
		return WechatCpResultHandler.handleResult(httpGet,AccessToken.class);
	}

	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}

	public void setWechatAppManager(WechatAppManager wechatAppManager) {
		this.wechatAppManager = wechatAppManager;
	}

	
}
