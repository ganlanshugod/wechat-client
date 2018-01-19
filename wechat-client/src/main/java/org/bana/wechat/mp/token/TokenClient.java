/**
* @Company 青鸟软通   
* @Title: TokenClient.java 
* @Package org.bana.wechat.mp.token 
* @author Liu Wenjie   
* @date 2015-8-18 下午5:14:32 
* @version V1.0   
*/ 
package org.bana.wechat.mp.token;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.token.domain.AccessToken;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.connection.domain.ApiTicket;
import org.bana.wechat.qy.connection.domain.JsApiTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: TokenClient 
 * @Description: 获取token的方法
 *  
 */
public class TokenClient {
	private static final Logger LOG = LoggerFactory.getLogger(TokenClient.class);

	/** 
	* @Description: 获取服务后Token
	* @author Han Tongyang   
	* @date 2015-9-6 上午10:00:34 
	* @param grantType
	* @param appId
	* @param secret
	* @return  
	*/ 
	public static AccessToken token(String grantType,String appId,String secret){
		if(StringUtils.isBlank(grantType,appId,secret)){
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"获取服务号AccessToken时参数不能为空,grantType,appId,secret="+grantType+","+appId+","+secret);
		}
		Map<String,Object> mapParam = new HashMap<String, Object>();
		mapParam.put("grant_type", grantType);
		mapParam.put("appid", appId);
		mapParam.put("secret", secret);
		String result = WeChatConnection.get(Constants.获取服务号access_token.getValue(), mapParam);
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			AccessToken accessToken = (AccessToken)JSONObject.toBean(json, AccessToken.class);
			LOG.info("转化后的服务号登录令牌为 " + accessToken);
			return accessToken;
		}else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/** 
	* @Description: 获取服务号JS Ticket
	* @author Han Tongyang   
	* @date 2015-9-6 上午10:02:54 
	* @param token
	* @return  
	*/ 
	public static JsApiTicket getTicket(String token){
		JsApiTicket jsApiTicket = getTicket(token, "jsapi");
		LOG.info("转化后的服务号JsApiTicket为 " + jsApiTicket);
		return jsApiTicket;
	}
	
	/** 
	* @Description: 获取服务号的apitiket
	* @author liuwenjie   
	* @date 2016-6-15 下午4:33:45 
	* @param token
	* @param type
	* @return  
	*/ 
	public static ApiTicket getTicket(String token,String type){
		if(StringUtils.isBlank(token)){
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"获取服务号JsApiTicket时参数不能为空,token="+token);
		}
		Map<String,Object> mapParam = new HashMap<String, Object>();
		mapParam.put("access_token", token);
		mapParam.put("type", type);
		String result = WeChatConnection.get(Constants.获取服务号JsApiTicket.getValue(), mapParam);
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			ApiTicket apiTicket = (ApiTicket)JSONObject.toBean(json, ApiTicket.class);
			LOG.info("转化后的服务号apiTicket为 " + apiTicket);
			return apiTicket;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
