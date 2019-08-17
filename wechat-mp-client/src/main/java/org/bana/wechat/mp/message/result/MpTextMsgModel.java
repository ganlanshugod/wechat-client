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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/** 
* @ClassName: MpTextMsgModel 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhangzhichao   
*/
@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement(name="xml")
@XmlType(propOrder = { "toUserName", "fromUserName", "createTime","msgType","content"})  
public class MpTextMsgModel {
	@XmlJavaTypeAdapter (CDataAdapter.class)
    @XmlElement (name = "ToUserName")
	private String toUserName;
	@XmlJavaTypeAdapter (CDataAdapter.class)
    @XmlElement (name = "FromUserName")
	private String fromUserName;
	@XmlElement (name = "CreateTime")
	private Integer createTime;
	@XmlJavaTypeAdapter (CDataAdapter.class)
    @XmlElement (name = "MsgType")
	private String msgType;
	@XmlJavaTypeAdapter (CDataAdapter.class)
    @XmlElement (name = "Content")
	private String content;
	public MpTextMsgModel() {
		Long l = new Date().getTime();
		this.createTime = Integer.parseInt(l/1000+"");
	}
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
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
}
