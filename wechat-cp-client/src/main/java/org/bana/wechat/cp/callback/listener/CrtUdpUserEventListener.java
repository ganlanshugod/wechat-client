/**
 * @Company JBINFO
 * @Title: CrtUdpUserEventListener.java
 * @Package org.bana.wechat.cp.callback.listener
 * @author Zhang Zhichao
 * @date 2018年4月11日 上午10:56:24
 * @version V1.0
 */
package org.bana.wechat.cp.callback.listener;

import org.bana.wechat.common.listener.WechatListener;
import org.bana.wechat.cp.callback.event.CreateUpdateUserEvent;

/**
 * @ClassName: CrtUdpUserEventListener
 * @Description: 新增、修改成员事件监听
 * @author Zhang Zhichao
 */
public interface CrtUdpUserEventListener extends WechatListener<CreateUpdateUserEvent>{

}
