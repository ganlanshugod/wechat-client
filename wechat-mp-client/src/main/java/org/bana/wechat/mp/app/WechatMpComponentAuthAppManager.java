/**
* @Company 全域旅游
* @Title: WechatMpComponentManager.java 
* @Package org.bana.wechat.mp.app 
* @author liuwenjie   
* @date Sep 18, 2020 5:28:20 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.app;

import java.util.Date;

import org.bana.wechat.mp.component.result.AuthorizationInfo;
import org.bana.wechat.mp.component.result.AuthorizerInfo;

/** 
* @ClassName: WechatMpComponentManager 
* @Description: 微信第三方授权相关的应用管理接口
* @author liuwenjie   
*/
public interface WechatMpComponentAuthAppManager extends WechatMpManager {

	/** 
	* @Description: 保存授权后的第三方
	* @author liuwenjie   
	* @date Sep 18, 2020 5:26:24 PM 
	* @param componentAppId
	* @param queryAuth
	* @param authorizerInfo  
	 * @param createDate 
	*/ 
	void createComponentAppConfig(String componentAppId, AuthorizationInfo authorizationInfo, AuthorizerInfo authorizerInfo, Date createDate);

	/** 
	* @Description: 更新授权后的第三方
	* @author liuwenjie   
	* @date Sep 18, 2020 5:33:50 PM 
	* @param componentAppId
	* @param queryAuth
	* @param authorizerInfo  
	*/ 
	void updateComponentAppConfig(String componentAppId, AuthorizationInfo authorizationInfo, AuthorizerInfo authorizerInfo,Date createDate);

	/** 
	* @Description: 删除一条第三方授权的应用配置
	* @author liuwenjie   
	* @date Sep 18, 2020 5:36:58 PM 
	* @param componentAppId
	* @param authorizerAppid  
	 * @param createDate 
	*/ 
	void deleteComponentAppConfig(String componentAppId, String authorizerAppid, Date createDate);
}
