/**
* @Company 全域旅游
* @Title: LocationCallBackEvent.java 
* @Package org.bana.wechat.mp.callback 
* @author liuwenjie   
* @date Sep 29, 2020 10:25:10 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: LocationCallBackEvent 
* @Description: LocationCallBackEvent 上报地理位置事件
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class LocationCallBackEvent extends CallBackEvent{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -2935159318510534605L;

	private String latitude; // <Latitude>23.137466</Latitude> 地理位置纬度  	
	private String longitude; //地理位置经度
	private String precision ; //地理位置精度
	
	
	@XmlElement(name="Latitude")
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@XmlElement(name="Longitude")
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@XmlElement(name="Precision")
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	
	@Override
	public String toString() {
		return "LocationCallBackEvent [latitude=" + latitude + ", longitude=" + longitude + ", precision=" + precision
				+ ", toString()=" + super.toString() + "]";
	}
	
}
