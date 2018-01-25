/**
 * @Company JBINFO
 * @Title: WechatAppManager.java
 * @Package org.bana.wechat.cp.app
 * @author Liu Wenjie
 * @date 2018年1月19日 下午2:55:06
 * @version V1.0
 */
package org.bana.wechat.cp.app;

/**
 * @ClassName: WechatAppManager
 * @Description: 微信企业号的管理接口
 * @author Liu Wenjie
 */
public interface WechatAppManager {

	/**
	 * Description: 获取app的配置信息
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午2:57:02
	 * @param corpId
	 * @param agentId
	 * @return
	 */
	WechatCorpAppConfig getAppConfig(String corpId,String agentId);
	
	/**
	 * Description: 获取套件信息
	 * @author Zhang Zhichao
	 * @date 2018年1月25日 下午4:13:54
	 * @param suiteId
	 * @return
	 */
	WechatCorpSuiteConfig getSuiteConfig(String suiteId);
}
