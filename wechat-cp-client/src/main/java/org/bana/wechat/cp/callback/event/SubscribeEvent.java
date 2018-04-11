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
import org.bana.wechat.cp.callback.result.event.AgentMsg;

/**
 * @ClassName: SubscribeEvent
 * @Description: 成员关注事件
 * @author Zhang Zhichao
 */
public class SubscribeEvent implements WechatEvent {
	/**
	 * @Fields subscribeEvent : 成员关注事件消息体
	 */
	private AgentMsg subscribeMsg;

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月11日 上午10:45:15
	 * @param subscribeMsg
	 */
	public SubscribeEvent(AgentMsg subscribeMsg) {
		super();
		this.subscribeMsg = subscribeMsg;
	}

	/**
	 * @Description: 属性 subscribeMsg 的get方法 
	 * @return subscribeMsg
	 */
	public AgentMsg getSubscribeMsg() {
		return subscribeMsg;
	}

	/**
	 * @Description: 属性 subscribeMsg 的set方法 
	 * @param subscribeMsg
	 */
	public void setSubscribeMsg(AgentMsg subscribeMsg) {
		this.subscribeMsg = subscribeMsg;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月11日 上午10:45:26
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubscribeEvent [subscribeMsg=" + subscribeMsg + "]";
	}

}
