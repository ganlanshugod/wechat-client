/**
* @Company 青鸟软通   
* @Title: MenuCreateParam.java 
* @Package org.bana.wechat.qy.menu.param 
* @author Liu Wenjie   
* @date 2015-5-15 下午11:30:39 
* @version V1.0   
*/ 
package org.bana.wechat.qy.menu.param;

import java.util.List;

import org.bana.wechat.qy.common.WeChatParam;
import org.bana.wechat.qy.menu.domain.Button;

/** 
 * @ClassName: MenuCreateParam 
 * @Description: 创建子应用的微信菜单的参数
 *  
 */
public class MenuCreateParam extends WeChatParam {

	private String agentid	;//是	企业应用的id，整型。可在应用的设置页面查看
	private List<Button> button;
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
	 * @Description: 属性 button 的get方法 
	 * @return button
	 */
	public List<Button> getButton() {
		return button;
	}
	/**
	 * @Description: 属性 button 的set方法 
	 * @param button 
	 */
	public void setButton(List<Button> button) {
		this.button = button;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-15 下午11:33:05 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "MenuCreateParam [agentid=" + agentid + ", button=" + button + ", access_token=" + access_token + "]";
	}
	
}
