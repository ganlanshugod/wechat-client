/**
 * @Company JBINFO
 * @Title: AccessTokenServiceImpl.java
 * @Package AccessTokenService
 * @author Liu Wenjie
 * @date 2018年1月19日 下午2:04:25
 * @version V1.0
 */
package org.bana.wechat.cp.token.impl;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.cp.app.CorpAppType;
import org.bana.wechat.cp.app.WechatAppManager;
import org.bana.wechat.cp.app.WechatCorpAppConfig;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.common.WechatCpException;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.token.AccessTokenService;
import org.bana.wechat.cp.token.SuiteAccessTokenService;
import org.bana.wechat.cp.token.domain.AccessToken;
import org.bana.wechat.cp.token.param.CorpTokenParam;
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
	
	private SuiteAccessTokenService suiteAccessTokenService;
	
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
		LOG.info("=====调用了获取getAccessToken的方法===========,corpId="+corpId+",agentId="+agentId);
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
				AccessToken accessTokenApp = getAccessTokenBySecret(corpId, secret);
				return accessTokenApp.getAccessToken();
			case 第三方托管:
			case 第三方通讯录:
				AccessToken accessTokenSuite = getAccessTokenByPermanentCode(appConfig.getCorpId(),appConfig.getPermanentCode(),appConfig.getSuiteId());
				return accessTokenSuite.getAccessToken();
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
	private AccessToken getAccessTokenBySecret(String corpId,String secret){
		if(StringUtils.isBlank(corpId,secret)){
			throw new WechatCpException(WechatCpException.PARAM_ERROR,"获取AccessToken时参数不能为空,corpId="+corpId+",secret="+secret);
		}
		StringBuffer sb = new StringBuffer(Constants.获取AccessToken.getValue())
				.append("?corpid=").append(corpId)
				.append("&corpsecret=").append(secret);
		JSONObject httpGet = httpHelper.httpGet(sb.toString());
		return WechatCpResultHandler.handleResult(httpGet,AccessToken.class);
	}
	
	
	private AccessToken getAccessTokenByPermanentCode(String corpId,String permanentCode,String suiteId){
		if(StringUtils.isBlank(corpId,permanentCode,suiteId)){
			throw new WechatCpException(WechatCpException.PARAM_ERROR,"获取AccessToken时参数不能为空,corpId="+corpId+",permanentCode="+permanentCode+",suiteId="+suiteId);
		}
		String suiteAccessToken = suiteAccessTokenService.getSuiteAccessToken(suiteId);
		CorpTokenParam corpTokenParam = new CorpTokenParam();
		corpTokenParam.setAuthCorpId(corpId);
		corpTokenParam.setPermanentCode(permanentCode);
		String url = Constants.获取企业号access_token.getValue()+"?suite_access_token="+suiteAccessToken;
		JSONObject httpPost = httpHelper.httpPost(url, corpTokenParam);
		return WechatCpResultHandler.handleResult(httpPost, AccessToken.class);
	}

	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}

	public void setWechatAppManager(WechatAppManager wechatAppManager) {
		this.wechatAppManager = wechatAppManager;
	}



	public void setSuiteAccessTokenService(SuiteAccessTokenService suiteAccessTokenService) {
		this.suiteAccessTokenService = suiteAccessTokenService;
	}
	
}
