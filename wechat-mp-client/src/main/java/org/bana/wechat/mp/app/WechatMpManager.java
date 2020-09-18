/**
 * @Company JBINFO
 * @Title: WechatMpManager.java
 * @Package org.bana.wechat.mp.common
 * @author Liu Wenjie
 * @date 2018年5月15日 下午5:52:33
 * @version V1.0
 */
package org.bana.wechat.mp.app;

/**
 * @ClassName: WechatMpManager
 * @Description: wechatMp配置信息
 * @author Liu Wenjie
 */
public interface WechatMpManager {

	/**
	 * Description: 获取服务号的配置信息
	 * @author Liu Wenjie
	 * @date 2018年5月15日 下午5:57:47
	 * @param appId
	 * @return
	 */
	WechatMpConfig getAppConfig(String appId);

}
