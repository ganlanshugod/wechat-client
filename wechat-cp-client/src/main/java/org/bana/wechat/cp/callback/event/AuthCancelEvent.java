/**
 * @Company JBINFO
 * @Title: AuthCancelEvent.java
 * @Package org.bana.wechat.cp.callback.event
 * @author Zhang Zhichao
 * @date 2018年1月31日 下午1:30:07
 * @version V1.0
 */
package org.bana.wechat.cp.callback.event;

import org.bana.wechat.common.listener.WechatEvent;
import org.bana.wechat.cp.callback.result.auth.AuthChange;

/**
 * @ClassName: AuthCancelEvent
 * @Description: 第三方应用授权取消事件
 * @author Zhang Zhichao
 */
public class AuthCancelEvent implements WechatEvent {

	/**
	 * @Fields authChange : 应用授权取消回调信息
	 */
	private AuthChange authCancel;

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月31日 下午1:31:35
	 * @param authCancel
	 */
	public AuthCancelEvent(AuthChange authCancel) {
		super();
		this.authCancel = authCancel;
	}

	/**
	 * @Description: 属性 authCancel 的get方法 
	 * @return authCancel
	 */
	public AuthChange getAuthCancel() {
		return authCancel;
	}

	/**
	 * @Description: 属性 authCancel 的set方法 
	 * @param authCancel
	 */
	public void setAuthCancel(AuthChange authCancel) {
		this.authCancel = authCancel;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月31日 下午1:31:48
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthCancelEvent [authCancel=" + authCancel + "]";
	}
	
}
