/**
 * @Company JBINFO
 * @Title: AgentEvent.java
 * @Package org.bana.wechat.cp.callback.result.event
 * @author Zhang Zhichao
 * @date 2018年4月11日 上午9:47:33
 * @version V1.0
 */
package org.bana.wechat.cp.callback.result.event;

import java.io.Serializable;

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
public class AgentMsg implements Serializable{

	private static final long serialVersionUID = -437767106727056781L;
	
	/**
	 * @Fields toUserName : 企业微信CorpID
	 */
	private String toUserName;
	/**
	 * @Fields fromUserName : 成员UserID
	 */
	private String fromUserName;
	/**
	 * @Fields createTime : 消息创建时间（整型）
	 */
	private Integer createTime;
	/**
	 * @Fields msgType : 消息类型
	 */
	private String msgType;
	/**
	 * @Fields event : 事件类型
	 */
	private String event;
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
	 * @Description: 属性 toUserName 的get方法 
	 * @return toUserName
	 */
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return toUserName;
	}
	/**
	 * @Description: 属性 toUserName 的set方法 
	 * @param toUserName
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	/**
	 * @Description: 属性 fromUserName 的get方法 
	 * @return fromUserName
	 */
	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}
	/**
	 * @Description: 属性 fromUserName 的set方法 
	 * @param fromUserName
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	/**
	 * @Description: 属性 createTime 的get方法 
	 * @return createTime
	 */
	@XmlElement(name="CreateTime")
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * @Description: 属性 createTime 的set方法 
	 * @param createTime
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * @Description: 属性 msgType 的get方法 
	 * @return msgType
	 */
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return msgType;
	}
	/**
	 * @Description: 属性 msgType 的set方法 
	 * @param msgType
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	/**
	 * @Description: 属性 event 的get方法 
	 * @return event
	 */
	@XmlElement(name="Event")
	public String getEvent() {
		return event;
	}
	/**
	 * @Description: 属性 event 的set方法 
	 * @param event
	 */
	public void setEvent(String event) {
		this.event = event;
	}
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
	 * @date 2018年4月12日 上午9:31:09
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AgentMsg [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime
				+ ", msgType=" + msgType + ", event=" + event + ", eventKey=" + eventKey + ", agentID=" + agentID + "]";
	}
}
