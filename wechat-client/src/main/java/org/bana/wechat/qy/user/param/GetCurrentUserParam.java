/**
* @Company 青鸟软通   
* @Title: GetCurrentUserParam.java 
* @Package org.bana.wechat.qy.user.param 
* @author Liu Wenjie   
* @date 2015-5-16 下午5:29:13 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: GetCurrentUserParam 
 * @Description: 获取当前用户的参数
 *  
 */
public class GetCurrentUserParam extends WeChatParam{

	private String code;
	private String agentid;
	/**
	 * @Description: 属性 code 的get方法 
	 * @return code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @Description: 属性 code 的set方法 
	 * @param code 
	 */
	public void setCode(String code) {
		this.code = code;
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
	* @date 2015-5-16 下午5:31:10 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "GetCurrentUserParam [code=" + code + ", agentid=" + agentid + ", access_token=" + access_token + "]";
	}
	
	
}