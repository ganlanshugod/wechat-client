/**
 * @Company 青鸟软通   
 * @Title: MediaParam.java 
 * @Package org.bana.wechat.mp.media.param 
 * @author Han Tongyang   
 * @date 2016-3-21 上午11:04:49 
 * @version V1.0   
 */
package org.bana.wechat.mp.media.param;

import org.apache.commons.fileupload.FileItem;
import org.bana.wechat.mp.common.WeChatMpParam;

/**
 * @ClassName: MediaParam
 * @Description: 多媒体实体类
 * 
 */
public class MediaParam extends WeChatMpParam {
	
	private String type; //文件类型
	private FileItem file; //文件

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FileItem getFile() {
		return file;
	}

	public void setFile(FileItem file) {
		this.file = file;
	}

}
