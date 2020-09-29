/**
* @Company 全域旅游
* @Title: ViewCallBackEvent.java 
* @Package org.bana.wechat.mp.callback.event 
* @author liuwenjie   
* @date Sep 29, 2020 10:33:29 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.event;

import javax.xml.bind.annotation.XmlElement;

/** 
* @ClassName: ViewCallBackEvent 
* @Description: 点击一个自定义菜单的时候触发
* @author liuwenjie   
*/
public class ViewCallBackEvent extends CallBackEvent{

	
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 7903898575456578601L;
	
	private String eventKey; // 事件KEY值，设置的跳转URL <EventKey><![CDATA[www.qq.com]]></EventKey>


	@XmlElement(name="EventKey")
	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	@Override
	public String toString() {
		return "ViewCallBackEvent [eventKey=" + eventKey + ", toString()=" + super.toString() + "]";
	}
	
}
