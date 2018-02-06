/**
 * @Company JBINFO
 * @Title: UserCPServiceImpl.java
 * @Package org.bana.wechat.cp.user
 * @author Liu Wenjie
 * @date 2018年1月19日 下午1:15:01
 * @version V1.0
 */
package org.bana.wechat.cp.user.impl;

import java.util.List;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.common.WechatCpService;
import org.bana.wechat.cp.user.UserCPService;
import org.bana.wechat.cp.user.domain.User;
import org.bana.wechat.cp.user.param.UserCreateParam;
import org.bana.wechat.cp.user.param.UserListParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: UserCPServiceImpl
 * @Description: 用户的CpService实现类
 * @author Liu Wenjie
 */
public class UserCPServiceImpl extends WechatCpService implements UserCPService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserCPServiceImpl.class);

	/**
	 * @Description:创建成员 的微信接口
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午6:06:34
	 * @param createParam
	 */
	public void create(UserCreateParam createParam) {
		JSONObject result = this.post(Constants.创建成员.getValue(), createParam);
		WechatCpResultHandler.handleResult(result);
		LOG.info("创建成功 " + createParam);
	}
	
	/**
	 * <p>Description: 获取成员列表</p>
	 * @author Zhang Zhichao
	 * @date 2018年2月2日 下午2:31:22
	 * @param userListParam
	 * @return
	 * @see org.bana.wechat.cp.user.UserCPService#findUserList(org.bana.wechat.cp.user.param.UserListParam)
	 */
	@Override
	public List<User> findUserList(UserListParam userListParam) {
		JSONObject result = this.get(Constants.获取部门成员详情.getValue(), userListParam);
		List<User> userList = WechatCpResultHandler.handleResult(result, User.class, "userlist");
		LOG.info("获取成员成功： " + userList.toString());
		return userList;
	}
}
