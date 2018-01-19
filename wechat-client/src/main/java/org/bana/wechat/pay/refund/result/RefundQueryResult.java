/**
* @Company 青鸟软通   
* @Title: RefundQueryResult.java 
* @Package org.bana.wechat.pay.refund.result 
* @author Liu Wenjie   
* @date 2015-9-24 下午12:06:05 
* @version V1.0   
*/ 
package org.bana.wechat.pay.refund.result;

import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.pay.common.WechatPayResult;

/** 
 * @ClassName: RefundQueryResult 
 * @Description: 结果页面 
 *  
 */
@XmlRootElement(name="xml")
public class RefundQueryResult extends WechatPayResult {
	private String device_info;//设备号 device_info 是 String(32) 013467007045764 终端设备号 
	private String transaction_id;//微信订单号 transaction_id 是 String(32) 1217752501201407033233368018 微信订单号 
	private String out_trade_no;//商户订单号 out_trade_no 是 String(32) 1217752501201407033233368018 商户系统内部的订单号 
	private Integer total_fee;//订单总金额 total_fee 是 Int 100 订单总金额，单位为分，只能为整数，详见支付金额 
	private String fee_type;//订单金额货币种类 fee_type 否 String(8) CNY 订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型 
	private Integer cash_fee;//现金支付金额 cash_fee 是 Int 100 现金支付金额，单位为分，只能为整数，详见支付金额 
	private Integer refund_count;//退款笔数 refund_count 是 Int 1 退款记录数 
	private String out_refund_no_$n;//商户退款单号 out_refund_no_$n 是 String(32) 1217752501201407033233368018 商户退款单号 
	private String refund_id_$n;//微信退款单号 refund_id_$n 是 String(28) 1217752501201407033233368018 微信退款单号 
	/**
	 * 退款渠道 refund_channel_$n 否 String(16) ORIGINAL ORIGINAL—原路退款 	BALANCE—退回到余额
	 */
	private String refund_channel_$n;
	private Integer refund_fee_$n;//退款金额 refund_fee_$n 是 Int 100 退款总金额,单位为分,可以做部分退款 
	private Integer coupon_refund_fee_$n;//代金券或立减优惠退款金额 coupon_refund_fee_$n 否 Int 100 代金券或立减优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠 
	private Integer coupon_refund_count_$n;//代金券或立减优惠使用数量 coupon_refund_count_$n 否 Int 1 代金券或立减优惠使用数量 ,$n为下标,从0开始编号 
	private String coupon_refund_batch_id_$n_$m;//代金券或立减优惠批次ID coupon_refund_batch_id_$n_$m 否 String(20)  100 批次ID ,$n为下标，$m为下标，从0开始编号 
	private String coupon_refund_id_$n_$m;//代金券或立减优惠ID coupon_refund_id_$n_$m 否 String(20)  10000  代金券或立减优惠ID, $n为下标，$m为下标，从0开始编号 
	private Integer coupon_refund_fee_$n_$m;//单个代金券或立减优惠支付金额 coupon_refund_fee_$n_$m 否 Int 100 单个代金券或立减优惠支付金额, $n为下标，$m为下标，从0开始编号 
	/**
	 * 退款状态 refund_status_$n 是 String(16) SUCCESS 退款状态： 
	SUCCESS—退款成功 
	FAIL—退款失败 
	PROCESSING—退款处理中 
	NOTSURE—未确定，需要商户原退款单号重新发起 
	CHANGE—转入代发，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，资金回流到商户的现金帐号，需要商户人工干预，通过线下或者财付通转账的方式进行退款。
	 */
	private String refund_status_$n;//
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
	public Integer getCash_fee() {
		return cash_fee;
	}
	/**
	 * @Description: 属性 cash_fee 的set方法 
	 * @param cash_fee 
	 */
	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}
	/**
	 * @Description: 属性 refund_count 的get方法 
	 * @return refund_count
	 */
	public Integer getRefund_count() {
		return refund_count;
	}
	/**
	 * @Description: 属性 refund_count 的set方法 
	 * @param refund_count 
	 */
	public void setRefund_count(Integer refund_count) {
		this.refund_count = refund_count;
	}
	/**
	 * @Description: 属性 out_refund_no_$n 的get方法 
	 * @return out_refund_no_$n
	 */
	public String getOut_refund_no_$n() {
		return out_refund_no_$n;
	}
	/**
	 * @Description: 属性 out_refund_no_$n 的set方法 
	 * @param out_refund_no_$n 
	 */
	public void setOut_refund_no_$n(String out_refund_no_$n) {
		this.out_refund_no_$n = out_refund_no_$n;
	}
	/**
	 * @Description: 属性 refund_id_$n 的get方法 
	 * @return refund_id_$n
	 */
	public String getRefund_id_$n() {
		return refund_id_$n;
	}
	/**
	 * @Description: 属性 refund_id_$n 的set方法 
	 * @param refund_id_$n 
	 */
	public void setRefund_id_$n(String refund_id_$n) {
		this.refund_id_$n = refund_id_$n;
	}
	/**
	 * @Description: 属性 refund_channel_$n 的get方法 
	 * @return refund_channel_$n
	 */
	public String getRefund_channel_$n() {
		return refund_channel_$n;
	}
	/**
	 * @Description: 属性 refund_channel_$n 的set方法 
	 * @param refund_channel_$n 
	 */
	public void setRefund_channel_$n(String refund_channel_$n) {
		this.refund_channel_$n = refund_channel_$n;
	}
	/**
	 * @Description: 属性 refund_fee_$n 的get方法 
	 * @return refund_fee_$n
	 */
	public Integer getRefund_fee_$n() {
		return refund_fee_$n;
	}
	/**
	 * @Description: 属性 refund_fee_$n 的set方法 
	 * @param refund_fee_$n 
	 */
	public void setRefund_fee_$n(Integer refund_fee_$n) {
		this.refund_fee_$n = refund_fee_$n;
	}
	/**
	 * @Description: 属性 coupon_refund_fee_$n 的get方法 
	 * @return coupon_refund_fee_$n
	 */
	public Integer getCoupon_refund_fee_$n() {
		return coupon_refund_fee_$n;
	}
	/**
	 * @Description: 属性 coupon_refund_fee_$n 的set方法 
	 * @param coupon_refund_fee_$n 
	 */
	public void setCoupon_refund_fee_$n(Integer coupon_refund_fee_$n) {
		this.coupon_refund_fee_$n = coupon_refund_fee_$n;
	}
	/**
	 * @Description: 属性 coupon_refund_count_$n 的get方法 
	 * @return coupon_refund_count_$n
	 */
	public Integer getCoupon_refund_count_$n() {
		return coupon_refund_count_$n;
	}
	/**
	 * @Description: 属性 coupon_refund_count_$n 的set方法 
	 * @param coupon_refund_count_$n 
	 */
	public void setCoupon_refund_count_$n(Integer coupon_refund_count_$n) {
		this.coupon_refund_count_$n = coupon_refund_count_$n;
	}
	/**
	 * @Description: 属性 coupon_refund_batch_id_$n_$m 的get方法 
	 * @return coupon_refund_batch_id_$n_$m
	 */
	public String getCoupon_refund_batch_id_$n_$m() {
		return coupon_refund_batch_id_$n_$m;
	}
	/**
	 * @Description: 属性 coupon_refund_batch_id_$n_$m 的set方法 
	 * @param coupon_refund_batch_id_$n_$m 
	 */
	public void setCoupon_refund_batch_id_$n_$m(String coupon_refund_batch_id_$n_$m) {
		this.coupon_refund_batch_id_$n_$m = coupon_refund_batch_id_$n_$m;
	}
	/**
	 * @Description: 属性 coupon_refund_id_$n_$m 的get方法 
	 * @return coupon_refund_id_$n_$m
	 */
	public String getCoupon_refund_id_$n_$m() {
		return coupon_refund_id_$n_$m;
	}
	/**
	 * @Description: 属性 coupon_refund_id_$n_$m 的set方法 
	 * @param coupon_refund_id_$n_$m 
	 */
	public void setCoupon_refund_id_$n_$m(String coupon_refund_id_$n_$m) {
		this.coupon_refund_id_$n_$m = coupon_refund_id_$n_$m;
	}
	/**
	 * @Description: 属性 coupon_refund_fee_$n_$m 的get方法 
	 * @return coupon_refund_fee_$n_$m
	 */
	public Integer getCoupon_refund_fee_$n_$m() {
		return coupon_refund_fee_$n_$m;
	}
	/**
	 * @Description: 属性 coupon_refund_fee_$n_$m 的set方法 
	 * @param coupon_refund_fee_$n_$m 
	 */
	public void setCoupon_refund_fee_$n_$m(Integer coupon_refund_fee_$n_$m) {
		this.coupon_refund_fee_$n_$m = coupon_refund_fee_$n_$m;
	}
	/**
	 * @Description: 属性 refund_status_$n 的get方法 
	 * @return refund_status_$n
	 */
	public String getRefund_status_$n() {
		return refund_status_$n;
	}
	/**
	 * @Description: 属性 refund_status_$n 的set方法 
	 * @param refund_status_$n 
	 */
	public void setRefund_status_$n(String refund_status_$n) {
		this.refund_status_$n = refund_status_$n;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-24 下午12:14:28 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "RefundQueryResult [device_info=" + device_info + ", transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no + ", total_fee=" + total_fee
				+ ", fee_type=" + fee_type + ", cash_fee=" + cash_fee + ", refund_count=" + refund_count + ", out_refund_no_$n=" + out_refund_no_$n + ", refund_id_$n="
				+ refund_id_$n + ", refund_channel_$n=" + refund_channel_$n + ", refund_fee_$n=" + refund_fee_$n + ", coupon_refund_fee_$n=" + coupon_refund_fee_$n
				+ ", coupon_refund_count_$n=" + coupon_refund_count_$n + ", coupon_refund_batch_id_$n_$m=" + coupon_refund_batch_id_$n_$m + ", coupon_refund_id_$n_$m="
				+ coupon_refund_id_$n_$m + ", coupon_refund_fee_$n_$m=" + coupon_refund_fee_$n_$m + ", refund_status_$n=" + refund_status_$n + ", return_code=" + return_code
				+ ", return_msg=" + return_msg + ", result_code=" + result_code + ", err_code=" + err_code + ", err_code_des=" + err_code_des + ", appid=" + appid + ", mch_id="
				+ mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign + "]";
	}

	
}
