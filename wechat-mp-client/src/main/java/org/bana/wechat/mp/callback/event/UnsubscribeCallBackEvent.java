/**
* @Company 全域旅游
* @Title: UnsubscribeCallBackEvent.java 
* @Package org.bana.wechat.mp.callback.event 
* @author liuwenjie   
* @date Sep 29, 2020 10:13:49 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.event;

import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: UnsubscribeCallBackEvent 
* @Description: 取消关注的事件
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class UnsubscribeCallBackEvent extends CallBackEvent {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 5905376976850605834L;

	@Override
	public String toString() {
		return "UnsubscribeCallBackEvent [toString()=" + super.toString() + "]";
	}

}
