/**
* @Company 青鸟软通   
* @Title: CovertToOpenIdParam.java 
* @Package org.bana.wechat.qy.user.param 
* @author Liu Wenjie   
* @date 2015-9-16 下午5:00:36 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: CovertToOpenIdParam 
 * @Description: 转化成openId的参数
 *  
 */
public class CovertToOpenIdParam extends WeChatParam {

	private String userid;//	是	企业号内的成员id
	private String agentid;//	否	需要发送红包的应用ID，若只是使用微信支付和企业转账，则无需该参数
	
	
	/**
	 * @Description: 属性 userid 的get方法 
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @Description: 属性 userid 的set方法 
	 * @param userid 
	 */
	public void setUserid(String userid) {
		this.userid = userid;
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
	* @date 2015-9-16 下午5:01:42 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CovertToOpenIdParam [userid=" + userid + ", agentid=" + agentid + ", access_token=" + access_token + "]";
	}
	
}
