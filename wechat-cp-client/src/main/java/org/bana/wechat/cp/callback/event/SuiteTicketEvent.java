/**
 * @Company JBINFO
 * @Title: SuiteTicketEvent.java
 * @Package org.bana.wechat.cp.callback
 * @author Liu Wenjie
 * @date 2018年1月26日 上午10:48:35
 * @version V1.0
 */
package org.bana.wechat.cp.callback.event;

import org.bana.wechat.common.listener.WechatEvent;
import org.bana.wechat.cp.callback.result.ticket.SuiteTicket;

/**
 * @ClassName: SuiteTicketEvent
 * @Description: suiteTicketEvent 事件
 * @author Liu Wenjie
 */
public class SuiteTicketEvent implements WechatEvent {

	/**
	 * @Fields suiteTicket : 微信推送的suiteTicket
	 */
	private SuiteTicket suiteTicket;
	
	public SuiteTicketEvent(SuiteTicket suiteTicket) {
		super();
		this.suiteTicket = suiteTicket;
	}

	public SuiteTicket getSuiteTicket() {
		return suiteTicket;
	}

	public void setSuiteTicket(SuiteTicket suiteTicket) {
		this.suiteTicket = suiteTicket;
	}

	@Override
	public String toString() {
		return "SuiteTicketEvent [suiteTicket=" + suiteTicket + "]";
	}
	
}
