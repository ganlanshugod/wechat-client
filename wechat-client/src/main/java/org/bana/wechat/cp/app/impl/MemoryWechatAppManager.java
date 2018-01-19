/**
 * @Company JBINFO
 * @Title: SimpleWechatAppManager.java
 * @Package org.bana.wechat.cp.app
 * @author Liu Wenjie
 * @date 2018年1月19日 下午2:58:29
 * @version V1.0
 */
package org.bana.wechat.cp.app.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.cp.app.WechatAppManager;
import org.bana.wechat.cp.app.WechatCorpAppConfig;

/**
 * @ClassName: MemoryWechatAppManager
 * @Description: App应用管理类
 * @author Liu Wenjie
 */
public class MemoryWechatAppManager implements WechatAppManager {

	private Map<String,WechatCorpAppConfig> appConfigMap = new HashMap<String,WechatCorpAppConfig>();
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午2:58:29
	 * @param corpId
	 * @param agentId
	 * @return
	 * @see org.bana.wechat.cp.app.WechatAppManager#getAppConfig(java.lang.String, java.lang.String)
	 */
	@Override
	public WechatCorpAppConfig getAppConfig(String corpId, String agentId) {
		String key = corpId+"|"+agentId;
		return appConfigMap.get(key);
	}
	
	public void addAppConfig(WechatCorpAppConfig appConfig){
		String corpId = appConfig.getCorpId();
		String agentId = appConfig.getAgentId();
		String key = corpId+"|"+agentId;
		appConfigMap.put(key, appConfig);
	}
}
