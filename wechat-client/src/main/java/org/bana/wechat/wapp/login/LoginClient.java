/**
* @Company 成长伴行   
* @Title: LoginClient.java 
* @Package org.bana.wechat.wapp.login 
* @author Yang Shuangshuang   
* @date 2017-1-5 13:16:14 
* @version V1.0   
*/ 
package org.bana.wechat.wapp.login;

import java.util.Map;

import net.sf.json.JSONObject;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.wapp.common.Constants;
import org.bana.wechat.wapp.login.domain.WappSession;
import org.bana.wechat.wapp.login.param.SessionGetParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: LoginClient 
 * @Description:小程序获取用户登录状态的接口
 *  
 */
public class LoginClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginClient.class);

	/** 
	* @Description: 获取企业号内容信息
	* @author Liu Wenjie   
	* @date 2015-5-15 下午5:20:23 
	* @param agentParam
	* @return  
	*/ 
	public static WappSession getSession(SessionGetParam sessionGetParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(sessionGetParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取open_id及session_key.getValue(), convertBean);
		JSONObject json = JSONObject.fromObject(result);
		WappSession session = (WappSession) JSONObject.toBean(json, WappSession.class);
		if(session==null||StringUtils.isBlank(session.getOpenid())){
			String errcode = json.getString(Constants.返回码.getValue());
			String errMsg=json.getString(Constants.返回信息.getValue());
			if(StringUtils.isNotBlank(errcode)){
				throw new BanaWeChatException(errcode, errMsg);
			}
		}
		return session;
	}
	
}
