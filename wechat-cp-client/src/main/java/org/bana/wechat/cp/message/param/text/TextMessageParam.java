/**
* @Company 青鸟软通   
* @Title: TextMessageParam.java 
* @Package org.bana.wechat.qy.message.param 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:10:19 
* @version V1.0   
*/ 
package org.bana.wechat.cp.message.param.text;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.message.param.MessageParam;

/** 
 * @ClassName: TextMessageParam 
 * @Description: text消息 
 *  
 */
public class TextMessageParam extends MessageParam{

	private static final long serialVersionUID = -6937219533545737058L;
	private TextMessage text; //	是	消息内容
	
	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2015-5-27 下午9:43:21  
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

	/**
	 * @Description: 属性 text 的set方法 
	 * @param text 
	 */
	public void setText(TextMessage text) {
		this.text = text;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:19:52 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "TextMessageParam [text=" + text + ", touser=" + touser + ", toparty=" + toparty + ", totag=" + totag + ", msgtype=" + msgtype + ", agentid=" + agentid + ", safe="
				+ safe + "]";
	}

}
