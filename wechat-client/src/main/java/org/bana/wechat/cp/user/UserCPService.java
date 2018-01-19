/**
 * @Company JBINFO
 * @Title: UserService.java
 * @Package org.bana.wechat.qy.user
 * @author Liu Wenjie
 * @date 2018年1月19日 下午12:58:57
 * @version V1.0
 */
package org.bana.wechat.cp.user;

import org.bana.wechat.cp.user.param.UserCreateParam;

/**
 * @ClassName: UserService
 * @Description: 微信企业号的UserService方法
 * @author Liu Wenjie
 */
public interface UserCPService {
	
	/**
	 * @Description:创建成员 的微信接口
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午6:06:34
	 * @param createParam
	 */
	public void create(UserCreateParam createParam);
}
