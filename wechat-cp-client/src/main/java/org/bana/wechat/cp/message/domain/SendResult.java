/**
* @Company 青鸟软通   
* @Title: SendResult.java 
* @Package org.bana.wechat.qy.message.domain 
* @author Liu Wenjie   
* @date 2015-5-27 下午8:59:24 
* @version V1.0   
*/ 
package org.bana.wechat.cp.message.domain;

/** 
 * @ClassName: SendResult 
 * @Description: 发送消息的接口返回值
 *  
 */
public class SendResult {

	private String invaliduser;
	private String invalidparty;
	private String invalidtag;
	/**
	 * @Description: 属性 invaliduser 的get方法 
	 * @return invaliduser
	 */
	public String getInvaliduser() {
		return invaliduser;
	}
	/**
	 * @Description: 属性 invaliduser 的set方法 
	 * @param invaliduser 
	 */
	public void setInvaliduser(String invaliduser) {
		this.invaliduser = invaliduser;
	}
	/**
	 * @Description: 属性 invalidparty 的get方法 
	 * @return invalidparty
	 */
	public String getInvalidparty() {
		return invalidparty;
	}
	/**
	 * @Description: 属性 invalidparty 的set方法 
	 * @param invalidparty 
	 */
	public void setInvalidparty(String invalidparty) {
		this.invalidparty = invalidparty;
	}
	/**
	 * @Description: 属性 invalidtag 的get方法 
	 * @return invalidtag
	 */
	public String getInvalidtag() {
		return invalidtag;
	}
	/**
	 * @Description: 属性 invalidtag 的set方法 
	 * @param invalidtag 
	 */
	public void setInvalidtag(String invalidtag) {
		this.invalidtag = invalidtag;
	}
	
	@Override
	public String toString() {
		return "SendResult [invaliduser=" + invaliduser + ", invalidparty=" + invalidparty + ", invalidtag="
				+ invalidtag + "]";
	}
	
	
}
