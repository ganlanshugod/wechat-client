/**
 * @Company JBINFO
 * @Title: SubscribeEventListener.java
 * @Package org.bana.wechat.cp.callback.listener
 * @author Zhang Zhichao
 * @date 2018年4月9日 下午4:28:11
 * @version V1.0
 */
package org.bana.wechat.cp.callback.listener;

import org.bana.wechat.common.listener.WechatListener;
import org.bana.wechat.cp.callback.event.SubscribeEvent;

/**
 * @ClassName: SubscribeEventListener
 * @Description: 成员关注事件监听
 * @author Zhang Zhichao
 */
public interface SubscribeEventListener extends WechatListener<SubscribeEvent>{

}
