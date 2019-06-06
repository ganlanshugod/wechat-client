/**
 * @Company JBINFO
 * @Title: WechatMpService.java
 * @Package org.bana.wechat.mp.common
 * @author Liu Wenjie
 * @date 2018年5月15日 上午10:48:52
 * @version V1.0
 */
package org.bana.wechat.mini.common;

import java.util.Map;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mini.media.param.WechatMiniUploadParam;
import org.bana.wechat.mini.token.AccessTokenService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: WechatMiniService
 * @Description: 
 * @author Liu Wenjie
 */
public abstract class WechatMiniService {

	public static final String HTTP_POST = "post";

	private HttpHelper httpHelper;
	
	private AccessTokenService accessTokenService;
	
	/**
	 * Description: 返回通用的http工具类对象
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午1:09:56
	 * @return
	 */
	protected JSONObject get(String url,WeChatMiniParam param){
		String paramStr = JSON.toJSONString(param);
		Map<String,Object> map = JSON.parseObject(paramStr, Map.class);
		String paramUrl = StringUtils.getUrlParamsByMap(map);
		if(!StringUtils.isBlank(paramUrl)){
			if(url.contains("?")){
				url += "&" + paramUrl;
			}else{
				url += "?" + paramUrl;
			}
		}
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
	protected JSONObject post(String url,WeChatMiniParam param){
		return getHttpHelper().httpPost(addAccessToken(url, param),param);
	}
	
	protected String addAccessToken(String url,WeChatMiniParam param){
		String accessToken = accessTokenService.getAccessToken(param.getAppId());
		if(url.contains("?")){
			url += "&";
		}else{
			url += "?";
		}
		url+="access_token="+accessToken;
		return url;
	}
	
	/**
	 * 上传文件的post接口
	 * @param url
	 * @param param
	 * @return
	 */
	protected JSONObject postMedia(String url,WechatMiniUploadParam param){
		url = addAccessToken(url, param);
		if(param.getType() == null){
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR, "必须指定type属性");
		}
		url+= "&type="+param.getType().getType();
		return getHttpHelper().uploadMedia(url, param.getFile());
	}
	
	/*========== getter and setter =============*/
	
	public void setHttpHelper(HttpHelper httpHelper) {
		this.httpHelper = httpHelper;
	}

	public void setAccessTokenService(AccessTokenService accessTokenService) {
		this.accessTokenService = accessTokenService;
	}
	
	protected HttpHelper getHttpHelper() {
		if(httpHelper == null){
			httpHelper = new HttpHelper();
		}
		return httpHelper;
	}
}
