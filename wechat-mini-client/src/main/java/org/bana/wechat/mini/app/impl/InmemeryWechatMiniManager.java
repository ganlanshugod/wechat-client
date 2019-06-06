/**
 * @Company JBINFO
 * @Title: InmemeryWechatMpManager.java
 * @Package org.bana.wechat.mp.app.impl
 * @author Liu Wenjie
 * @date 2018年5月15日 下午5:58:52
 * @version V1.0
 */
package org.bana.wechat.mini.app.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.mini.app.WechatMiniConfig;
import org.bana.wechat.mini.app.WechatMiniManager;


/**
 * @ClassName: InmemeryWechatMiniManager
 * @Description: 内存的Mini信息管理实现类
 * @author Liu Wenjie
 */
public class InmemeryWechatMiniManager implements WechatMiniManager{

	private Map<String,WechatMiniConfig> appConfigMap = new HashMap<String,WechatMiniConfig>();
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午5:59:21
	 * @param appId
	 * @return
	 * @see org.bana.wechat.mp.app.WechatMiniManager#getAppConfig(java.lang.String)
	 */
	@Override
	public WechatMiniConfig getAppConfig(String appId) {
		return appConfigMap.get(appId);
	}

	/**
	 * Description: 添加配置
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午6:00:44
	 * @param appConfig
	 */
	public void addAppConfig(WechatMiniConfig appConfig){
		String appId = appConfig.getAppId();
		appConfigMap.put(appId, appConfig);
	}
}
