/**
* @Company 全域旅游
* @Title: AuthClient.java 
* @Package org.bana.wechat.mp.component 
* @author liuwenjie   
* @date Sep 17, 2020 9:24:32 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component;

import org.bana.wechat.common.page.PageResult;
import org.bana.wechat.mp.component.param.AuthorizerOption;
import org.bana.wechat.mp.component.result.AuthDetailInfo;
import org.bana.wechat.mp.component.result.AuthorizationInfo;
import org.bana.wechat.mp.component.result.SimpleAuthorizer;

/** 
* @ClassName: ComponentService 
* @Description: 第三方服务商相关的应用处理方法
* @author liuwenjie   
*/
public interface ComponentService {

	/** 
	* @Description: 创建第三方平台的预授权码
	* @author liuwenjie   
	* @date Sep 18, 2020 1:21:57 PM 
	* @param appId  
	*/ 
	public String createPreAuthCode(String componentAppId);
	
	
	/** 
	* @Description: 授权后，根据码获取公众号的授权信息
	* @author liuwenjie   
	* @date Sep 18, 2020 1:58:05 PM 
	* @param appId 第三方套件的应用id
	* @param authCode 授权码
	* @return  
	*/ 
	public AuthorizationInfo queryAuth(String componentAppId,String authCode);
	
	
	/** 
	* @Description: 获取授权公众号的详细授权信息
	* @author liuwenjie   
	* @date Sep 18, 2020 3:45:23 PM 
	* @param componentAppId  第三方套件id
	* @param authorizerAppid 授权的公众号id
	* @return  
	*/ 
	public AuthDetailInfo getAuthorizerInfo(String componentAppId,String authorizerAppid);
	
	/**
	* @Description: 获取授权公众号对应功能配置信息
	* @author liuwenjie   
	* @date Sep 18, 2020 4:22:41 PM 
	* @param componentAppId
	* @param authorizerAppid
	* @param option
	* @return
	 */
	public String getAuthorizerOption(String componentAppId,String authorizerAppid,AuthorizerOption option);
	
	
	/** 
	* @Description: 设置授权公众号的功能开关
	* @author liuwenjie   
	* @date Sep 18, 2020 4:27:47 PM 
	* @param componentAppId
	* @param authorizerAppid
	* @param option
	* @param optionValue  
	*/ 
	public void setAuthorizerOption(String componentAppId,String authorizerAppid,AuthorizerOption option,String optionValue);

	
		
	/** 
	* @Description: 获取授权的公众号列表
	* @author liuwenjie   
	* @date Sep 23, 2020 12:13:33 PM 
	* @param componentAppId
	* @param offset
	* @param count  
	*/ 
	public PageResult<SimpleAuthorizer> getAuthorizerList(String componentAppId,int offset,int count);
}
