/**
 * @Company JBINFO
 * @Title: AuthChangeEventListener.java
 * @Package org.bana.wechat.cp.callback.listener
 * @author Zhang Zhichao
 * @date 2018年1月31日 上午9:41:43
 * @version V1.0
 */
package org.bana.wechat.cp.callback.listener;

import org.bana.wechat.common.listener.WechatListener;
import org.bana.wechat.cp.callback.event.AuthChangeEvent;

/**
 * @ClassName: AuthChangeEventListener
 * @Description: 第三方应用授权变更事件监听
 * @author Zhang Zhichao
 */
public interface AuthChangeEventListener extends WechatListener<AuthChangeEvent>{

}
