/**
 * @Company JBINFO
 * @Title: TestSuiteTicketEventListener.java
 * @Package org.bana.springboot.wechat.cp.callback.listner
 * @author Liu Wenjie
 * @date 2018年1月26日 下午6:24:26
 * @version V1.0
 */
package org.bana.springboot.wechat.cp.callback.listner;

import org.bana.wechat.cp.callback.event.SuiteTicketEvent;
import org.bana.wechat.cp.callback.listener.SuiteTicketEventListener;

/**
 * @ClassName: TestSuiteTicketEventListener
 * @Description: 测试的一个事件监听器
 * @author Liu Wenjie
 */
public class TestSuiteTicketEventListener implements SuiteTicketEventListener {

	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月26日 下午6:24:26
	 * @param event
	 * @return
	 * @see org.bana.wechat.common.listener.WechatListener#onApplicationEvent(java.lang.Object)
	 */
	@Override
	public Object onApplicationEvent(SuiteTicketEvent event) {
		System.out.println("==出发了SuitTicket时间" + event.getSuiteTicket());
		return null;
	}

}
