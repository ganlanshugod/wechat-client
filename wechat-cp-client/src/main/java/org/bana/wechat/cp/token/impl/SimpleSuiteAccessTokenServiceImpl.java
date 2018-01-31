/**
 * @Company JBINFO
 * @Title: SimpleSuiteAccessTokenServiceImpl.java
 * @Package org.bana.wechat.cp.token.impl
 * @author Liu Wenjie
 * @date 2018年1月31日 下午12:02:36
 * @version V1.0
 */
package org.bana.wechat.cp.token.impl;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.cp.app.WechatAppManager;
import org.bana.wechat.cp.app.WechatCorpSuiteConfig;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.common.WechatCpException;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.token.SuiteAccessTokenService;
import org.bana.wechat.cp.token.domain.SuiteAccessToken;
import org.bana.wechat.cp.token.param.SuiteTokenParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: SimpleSuiteAccessTokenServiceImpl
 * @Description: 
 * @author Liu Wenjie
 */
public class SimpleSuiteAccessTokenServiceImpl implements SuiteAccessTokenService{
	
	private static final Logger LOG = LoggerFactory.getLogger(SimpleSuiteAccessTokenServiceImpl.class);

	private WechatAppManager wechatAppManager;
	
	private HttpHelper httpHelper = new HttpHelper();
	
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

	public void setWechatAppManager(WechatAppManager wechatAppManager) {
		this.wechatAppManager = wechatAppManager;
	}
	
}
