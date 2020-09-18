/**
* @Company 全域旅游
* @Title: AuthorizerOption.java 
* @Package org.bana.wechat.mp.component.result 
* @author liuwenjie   
* @date Sep 18, 2020 4:13:05 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.param;

/** 
* @ClassName: AuthorizerOption 
* @Description: 授权方的公众号权限的开关信息 
* @author liuwenjie   
*/
public enum AuthorizerOption {

	地理位置上报("location_report"),
	语音识别开关("voice_recognize"),
	多客服开关("customer_service");
	
	private String optionName;
	
	private AuthorizerOption(String optionName) {
		this.optionName = optionName;
	}

	public String getOptionName() {
		return optionName;
	}
	
	public static enum LocationReportValue{
		无上报("0"),
		进入会话时上报("1"),
		每5s上报("2");
		
		private String value;
		private LocationReportValue(String value){
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
}
