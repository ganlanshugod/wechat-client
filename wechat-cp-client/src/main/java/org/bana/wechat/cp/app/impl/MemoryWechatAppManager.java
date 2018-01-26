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
import org.bana.wechat.cp.app.WechatCorpSuiteConfig;

/**
 * @ClassName: MemoryWechatAppManager
 * @Description: App应用管理类
 * @author Liu Wenjie
 */
public class MemoryWechatAppManager implements WechatAppManager {

	private Map<String,WechatCorpAppConfig> appConfigMap = new HashMap<String,WechatCorpAppConfig>();
	private Map<String,WechatCorpSuiteConfig> suiteConfigMap = new HashMap<String,WechatCorpSuiteConfig>();
	
	private String suiteTicket;
	
	
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
	
	/**
	 * <p>Description: 获取套件信息</p>
	 * @author Zhang Zhichao
	 * @date 2018年1月25日 下午4:14:43
	 * @param suiteId
	 * @return
	 * @see org.bana.wechat.cp.app.WechatAppManager#getSuiteConfig(java.lang.String)
	 */
	@Override
	public WechatCorpSuiteConfig getSuiteConfig(String suiteId) {
		return suiteConfigMap.get(suiteId);
	}
	
	public void addAppConfig(WechatCorpAppConfig appConfig){
		String corpId = appConfig.getCorpId();
		String agentId = appConfig.getAgentId();
		String key = corpId+"|"+agentId;
		appConfigMap.put(key, appConfig);
	}
	
	public void addSuiteConfig(WechatCorpSuiteConfig suiteConfig){
		suiteConfigMap.put(suiteConfig.getSuiteId(), suiteConfig);
	}
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月26日 下午5:03:29
	 * @param suiteId
	 * @return
	 * @see org.bana.wechat.cp.app.WechatAppManager#getSuiteTicket(java.lang.String)
	 */
	@Override
	public String getSuiteTicket(String suiteId) {
		return suiteTicket;
	}

	public void setSuiteTicket(String suiteTicket) {
		this.suiteTicket = suiteTicket;
	}
	
}
