/**
* @Company 全域旅游
* @Title: SubscribeCallBackEvent.java 
* @Package org.bana.wechat.mp.callback.event 
* @author liuwenjie   
* @date Sep 29, 2020 10:11:35 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: SubscribeCallBackEvent 
* @Description: 关注相关的事件，注意要根据eventKey 参数是否为空，来判断是否是扫描二维码进入的
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class SubscribeCallBackEvent extends CallBackEvent {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 3373438229694012394L;
	
	private String eventKey; // 事件KEY值，qrscene_为前缀，后面为二维码的参数值 EventKey><![CDATA[qrscene_123123]]></EventKey> 
	private String ticket; // 二维码的ticket，可用来换取二维码图片 <Ticket><![CDATA[TICKET]]></Ticket>
	
	
	@XmlElement(name="EventKey")
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
	@XmlElement(name="Ticket")
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "SubscribeCallBackEvent [eventKey=" + eventKey + ", ticket=" + ticket + ", toString()="
				+ super.toString() + "]";
	}

	
}
