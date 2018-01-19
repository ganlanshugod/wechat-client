/**
* @Company 青鸟软通   
* @Title: SetAgentParam.java 
* @Package org.bana.wechat.qy.suite.param 
* @author Liu Wenjie   
* @date 2015-5-14 下午2:08:13 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.param;

import org.bana.wechat.qy.common.WeChatSuiteParam;

/** 
 * @ClassName: SetAgentParam 
 * @Description: 设置企业号应用
 *  
 */
@Deprecated
public class SetAgentParam extends WeChatSuiteParam{

	private String suite_id	;//应用套件id
	private String auth_corpid	;//授权方corpid
	private String permanent_code	;//永久授权码，从get_permanent_code接口中获取
	private AgentParam agent;
	/**
	 * @Description: 属性 suite_id 的get方法 
	 * @return suite_id
	 */
	public String getSuite_id() {
		return suite_id;
	}
	/**
	 * @Description: 属性 suite_id 的set方法 
	 * @param suite_id 
	 */
	public void setSuite_id(String suite_id) {
		this.suite_id = suite_id;
	}
	/**
	 * @Description: 属性 auth_corpid 的get方法 
	 * @return auth_corpid
	 */
	public String getAuth_corpid() {
		return auth_corpid;
	}
	/**
	 * @Description: 属性 auth_corpid 的set方法 
	 * @param auth_corpid 
	 */
	public void setAuth_corpid(String auth_corpid) {
		this.auth_corpid = auth_corpid;
	}
	/**
	 * @Description: 属性 permanent_code 的get方法 
	 * @return permanent_code
	 */
	public String getPermanent_code() {
		return permanent_code;
	}
	/**
	 * @Description: 属性 permanent_code 的set方法 
	 * @param permanent_code 
	 */
	public void setPermanent_code(String permanent_code) {
		this.permanent_code = permanent_code;
	}
	/**
	 * @Description: 属性 agent 的get方法 
	 * @return agent
	 */
	public AgentParam getAgent() {
		return agent;
	}
	/**
	 * @Description: 属性 agent 的set方法 
	 * @param agent 
	 */
	public void setAgent(AgentParam agent) {
		this.agent = agent;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 下午2:12:39 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "SetAgentParam [suite_id=" + suite_id + ", auth_corpid=" + auth_corpid + ", permanent_code=" + permanent_code + ", agent=" + agent + ", suite_access_token="
				+ suite_access_token + "]";
	}
	
}
