/**
* @Company 青鸟软通   
* @Title: CallBackResult.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-6-11 上午10:58:28 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @ClassName: CallBackResult 
 * @Description: 微信回调的返回值结果对象
 * <xml><ToUserName><![CDATA[wxc2a104d974df2b69]]></ToUserName>
<FromUserName><![CDATA[QY46_gxcj_1433834399033]]></FromUserName>
<CreateTime>1433991208</CreateTime>
<MsgType><![CDATA[event]]></MsgType>
<AgentID>3</AgentID>
<Event><![CDATA[enter_agent]]></Event>
<EventKey><![CDATA[]]></EventKey>
</xml>
 *  
 */
@XmlRootElement(name="xml")
public class CallBackResult implements Serializable{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 2567559801968336408L;
	
	private String toUserName;
	private String fromUserName;
	private Long createTime;
	private String msgType;
	private String agentId;
	private String event;
	private String eventKey;
	private String content;
	private Long msgId;
	
	private String mediaId;
	
	private String title;
	private String description;
	private String url;
	private String picUrl;

	/**
	 * @Description: 属性 title 的get方法 
	 * @return title
	 */
	@XmlElement(name="Title")
	public String getTitle() {
		return title;
	}
	/**
	 * @Description: 属性 title 的set方法 
	 * @param title 
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @Description: 属性 description 的get方法 
	 * @return description
	 */
	@XmlElement(name="Description")
	public String getDescription() {
		return description;
	}
	/**
	 * @Description: 属性 description 的set方法 
	 * @param description 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @Description: 属性 url 的get方法 
	 * @return url
	 */
	@XmlElement(name="Url")
	public String getUrl() {
		return url;
	}
	/**
	 * @Description: 属性 url 的set方法 
	 * @param url 
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @Description: 属性 picUrl 的get方法 
	 * @return picUrl
	 */
	@XmlElement(name="PicUrl")
	public String getPicUrl() {
		return picUrl;
	}
	/**
	 * @Description: 属性 picUrl 的set方法 
	 * @param picUrl 
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
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
	public Long getCreateTime() {
		return createTime;
	}
	/**
	 * @Description: 属性 createTime 的set方法 
	 * @param createTime 
	 */
	public void setCreateTime(Long createTime) {
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
	 * @Description: 属性 agentId 的get方法 
	 * @return agentId
	 */
	@XmlElement(name="AgentID")
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
	 * @Description: 属性 content 的get方法 
	 * @return content
	 */
	@XmlElement(name="Content")
	public String getContent() {
		return content;
	}
	/**
	 * @Description: 属性 content 的set方法 
	 * @param content 
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @Description: 属性 msgId 的get方法 
	 * @return msgId
	 */
	@XmlElement(name="MsgId")
	public Long getMsgId() {
		return msgId;
	}
	/**
	 * @Description: 属性 msgId 的set方法 
	 * @param msgId 
	 */
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	
	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-10-9 下午2:08:10 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CallBackResult [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime + ", msgType=" + msgType + ", agentId=" + agentId
				+ ", event=" + event + ", eventKey=" + eventKey + ", content=" + content + ", msgId=" + msgId +",mediaId=" + mediaId + "]";
	}
		

	
}
