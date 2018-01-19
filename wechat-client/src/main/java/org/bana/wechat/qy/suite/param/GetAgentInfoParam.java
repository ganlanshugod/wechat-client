/**
* @Company 青鸟软通   
* @Title: GetAgentInfoParam.java 
* @Package org.bana.wechat.qy.suite.param 
* @author Liu Wenjie   
* @date 2015-5-14 下午1:42:23 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.param;

import org.bana.wechat.qy.common.WeChatSuiteParam;

/** 
 * @ClassName: GetAgentInfoParam 
 * @Description: 获取企业号应用
 *  
 */
public class GetAgentInfoParam extends WeChatSuiteParam {

	private String suite_id	;//应用套件id
	private String auth_corpid	;//授权方corpid
	private String permanent_code	;//永久授权码，从get_permanent_code接口中获取
	private String agentid	;//授权方应用id
	
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
	 * @Description: 属性 agentid 的get方法 
	 * @return agentid
	 */
	public String getAgentid() {
		return agentid;
	}
	/**
	 * @Description: 属性 agentid 的set方法 
	 * @param agentid 
	 */
	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 下午1:43:23 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "GetAgentInfoParam [suite_id=" + suite_id + ", auth_corpid=" + auth_corpid + ", permanent_code=" + permanent_code + ", agentid=" + agentid + ", suite_access_token="
				+ suite_access_token + "]";
	}
	
}
