/**
 * @Company 艾美伴行  
 * @Title: TextMessage.java 
 * @Package org.bana.wechat.qy.kefu.param 
 * @author Yang Shuangshuang   
 * @date 2016-5-5 13:01:30 
 * @version V1.0   
 */
package org.bana.wechat.qy.kefu.param.text;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.qy.kefu.param.KefuParam;
import org.bana.wechat.qy.message.param.text.TextMessage;

/**
 * @ClassName: TextMessage
 * @Description: 客服文本消息
 * 
 */
public class TextMessageParam extends KefuParam {

	private TextMessage text; // 是 消息内容

	

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Yang Shuangshuang
	 * @date 2016-5-5 下午1:03:38
	 */
	public TextMessageParam() {
		setMsgtype(Constants.text消息.getValue());
	}

	/**
	 * @Description: 属性 text 的get方法
	 * @return text
	 */
	public TextMessage getText() {
		return text;
	}

	public void setText(TextMessage text) {
		this.text = text;
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
		return "TextMessageParam [text=" + text + ", sender=" + sender + ", receiver=" + receiver +
				", msgtype=" + ", access_token=" + access_token +  "]";
	}

}
