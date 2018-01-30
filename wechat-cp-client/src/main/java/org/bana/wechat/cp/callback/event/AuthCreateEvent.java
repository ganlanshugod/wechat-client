/**
 * @Company JBINFO
 * @Title: AuthCreateEvent.java
 * @Package org.bana.wechat.cp.callback.event
 * @author Zhang Zhichao
 * @date 2018年1月29日 上午10:29:52
 * @version V1.0
 */
package org.bana.wechat.cp.callback.event;

import org.bana.wechat.common.listener.WechatEvent;
import org.bana.wechat.cp.callback.result.auth.AuthCreate;

/**
 * @ClassName: AuthCreateEvent
 * @Description: 第三方应用托管成功事件
 * @author Zhang Zhichao
 */
public class AuthCreateEvent implements WechatEvent {
	
	
	/**
	 * @Fields receiveSuitResult : 应用授权回调信息
	 */
	private AuthCreate authCreate;

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月29日 下午7:33:22
	 * @param authCreate
	 */
	public AuthCreateEvent(AuthCreate authCreate) {
		super();
		this.authCreate = authCreate;
	}

	/**
	 * @Description: 属性 authCreate 的get方法 
	 * @return authCreate
	 */
	public AuthCreate getAuthCreate() {
		return authCreate;
	}

	/**
	 * @Description: 属性 authCreate 的set方法 
	 * @param authCreate
	 */
	public void setAuthCreate(AuthCreate authCreate) {
		this.authCreate = authCreate;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月29日 下午7:33:30
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthCreateEvent [authCreate=" + authCreate + "]";
	}

	
}
