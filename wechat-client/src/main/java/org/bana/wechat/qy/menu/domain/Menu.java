/**
* @Company 青鸟软通   
* @Title: Menu.java 
* @Package org.bana.wechat.qy.menu.domain 
* @author Liu Wenjie   
* @date 2015-5-15 下午11:01:07 
* @version V1.0   
*/ 
package org.bana.wechat.qy.menu.domain;

import java.util.List;

/** 
 * @ClassName: Menu 
 * @Description: 菜单对象
 *  
 */
public class Menu {

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
	* @date 2015-5-15 下午11:17:31 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "Menu [agentid=" + agentid + ", button=" + button + "]";
	}
	
}
