/**
 * @Company 青鸟软通   
 * @Title: MessageTypeEnum.java 
 * @Package org.bana.wechat.mp.message 
 * @author Han Tongyang   
 * @date 2016-3-21 下午7:01:39 
 * @version V1.0   
 */
package org.bana.wechat.mp.message.util;

/**
 * @ClassName: MessageTypeEnum
 * @Description: 消息类型枚举
 * 
 */
public enum MessageTypeEnum {
	图文消息("mpnews"), 文本("text"), 语音("voice"), 图片("image"), 视频("mpvideo");

	private String messageType;

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Han Tongyang
	 * @date 2016-3-21 下午7:03:48
	 * @param messageType
	 */
	private MessageTypeEnum(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageType() {
		return messageType;
	}

}
