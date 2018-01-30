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
import org.bana.wechat.cp.app.WechatCorpSuiteConfig;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.common.WechatCpException;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.token.AccessTokenService;
import org.bana.wechat.cp.token.domain.AccessToken;
import org.bana.wechat.cp.token.domain.SuiteAccessToken;
import org.bana.wechat.cp.token.param.SuiteTokenParam;
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
				AccessToken accessToken = getAccessTokenBySecret(corpId, secret);
				return accessToken.getAccessToken();
			case 第三方托管:
			case 第三方通讯录:
				throw new RuntimeException("不支持第三方的应用的token获取方式");
			default:
				throw new RuntimeException("位置的AppType"+corpAppType);
		}
		
	}
	
	/**
	 * <p>Description: 根据企业微信的suiteId获取套件的suite_access_token</p>
	 * @author Zhang Zhichao
	 * @date 2018年1月25日 下午2:17:51
	 * @param suiteId
	 * @return
	 * @see org.bana.wechat.cp.token.AccessTokenService#getSuiteAccessToken(java.lang.String)
	 */
	@Override
	public String getSuiteAccessToken(String suiteId) {
		LOG.info("=====调用了获取getSuiteAccessToken的方法===========,suiteId="+suiteId);
		// 获取套件信息
		WechatCorpSuiteConfig suiteConfig = wechatAppManager.getSuiteConfig(suiteId);
		if(suiteConfig==null){
			throw new WechatCpException(WechatCpException.SUITE_PARAM_ERROR2, "没有找到suiteId="+suiteId+"的套件信息");
		}
		String suiteTicket = wechatAppManager.getSuiteTicket(suiteId);
		if(StringUtils.isBlank(suiteTicket)){
			throw new WechatCpException(WechatCpException.SUITE_PARAM_ERROR3, "没有找到suiteId" + suiteId + "对应的suiteTicket");
		}
		SuiteTokenParam suiteParam = new SuiteTokenParam();
		suiteParam.setSuiteId(suiteId);
		suiteParam.setSuiteSecret(suiteConfig.getSuiteSecret());
		suiteParam.setSuiteTicket(suiteTicket);
		JSONObject httpPost = httpHelper.httpPost(Constants.获取SuiteToken.getValue(), suiteParam);
		SuiteAccessToken suiteAccessToken = WechatCpResultHandler.handleResult(httpPost,SuiteAccessToken.class);
		return suiteAccessToken.getSuiteAccessToken();
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

	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}

	public void setWechatAppManager(WechatAppManager wechatAppManager) {
		this.wechatAppManager = wechatAppManager;
	}

	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月30日 下午3:40:19
	 * @param corpId
	 * @param agentId
	 * @return
	 * @see org.bana.wechat.cp.token.AccessTokenService#getJsApiTicket(java.lang.String, java.lang.String)
	 */
	@Override
	public String getJsApiTicket(String corpId, String agentId) {
		LOG.info("=====调用了获取getJsApiTicket的方法===========,corpId="+corpId+",agentId="+agentId);
		String accessToken = this.getAccessToken(corpId, agentId);
		return getJsApiTicket(accessToken);
	}
	
	protected String getJsApiTicket(String accessToken){
		String url = Constants.获取JsApiTicket.getValue() + "?access_token=" + accessToken;
		JSONObject httpGet = httpHelper.httpGet(url);
		WechatCpResultHandler.handleResult(httpGet);
		String ticket = httpGet.getString("ticket");
		return ticket;
	}

	
}
