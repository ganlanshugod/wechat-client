/**
 * @Company JBINFO
 * @Title: WechatCpService.java
 * @Package org.bana.wechat.cp.common
 * @author Liu Wenjie
 * @date 2018年1月19日 下午1:05:27
 * @version V1.0
 */
package org.bana.wechat.cp.common;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.cp.token.AccessTokenService;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: WechatCpService
 * @Description: 微信企业号的通用抽象类
 * @author Liu Wenjie
 */
public abstract class WechatCpService {

	private HttpHelper httpHelper = new HttpHelper();
	
	private AccessTokenService accessTokenService;

	/**
	 * Description: 返回通用的http工具类对象
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午1:09:56
	 * @return
	 */
	protected JSONObject get(String url,WeChatCPParam param){
		return getHttpHelper().httpGet(addAccessToken(url, param));
	}
	
	/**
	 * Description: post 提交参数
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午1:35:54
	 * @param url
	 * @param param
	 * @return
	 */
	protected JSONObject post(String url,WeChatCPParam param){
		return getHttpHelper().httpPost(addAccessToken(url, param),param);
	}
	
	private String addAccessToken(String url,WeChatCPParam param){
		String accessToken = accessTokenService.getAccessToken(param.getCorpId(), param.getAgentId());
		if(url.contains("?")){
			url += "&";
		}else{
			url += "?";
		}
		url+="access_token="+accessToken;
		return url;
	}
	
	protected HttpHelper getHttpHelper() {
		if(httpHelper == null){
			httpHelper = new HttpHelper();
		}
		return httpHelper;
	}

	
	/*=========getter and setter ===========*/
	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}

	public void setAccessTokenService(AccessTokenService accessTokenService) {
		this.accessTokenService = accessTokenService;
	}
	
}
