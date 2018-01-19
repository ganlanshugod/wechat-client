/**
* @Company 青鸟软通   
* @Title: RefundResult.java 
* @Package org.bana.wechat.pay.refund.result 
* @author Liu Wenjie   
* @date 2015-9-23 下午3:45:43 
* @version V1.0   
*/ 
package org.bana.wechat.pay.refund.result;

import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.pay.common.WechatPayResult;

/** 
 * @ClassName: RefundResult 
 * @Description: 申请退款的返回值结果
 *  
 */
@XmlRootElement(name="xml")
public class RefundResult extends WechatPayResult {

	private String device_info;//设备号 device_info 否 String(32) 013467007045764 微信支付分配的终端设备号，与下单一致 
	private String transaction_id;//微信订单号 transaction_id 是 String(28) 1217752501201407033233368018 微信订单号 
	private String out_trade_no;//商户订单号 out_trade_no 是 String(32) 1217752501201407033233368018 商户系统内部的订单号 
	private String out_refund_no;//商户退款单号 out_refund_no 是 String(32) 1217752501201407033233368018 商户退款单号 
	private String refund_id;//微信退款单号 refund_id 是 String(28) 1217752501201407033233368018 微信退款单号 
	private String refund_channel;//退款渠道 refund_channel 否 String(16) ORIGINAL  ORIGINAL—原路退款  BALANCE—退回到余额
	 
	private Integer refund_fee;//退款金额 refund_fee 是 Int 100 退款总金额,单位为分,可以做部分退款 
	private Integer total_fee;//订单总金额 total_fee 是 Int 100 订单总金额，单位为分，只能为整数，详见支付金额 
	private String fee_type;//订单金额货币种类 fee_type 否 String(8) CNY 订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型 
	private String cash_fee;//现金支付金额 cash_fee 是 Int 100 现金支付金额，单位为分，只能为整数，详见支付金额 
	private Integer cash_refund_fee;//现金退款金额 cash_refund_fee 否 Int 100 现金退款金额，单位为分，只能为整数，详见支付金额 
	private Integer coupon_refund_fee;//代金券或立减优惠退款金额 coupon_refund_fee 否 Int 100 代金券或立减优惠退款金额=订单金额-现金退款金额，注意：立减优惠金额不会退回 
	private Integer coupon_refund_count;//代金券或立减优惠使用数量 coupon_refund_count 否 Int 1 代金券或立减优惠使用数量 
	private String coupon_refund_id;//代金券或立减优惠ID coupon_refund_id 否 String(20)  10000  代金券或立减优惠ID 
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
	 * @Description: 属性 refund_channel 的get方法 
	 * @return refund_channel
	 */
	public String getRefund_channel() {
		return refund_channel;
	}
	/**
	 * @Description: 属性 refund_channel 的set方法 
	 * @param refund_channel 
	 */
	public void setRefund_channel(String refund_channel) {
		this.refund_channel = refund_channel;
	}
	/**
	 * @Description: 属性 refund_fee 的get方法 
	 * @return refund_fee
	 */
	public Integer getRefund_fee() {
		return refund_fee;
	}
	/**
	 * @Description: 属性 refund_fee 的set方法 
	 * @param refund_fee 
	 */
	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}
	/**
	 * @Description: 属性 total_fee 的get方法 
	 * @return total_fee
	 */
	public Integer getTotal_fee() {
		return total_fee;
	}
	/**
	 * @Description: 属性 total_fee 的set方法 
	 * @param total_fee 
	 */
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}
	/**
	 * @Description: 属性 fee_type 的get方法 
	 * @return fee_type
	 */
	public String getFee_type() {
		return fee_type;
	}
	/**
	 * @Description: 属性 fee_type 的set方法 
	 * @param fee_type 
	 */
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	/**
	 * @Description: 属性 cash_fee 的get方法 
	 * @return cash_fee
	 */
	public String getCash_fee() {
		return cash_fee;
	}
	/**
	 * @Description: 属性 cash_fee 的set方法 
	 * @param cash_fee 
	 */
	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}
	/**
	 * @Description: 属性 cash_refund_fee 的get方法 
	 * @return cash_refund_fee
	 */
	public Integer getCash_refund_fee() {
		return cash_refund_fee;
	}
	/**
	 * @Description: 属性 cash_refund_fee 的set方法 
	 * @param cash_refund_fee 
	 */
	public void setCash_refund_fee(Integer cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}
	/**
	 * @Description: 属性 coupon_refund_fee 的get方法 
	 * @return coupon_refund_fee
	 */
	public Integer getCoupon_refund_fee() {
		return coupon_refund_fee;
	}
	/**
	 * @Description: 属性 coupon_refund_fee 的set方法 
	 * @param coupon_refund_fee 
	 */
	public void setCoupon_refund_fee(Integer coupon_refund_fee) {
		this.coupon_refund_fee = coupon_refund_fee;
	}
	/**
	 * @Description: 属性 coupon_refund_count 的get方法 
	 * @return coupon_refund_count
	 */
	public Integer getCoupon_refund_count() {
		return coupon_refund_count;
	}
	/**
	 * @Description: 属性 coupon_refund_count 的set方法 
	 * @param coupon_refund_count 
	 */
	public void setCoupon_refund_count(Integer coupon_refund_count) {
		this.coupon_refund_count = coupon_refund_count;
	}
	/**
	 * @Description: 属性 coupon_refund_id 的get方法 
	 * @return coupon_refund_id
	 */
	public String getCoupon_refund_id() {
		return coupon_refund_id;
	}
	/**
	 * @Description: 属性 coupon_refund_id 的set方法 
	 * @param coupon_refund_id 
	 */
	public void setCoupon_refund_id(String coupon_refund_id) {
		this.coupon_refund_id = coupon_refund_id;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-23 下午3:49:18 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "RefundResult [device_info=" + device_info + ", transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no + ", out_refund_no=" + out_refund_no
				+ ", refund_id=" + refund_id + ", refund_channel=" + refund_channel + ", refund_fee=" + refund_fee + ", total_fee=" + total_fee + ", fee_type=" + fee_type
				+ ", cash_fee=" + cash_fee + ", cash_refund_fee=" + cash_refund_fee + ", coupon_refund_fee=" + coupon_refund_fee + ", coupon_refund_count=" + coupon_refund_count
				+ ", coupon_refund_id=" + coupon_refund_id + ", return_code=" + return_code + ", return_msg=" + return_msg + ", result_code=" + result_code + ", err_code="
				+ err_code + ", err_code_des=" + err_code_des + ", appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign + "]";
	}

}
