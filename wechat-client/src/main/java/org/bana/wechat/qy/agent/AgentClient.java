/**
* @Company 青鸟软通   
* @Title: AgentClient.java 
* @Package org.bana.wechat.qy.agent.domain 
* @author Liu Wenjie   
* @date 2015-5-15 下午5:16:14 
* @version V1.0   
*/ 
package org.bana.wechat.qy.agent;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.qy.agent.domain.AgentInfo;
import org.bana.wechat.qy.agent.param.AgentGetParam;
import org.bana.wechat.qy.agent.param.AgentSetParam;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.Constants;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.common.WeChatParam;
import org.bana.wechat.qy.suite.domain.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: AgentClient 
 * @Description: 企业应用的管理端口
 *  
 */
public class AgentClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(AgentClient.class);

	/** 
	* @Description: 获取企业号内容信息
	* @author Liu Wenjie   
	* @date 2015-5-15 下午5:20:23 
	* @param agentParam
	* @return  
	*/ 
	public static AgentInfo get(AgentGetParam agentParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(agentParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取企业号应用_access.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		// 将结果进行转换
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			AgentInfo bean = (AgentInfo) JSONObject.toBean(json, AgentInfo.class);
			LOG.info("转化后获取企业号应用为 " + bean);
			return bean;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/** 
	* @Description: 设置微信企业号的参数
	* @author Liu Wenjie   
	* @date 2015-5-15 下午5:24:37 
	* @param agentParam  
	*/ 
	public static void set(AgentSetParam agentParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(agentParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.设置企业号应用_access.getValue(), convertBean);
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
	* @Description: 获取应用概况列表说明
	* @author Liu Wenjie   
	* @date 2015-5-15 下午5:27:56 
	* @param listParam
	* @return  
	*/ 
	public static List<Agent> list(WeChatParam listParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(listParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取应用概况列表说明.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		// 将结果进行转换
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			JSONArray jsonArray = json.getJSONArray("agentlist");
			Agent[] array = (Agent[])JSONArray.toArray(jsonArray,Agent.class);
			LOG.info("获取的当前企业号的应用列表为  " + Arrays.toString(array));
			return Arrays.asList(array);
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
