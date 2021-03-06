package org.bana.wechat.mini.media.param;

import java.io.File;

import org.bana.wechat.mini.common.WeChatMiniParam;
import org.bana.wechat.mini.media.UploadType;


public class WechatMiniUploadParam extends WeChatMiniParam{

	private static final long serialVersionUID = -783214887185720219L;

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
		return "WechatMiniUploadParam [type=" + type + ", toString()=" + super.toString() + "]";
	}
	
}
