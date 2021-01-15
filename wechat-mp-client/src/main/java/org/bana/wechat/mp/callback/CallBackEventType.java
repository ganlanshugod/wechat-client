/**
* @Company 全域旅游
* @Title: CallBackEventType.java 
* @Package org.bana.wechat.mp.callback 
* @author liuwenjie   
* @date Sep 29, 2020 10:39:25 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback;

/** 
* @ClassName: CallBackEventType 
* @Description: 回调方法中的事件类型
* @author liuwenjie   
*/
public enum CallBackEventType {

	关注_含扫码("subscribe"),
	取消关注("unsubscribe"),
	扫码事件_已关注扫码("SCAN"),
	上报位置("LOCATION"),
	点击自定义菜单事件("CLICK"),
	点击自定义的连接菜单("VIEW"),
	模板小时是否送达成功("TEMPLATESENDJOBFINISH"),
	点击小程序连接("view_miniprogram"),
	不支持的通知("unknow")
	;
	
	
	private String value;
	private CallBackEventType(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
	public static CallBackEventType instance(String value) {
		for (CallBackEventType type : values()) {
			if(type.value.equalsIgnoreCase(value)) {
				return type;
			}
		}
		return 不支持的通知;
	}
}
