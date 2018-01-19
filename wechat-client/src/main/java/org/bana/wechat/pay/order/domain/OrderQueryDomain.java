/**
* @Company 青鸟软通   
* @Title: OrderQueryDomain.java 
* @Package org.bana.wechat.pay.orderquery.domain 
* @author Liu Wenjie   
* @date 2015-9-22 下午8:43:47 
* @version V1.0   
*/ 
package org.bana.wechat.pay.order.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.pay.common.WechatPayResult;

/** 
 * @ClassName: OrderQueryDomain 
 * @Description: 訂單的結果對象 
 *  
 */
@XmlRootElement(name="xml")
public class OrderQueryDomain extends WechatPayResult {

	private String device_info;//设备号  device_info  否  String(32)  013467007045764  微信支付分配的终端设备号，  
	private String openid;//用户标识  openid  是  String(128)  oUpF8uMuAJO_M2pxb1Q9zNjWeS6o  用户在商户appid下的唯一标识  
	private String is_subscribe;//是否关注公众账号  is_subscribe  否  String(1)  Y  用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效  
	private String trade_type;//交易类型  trade_type  是  String(16)  JSAPI  调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY，详细说明见参数规定 
	/*
	 * 交易状态  trade_state  是  String(32) SUCCESS  SUCCESS—支付成功 
	 *	REFUND—转入退款 
	 *	NOTPAY—未支付 
	 *	CLOSED—已关闭 
	 *	REVOKED—已撤销（刷卡支付） 
	 *	USERPAYING--用户支付中 
	 *	PAYERROR--支付失败(其他原因，如银行返回失败)
	*/
	private String trade_state;
	private String bank_type;//付款银行  bank_type  是  String(16)  CMC  银行类型，采用字符串类型的银行标识  
	private Integer total_fee;//总金额  total_fee  是  Int  100  订单总金额，单位为分  
	private String fee_type;//货币种类  fee_type  否  String(8)  CNY  货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型 
	private Integer cash_fee;//现金支付金额  cash_fee  是  Int  100  现金支付金额订单现金支付金额，详见支付金额 
	private String cash_fee_type;//现金支付货币类型  cash_fee_type  否  String(16)  CNY  货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型 
	private Integer coupon_fee;//代金券或立减优惠金额  coupon_fee  否  Int  100 “代金券或立减优惠”金额<=订单总金额，订单总金额-“代金券或立减优惠”金额=现金支付金额，详见支付金额 
	private Integer coupon_count;//代金券或立减优惠使用数量  coupon_count  否  Int  1  代金券或立减优惠使用数量  
	private String coupon_batch_id_;//代金券或立减优惠批次ID  coupon_batch_id_$n  否  String(20)  100  代金券或立减优惠批次ID ,$n为下标，从0开始编号  
	private String coupon_id_$n;//代金券或立减优惠ID  coupon_id_$n  否  String(20)  10000   代金券或立减优惠ID, $n为下标，从0开始编号  
	private Integer coupon_fee_$n;//单个代金券或立减优惠支付金额  coupon_fee_$n  否  Int  100  单个代金券或立减优惠支付金额, $n为下标，从0开始编号  
	private String transaction_id;//微信支付订单号  transaction_id  是  String(32)  1009660380201506130728806387  微信支付订单号  
	private String out_trade_no;//商户订单号  out_trade_no  是  String(32)  20150806125346  商户系统的订单号，与请求一致。  
	private String attach;//附加数据  attach  否  String(128)  深圳分店 附加数据，原样返回  
	private String time_end;//支付完成时间  time_end  是  String(14)  20141030133525  订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则  
	private String trade_state_desc;//交易状态描述  trade_state_desc 是  String(256)  支付失败，请重新下单支付 对当前查询订单状态的描述和下一步操作的指引 
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
	 * @Description: 属性 is_subscribe 的get方法 
	 * @return is_subscribe
	 */
	public String getIs_subscribe() {
		return is_subscribe;
	}
	/**
	 * @Description: 属性 is_subscribe 的set方法 
	 * @param is_subscribe 
	 */
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	/**
	 * @Description: 属性 trade_type 的get方法 
	 * @return trade_type
	 */
	public String getTrade_type() {
		return trade_type;
	}
	/**
	 * @Description: 属性 trade_type 的set方法 
	 * @param trade_type 
	 */
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	/**
	 * @Description: 属性 trade_state 的get方法 
	 * @return trade_state
	 */
	public String getTrade_state() {
		return trade_state;
	}
	/**
	 * @Description: 属性 trade_state 的set方法 
	 * @param trade_state 
	 */
	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}
	/**
	 * @Description: 属性 bank_type 的get方法 
	 * @return bank_type
	 */
	public String getBank_type() {
		return bank_type;
	}
	/**
	 * @Description: 属性 bank_type 的set方法 
	 * @param bank_type 
	 */
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
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
	 * @Description: 属性 cash_fee_type 的get方法 
	 * @return cash_fee_type
	 */
	public String getCash_fee_type() {
		return cash_fee_type;
	}
	/**
	 * @Description: 属性 cash_fee_type 的set方法 
	 * @param cash_fee_type 
	 */
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}
	/**
	 * @Description: 属性 coupon_fee 的get方法 
	 * @return coupon_fee
	 */
	public Integer getCoupon_fee() {
		return coupon_fee;
	}
	/**
	 * @Description: 属性 coupon_fee 的set方法 
	 * @param coupon_fee 
	 */
	public void setCoupon_fee(Integer coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	/**
	 * @Description: 属性 coupon_count 的get方法 
	 * @return coupon_count
	 */
	public Integer getCoupon_count() {
		return coupon_count;
	}
	/**
	 * @Description: 属性 coupon_count 的set方法 
	 * @param coupon_count 
	 */
	public void setCoupon_count(Integer coupon_count) {
		this.coupon_count = coupon_count;
	}
	/**
	 * @Description: 属性 coupon_batch_id_ 的get方法 
	 * @return coupon_batch_id_
	 */
	public String getCoupon_batch_id_() {
		return coupon_batch_id_;
	}
	/**
	 * @Description: 属性 coupon_batch_id_ 的set方法 
	 * @param coupon_batch_id_ 
	 */
	public void setCoupon_batch_id_(String coupon_batch_id_) {
		this.coupon_batch_id_ = coupon_batch_id_;
	}
	/**
	 * @Description: 属性 coupon_id_$n 的get方法 
	 * @return coupon_id_$n
	 */
	public String getCoupon_id_$n() {
		return coupon_id_$n;
	}
	/**
	 * @Description: 属性 coupon_id_$n 的set方法 
	 * @param coupon_id_$n 
	 */
	public void setCoupon_id_$n(String coupon_id_$n) {
		this.coupon_id_$n = coupon_id_$n;
	}
	/**
	 * @Description: 属性 coupon_fee_$n 的get方法 
	 * @return coupon_fee_$n
	 */
	public Integer getCoupon_fee_$n() {
		return coupon_fee_$n;
	}
	/**
	 * @Description: 属性 coupon_fee_$n 的set方法 
	 * @param coupon_fee_$n 
	 */
	public void setCoupon_fee_$n(Integer coupon_fee_$n) {
		this.coupon_fee_$n = coupon_fee_$n;
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
	 * @Description: 属性 attach 的get方法 
	 * @return attach
	 */
	public String getAttach() {
		return attach;
	}
	/**
	 * @Description: 属性 attach 的set方法 
	 * @param attach 
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}
	/**
	 * @Description: 属性 time_end 的get方法 
	 * @return time_end
	 */
	public String getTime_end() {
		return time_end;
	}
	/**
	 * @Description: 属性 time_end 的set方法 
	 * @param time_end 
	 */
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	/**
	 * @Description: 属性 trade_state_desc 的get方法 
	 * @return trade_state_desc
	 */
	public String getTrade_state_desc() {
		return trade_state_desc;
	}
	/**
	 * @Description: 属性 trade_state_desc 的set方法 
	 * @param trade_state_desc 
	 */
	public void setTrade_state_desc(String trade_state_desc) {
		this.trade_state_desc = trade_state_desc;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-22 下午8:53:45 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "OrderQueryDomain [device_info=" + device_info + ", openid=" + openid + ", is_subscribe=" + is_subscribe + ", trade_type=" + trade_type + ", trade_state="
				+ trade_state + ", bank_type=" + bank_type + ", total_fee=" + total_fee + ", fee_type=" + fee_type + ", cash_fee=" + cash_fee + ", cash_fee_type=" + cash_fee_type
				+ ", coupon_fee=" + coupon_fee + ", coupon_count=" + coupon_count + ", coupon_batch_id_=" + coupon_batch_id_ + ", coupon_id_$n=" + coupon_id_$n
				+ ", coupon_fee_$n=" + coupon_fee_$n + ", transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no + ", attach=" + attach + ", time_end=" + time_end
				+ ", trade_state_desc=" + trade_state_desc + ", return_code=" + return_code + ", return_msg=" + return_msg + ", result_code=" + result_code + ", err_code="
				+ err_code + ", err_code_des=" + err_code_des + ", appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign + "]";
	}

}
