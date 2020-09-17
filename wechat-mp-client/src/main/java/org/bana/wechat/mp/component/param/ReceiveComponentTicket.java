/**
* @Company 全域旅游
* @Title: ReceiveComponentTicket.java 
* @Package org.bana.wechat.mp.component.param 
* @author liuwenjie   
* @date Sep 17, 2020 4:11:58 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.param;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
* @ClassName: ReceiveComponentTicket 
* @Description: 推送ticket的参数对象
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class ReceiveComponentTicket extends ReceiveObj{

	
	private String appId;
	
	private long createTime;
	
	private String componentVerifyTicket;
	
	@XmlElement(name="AppId")
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	@XmlElement(name="CreateTime")
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	@XmlElement(name="ComponentVerifyTicket")
	public String getComponentVerifyTicket() {
		return componentVerifyTicket;
	}
	public void setComponentVerifyTicket(String componentVerifyTicket) {
		this.componentVerifyTicket = componentVerifyTicket;
	}
	
	@Override
	public String toString() {
		return "ReceiveComponentTicket [appId=" + appId + ", createTime=" + createTime + ", componentVerifyTicket="
				+ componentVerifyTicket + ", getInfoType()=" + getInfoType() + "]";
	}
	
}
