/**
* @Company 青鸟软通   
* @Title: Gettoken.java 
* @Package org.bana.wechat.qy.connection 
* @author Liu Wenjie   
* @date 2015-5-9 下午3:17:40 
* @version V1.0   
*/ 
package org.bana.wechat.qy.connection;

import java.util.HashMap;
import java.util.Map;

import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.token.domain.AccessToken;
import org.bana.wechat.cp.token.domain.SuiteAccessToken;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.connection.domain.JsApiTicket;
import org.bana.wechat.qy.connection.domain.ProviderAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/** 
 * @ClassName: Gettoken 
 * @Description: 获取访问微信接口所需要的AccessToken
 *  
 */
public class GetToken {
	
	private static final Logger LOG = LoggerFactory.getLogger(GetToken.class);
	/** 
	* @Description: 根据企业号id和管理秘钥获取访问微信接口的许可
	* @author Liu Wenjie   
	* @date 2015-5-9 下午3:38:57 
	* @param cropId
	* @param secret 
	*/ 
	public static AccessToken getAccessToken(String cropId,String secret){
		if(StringUtils.isBlank(cropId,secret)){
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"获取AccessToken时参数不能为空,cropId="+cropId+",secret="+secret);
		}
		Map<String,Object> mapParam = new HashMap<String, Object>();
		mapParam.put("corpid", cropId);
		mapParam.put("corpsecret", secret);
		String result = WeChatConnection.get(Constants.获取AccessToken.getValue(), mapParam);
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			AccessToken accessToken = (AccessToken)JSONObject.toBean(json, AccessToken.class);
			LOG.info("转化后的登录令牌为 " + accessToken);
			return accessToken;
		}else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/**
	* @Description: 获取应用套件令牌
	* @author Liu Wenjie   
	* @date 2015-5-12 下午9:12:37 
	* @param suite_id
	* @return
	 */
	public static SuiteAccessToken getSuiteToken(String suite_id,String suite_secret,String suite_ticket){
		if(StringUtils.isBlank(suite_id,suite_secret,suite_ticket)){
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"获取AccessToken时参数不能为空,suite_id="+suite_id+",suite_secret="+suite_secret+",suite_ticket="+suite_ticket);
		}
		Map<String,Object> mapParam = new HashMap<String, Object>();
		mapParam.put("suite_id", suite_id);
		mapParam.put("suite_secret", suite_secret);
		mapParam.put("suite_ticket", suite_ticket);
		String result = WeChatConnection.post(Constants.获取SuiteToken.getValue(), mapParam);
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			SuiteAccessToken accessToken = (SuiteAccessToken)JSONObject.toBean(json, SuiteAccessToken.class);
			LOG.info("转化后的suit登录令牌为 " + accessToken);
			return accessToken;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
		
	}
	
	/**
	* @Description: 获取JsApi的票据信息
	* @author Liu Wenjie   
	* @date 2015-6-15 下午12:42:23 
	* @return
	 */
	public static JsApiTicket getJsApiTicket(String access_token){
		if(StringUtils.isBlank(access_token)){
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"获取JsApiTicket时参数不能为空,access_token="+access_token);
		}
		Map<String,Object> mapParam = new HashMap<String, Object>();
		mapParam.put("access_token", access_token);
		String result = WeChatConnection.get(Constants.获取JsApiTicket.getValue(), mapParam);
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			JsApiTicket jsApiTicket = (JsApiTicket)JSONObject.toBean(json, JsApiTicket.class);
			LOG.info("转化后的JsApiTicket为 " + jsApiTicket);
			return jsApiTicket;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/** 
	* @Description: 获取应用提供商凭证ProviderAccessToken
	* @author Richard Core   
	* @date 2016-3-22 下午2:46:02 
	* @param cropId
	* @param providerSecret
	* @return  
	*/ 
	public static ProviderAccessToken getProviderAccessToken(String cropId,String providerSecret){
		if(StringUtils.isBlank(cropId,providerSecret)){
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"获取providerAccessToken时参数不能为空,cropId="+cropId+",providerSecret="+providerSecret);
		}
		Map<String,Object> mapParam = new HashMap<String, Object>();
		mapParam.put("corpid", cropId);
		mapParam.put("provider_secret", providerSecret);
		String result = WeChatConnection.post(Constants.获取应用提供商凭证.getValue(), mapParam);
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			ProviderAccessToken accessToken = (ProviderAccessToken)JSONObject.toBean(json, ProviderAccessToken.class);
			LOG.info("转化后的服务商令牌为 " + accessToken);
			return accessToken;
		}else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

}
