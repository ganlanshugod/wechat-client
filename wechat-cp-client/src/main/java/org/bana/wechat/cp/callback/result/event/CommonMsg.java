/**
 * @Company JBINFO
 * @Title: CommonEvent.java
 * @Package org.bana.wechat.cp.callback.result.event
 * @author Zhang Zhichao
 * @date 2018年4月9日 下午3:57:15
 * @version V1.0
 */
package org.bana.wechat.cp.callback.result.event;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: CommonMsg
 * @Description: 公共的事件消息体
 * @author Zhang Zhichao
 */
@XmlRootElement(name="xml")
public class CommonMsg implements Serializable {

	private static final long serialVersionUID = -4248231517163933548L;
	
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
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月11日 上午9:54:26
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CommonEvent [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime
				+ ", msgType=" + msgType + ", event=" + event + "]";
	}
	
}
