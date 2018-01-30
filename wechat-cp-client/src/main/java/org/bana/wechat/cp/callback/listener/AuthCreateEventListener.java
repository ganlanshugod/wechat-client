/**
 * @Company JBINFO
 * @Title: AuthCreateEventListener.java
 * @Package org.bana.wechat.cp.callback.listener
 * @author Zhang Zhichao
 * @date 2018年1月29日 上午10:43:52
 * @version V1.0
 */
package org.bana.wechat.cp.callback.listener;

import org.bana.wechat.common.listener.WechatListener;
import org.bana.wechat.cp.callback.event.AuthCreateEvent;

/**
 * @ClassName: AuthCreateEventListener
 * @Description: 第三方应用授权成功事件监听
 * @author Zhang Zhichao
 */
public interface AuthCreateEventListener extends WechatListener<AuthCreateEvent> {
	
}
