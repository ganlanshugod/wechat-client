/**
 * @Company JBINFO
 * @Title: UserCPServiceImpl.java
 * @Package org.bana.wechat.cp.user
 * @author Liu Wenjie
 * @date 2018年1月19日 下午1:15:01
 * @version V1.0
 */
package org.bana.wechat.cp.user.impl;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.common.WechatCpService;
import org.bana.wechat.cp.user.UserCPService;
import org.bana.wechat.cp.user.param.UserCreateParam;
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
}
