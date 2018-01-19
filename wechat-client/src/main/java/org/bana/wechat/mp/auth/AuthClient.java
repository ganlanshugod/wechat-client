/**
* @Company 青鸟软通   
* @Title: AuthClient.java 
* @Package org.bana.wechat.mp.auth 
* @author Han Tongyang   
* @date 2015-8-26 下午5:26:02 
* @version V1.0   
*/ 
package org.bana.wechat.mp.auth;

import java.util.Map;

import net.sf.json.JSONObject;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.mp.auth.domain.AuthTokenDomain;
import org.bana.wechat.mp.auth.param.AuthTokenParam;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: AuthClient 
 * @Description: 网页验证
 *  
 */
public class AuthClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthClient.class);
	
	/** 
	* @Description: 获取token
	* @author Han Tongyang   
	* @date 2015-8-26 下午7:55:53 
	* @return  
	*/ 
	public static AuthTokenDomain getToken(AuthTokenParam param){
		param.setGrant_type("authorization_code");
		LOG.info("============AuthClient.getToken(" + param + ")");
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.页面认证获取TOKEN.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			AuthTokenDomain domain = (AuthTokenDomain) JSONObject.toBean(json, AuthTokenDomain.class);
			LOG.info("转化后的用户结果为 " + domain);
			return domain;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

//	public static Auth
	
	
}
