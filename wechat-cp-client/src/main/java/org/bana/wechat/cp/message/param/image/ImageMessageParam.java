/**
* @Company 青鸟软通   
* @Title: ImageMessageParam.java 
* @Package org.bana.wechat.qy.message.param.image 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:19:13 
* @version V1.0   
*/ 
package org.bana.wechat.cp.message.param.image;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.message.param.MessageParam;

/** 
 * @ClassName: ImageMessageParam 
 * @Description: image消息
 *  
 */
public class ImageMessageParam extends MessageParam {

	private static final long serialVersionUID = 1482934586236724709L;
	private ImageMessage image;

	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2015-5-27 下午9:42:35  
	 */
	public ImageMessageParam() {
		setMsgtype(Constants.image消息.getValue());
	}
	
	/**
	 * @Description: 属性 image 的get方法 
	 * @return image
	 */
	public ImageMessage getImage() {
		return image;
	}

	/**
	 * @Description: 属性 image 的set方法 
	 * @param image 
	 */
	public void setImage(ImageMessage image) {
		this.image = image;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:21:32 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "ImageMessageParam [image=" + image + ", touser=" + touser + ", toparty=" + toparty + ", totag=" + totag + ", msgtype=" + msgtype + ", agentid=" + agentid
				+ ", safe=" + safe + "]";
	}
	
}
