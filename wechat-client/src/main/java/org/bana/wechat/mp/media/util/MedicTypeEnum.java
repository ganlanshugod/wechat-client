/**
 * @Company 青鸟软通   
 * @Title: MedicEnum.java 
 * @Package org.bana.wechat.mp.media 
 * @author Han Tongyang   
 * @date 2016-3-21 下午6:04:37 
 * @version V1.0   
 */
package org.bana.wechat.mp.media.util;

/**
 * @ClassName: MedicEnum
 * @Description: 多媒体类型枚举
 * 
 */
public enum MedicTypeEnum {

	图片("image"), 语音("voice"), 视频("video"), 缩略图("thumb");

	private String mediaType;

	private MedicTypeEnum(String mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * @author Han Tongyang
	 * @date 2016-1-13 下午2:37:16
	 * @return
	 */
	public String getMediaType() {
		return mediaType;
	}

}
