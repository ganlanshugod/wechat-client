/**
 * @Company JBINFO
 * @Title: UserService.java
 * @Package org.bana.wechat.qy.user
 * @author Liu Wenjie
 * @date 2018年1月19日 下午12:58:57
 * @version V1.0
 */
package org.bana.wechat.cp.user;

import java.util.List;

import org.bana.wechat.cp.user.domain.User;
import org.bana.wechat.cp.user.param.UserCreateParam;
import org.bana.wechat.cp.user.param.UserListParam;
import org.bana.wechat.cp.user.param.UserParam;

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
	
	/**
	 * Description: 获取单个成员
	 * @author Zhang Zhichao
	 * @date 2018年2月6日 下午1:28:15
	 * @param userParam
	 * @return
	 */
	public User findUser(UserParam userParam);
	
	/**
	 * Description:获取成员列表
	 * @author Zhang Zhichao
	 * @date 2018年2月2日 下午2:30:40
	 * @param userListParam
	 * @return
	 */
	public List<User> findUserList(UserListParam userListParam);
}
