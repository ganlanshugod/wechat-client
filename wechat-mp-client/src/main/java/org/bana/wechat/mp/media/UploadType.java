package org.bana.wechat.mp.media;

public enum UploadType {
	
	图片("image"),语音("voice"),视频("video"),缩略图("thumb");
	
	private String type;
	private UploadType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
	public static UploadType getInstance(String type){
		for (UploadType uploadType : values()) {
			if(uploadType.type.equals(type)){
				return uploadType;
			}
		}
		return null;
	}
	
}
