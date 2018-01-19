/**
* @Company 青鸟软通   
* @Title: AgentGetParam.java 
* @Package org.bana.wechat.qy.agent.param 
* @author Liu Wenjie   
* @date 2015-5-15 下午5:18:56 
* @version V1.0   
*/ 
package org.bana.wechat.qy.agent.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: AgentGetParam 
 * @Description: 获取微信企业应用的信息
 *  
 */
public class AgentGetParam extends WeChatParam {

	private String agentId;

	/**
	 * @Description: 属性 agentId 的get方法 
	 * @return agentId
	 */
	public String getAgentId() {
		return agentId;
	}

	/**
	 * @Description: 属性 agentId 的set方法 
	 * @param agentId 
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-15 下午5:20:07 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AgentGetParam [agentId=" + agentId + ", access_token=" + access_token + "]";
	}
	
	
}
