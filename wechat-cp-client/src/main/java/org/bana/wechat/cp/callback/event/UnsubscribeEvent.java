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
import org.bana.wechat.cp.callback.result.event.AgentMsg;

/**
 * @ClassName: UnsubscribeEvent
 * @Description: 成员取消关注事件
 * @author Zhang Zhichao
 */
public class UnsubscribeEvent implements WechatEvent {
	/**
	 * @Fields unsubscribeEvent : 成员取消关注事件消息体
	 */
	private AgentMsg unsubscribeMsg;

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月11日 上午10:45:55
	 * @param unsubscribeMsg
	 */
	public UnsubscribeEvent(AgentMsg unsubscribeMsg) {
		super();
		this.unsubscribeMsg = unsubscribeMsg;
	}

	/**
	 * @Description: 属性 unsubscribeMsg 的get方法 
	 * @return unsubscribeMsg
	 */
	public AgentMsg getUnsubscribeMsg() {
		return unsubscribeMsg;
	}

	/**
	 * @Description: 属性 unsubscribeMsg 的set方法 
	 * @param unsubscribeMsg
	 */
	public void setUnsubscribeMsg(AgentMsg unsubscribeMsg) {
		this.unsubscribeMsg = unsubscribeMsg;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月11日 上午10:46:08
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UnsubscribeEvent [unsubscribeMsg=" + unsubscribeMsg + "]";
	}
	
}
