/**
* @Company 青鸟软通   
* @Title: BaseReturnMessage.java 
* @Package org.bana.wechat.qy.message.param 
* @author Liu Wenjie   
* @date 2015-11-1 下午2:22:33 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message.param;

import javax.xml.bind.annotation.XmlElement;

/** 
 * @ClassName: BaseReturnMessage 
 * @Description: 返回消息的基本对象 
 *  
 */
public class BaseReturnMessage {
	
	
	private String toUserName;
	
	private String fromUserName;
	
	private long createTime;
	
	private String msgType;
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
	public long getCreateTime() {
		return createTime;
	}
	/**
	 * @Description: 属性 createTime 的set方法 
	 * @param createTime 
	 */
	public void setCreateTime(long createTime) {
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
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-11-1 下午2:24:30 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "BaseReturnMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime + ", msgType=" + msgType + "]";
	}
	
}
