/**
 * @Company 青鸟软通   
 * @Title: SuiteClient.java 
 * @Package org.bana.wechat.qy.suite 
 * @author Liu Wenjie   
 * @date 2015-5-14 上午9:38:31 
 * @version V1.0   
 */
package org.bana.wechat.qy.suite;

import java.util.HashMap;
import java.util.Map;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.token.domain.AccessToken;
import org.bana.wechat.qy.agent.domain.AgentInfo;
import org.bana.wechat.qy.agent.domain.User;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.suite.domain.Agent;
import org.bana.wechat.qy.suite.domain.AuthCorpInfo;
import org.bana.wechat.qy.suite.domain.AuthInfo;
import org.bana.wechat.qy.suite.domain.Department;
import org.bana.wechat.qy.suite.domain.PermanentCode;
import org.bana.wechat.qy.suite.domain.PreAuthCode;
import org.bana.wechat.qy.suite.param.GetAgentInfoParam;
import org.bana.wechat.qy.suite.param.GetAuthInfoParam;
import org.bana.wechat.qy.suite.param.GetCorpTokenParam;
import org.bana.wechat.qy.suite.param.MarkSuiteParam;
import org.bana.wechat.qy.suite.param.PermanentCodeParam;
import org.bana.wechat.qy.suite.param.PreAuthCodeParam;
import org.bana.wechat.qy.suite.param.SetAgentParam;
import org.bana.wechat.qy.suite.param.SetSessionInfoParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @ClassName: SuiteClient
 * @Description: 第三方应用套件的接口说明
 * 
 */
public class SuiteClient {

	private static final Logger LOG = LoggerFactory.getLogger(SuiteClient.class);

	/**
	 * @Description: 获取预授权码
	 * @author Liu Wenjie
	 * @date 2015-5-14 上午10:31:44
	 * @param preParam
	 * @return
	 */
	public static PreAuthCode getPreAuthCode(PreAuthCodeParam preParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(preParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.获取预授权码.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			PreAuthCode bean = (PreAuthCode) JSONObject.toBean(json, PreAuthCode.class);
			LOG.info("转化后的预授权码对象为 " + bean);
			return bean;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/** 
	* @Description: 设置预授权的设置授权配置
	* @author Liu Wenjie   
	* @date 2016-1-8 上午10:50:12 
	* @param setSessionParam  
	*/ 
	public static void setSessionInfo(SetSessionInfoParam setSessionParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(setSessionParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.设置授权配置.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("设置授权信息成功");
			return;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description: 获取企业号的永久授权码
	 * @author Liu Wenjie
	 * @date 2015-5-14 上午11:53:34
	 * @return
	 */
	public static PermanentCode getPermanentCode(PermanentCodeParam codeParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(codeParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.获取企业号的永久授权码.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setRootClass(PermanentCode.class);
		Map<String,Object> mapClass = new HashMap<String,Object>();
		mapClass.put("agent", Agent.class);
		mapClass.put("department", Department.class);
		jsonConfig.setClassMap(mapClass);
		if (WeChatConnection.isSuccess(json)) {
			PermanentCode bean = (PermanentCode) JSONObject.toBean(json, jsonConfig);
			LOG.info("转化后的企业号的永久授权码为 " + bean);
			return bean;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description: 获取企业号的授权信息
	 * @author Liu Wenjie
	 * @date 2015-5-14 下午1:29:10
	 */
	public static Map<String, Object> getAuthInfo(GetAuthInfoParam authInfoParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(authInfoParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.获取企业号的授权信息.getValue(), convertBean);
		// 将结果进行转换
		Map<String, Object> resultMap = new HashMap<String, Object>();
		JSONObject json = JSONObject.fromObject(result);
		if(WeChatConnection.isSuccess(json)){
			// auth_corp_info
			JSONObject corpInfoJson = json.getJSONObject("auth_corp_info");
			resultMap.put("auth_corp_info", JSONObject.toBean(corpInfoJson, AuthCorpInfo.class));
			// auth_info
			JSONObject authInfoJson = json.getJSONObject("auth_info");
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setRootClass(AuthInfo.class);
			Map<String,Object> mapClass = new HashMap<String,Object>();
			mapClass.put("agent", Agent.class);
			mapClass.put("department", Department.class);
			jsonConfig.setClassMap(mapClass);
			resultMap.put("auth_info", JSONObject.toBean(authInfoJson, jsonConfig));
		}else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
		return resultMap;
	}

	/**
	 * @Description: 获取企业号应用
	 * @author Liu Wenjie
	 * @date 2015-5-14 下午2:05:31
	 * @param agentParam
	 * @return
	 */
	public static AgentInfo getAgentInfo(GetAgentInfoParam agentParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(agentParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.获取企业号应用.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		// 将结果进行转换
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			JsonConfig config = new JsonConfig();
			config.setRootClass(AgentInfo.class);
			Map<String,Object> mapClass = new HashMap<String, Object>();
			mapClass.put("user", User.class);
			config.setClassMap(mapClass);
			AgentInfo bean = (AgentInfo) JSONObject.toBean(json, config);
			LOG.info("转化后获取企业号应用为 " + bean);
			return bean;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description: 设置企业号应用
	 * @author Liu Wenjie
	 * @date 2015-5-14 下午2:14:40
	 * @param agentParam
	 * @deprecated @since 0.2.0 被 AgentClient.set() 方法替换
	 */
	@Deprecated
	public static void setAgent(SetAgentParam agentParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(agentParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.设置企业号应用.getValue(), convertBean ,false);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		// 将结果进行转换
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			LOG.info("设置企业应用信息成功 ");
			return;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

	/**
	 * @Description:获取企业号access_token
	 * @author Liu Wenjie
	 * @date 2015-5-14 下午2:16:37
	 * @param getTokenParam
	 * @return
	 */
	public static AccessToken getCorpToken(GetCorpTokenParam getTokenParam) {
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(getTokenParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.获取企业号access_token.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if(WeChatConnection.isSuccess(json)){
			AccessToken accessToken = (AccessToken)JSONObject.toBean(json, AccessToken.class);
			LOG.info("转化后的登录令牌为 " + accessToken);
			return accessToken;
		}else{
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
		
	}
	
	/**
	 * 临时接口，设置应用套件为通讯录应用和普通应用
	 * @param markSuiteParam
	 */
	public static void markAsContactsSuite(MarkSuiteParam markSuiteParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(markSuiteParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.设置应用得属性_测试临时接口.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if(WeChatConnection.isSuccess(json)){
			LOG.info("返回成功。。 ");
			return ;
		}else{
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}

}
