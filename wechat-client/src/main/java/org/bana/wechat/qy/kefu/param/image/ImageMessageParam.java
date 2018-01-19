/**
 * @Company 艾美伴行  
 * @Title: TextMeImageMessageParamssage.java 
 * @Package org.bana.wechat.qy.kefu.param 
 * @author Yang Shuangshuang   
 * @date 2016-5-5 13:01:30 
 * @version V1.0   
 */
package org.bana.wechat.qy.kefu.param.image;

import org.bana.wechat.qy.common.Constants;
import org.bana.wechat.qy.kefu.param.KefuParam;
import org.bana.wechat.qy.message.param.image.ImageMessage;

/**
 * @ClassName: ImageMessageParam
 * @Description: 客服图片消息
 * 
 */
public class ImageMessageParam extends KefuParam {

	private ImageMessage image; // 是 消息内容

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Yang Shuangshuang
	 * @date 2016-5-5 下午1:03:38
	 */
	public ImageMessageParam() {
		setMsgtype(Constants.image消息.getValue());
	}

	/**
	 * @Description: 属性 text 的get方法
	 * @return text
	 */
	public ImageMessage getImage() {
		return image;
	}

	public void setImage(ImageMessage image) {
		this.image = image;
	}
	
	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Liu Wenjie
	 * @date 2015-5-27 下午9:19:52
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TextMessageParam [image=" + image + ", sender=" + sender + ", receiver=" + receiver +
				", msgtype=" + ", access_token=" + access_token +  "]";
	}

}
