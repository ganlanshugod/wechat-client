/**
* @Company 艾美伴行  
* @Title: KefuParam.java 
* @Package org.bana.wechat.qy.kefu.param 
* @author Yang Shuangshuang   
* @date 2016-5-5 下午1:28:30 
* @version V1.0   
*/ 
package org.bana.wechat.qy.kefu.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: KefuParam 
 * @Description: 客服发送消息接口的统一对象
 *  
 */
public abstract class KefuParam extends WeChatParam {

	protected Sender sender; 
	protected Receiver receiver; 
	protected String msgtype; //消息类型 
	
	
	/**
	 * @Description: 属性 msgtype 的get方法 
	 * @return msgtype
	 */
	public String getMsgtype() {
		return msgtype;
	}
	/**
	 * @Description: 属性 msgtype 的set方法 
	 * @param msgtype 
	 */
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
	public Sender getSender() {
		return sender;
	}
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	public Receiver getReceiver() {
		return receiver;
	}
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}
	
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:09:39 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "KefuParam [sender=" + sender + ", receiver=" + receiver + 
				", msgtype=" +msgtype+ ", access_token=" + access_token + "]";
	}
	
}
