/**
 * @Company 青鸟软通   
 * @Title: MediaResult.java 
 * @Package org.bana.wechat.mp.media.result 
 * @author Han Tongyang   
 * @date 2016-3-21 下午2:00:53 
 * @version V1.0   
 */
package org.bana.wechat.mp.media.result;

/**
 * @ClassName: MediaResult
 * @Description: 多媒体接口返回值
 * 
 */
public class MediaResult {

	private String type; //媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	private String mediaId; //媒体文件ID
	private int createdAt; //创建时间

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "MediaResult [type=" + type + ", mediaId=" + mediaId
				+ ", createdAt=" + createdAt + "]";
	}

}
