/**
 * @Company JBINFO
 * @Title: WechatListener.java
 * @Package org.bana.wechat.common
 * @author Liu Wenjie
 * @date 2018年1月25日 下午6:53:33
 * @version V1.0
 */
package org.bana.wechat.common.listener;

/**
 * @ClassName: WechatListener
 * @Description: 微信时间的监听器
 * @author Liu Wenjie
 */
public interface WechatListener<T> {

	/**
	 * Description: 微信监听器
	 * @author Liu Wenjie
	 * @date 2018年1月25日 下午6:58:52
	 * @param event
	 */
	public Object onApplicationEvent(T event);
}
