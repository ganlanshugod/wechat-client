/**
* @Company 青鸟软通   
* @Title: Constants.java 
* @Package org.bana.wechat.mp.common 
* @author Liu Wenjie   
* @date 2015-8-18 下午5:02:25 
* @version V1.0   
*/ 
package org.bana.wechat.pay.common;

/** 
 * @ClassName: Constants 
 * @Description: 服务号的常量对象
 *  
 */
public enum Constants {

	/*接口地址的公共*/
	接口根路径("https://api.mch.weixin.qq.com"),
	/*微信公众号支付*/
	统一下单(接口根路径.value + "/pay/unifiedorder"),
	查看订单(接口根路径.value + "/pay/orderquery"),
	关闭订单(接口根路径.value + "/pay/closeorder"),
	/*申请退款*/
	申请退款(接口根路径.value + "/secapi/pay/refund"),
	查询退款(接口根路径.value + "/pay/refundquery"),
	/*账单下载*/
	下载对账单(接口根路径.value + "/pay/downloadbill"),
	/*微信掃碼支付*/
	微信二维码字符串("weixin://wxpay/bizpayurl?sign=${sign}&appid=${appid}&mch_id=${mch_id}&product_id=${product_id}&time_stamp=${time_stamp}&nonce_str=${nonce_str}"),
	/*返回值属性的设置*/
	返回码("return_code"),
	返回信息("return_msg"),
	成功码("SUCCESS");
	
	
	private String value;
	
	private Constants(String value){
		this.value = value;
	}
	/**
	 * @Description: 属性 value 的get方法 
	 * @return value
	 */
	public String getValue() {
		return value;
	}
}
