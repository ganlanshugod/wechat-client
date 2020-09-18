/**
* @Company 全域旅游
* @Title: ReceiveInfoType.java 
* @Package org.bana.wechat.mp.component.common 
* @author liuwenjie   
* @date Sep 18, 2020 4:59:27 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.common;

/** 
* @ClassName: ReceiveInfoType 
* @Description: 推送信息的InfoType类型
* @author liuwenjie   
*/
public enum ReceiveInfoType {

	推送ticket("component_verify_ticket"),
	授权成功通知("authorized"),
	取消授权通知("unauthorized"),
	授权更新通知("updateauthorized"),
	不支持的通知("unknow")
	;
	
	
	private String value;
	private ReceiveInfoType(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
	public static ReceiveInfoType instance(String value) {
		for (ReceiveInfoType type : values()) {
			if(type.value.equalsIgnoreCase(value)) {
				return type;
			}
		}
		return 不支持的通知;
	}
}
