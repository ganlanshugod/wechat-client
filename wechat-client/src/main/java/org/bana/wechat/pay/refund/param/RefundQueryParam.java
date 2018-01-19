/**
* @Company 青鸟软通   
* @Title: RefundQueryParam.java 
* @Package org.bana.wechat.pay.refund.param 
* @author Liu Wenjie   
* @date 2015-9-24 下午12:04:58 
* @version V1.0   
*/ 
package org.bana.wechat.pay.refund.param;

import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.pay.common.WechatPayParam;

/** 
 * @ClassName: RefundQueryParam 
 * @Description: 退款申请的Query参数
 *  
 */
@XmlRootElement(name="xml")
public class RefundQueryParam extends WechatPayParam {

	private String device_info;//设备号 device_info 否 String(32) 013467007045764 商户自定义的终端设备号，如门店编号、设备的ID等 
	
	//四选一 以下四选一
	private String transaction_id;//微信订单号 transaction_id  String(28) 1217752501201407033233368018 微信订单号 
	private String out_trade_no;//商户订单号 out_trade_no String(32) 1217752501201407033233368018 商户系统内部的订单号 
	private String out_refund_no;//商户退款单号 out_refund_no String(32) 1217752501201407033233368018 商户侧传给微信的退款单号 
	private String refund_id;//微信退款单号 refund_id String(28) 1217752501201407033233368018 微信生成的退款单号，在申请退款接口有返回 
	/**
	 * @Description: 属性 device_info 的get方法 
	 * @return device_info
	 */
	public String getDevice_info() {
		return device_info;
	}
	/**
	 * @Description: 属性 device_info 的set方法 
	 * @param device_info 
	 */
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	/**
	 * @Description: 属性 transaction_id 的get方法 
	 * @return transaction_id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}
	/**
	 * @Description: 属性 transaction_id 的set方法 
	 * @param transaction_id 
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	/**
	 * @Description: 属性 out_trade_no 的get方法 
	 * @return out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}
	/**
	 * @Description: 属性 out_trade_no 的set方法 
	 * @param out_trade_no 
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	/**
	 * @Description: 属性 out_refund_no 的get方法 
	 * @return out_refund_no
	 */
	public String getOut_refund_no() {
		return out_refund_no;
	}
	/**
	 * @Description: 属性 out_refund_no 的set方法 
	 * @param out_refund_no 
	 */
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}
	/**
	 * @Description: 属性 refund_id 的get方法 
	 * @return refund_id
	 */
	public String getRefund_id() {
		return refund_id;
	}
	/**
	 * @Description: 属性 refund_id 的set方法 
	 * @param refund_id 
	 */
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-24 下午12:14:45 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "RefundQueryParam [device_info=" + device_info + ", transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no + ", out_refund_no=" + out_refund_no
				+ ", refund_id=" + refund_id + ", appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign + "]";
	}
	 

}
