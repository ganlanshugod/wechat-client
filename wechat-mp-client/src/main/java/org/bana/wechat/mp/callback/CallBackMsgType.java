package org.bana.wechat.mp.callback;

/** 
* @ClassName: ReceiveInfoType 
* @Description: 推送信息的InfoType类型
* @author liuwenjie   
*/
public enum CallBackMsgType {

	文本("text"),
	图片("image"),
	语音("voice"),
	视频("video"),
	小视频("shortvideo"),
	地理位置("location"),
	连接("link"),
	事件("event"),
	不支持的通知("unknow")
	;
	
	
	private String value;
	private CallBackMsgType(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
	public static CallBackMsgType instance(String value) {
		for (CallBackMsgType type : values()) {
			if(type.value.equalsIgnoreCase(value)) {
				return type;
			}
		}
		return 不支持的通知;
	}
}
