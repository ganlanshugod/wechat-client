/**
* @Company 全域旅游
* @Title: WechatMpComponentManager.java 
* @Package org.bana.wechat.mp.component 
* @author liuwenjie   
* @date Sep 17, 2020 9:41:06 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.common;

import java.util.Collection;

/** 
* @ClassName: WechatMpComponentManager 
* @Description: 微信公众号第三方服务商的配置管理类
* @author liuwenjie   
*/
public interface WechatMpComponentManager {

	/** 
	* @Description: 根据appId获取对应的第三方服务商配置信息
	* @author liuwenjie   
	* @date Sep 17, 2020 9:50:01 AM 
	* @param appId
	* @return  
	*/ 
	WechatMpComponentConfig getConfig(String appId);
	
	
	/** 
	* @Description:
	* @author liuwenjie   
	* @date 2020年11月30日 上午11:00:31 
	* @return  
	*/ 
	Collection<WechatMpComponentConfig> getAllConfig();
}
