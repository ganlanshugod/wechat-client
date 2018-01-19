/**
* @Company 青鸟软通   
* @Title: BrcodeParam.java 
* @Package org.bana.wechat.pay.common 
* @author Liu Wenjie   
* @date 2015-9-29 下午3:48:38 
* @version V1.0   
*/ 
package org.bana.wechat.pay.brcode;

import org.bana.wechat.pay.common.WechatPayParam;


/** 
 * @ClassName: BrcodeParam 
 * @Description: 生成二维码的参数对象
 *  
 */
public class BrcodeParam extends WechatPayParam {

	private String time_stamp;//时间戳 time_stamp String(10) 是 1414488825 系统当前时间，定义规则详见时间戳 
	private String product_id;//商品ID product_id String(32) 是 88888 商户定义的商品id 或者订单号 
	
	/**
	 * @Description: 属性 time_stamp 的get方法 
	 * @return time_stamp
	 */
	public String getTime_stamp() {
		return time_stamp;
	}
	/**
	 * @Description: 属性 time_stamp 的set方法 
	 * @param time_stamp 
	 */
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	/**
	 * @Description: 属性 product_id 的get方法 
	 * @return product_id
	 */
	public String getProduct_id() {
		return product_id;
	}
	/**
	 * @Description: 属性 product_id 的set方法 
	 * @param product_id 
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-29 下午3:50:22 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "BrcodeParam [time_stamp=" + time_stamp + ", product_id=" + product_id + ", appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign
				+ "]";
	}
	
}
