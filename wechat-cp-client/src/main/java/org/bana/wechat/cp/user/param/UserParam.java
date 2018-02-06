/**
 * @Company JBINFO
 * @Title: UserParam.java
 * @Package org.bana.wechat.cp.user.param
 * @author Zhang Zhichao
 * @date 2018年2月6日 下午1:26:28
 * @version V1.0
 */
package org.bana.wechat.cp.user.param;

import org.bana.wechat.cp.common.WeChatCPParam;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: UserParam
 * @Description: 获取单个成员参数
 * @author Zhang Zhichao
 */
public class UserParam extends WeChatCPParam {

	private static final long serialVersionUID = -1509800118200444411L;
	
	@JSONField(name="userid")
	private String userId;//成员UserID。

	/**
	 * @Description: 属性 userId 的get方法 
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @Description: 属性 userId 的set方法 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年2月6日 下午1:27:36
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserParam [userId=" + userId + "]";
	}
	
}
