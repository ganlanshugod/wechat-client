/**
* @Company 青鸟软通   
* @Title: ReceiveSuiteToken.java 
* @Package org.bana.wechat.qy.connection.domain 
* @author Liu Wenjie   
* @date 2015-5-13 上午10:03:18 
* @version V1.0   
*/ 
package org.bana.wechat.cp.suite.domain;

/** 
 * @ClassName: ReceiveSuiteToken 
 * @Description: 微信回调企业应用时写入的对象信息
 *  
 */
public class ReceiveSuiteTicket extends ReceiveSuitResult{
	
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 7347712658380399433L;
	private String suiteTicket;
	
	
	/*==============getter and setter =================*/
	/**
	 * @Description: 属性 suiteTicket 的get方法 
	 * @return suiteTicket
	 */
	public String getSuiteTicket() {
		return suiteTicket;
	}
	/**
	 * @Description: 属性 suiteTicket 的set方法 
	 * @param suiteTicket 
	 */
	public void setSuiteTicket(String suiteTicket) {
		this.suiteTicket = suiteTicket;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-13 下午3:28:54 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "ReceiveSuiteToken [suiteTicket=" + suiteTicket + ", suiteId=" + suiteId + ", infoType=" + infoType + ", timeStamp=" + timeStamp + "]";
	}
	
}
