/**
 * @Company JBINFO
 * @Title: InmemeryWechatMpManager.java
 * @Package org.bana.wechat.mp.app.impl
 * @author Liu Wenjie
 * @date 2018年5月15日 下午5:58:52
 * @version V1.0
 */
package org.bana.wechat.mp.app.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.mp.app.WechatMpConfig;
import org.bana.wechat.mp.app.WechatMpManager;

/**
 * @ClassName: InmemeryWechatMpManager
 * @Description: 内存的Mp信息管理实现类
 * @author Liu Wenjie
 */
public class InmemeryWechatMpManager implements WechatMpManager{

	private Map<String,WechatMpConfig> appConfigMap = new HashMap<String,WechatMpConfig>();
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午5:59:21
	 * @param appId
	 * @return
	 * @see org.bana.wechat.mp.app.WechatMpManager#getAppConfig(java.lang.String)
	 */
	@Override
	public WechatMpConfig getAppConfig(String appId) {
		return appConfigMap.get(appId);
	}

	/**
	 * Description: 添加配置
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午6:00:44
	 * @param appConfig
	 */
	public void addAppConfig(WechatMpConfig appConfig){
		String appId = appConfig.getAppId();
		appConfigMap.put(appId, appConfig);
	}
}
