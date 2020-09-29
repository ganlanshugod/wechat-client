/**
* @Company 全域旅游
* @Title: ScanCallBackEvent.java 
* @Package org.bana.wechat.mp.callback.event 
* @author liuwenjie   
* @date Sep 29, 2020 10:16:52 AM 
* @version V1.0   
*/
package org.bana.wechat.mp.callback.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: ScanCallBackEvent
 * @Description: 如果用户扫描带参数的关注二维码时，已经关注了公众号，则会触发scan事件
 * @author liuwenjie
 */
@XmlRootElement(name = "xml")
public class ScanCallBackEvent extends CallBackEvent {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 2603742482255151649L;

	private String eventKey; // 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
	private String ticket; // 二维码的ticket，可用来换取二维码图片<Ticket><![CDATA[TICKET]]></Ticket>

	@XmlElement(name = "EventKey")
	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	@XmlElement(name = "Ticket")
	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "ScanCallBackEvent [eventKey=" + eventKey + ", ticket=" + ticket + ", toString()=" + super.toString()
				+ "]";
	}

}
