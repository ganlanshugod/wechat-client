/**
* @Company 青鸟软通   
* @Title: AuthUtil.java 
* @Package org.bana.wechat.mp.common 
* @author Liu Wenjie   
* @date 2015-9-18 下午3:11:06 
* @version V1.0   
*/ 
package org.bana.wechat.mp.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: AuthUtil 
 * @Description: 与认证相关的工具方法
 *  
 */
public class AuthUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthUtil.class);
	
	public static enum AuthType{
		snsapi_base,snsapi_userinfo;
	}

	/** 
	* @Description: 初始化Oauth2.0的重定向url
	* @author Liu Wenjie   
	* @date 2015-9-18 下午3:11:57 
	* @param currentUrl
	* @return  
	*/ 
	public static String initAuditCodeUrl(String currentUrl,String appId,String state,AuthType type) {
		try {
			Map<String, String> context = new HashMap<String, String>();
			context.put("REDIRECT_URI", URLEncoder.encode(currentUrl, "utf-8"));
			context.put("APPID", appId);
			context.put("state", state);
			String wechatRedirect = "";
			if(AuthType.snsapi_base.equals(type)){
				wechatRedirect = StringUtils.replaceAll(Constants.MP_BASE_AUTH_URL.getValue(), context);
			}else{
				wechatRedirect = StringUtils.replaceAll(Constants.MP_USERINFO_AUTH_URL.getValue(), context);
			}
			LOG.info("=======initAuditCodeUrl：" + wechatRedirect);
			return wechatRedirect;
		} catch (UnsupportedEncodingException e) {
			throw new BanaWeChatException(BanaWeChatException.SYSTEM_CODE, e.getMessage(),e);
		}
	}
}
