/**
 * @Company 青鸟软通   
 * @Title: UserClient.java 
 * @Package org.bana.wechat.qy.user 
 * @author Liu Wenjie   
 * @date 2015-5-9 下午9:21:05 
 * @version V1.0   
 */
package org.bana.wechat.qy.user;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.login.domain.WechatLoginUser;
import org.bana.wechat.qy.login.param.LoginInfoParam;
import org.bana.wechat.qy.user.domain.CurrentUserInfo;
import org.bana.wechat.qy.user.domain.OpenIdUser;
import org.bana.wechat.qy.user.domain.SimpleUser;
import org.bana.wechat.qy.user.domain.User;
import org.bana.wechat.qy.user.param.CovertToOpenIdParam;
import org.bana.wechat.qy.user.param.CovertToUserIdParam;
import org.bana.wechat.qy.user.param.GetCurrentUserParam;
import org.bana.wechat.qy.user.param.UserBatchDeleteParam;
import org.bana.wechat.qy.user.param.UserCreateParam;
import org.bana.wechat.qy.user.param.UserDeleteParam;
import org.bana.wechat.qy.user.param.UserGetParam;
import org.bana.wechat.qy.user.param.UserListParam;
import org.bana.wechat.qy.user.param.UserUpdateParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

/**
 * @ClassName: UserClient
 * @Description: 通讯录同步的功能
 * 
 */
public class UserClient {

	private static final Logger LOG = LoggerFactory.getLogger(UserClient.class);

	/**
	 * @Description:创建成员 的微信接口
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午6:06:34
	 * @param createParam
	 */
	public static void create(UserCreateParam createParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(createParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.创建成员.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("创建成功 " + createParam);
			return;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description: 更新成员（ 如果非必须的字段未指定，则不更新该字段之前的设置值）
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午6:22:56
	 * @param updateParam
	 */
	public static void update(UserUpdateParam updateParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(updateParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.更新成员.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("更新成功 " + updateParam);
			return;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description: 删除成员
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午6:34:13
	 * @param deleteParam
	 */
	public static void delete(UserDeleteParam deleteParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(deleteParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.删除成员.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("删除成功 " + deleteParam);
			return;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description: 批量删除的方法
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午7:07:57
	 * @param batchDeleteParam
	 */
	public static void batchDelete(UserBatchDeleteParam batchDeleteParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(batchDeleteParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.批量删除成员.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("删除成功 " + batchDeleteParam);
			return;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description: 根据参数获取成员信息
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午8:39:05
	 * @param getParam
	 */
	public static User get(UserGetParam getParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(getParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取成员.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			User user = (User) JSONObject.toBean(json, User.class);
			LOG.info("转化后的用户结果为 " + user);
			return user;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description: 获取部门成员简单集合对象
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午9:13:38
	 * @return
	 */
	public static List<SimpleUser> simpleList(UserListParam listParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(listParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取部门成员.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			JSONArray jsonArray = json.getJSONArray("userlist");
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setRootClass(SimpleUser.class);
			jsonConfig.setJavaPropertyFilter(new PropertyFilter() {
				public boolean apply(Object source/* 属性的拥有者 */, String name /* 属性名字 */, Object value/* 属性值 */) {
					if (name.equals("department")) {
						return true;
					} else {
						return false;
					}
				}
			});
			SimpleUser[] array = (SimpleUser[]) JSONArray.toArray(jsonArray, jsonConfig);
			LOG.info("转化后的简单成员集合结果为 " + Arrays.toString(array));
			return Arrays.asList(array);
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description: 获取部门成员(详情)
	 * @author Liu Wenjie
	 * @date 2015-5-11 下午9:24:42
	 * @param listParam
	 * @return
	 */
	public static List<User> list(UserListParam listParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(listParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取部门成员详情.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			JSONArray jsonArray = json.getJSONArray("userlist");
			User[] array = (User[]) JSONArray.toArray(jsonArray, User.class);
			LOG.info("转化后的成员详情集合结果为 " + Arrays.toString(array));
			return Arrays.asList(array);
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/**
	* @Description: 获取当前用户信息
	* @author Liu Wenjie   
	* @date 2015-5-16 下午5:28:34 
	* @return
	 */
	public static CurrentUserInfo getUserInfo(GetCurrentUserParam userParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(userParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.根据code获取成员信息.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		
		if (WeChatConnection.isSuccess(json)) {
			CurrentUserInfo bean = new CurrentUserInfo();
			if(json.has("UserId")){//已关注的用户，可以获得UserId
				String userId = json.getString("UserId");
				bean.setUserId(userId);
			}
			if(json.has("OpenId")){//未关注的用户可以获得OpenId
				String openId = json.getString("OpenId");
				bean.setOpenId(openId);
			}
			String deviceId = json.getString("DeviceId");
			bean.setDeviceId(deviceId);
			LOG.info("转化后的当前用户为 " + bean);
			return bean;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/** 
	* @Description: UserId转化成openId的方法
	* @author Liu Wenjie   
	* @date 2015-9-16 下午5:02:21 
	* @param param
	* @return  
	*/ 
	public static OpenIdUser convertToOpenIdUser(CovertToOpenIdParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.userid转换成openid接口.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			OpenIdUser bean = (OpenIdUser)JSONObject.toBean(json, OpenIdUser.class);
			LOG.info("转化后的当前用户为 " + bean);
			return bean;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/** 
	* @Description:openId转化成UserId的方法
	* @author Liu Wenjie   
	* @date 2015-9-16 下午5:08:49 
	* @param param
	* @return  
	*/ 
	public static String convertToUserId(CovertToUserIdParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.openid转换成userid接口.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			String userId = json.getString("userid");
			LOG.info("转化后的当前用户为 " + userId);
			return userId;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	/** 
	* @Description: 获取微信单点登录用户信息
	* @author Richard Core   
	* @date 2016-3-22 上午10:17:14 
	* @param param
	* @return  
	*/ 
	public static WechatLoginUser getLoginInfo(LoginInfoParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.微信单点登录获取用户登录信息.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			WechatLoginUser loginUser = (WechatLoginUser) JSONObject.toBean(json, WechatLoginUser.class);
			LOG.info("转化后的登录用户为 " + loginUser);
			return loginUser;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

}
