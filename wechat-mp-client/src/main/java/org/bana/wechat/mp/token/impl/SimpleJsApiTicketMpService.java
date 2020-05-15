/**
 * @Company JBINFO
 * @Title: SimpleJsApiTicketService.java
 * @Package org.bana.wechat.cp.token.impl
 * @author Liu Wenjie
 * @date 2018年1月31日 下午12:03:11
 * @version V1.0
 */
package org.bana.wechat.mp.token.impl;

import org.bana.wechat.common.http.HttpHelperService;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.token.AccessTokenService;
import org.bana.wechat.mp.token.JsApiTicketMpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: SimpleJsApiTicketService
 * @Description: Simple
 * @author Liu Wenjie
 */
public class SimpleJsApiTicketMpService extends HttpHelperService  implements JsApiTicketMpService{
	
	private AccessTokenService accessTokenService;
	
//	private HttpHelper httpHelper = new HttpHelper();
	
	private static final Logger LOG = LoggerFactory.getLogger(SimpleAccessTokenServiceImpl.class);

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
	public String getJsApiTicket(String appId) {
		LOG.info("=====调用了获取getJsApiTicket的方法===========,corpId="+appId);
		String accessToken = accessTokenService.getAccessToken(appId);
		return getJsApiTicketByToken(accessToken);
	}
	
	protected String getJsApiTicketByToken(String accessToken){
		String url = Constants.获取服务号JsApiTicket.getValue() + "?access_token=" + accessToken + "&type=jsapi";
		JSONObject httpGet = httpHelper.httpGet(url);
		WechatMpResultHandler.handleResult(httpGet);
		String ticket = httpGet.getString("ticket");
		return ticket;
	}

	public void setAccessTokenService(AccessTokenService accessTokenService) {
		this.accessTokenService = accessTokenService;
	}
	
}
