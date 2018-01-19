/**
* @Company 青鸟软通   
* @Title: UserClient.java 
* @Package org.bana.wechat.mp.user 
* @author Liu Wenjie   
* @date 2015-8-20 下午4:28:00 
* @version V1.0   
*/ 
package org.bana.wechat.mp.user;

import java.util.Map;

import net.sf.json.JSONObject;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.user.domain.UserInfo;
import org.bana.wechat.mp.user.param.UserInfoParam;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: UserClient 
 * @Description: 用户管理接口
 *  
 */
public class UserClient {

	private static final Logger LOG = LoggerFactory.getLogger(UserClient.class);
	
	/** 
	* @Description: 获取用户信息
	* @author Liu Wenjie   
	* @date 2015-8-20 下午4:33:15   
	*/ 
	public static UserInfo getUserInfo(UserInfoParam userParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(userParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取用户基本信息.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			UserInfo user = (UserInfo) JSONObject.toBean(json, UserInfo.class);
			LOG.info("转化后的用户结果为 " + user);
			return user;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
}
