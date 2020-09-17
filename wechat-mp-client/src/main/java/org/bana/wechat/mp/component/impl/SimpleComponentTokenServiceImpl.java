/**
* @Company 全域旅游
* @Title: SimpleComponentTokenServiceImpl.java 
* @Package org.bana.wechat.mp.component.impl 
* @author liuwenjie   
* @date Sep 17, 2020 9:36:49 AM 
* @version V1.0   
*/
package org.bana.wechat.mp.component.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.common.http.HttpHelperService;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.component.ComponentTokenService;
import org.bana.wechat.mp.component.common.WechatMpComponentConfig;
import org.bana.wechat.mp.component.common.WechatMpComponentManager;
import org.bana.wechat.mp.component.common.WechatMpComponentTicketStore;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: SimpleComponentTokenServiceImpl
 * @Description: 一个简单的组件token实现类，不能处理token的保存问题
 * @author liuwenjie
 */
public class SimpleComponentTokenServiceImpl extends HttpHelperService implements ComponentTokenService {

	private WechatMpComponentManager wechatMpComponentManager;
	
	private WechatMpComponentTicketStore WechatMpComponentTicketStore;
	/**
	 * <p>
	 * Description:
	 * </p>
	 * @author liuwenjie
	 * @date Sep 17, 2020 9:37:28 AM
	 * @param appId
	 * @return
	 * @see org.bana.wechat.mp.component.ComponentTokenService#getComponentToken(java.lang.String)
	 */
	@Override
	public String getComponentToken(String appId) {
		WechatMpComponentConfig config = wechatMpComponentManager.getConfig(appId);
		
		String ticket = WechatMpComponentTicketStore.getComponentVerifyTicket(appId);
		
//		{
//		  "component_appid":  "appid_value" ,
//		  "component_appsecret":  "appsecret_value",
//		  "component_verify_ticket": "ticket_value"
//		}
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("component_appid", config.getComponentAppid());
		paramMap.put("component_appsecret", config.getComponentAppsecret());
		paramMap.put("component_verify_ticket", ticket);
		JSONObject httpPost = this.httpHelper.httpPost(Constants.第三方获取令牌.getValue(),paramMap);
		WechatMpResultHandler.handleResult(httpPost);
//		{
//			  "component_access_token": "61W3mEpU66027wgNZ_MhGHNQDHnFATkDa9-2llqrMBjUwxRSNPbVsMmyD-yq8wZETSoE5NQgecigDrSHkPtIYA",
//			  "expires_in": 7200
//			}
		return httpPost.getString("component_access_token");
	}
	
	
	public void setWechatMpComponentManager(WechatMpComponentManager wechatMpComponentManager) {
		this.wechatMpComponentManager = wechatMpComponentManager;
	}


	public void setWechatMpComponentTicketStore(WechatMpComponentTicketStore wechatMpComponentTicketStore) {
		WechatMpComponentTicketStore = wechatMpComponentTicketStore;
	}
	
	
}
