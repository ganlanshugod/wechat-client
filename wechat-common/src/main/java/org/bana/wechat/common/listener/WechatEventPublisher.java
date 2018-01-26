/**
 * @Company JBINFO
 * @Title: WechatEventPublisher.java
 * @Package org.bana.wechat.common.listener
 * @author Liu Wenjie
 * @date 2018年1月25日 下午7:05:56
 * @version V1.0
 */
package org.bana.wechat.common.listener;

/**
 * @ClassName: WechatEventPublisher
 * @Description: 微信的事件触发器
 * @author Liu Wenjie
 */
public interface WechatEventPublisher {

	/**
	 * Description: 触发一个事件
	 * @author Liu Wenjie
	 * @date 2018年1月25日 下午7:06:42
	 * @param event
	 */
	<T extends WechatEvent> Object publishEvent(T event);
}
