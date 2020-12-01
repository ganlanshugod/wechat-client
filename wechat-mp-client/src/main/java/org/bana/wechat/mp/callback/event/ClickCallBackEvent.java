/**
* @Company 全域旅游
* @Title: ClickCallBackEvent.java 
* @Package org.bana.wechat.mp.callback 
* @author liuwenjie   
* @date Sep 29, 2020 10:29:16 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: ClickCallBackEvent 
* @Description: 点击回调事件
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class ClickCallBackEvent extends CallBackEvent {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -4001662748545228345L;
	
	
	private String eventKey; // 事件KEY值，与自定义菜单接口中KEY值对应 <EventKey><![CDATA[EVENTKEY]]></EventKey>


	@XmlElement(name="EventKey")
	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}


	@Override
	public String toString() {
		return "ClickCallBackEvent [eventKey=" + eventKey + ", toString()=" + super.toString() + "]";
	}
	
}
