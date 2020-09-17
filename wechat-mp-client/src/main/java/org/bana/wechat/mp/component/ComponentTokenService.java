/**
* @Company 全域旅游
* @Title: ComponentTokenService.java 
* @Package org.bana.wechat.mp.component 
* @author liuwenjie   
* @date Sep 17, 2020 9:28:51 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component;

/** 
* @ClassName: ComponentTokenService 
* @Description: 第三方平台token对应的Service配置
* @author liuwenjie   
*/
public interface ComponentTokenService {

	/** 
	* @Description: 获取公众号第三方服务商的token对象
	* @author liuwenjie   
	* @date Sep 17, 2020 9:33:13 AM 
	* @param appId
	* @return  
	*/ 
	String getComponentToken(String appId);
}
