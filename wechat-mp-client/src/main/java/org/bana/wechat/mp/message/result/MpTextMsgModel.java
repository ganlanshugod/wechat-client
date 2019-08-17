/**
* @Company Elink   
* @Title: MpTextMsgModel.java 
* @Package com.elink.wdt.shop.card.model 
* @author zhangzhichao   
* @date Aug 17, 2019 11:20:08 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.message.result;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: MpTextMsgModel 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhangzhichao   
*/
@XmlRootElement(name="xml")  
public class MpTextMsgModel {
	private static final String PRE = "![CDATA[";
	private static final String END = "]]";
	
	private String toUserName;
	private String fromUserName;
	private Integer createTime;
	private String msgType;
	private String content;
	private boolean transFlag;
	public MpTextMsgModel() {
		Long l = new Date().getTime();
		this.createTime = Integer.parseInt(l/1000+"");
	}
	public void setTransFlag(boolean transFlag) {
		this.transFlag = transFlag;
	}
	
	public String getToUserName() {
		return transFlag?removePrefix(toUserName):toUserName;
	}
	@XmlElement(name="ToUserName")
	public void setToUserName(String toUserName) {
		this.toUserName = addPrefix(toUserName);
	}
	public String getFromUserName() {
		return transFlag?removePrefix(fromUserName):fromUserName;
	}
	@XmlElement(name="FromUserName")
	public void setFromUserName(String fromUserName) {
		this.fromUserName = addPrefix(fromUserName);
	}
	public String getMsgType() {
		return transFlag?removePrefix(msgType):msgType;
	}
	@XmlElement(name="MsgType")
	public void setMsgType(String msgType) {
		this.msgType = addPrefix(msgType);
	}
	public String getContent() {
		return transFlag?removePrefix(content):content;
	}
	@XmlElement(name="Content")
	public void setContent(String content) {
		this.content = addPrefix(content);
	}
	public Integer getCreateTime() {
		return createTime;
	}
	@XmlElement(name="CreateTime")
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**************值处理*******************/
	private String addPrefix(String fieldValue) {
		return PRE + fieldValue + END;
	}
	private String removePrefix(String fieldValue) {
		fieldValue = fieldValue.substring(PRE.length());
		int i = fieldValue.lastIndexOf(END);
		fieldValue = fieldValue.substring(0, i);
		return fieldValue;
	}
}
