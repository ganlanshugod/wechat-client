/**
* @Company 全域旅游
* @Title: InMermeryWechatMp.java 
* @Package org.bana.wechat.mp.component.common 
* @author liuwenjie   
* @date Sep 17, 2020 10:27:00 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.component.common.WechatMpComponentConfig;
import org.bana.wechat.mp.component.common.WechatMpComponentManager;

/** 
* @ClassName: InMermeryWechatMp 
* @Description: 内存方式实现的微信第三方应用配置管理方法
* @author liuwenjie   
*/
public class InMermeryWechatMpComponentManager implements WechatMpComponentManager {

	private Map<String,WechatMpComponentConfig> cacheMap = new HashMap<>();
	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 17, 2020 10:27:40 AM 
	* @param appId
	* @return 
	* @see org.bana.wechat.mp.component.common.WechatMpComponentManager#getConfig(java.lang.String) 
	*/ 
	@Override
	public WechatMpComponentConfig getConfig(String appId) {
		WechatMpComponentConfig wechatMpComponentConfig = cacheMap.get(appId);
		if(wechatMpComponentConfig == null) {
			throw new WeChatMpException(WeChatMpException.MP_COMP_ERROR, "没有获取到appId："+ appId + " 对应的第三方配置信息");
		}
		return wechatMpComponentConfig;
	}
	
	public void add(WechatMpComponentConfig config) {
		if(config != null) {
			cacheMap.put(config.getComponentAppid(), config);
		}
	}

}
