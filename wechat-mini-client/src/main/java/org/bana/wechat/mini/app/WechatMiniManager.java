/**
 * @Company JBINFO
 * @Title: WechatMpManager.java
 * @Package org.bana.wechat.mp.common
 * @author Liu Wenjie
 * @date 2018年5月15日 下午5:52:33
 * @version V1.0
 */
package org.bana.wechat.mini.app;

/**
 * @ClassName: WechatMiniManager
 * @Description: wechatMini配置信息
 * @author Liu Wenjie
 */
public interface WechatMiniManager {

	/**
	 * Description: 获取服务号的配置信息
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午5:57:47
	 * @param appId
	 * @return
	 */
	WechatMiniConfig getAppConfig(String appId);
}
