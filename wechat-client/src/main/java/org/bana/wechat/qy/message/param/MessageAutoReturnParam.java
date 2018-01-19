/**
* @Company 青鸟软通   
* @Title: MessageAutoReturnParam.java 
* @Package org.bana.wechat.qy.message.param 
* @author Liu Wenjie   
* @date 2015-11-1 上午11:25:52 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message.param;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @ClassName: MessageAutoReturnParam 
 * @Description: 消息和时间的自动回复消息体的参数对象
 *  
 */
@XmlRootElement(name="xml")
public class MessageAutoReturnParam {
	
	
	private String msgSignature;//签名
	
	private long timeStamp;//时间戳，只到秒
	
	private String nonce;//随机字符串
	
	private String encrypt;//密文
	/**
	 * @Description: 属性 msgSignature 的get方法 
	 * @return msgSignature
	 */
	@XmlElement(name="MsgSignature")
	public String getMsgSignature() {
		return msgSignature;
	}
	/**
	 * @Description: 属性 msgSignature 的set方法 
	 * @param msgSignature 
	 */
	public void setMsgSignature(String msgSignature) {
		this.msgSignature = msgSignature;
	}
	/**
	 * @Description: 属性 timeStamp 的get方法 
	 * @return timeStamp
	 */
	@XmlElement(name="TimeStamp")
	public long getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @Description: 属性 timeStamp 的set方法 
	 * @param timeStamp 
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @Description: 属性 nonce 的get方法 
	 * @return nonce
	 */
	@XmlElement(name="Nonce")
	public String getNonce() {
		return nonce;
	}
	/**
	 * @Description: 属性 nonce 的set方法 
	 * @param nonce 
	 */
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	/**
	 * @Description: 属性 encrypt 的get方法 
	 * @return encrypt
	 */
	@XmlElement(name="Encrypt")
	public String getEncrypt() {
		return encrypt;
	}
	/**
	 * @Description: 属性 encrypt 的set方法 
	 * @param encrypt 
	 */
	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-11-1 上午11:32:50 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "MessageAutoReturnParam [MsgSignature=" + msgSignature + ", timeStamp=" + timeStamp + ", nonce=" + nonce + ", encrypt=" + encrypt + "]";
	}
	
}
