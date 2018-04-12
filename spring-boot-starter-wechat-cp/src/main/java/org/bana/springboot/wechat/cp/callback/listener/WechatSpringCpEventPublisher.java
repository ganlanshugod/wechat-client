/**
 * @Company JBINFO
 * @Title: WechatCpEventPublisher.java
 * @Package org.bana.wechat.cp.callback
 * @author Liu Wenjie
 * @date 2018年1月26日 下午5:52:49
 * @version V1.0
 */
package org.bana.springboot.wechat.cp.callback.listener;

import org.bana.wechat.cp.callback.WechatCpEventPublisher;
import org.bana.wechat.cp.callback.listener.AuthCancelEventListener;
import org.bana.wechat.cp.callback.listener.AuthChangeEventListener;
import org.bana.wechat.cp.callback.listener.AuthCreateEventListener;
import org.bana.wechat.cp.callback.listener.CrtUdpUserEventListener;
import org.bana.wechat.cp.callback.listener.SubscribeEventListener;
import org.bana.wechat.cp.callback.listener.SuiteTicketEventListener;
import org.bana.wechat.cp.callback.listener.UnsubscribeEventListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: WechatCpEventPublisher
 * @Description: 微信企业号的事件发布方法
 * @author Liu Wenjie
 */
public class WechatSpringCpEventPublisher extends WechatCpEventPublisher {

	@Autowired(required=false)
	private SuiteTicketEventListener suiteTicketEventListener;
	
	@Autowired(required=false)
	private AuthCreateEventListener authCreateEventListener;
	
	@Autowired(required=false)
	private AuthChangeEventListener authChangeEventListener;
	
	@Autowired(required=false)
	private AuthCancelEventListener authCancelEventListener;
	
	@Autowired(required=false)
	private CrtUdpUserEventListener crtUdpUserEventListener;
	
	@Autowired(required=false)
	private SubscribeEventListener subscribeEventListener;
	
	@Autowired(required=false)
	private UnsubscribeEventListener unsubscribeEventListener;
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月26日 下午6:27:55
	 * @return
	 * @see org.bana.wechat.cp.callback.WechatCpEventPublisher#getSuiteTicketEventListener()
	 */
	@Override
	public SuiteTicketEventListener getSuiteTicketEventListener() {
		return suiteTicketEventListener;
	}
	
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月29日 下午6:16:49
	 * @return
	 * @see org.bana.wechat.cp.callback.WechatCpEventPublisher#getAuthCreateEventListener()
	 */
	@Override
	public AuthCreateEventListener getAuthCreateEventListener() {
		return authCreateEventListener;
	}
	
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月31日 上午9:51:12
	 * @return
	 * @see org.bana.wechat.cp.callback.WechatCpEventPublisher#getAuthChangeEventListener()
	 */
	@Override
	public AuthChangeEventListener getAuthChangeEventListener() {
		return authChangeEventListener;
	}
	
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月31日 下午1:41:12
	 * @return
	 * @see org.bana.wechat.cp.callback.WechatCpEventPublisher#getAuthCancelEventListener()
	 */
	@Override
	public AuthCancelEventListener getAuthCancelEventListener() {
		return authCancelEventListener;
	}
	
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月12日 上午9:52:18
	 * @return
	 * @see org.bana.wechat.cp.callback.WechatCpEventPublisher#getCrtUdpUserEventListener()
	 */
	@Override
	public CrtUdpUserEventListener getCrtUdpUserEventListener() {
		return crtUdpUserEventListener;
	}
	
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月12日 上午10:00:34
	 * @return
	 * @see org.bana.wechat.cp.callback.WechatCpEventPublisher#getSubscribeEventListener()
	 */
	@Override
	public SubscribeEventListener getSubscribeEventListener() {
		return subscribeEventListener;
	}
	
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月12日 上午10:03:58
	 * @return
	 * @see org.bana.wechat.cp.callback.WechatCpEventPublisher#getUnsubscribeEventListener()
	 */
	@Override
	public UnsubscribeEventListener getUnsubscribeEventListener() {
		return unsubscribeEventListener;
	}
}
