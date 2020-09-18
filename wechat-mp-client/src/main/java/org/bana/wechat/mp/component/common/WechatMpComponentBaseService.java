/**
* @Company 全域旅游
* @Title: WechatMpComponentService.java 
* @Package org.bana.wechat.mp.component.common 
* @author liuwenjie   
* @date Sep 18, 2020 1:27:01 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.common;

import java.util.Map;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.component.ComponentTokenService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/** 
* @ClassName: WechatMpComponentService 
* @Description: 一个微信第三方应用平台对应的service实现
* @author liuwenjie   
*/
public class WechatMpComponentBaseService {

	private ComponentTokenService componentTokenService;
	
	private HttpHelper httpHelper;
	
	
	/**
	 * Description: 返回通用的http工具类对象
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午1:09:56
	 * @return
	 */
	protected JSONObject get(String url,String appId,Object param){
		String paramStr = JSON.toJSONString(param);
		Map<String,Object> map = null;
		if(param != null) {
			if(param instanceof Map) {
				map = (Map)param;
			}else {
				map = JSON.parseObject(paramStr, Map.class);
			}
		}
		String paramUrl = StringUtils.getUrlParamsByMap(map);
		if(!StringUtils.isBlank(paramUrl)){
			if(url.contains("?")){
				url += "&" + paramUrl;
			}else{
				url += "?" + paramUrl;
			}
		}
		return getHttpHelper().httpGet(addAccessToken(url, appId));
	}
	
	protected JSONObject post(String url,String appId,Object param){
		return getHttpHelper().httpPost(addAccessToken(url, appId),param);
	}
	
	protected String addAccessToken(String url,String appId){
		String accessToken = componentTokenService.getComponentToken(appId);
		if(url.contains("?")){
			url += "&";
		}else{
			url += "?";
		}
		url+="component_access_token="+accessToken;
		return url;
	}
	
	/*====getter and setter -====*/
	
	public void setComponentTokenService(ComponentTokenService componentTokenService) {
		this.componentTokenService = componentTokenService;
	}


	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}
	
	protected HttpHelper getHttpHelper() {
		if(httpHelper == null){
			httpHelper = new HttpHelper();
		}
		return httpHelper;
	}
}
