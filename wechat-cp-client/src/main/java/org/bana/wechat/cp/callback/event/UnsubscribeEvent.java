/**
 * @Company JBINFO
 * @Title: UnsubscribeEvent.java
 * @Package org.bana.wechat.cp.callback.event
 * @author Zhang Zhichao
 * @date 2018年4月9日 下午4:20:10
 * @version V1.0
 */
package org.bana.wechat.cp.callback.event;

import org.bana.wechat.common.listener.WechatEvent;
import org.bana.wechat.cp.callback.result.event.CommonEvent;

/**
 * @ClassName: UnsubscribeEvent
 * @Description: 成员取消关注事件
 * @author Zhang Zhichao
 */
public class UnsubscribeEvent implements WechatEvent {
	/**
	 * @Fields unsubscribeEvent : 成员取消关注事件消息体
	 */
	private CommonEvent unsubscribeEvent;
	
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月9日 下午4:23:40
	 * @param unsubscribeEvent
	 */
	public UnsubscribeEvent(CommonEvent unsubscribeEvent) {
		super();
		this.unsubscribeEvent = unsubscribeEvent;
	}

	/**
	 * @Description: 属性 unsubscribeEvent 的get方法 
	 * @return unsubscribeEvent
	 */
	public CommonEvent getUnsubscribeEvent() {
		return unsubscribeEvent;
	}

	/**
	 * @Description: 属性 unsubscribeEvent 的set方法 
	 * @param unsubscribeEvent
	 */
	public void setUnsubscribeEvent(CommonEvent unsubscribeEvent) {
		this.unsubscribeEvent = unsubscribeEvent;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月9日 下午4:22:17
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UnsubscribeEvent [unsubscribeEvent=" + unsubscribeEvent + "]";
	}
	
}
