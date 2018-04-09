/**
 * @Company JBINFO
 * @Title: SubscribeEvent.java
 * @Package org.bana.wechat.cp.callback.event
 * @author Zhang Zhichao
 * @date 2018年4月9日 下午4:10:28
 * @version V1.0
 */
package org.bana.wechat.cp.callback.event;

import org.bana.wechat.common.listener.WechatEvent;
import org.bana.wechat.cp.callback.result.event.CommonEvent;

/**
 * @ClassName: SubscribeEvent
 * @Description: 成员关注事件
 * @author Zhang Zhichao
 */
public class SubscribeEvent implements WechatEvent {
	/**
	 * @Fields subscribeEvent : 成员关注事件消息体
	 */
	private CommonEvent subscribeEvent;

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月9日 下午4:23:27
	 * @param subscribeEvent
	 */
	public SubscribeEvent(CommonEvent subscribeEvent) {
		super();
		this.subscribeEvent = subscribeEvent;
	}

	/**
	 * @Description: 属性 subscribeEvent 的get方法 
	 * @return subscribeEvent
	 */
	public CommonEvent getSubscribeEvent() {
		return subscribeEvent;
	}

	/**
	 * @Description: 属性 subscribeEvent 的set方法 
	 * @param subscribeEvent
	 */
	public void setSubscribeEvent(CommonEvent subscribeEvent) {
		this.subscribeEvent = subscribeEvent;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月9日 下午4:19:30
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubscribeEvent [subscribeEvent=" + subscribeEvent + "]";
	}
	
}
