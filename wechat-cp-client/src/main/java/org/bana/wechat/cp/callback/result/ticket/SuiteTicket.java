package org.bana.wechat.cp.callback.result.ticket;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @ClassName: ReceiveSuiteTicket
 * @Description: 微信回调推送tiecket的接口
 * <xml>
        <SuiteId><![CDATA[ww4asffe99e54c0f4c]]></SuiteId>
        <InfoType> <![CDATA[suite_ticket]]></InfoType>
        <TimeStamp>1403610513</TimeStamp>
        <SuiteTicket><![CDATA[asdfasfdasdfasdf]]></SuiteTicket>
    </xml>
 */
@XmlRootElement(name="xml")
public class SuiteTicket implements Serializable{
	
	/** 	
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 7347712658380399433L;
	
	private String suiteId; //第三方应用的SuiteId
	private String infoType; //suite_ticket
	private Long timestamp; //时间戳,到秒
	private String suiteTicket; //Ticket内容，最长为512字节
	
	
	/*==============getter and setter =================*/
	/**
	 * @Description: 属性 suiteTicket 的get方法 
	 * @return suiteTicket
	 */
	@XmlElement(name="SuiteTicket")
	public String getSuiteTicket() {
		return suiteTicket;
	}
	/**
	 * @Description: 属性 suiteTicket 的set方法 
	 * @param suiteTicket 
	 */
	public void setSuiteTicket(String suiteTicket) {
		this.suiteTicket = suiteTicket;
	}
	@XmlElement(name="SuiteId")
	public String getSuiteId() {
		return suiteId;
	}
	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}
	@XmlElement(name="InfoType")
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	@XmlElement(name="TimeStamp")
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ReceiveSuiteTicket [suiteId=" + suiteId + ", infoType=" + infoType + ", timestamp=" + timestamp
				+ ", suiteTicket=" + suiteTicket + "]";
	}
	
}
