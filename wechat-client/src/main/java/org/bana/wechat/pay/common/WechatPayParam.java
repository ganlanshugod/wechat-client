/**
* @Company 青鸟软通   
* @Title: WechatPayParam.java 
* @Package org.bana.wechat.pay.common 
* @author Liu Wenjie   
* @date 2015-9-17 下午8:10:59 
* @version V1.0   
*/ 
package org.bana.wechat.pay.common;

/** 
 * @ClassName: WechatPayParam 
 * @Description: 公共的pay调用个参数对象
 *  
 */
public class WechatPayParam {

	protected String appid;//公众账号ID  appid  是  String(32)  wxd678efh567hg6787 微信分配的公众账号ID（企业号corpid即为此appId）  
	protected String mch_id;//商户号  mch_id  是  String(32) 1230000109  微信支付分配的商户号  
	
	protected String nonce_str;//随机字符串	nonce_str	是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	微信返回的随机字符串
	protected String sign;//签名	sign	是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	微信返回的签名，详见签名算法
	
	
	/**
	 * @Description: 属性 appid 的get方法 
	 * @return appid
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * @Description: 属性 appid 的set方法 
	 * @param appid 
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * @Description: 属性 mch_id 的get方法 
	 * @return mch_id
	 */
	public String getMch_id() {
		return mch_id;
	}
	/**
	 * @Description: 属性 mch_id 的set方法 
	 * @param mch_id 
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	/**
	 * @Description: 属性 nonce_str 的get方法 
	 * @return nonce_str
	 */
	public String getNonce_str() {
		return nonce_str;
	}
	/**
	 * @Description: 属性 nonce_str 的set方法 
	 * @param nonce_str 
	 */
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	/**
	 * @Description: 属性 sign 的get方法 
	 * @return sign
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * @Description: 属性 sign 的set方法 
	 * @param sign 
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
