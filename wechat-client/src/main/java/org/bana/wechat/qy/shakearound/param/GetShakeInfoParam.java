/**
* @Company 青鸟软通   
* @Title: GetShakeInfoParam.java 
* @Package org.bana.wechat.qy.shakearound 
* @author Liu Wenjie   
* @date 2015-9-16 上午11:37:57 
* @version V1.0   
*/ 
package org.bana.wechat.qy.shakearound.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: GetShakeInfoParam 
 * @Description: 获取摇一摇周边的用户信息的参数
 *  
 */
public class GetShakeInfoParam extends WeChatParam{

	/** 
	* @Fields ticket : 回调地址中的ticket参数
	*/ 
	private String ticket;

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
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-16 上午11:41:01 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "GetShakeInfoParam [ticket=" + ticket + ", access_token=" + access_token + "]";
	}
	
}
