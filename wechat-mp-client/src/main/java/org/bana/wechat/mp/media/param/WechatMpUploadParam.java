package org.bana.wechat.mp.media.param;

import java.io.File;

import org.bana.wechat.mp.common.WeChatMpParam;
import org.bana.wechat.mp.media.UploadType;

public class WechatMpUploadParam extends WeChatMpParam{

	private static final long serialVersionUID = -2800577327488302461L;

	private UploadType type; //（image）、语音（voice）、视频（video）和缩略图（thumb）
	
	private File file;


	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	

	public UploadType getType() {
		return type;
	}

	public void setType(UploadType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "WechatMpUploadParam [type=" + type + ", toString()=" + super.toString() + "]";
	}
	
}
