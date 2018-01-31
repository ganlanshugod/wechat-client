/**
 * @Company JBINFO
 * @Title: AuthChangeEvent.java
 * @Package org.bana.wechat.cp.callback.event
 * @author Zhang Zhichao
 * @date 2018年1月31日 上午9:38:38
 * @version V1.0
 */
package org.bana.wechat.cp.callback.event;

import org.bana.wechat.common.listener.WechatEvent;
import org.bana.wechat.cp.callback.result.auth.AuthChange;

/**
 * @ClassName: AuthChangeEvent
 * @Description: 第三方应用授权变更事件
 * @author Zhang Zhichao
 */
public class AuthChangeEvent implements WechatEvent {
	
	/**
	 * @Fields authChange : 应用授权变更回调信息
	 */
	private AuthChange authChange;
	
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月31日 上午9:49:13
	 * @param authChange
	 */
	public AuthChangeEvent(AuthChange authChange) {
		super();
		this.authChange = authChange;
	}

	/**
	 * @Description: 属性 authChange 的get方法 
	 * @return authChange
	 */
	public AuthChange getAuthChange() {
		return authChange;
	}

	/**
	 * @Description: 属性 authChange 的set方法 
	 * @param authChange
	 */
	public void setAuthChange(AuthChange authChange) {
		this.authChange = authChange;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月31日 上午9:39:44
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthChangeEvent [authChange=" + authChange + "]";
	}
	
}
