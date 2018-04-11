/**
 * @Company JBINFO
 * @Title: CreateUserEvent.java
 * @Package org.bana.wechat.cp.callback.event
 * @author Zhang Zhichao
 * @date 2018年4月11日 上午10:31:41
 * @version V1.0
 */
package org.bana.wechat.cp.callback.event;

import org.bana.wechat.common.listener.WechatEvent;
import org.bana.wechat.cp.callback.result.event.CreateUpdateUser;

/**
 * @ClassName: CreateUserEvent
 * @Description: 新增、修改成员事件
 * @author Zhang Zhichao
 */
public class CreateUpdateUserEvent implements WechatEvent {
	
	/**
	 * @Fields createEvent : 新增、修改成员消息体
	 */
	private CreateUpdateUser createUpdateUser;

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月11日 上午10:53:34
	 * @param createUpdateUser
	 */
	public CreateUpdateUserEvent(CreateUpdateUser createUpdateUser) {
		super();
		this.createUpdateUser = createUpdateUser;
	}

	/**
	 * @Description: 属性 createUpdateUser 的get方法 
	 * @return createUpdateUser
	 */
	public CreateUpdateUser getCreateUpdateUser() {
		return createUpdateUser;
	}

	/**
	 * @Description: 属性 createUpdateUser 的set方法 
	 * @param createUpdateUser
	 */
	public void setCreateUpdateUser(CreateUpdateUser createUpdateUser) {
		this.createUpdateUser = createUpdateUser;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月11日 上午10:53:44
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CreateUpdateUserEvent [createUpdateUser=" + createUpdateUser + "]";
	}

}
