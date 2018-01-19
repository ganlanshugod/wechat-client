/**
* @Company 青鸟软通   
* @Title: BrcodeResult.java 
* @Package org.bana.wechat.pay.brcode 
* @author Liu Wenjie   
* @date 2015-9-29 下午4:48:13 
* @version V1.0   
*/ 
package org.bana.wechat.pay.brcode;

import org.bana.wechat.pay.common.WechatPayResult;

/** 
 * @ClassName: BrcodeResult 
 * @Description: BrcodeResult
 *  
 */
public class BrcodeResult extends WechatPayResult {

	private String prepay_id;//预支付ID prepay_id String(64) 是 wx201410272009395522657a690389285100 调用统一下单接口生成的预支付ID 

	/**
	 * @Description: 属性 prepay_id 的get方法 
	 * @return prepay_id
	 */
	public String getPrepay_id() {
		return prepay_id;
	}

	/**
	 * @Description: 属性 prepay_id 的set方法 
	 * @param prepay_id 
	 */
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-29 下午4:51:36 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "BrcodeResult [prepay_id=" + prepay_id + ", return_code=" + return_code + ", return_msg=" + return_msg + ", result_code=" + result_code + ", err_code=" + err_code
				+ ", err_code_des=" + err_code_des + ", appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign + "]";
	}

}
