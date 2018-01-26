/**
 * @Company JBINFO
 * @Title: WechatListenerFactory.java
 * @Package org.bana.wechat.common.listener
 * @author Liu Wenjie
 * @date 2018年1月26日 上午10:45:27
 * @version V1.0
 */
package org.bana.wechat.common.listener;

/**
 * @ClassName: WechatListenerFactory
 * @Description: 微信监听器工厂类
 * @author Liu Wenjie
 */
public interface WechatListenerFactory {

	/**
	 * Description: 根据事件获取对应的listener
	 * @author Liu Wenjie
	 * @date 2018年1月26日 上午10:55:10
	 * @param event
	 * @return
	 */
	<T extends WechatEvent> WechatListener<T> getWechatListener(Class<T> cls);
}
