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
import org.bana.wechat.cp.callback.event.AuthCancelEvent;
import org.bana.wechat.cp.callback.event.AuthChangeEvent;
import org.bana.wechat.cp.callback.event.AuthCreateEvent;
import org.bana.wechat.cp.callback.event.CreateUpdateUserEvent;
import org.bana.wechat.cp.callback.event.SubscribeEvent;
import org.bana.wechat.cp.callback.event.SuiteTicketEvent;
import org.bana.wechat.cp.callback.event.UnsubscribeEvent;
import org.bana.wechat.cp.callback.listener.AuthCancelEventListener;
import org.bana.wechat.cp.callback.listener.AuthChangeEventListener;
import org.bana.wechat.cp.callback.listener.AuthCreateEventListener;
import org.bana.wechat.cp.callback.listener.CrtUdpUserEventListener;
import org.bana.wechat.cp.callback.listener.SubscribeEventListener;
import org.bana.wechat.cp.callback.listener.SuiteTicketEventListener;
import org.bana.wechat.cp.callback.listener.UnsubscribeEventListener;

/**
 * @ClassName: WechatCpEventPublisher
 * @Description: 微信企业号的事件发布方法
 * @author Liu Wenjie
 */
public class WechatCpEventPublisher extends BaseWechatEventPublisher {

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
		if(cls.isAssignableFrom(AuthCreateEvent.class)){
			return (WechatListener<T>)getAuthCreateEventListener();
		}
		if(cls.isAssignableFrom(AuthChangeEvent.class)){
			return (WechatListener<T>)getAuthChangeEventListener();
		}
		if(cls.isAssignableFrom(AuthCancelEvent.class)){
			return (WechatListener<T>)getAuthCancelEventListener();
		}
		// 成员关注事件
		if(cls.isAssignableFrom(SubscribeEvent.class)){
			return (WechatListener<T>)getSubscribeEventListener();
		}
		// 成员取消关注事件
		if(cls.isAssignableFrom(UnsubscribeEvent.class)){
			return (WechatListener<T>)getUnsubscribeEventListener();
		}
		// 成员新增、修改事件
		if(cls.isAssignableFrom(CreateUpdateUserEvent.class)){
			return (WechatListener<T>)getCrtUdpUserEventListener();
		}
		return null;
	}

	public SuiteTicketEventListener getSuiteTicketEventListener() {
		return null;
	}
	
	public AuthCreateEventListener getAuthCreateEventListener() {
		return null;
	}
	
	public AuthChangeEventListener getAuthChangeEventListener() {
		return null;
	}
	
	public AuthCancelEventListener getAuthCancelEventListener() {
		return null;
	}
	
	public SubscribeEventListener getSubscribeEventListener() {
		return null;
	}
	
	public UnsubscribeEventListener getUnsubscribeEventListener() {
		return null;
	}
	
	public CrtUdpUserEventListener getCrtUdpUserEventListener() {
		return null;
	}

}
