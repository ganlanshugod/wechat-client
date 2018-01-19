/**
* @Company 青鸟软通   
* @Title: JsApiTicket.java 
* @Package org.bana.wechat.qy.connection.domain 
* @author Liu Wenjie   
* @date 2015-6-15 下午12:40:20 
* @version V1.0   
*/ 
package org.bana.wechat.qy.connection.domain;

import java.io.Serializable;

/** 
 * @ClassName: JsApiTicket 
 * @Description: JsApi获取的票据信息
 *  
 */
public class JsApiTicket implements Serializable{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 6686226116694040814L;
	private String ticket;
	private String expires_in;
	/**
	 * @Description: 属性 ticket 的get方法 
	 * @return ticket
	 */
	public String getTicket() {
		return ticket;
	}
	/**
	 * @Description: 属性 ticket 的set方法 
	 * @param ticket 
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	/**
	 * @Description: 属性 expires_in 的get方法 
	 * @return expires_in
	 */
	public String getExpires_in() {
		return expires_in;
	}
	/**
	 * @Description: 属性 expires_in 的set方法 
	 * @param expires_in 
	 */
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-6-15 下午12:41:16 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "JsApiTicket [ticket=" + ticket + ", expires_in=" + expires_in + "]";
	}
	
}
