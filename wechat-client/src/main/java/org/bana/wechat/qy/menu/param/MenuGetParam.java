/**
* @Company 青鸟软通   
* @Title: MenuGetParam.java 
* @Package org.bana.wechat.qy.menu.param 
* @author Liu Wenjie   
* @date 2015-5-15 下午10:59:19 
* @version V1.0   
*/ 
package org.bana.wechat.qy.menu.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: MenuGetParam 
 * @Description: 获取菜单列表的参数
 *  
 */
public class MenuGetParam extends WeChatParam{

	private String agentid;//企业应用的id，整型。可在应用的设置页面查看

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
	* @date 2015-5-15 下午11:00:38 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "MenuGetParam [agentid=" + agentid + ", access_token=" + access_token + "]";
	}
	
}
