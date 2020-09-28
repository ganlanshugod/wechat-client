/**
* @Company 全域旅游
* @Title: LocationCallBackMessage.java 
* @Package org.bana.wechat.mp.callback.msg 
* @author liuwenjie   
* @date Sep 28, 2020 12:22:39 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: LocationCallBackMessage 
* @Description: 
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class LocationCallBackMessage extends CallBackMessage {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -2592576888156342039L;
	
	
	private String location_X; //<Location_X>23.134521</Location_X>
	private String location_Y; // <Location_Y>113.358803</Location_Y>
	private String scale; //<Scale>20</Scale>
	private String label ; //<Label><![CDATA[位置信息]]></Label>
	
	@XmlElement(name="Location_X")
	public String getLocation_X() {
		return location_X;
	}
	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}
	
	@XmlElement(name="Location_Y")
	public String getLocation_Y() {
		return location_Y;
	}
	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}
	
	@XmlElement(name="Scale")
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	
	@XmlElement(name="Label")
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return "LocationCallBackMessage [location_X=" + location_X + ", location_Y=" + location_Y + ", scale=" + scale
				+ ", label=" + label + ", getAppId()=" + getAppId() + ", getOpenId()=" + getOpenId()
				+ ", getCreateTime()=" + getCreateTime() + ", getMsgId()=" + getMsgId() + ", getMsgType()="
				+ getMsgType() + "]";
	}
	
}
