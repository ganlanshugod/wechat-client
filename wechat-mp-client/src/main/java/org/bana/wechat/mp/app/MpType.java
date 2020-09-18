/**
* @Company 全域旅游
* @Title: MpType.java 
* @Package org.bana.wechat.mp.app 
* @author liuwenjie   
* @date Sep 18, 2020 2:57:48 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.app;

/** 
* @ClassName: MpType 
* @Description: MpType应用的类型enum
* @author liuwenjie   
*/
public enum MpType{

	自建类型("custom"),
	第三方授权("thrid");
	
	private String value;
	private MpType(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
