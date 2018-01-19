/**
* @Company 艾美伴行   
* @Title; MessageItem.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 下午12:19:33 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

import org.bana.wechat.qy.kefu.param.Receiver;

/** 
 * @ClassName: MessageItem 
 * @Description: 客服消息
 *  
 */
public class MessageItem {

	private String fromUserName;
	private Long createTime;
	private String msgType;
	private String content;
	private String msgId;
	private Receiver receiver;
	private String mediaId;

	
	public String getFromUserName() {
		return fromUserName;
	}


	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}


	public Long getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	public String getMsgType() {
		return msgType;
	}


	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getMsgId() {
		return msgId;
	}


	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}


	public Receiver getReceiver() {
		return receiver;
	}


	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
	
	public String getMediaId() {
		return mediaId;
	}


	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}


	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-12-16 下午12:40:44 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "MessageItem [fromUserName=" + fromUserName + ", createTime=" + createTime + ", msgType=" + msgType + ", content=" + content + 
				", msgId=" + msgId + ", receiver="+ receiver +  ", mediaId="+ mediaId +  "]";
	}


	
	
}
