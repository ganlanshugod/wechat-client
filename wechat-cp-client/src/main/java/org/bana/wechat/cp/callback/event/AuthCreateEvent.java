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
	private AuthCreate receiveSuitResult;

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月29日 上午10:39:04
	 * @param receiveSuitResult
	 */
	public AuthCreateEvent(AuthCreate receiveSuitResult) {
		super();
		this.receiveSuitResult = receiveSuitResult;
	}

	/**
	 * @Description: 属性 receiveSuitResult 的get方法 
	 * @return receiveSuitResult
	 */
	public AuthCreate getReceiveSuitResult() {
		return receiveSuitResult;
	}

	/**
	 * @Description: 属性 receiveSuitResult 的set方法 
	 * @param receiveSuitResult
	 */
	public void setReceiveSuitResult(AuthCreate receiveSuitResult) {
		this.receiveSuitResult = receiveSuitResult;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月29日 上午10:39:17
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthCreateEvent [receiveSuitResult=" + receiveSuitResult + "]";
	}
	
}
