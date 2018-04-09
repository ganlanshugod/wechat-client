/**
 * @Company JBINFO
 * @Title: UnsubscribeEventListener.java
 * @Package org.bana.wechat.cp.callback.listener
 * @author Zhang Zhichao
 * @date 2018年4月9日 下午4:29:23
 * @version V1.0
 */
package org.bana.wechat.cp.callback.listener;

import org.bana.wechat.common.listener.WechatListener;
import org.bana.wechat.cp.callback.event.UnsubscribeEvent;

/**
 * @ClassName: UnsubscribeEventListener
 * @Description: 成员取消关注事件监听
 * @author Zhang Zhichao
 */
public interface UnsubscribeEventListener extends WechatListener<UnsubscribeEvent>{

}
