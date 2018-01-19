/**
* @Company 艾美伴行   
* @Title: CardExt.java 
* @Package org.bana.wechat.mp.message.param 
* @author liuwenjie   
* @date 2016-6-15 下午5:13:30 
* @version V1.0   
*/ 
package org.bana.wechat.mp.message.param;

/** 
 * @ClassName: CardExt 
 * @Description: 卡券客服消息的扩展字段
 *  
 */
public class CardExt {

	private String code;
	private String openid;
	private long timestamp;
	private String signature;
	/**
	 * @Description: 属性 code 的get方法 
	 * @return code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @Description: 属性 code 的set方法 
	 * @param code 
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @Description: 属性 openid 的get方法 
	 * @return openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * @Description: 属性 openid 的set方法 
	 * @param openid 
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * @Description: 属性 timestamp 的get方法 
	 * @return timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	/**
	 * @Description: 属性 timestamp 的set方法 
	 * @param timestamp 
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @Description: 属性 signature 的get方法 
	 * @return signature
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @Description: 属性 signature 的set方法 
	 * @param signature 
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午5:15:17 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CardExt [code=" + code + ", openid=" + openid + ", timestamp=" + timestamp + ", signature=" + signature + "]";
	}
	
}
