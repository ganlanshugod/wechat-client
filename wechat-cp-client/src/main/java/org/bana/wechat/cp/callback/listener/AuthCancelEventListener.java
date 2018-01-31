/**
 * @Company JBINFO
 * @Title: AuthCancelEventListener.java
 * @Package org.bana.wechat.cp.callback.listener
 * @author Zhang Zhichao
 * @date 2018年1月31日 下午1:34:08
 * @version V1.0
 */
package org.bana.wechat.cp.callback.listener;

import org.bana.wechat.common.listener.WechatListener;
import org.bana.wechat.cp.callback.event.AuthCancelEvent;
import org.bana.wechat.cp.callback.event.AuthChangeEvent;

/**
 * @ClassName: AuthCancelEventListener
 * @Description: 第三方应用授权取消事件监听
 * @author Zhang Zhichao
 */
public interface AuthCancelEventListener extends WechatListener<AuthCancelEvent>{

}
