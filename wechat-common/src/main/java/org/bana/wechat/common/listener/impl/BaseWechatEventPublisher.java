package org.bana.wechat.common.listener.impl;

import org.bana.wechat.common.listener.WechatEvent;
import org.bana.wechat.common.listener.WechatEventPublisher;
import org.bana.wechat.common.listener.WechatListener;
import org.bana.wechat.common.listener.WechatListenerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: BaseWechatEventPublisher
 * @Description: 一个标准的事件发布类
 * @author Liu Wenjie
 */
public class BaseWechatEventPublisher implements WechatEventPublisher,WechatListenerFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(BaseWechatEventPublisher.class);

	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月26日 上午11:30:10
	 * @param event
	 * @see org.bana.wechat.common.listener.WechatEventPublisher#publishEvent(org.bana.wechat.common.listener.WechatEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends WechatEvent> Object publishEvent(T event) {
		WechatListener<T> wechatListener = getWechatListener((Class<T>)event.getClass());
		if(wechatListener == null){
			//没有找到对应的Lister
			LOG.warn("没有找到对应的处理Lister，事件只是控制台打印==="+event.toString());
			return null;
		}
		return wechatListener.onApplicationEvent(event);
	}

	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月26日 上午11:43:21
	 * @param cls
	 * @return
	 * @see org.bana.wechat.common.listener.WechatListenerFactory#getWechatListener(java.lang.Class)
	 */
	@Override
	public <T extends WechatEvent> WechatListener<T> getWechatListener(Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
