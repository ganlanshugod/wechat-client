/**
 * @Company JBINFO
 * @Title: WechatCpEventPublisher.java
 * @Package org.bana.wechat.cp.callback
 * @author Liu Wenjie
 * @date 2018年1月26日 下午5:52:49
 * @version V1.0
 */
package org.bana.wechat.cp.callback;

import org.bana.wechat.common.listener.WechatEvent;
import org.bana.wechat.common.listener.WechatListener;
import org.bana.wechat.common.listener.impl.BaseWechatEventPublisher;
import org.bana.wechat.cp.callback.event.SuiteTicketEvent;
import org.bana.wechat.cp.callback.listener.SuiteTicketEventListener;

/**
 * @ClassName: WechatCpEventPublisher
 * @Description: 微信企业号的事件发布方法
 * @author Liu Wenjie
 */
public class WechatCpEventPublisher extends BaseWechatEventPublisher {

	private SuiteTicketEventListener SuiteTicketEventListener;
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月26日 下午5:32:55
	 * @param cls
	 * @return
	 * @see org.bana.wechat.common.listener.impl.BaseWechatEventPublisher#getWechatListener(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends WechatEvent> WechatListener<T> getWechatListener(Class<T> cls) {
		if(cls.isAssignableFrom(SuiteTicketEvent.class)){
			return (WechatListener<T>)getSuiteTicketEventListener();
		}
		return null;
	}

	public SuiteTicketEventListener getSuiteTicketEventListener() {
		return SuiteTicketEventListener;
	}

	public void setSuiteTicketEventListener(SuiteTicketEventListener suiteTicketEventListener) {
		SuiteTicketEventListener = suiteTicketEventListener;
	}

}
