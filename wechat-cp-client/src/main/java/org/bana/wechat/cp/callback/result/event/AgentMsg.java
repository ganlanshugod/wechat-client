/**
 * @Company JBINFO
 * @Title: AgentEvent.java
 * @Package org.bana.wechat.cp.callback.result.event
 * @author Zhang Zhichao
 * @date 2018年4月11日 上午9:47:33
 * @version V1.0
 */
package org.bana.wechat.cp.callback.result.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: AgentEvent
 * @Description: 应用相关的事件消息体：包括
 * 1、成员关注/取消关注；
 * 2、进入应用；
 * 3、菜单事件；
 * @author Zhang Zhichao
 */
@XmlRootElement(name="xml")
public class AgentMsg extends CommonMsg{

	private static final long serialVersionUID = -437767106727056781L;
	
	/**
	 * @Fields eventKey : 事件KEY值
	 */
	private String eventKey;
	/**
	 * @Fields agentID : 企业应用的id，整型
	 */
	private Integer agentID;
	
	/*=======================get,set=========================================*/
	/**
	 * @Description: 属性 eventKey 的get方法 
	 * @return eventKey
	 */
	@XmlElement(name="EventKey")
	public String getEventKey() {
		return eventKey;
	}
	/**
	 * @Description: 属性 eventKey 的set方法 
	 * @param eventKey
	 */
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	/**
	 * @Description: 属性 agentID 的get方法 
	 * @return agentID
	 */
	@XmlElement(name="AgentID")
	public Integer getAgentID() {
		return agentID;
	}
	/**
	 * @Description: 属性 agentID 的set方法 
	 * @param agentID
	 */
	public void setAgentID(Integer agentID) {
		this.agentID = agentID;
	}
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月11日 上午9:53:16
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AgentEvent [eventKey=" + eventKey + ", agentID=" + agentID + "]";
	}
}
