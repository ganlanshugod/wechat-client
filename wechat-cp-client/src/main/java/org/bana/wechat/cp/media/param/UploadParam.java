/**
* @Company 青鸟软通   
* @Title: UploadParam.java 
* @Package org.bana.wechat.qy.media.param 
* @author Liu Wenjie   
* @date 2015-7-20 下午5:16:49 
* @version V1.0   
*/ 
package org.bana.wechat.cp.media.param;

import java.util.Arrays;

import org.bana.wechat.cp.common.WeChatCPParam;


/** 
 * @ClassName: UploadParam 
 * @Description: wechatParam
 *  
 */
public class UploadParam extends WeChatCPParam {

	private static final long serialVersionUID = 7519185427008906607L;

	private String type;//文件类型
	
	private byte[] media;//文件流数组
	
	private String fileExt;
	
	private String contentType;
	
	private String fileName;
	

	/**
	 * @Description: 属性 type 的get方法 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @Description: 属性 type 的set方法 
	 * @param type 
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @Description: 属性 media 的get方法 
	 * @return media
	 */
	public byte[] getMedia() {
		return media;
	}

	/**
	 * @Description: 属性 media 的set方法 
	 * @param media 
	 */
	public void setMedia(byte[] media) {
		this.media = media;
	}

	/**
	 * @Description: 属性 fileExt 的get方法 
	 * @return fileExt
	 */
	public String getFileExt() {
		return fileExt;
	}

	/**
	 * @Description: 属性 fileExt 的set方法 
	 * @param fileExt 
	 */
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	/**
	 * @Description: 属性 contentType 的get方法 
	 * @return contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @Description: 属性 contentType 的set方法 
	 * @param contentType 
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @Description: 属性 fileName 的get方法 
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @Description: 属性 fileName 的set方法 
	 * @param fileName 
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-7-20 下午8:41:16 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "UploadParam [type=" + type + ", media=" + Arrays.toString(media) + ", fileExt=" + fileExt + ", contentType=" + contentType + "]";
	}
	
}
