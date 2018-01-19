/**
* @Company 青鸟软通   
* @Title: RefundClientParam.java 
* @Package org.bana.wechat.pay.refund.param 
* @author Liu Wenjie   
* @date 2015-9-23 下午3:40:05 
* @version V1.0   
*/ 
package org.bana.wechat.pay.refund.param;

import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.pay.common.WechatPayParam;

/** 
 * @ClassName: RefundClientParam 
 * @Description: 申请兑款的 
 *  
 */
@XmlRootElement(name="xml")
public class RefundParam extends WechatPayParam {
	
	private String device_info;//设备号 device_info 否 String(32) 013467007045764 终端设备号 
	private String transaction_id;//微信订单号 transaction_id 二选一 String(28) 1217752501201407033233368018 微信生成的订单号，在支付通知中有返回 
	private String out_trade_no;//商户订单号 out_trade_no String(32) 1217752501201407033233368018 商户侧传给微信的订单号 
	private String out_refund_no;//商户退款单号 out_refund_no 是 String(32) 1217752501201407033233368018 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔 
	private Integer total_fee;//总金额 total_fee 是 Int 100 订单总金额，单位为分，只能为整数，详见支付金额 
	private Integer refund_fee;//退款金额 refund_fee 是 Int 100 退款总金额，订单总金额，单位为分，只能为整数，详见支付金额 
	private String refund_fee_type;//货币种类 refund_fee_type 否 String(8) CNY 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型 
	private String op_user_id;//操作员 op_user_id 是 String(32) 1900000109 操作员帐号, 默认为商户号 
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
	 * @Description: 属性 refund_fee_type 的get方法 
	 * @return refund_fee_type
	 */
	public String getRefund_fee_type() {
		return refund_fee_type;
	}
	/**
	 * @Description: 属性 refund_fee_type 的set方法 
	 * @param refund_fee_type 
	 */
	public void setRefund_fee_type(String refund_fee_type) {
		this.refund_fee_type = refund_fee_type;
	}
	/**
	 * @Description: 属性 op_user_id 的get方法 
	 * @return op_user_id
	 */
	public String getOp_user_id() {
		return op_user_id;
	}
	/**
	 * @Description: 属性 op_user_id 的set方法 
	 * @param op_user_id 
	 */
	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-23 下午3:45:14 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "RefundParam [device_info=" + device_info + ", transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no + ", out_refund_no=" + out_refund_no
				+ ", total_fee=" + total_fee + ", refund_fee=" + refund_fee + ", refund_fee_type=" + refund_fee_type + ", op_user_id=" + op_user_id + ", appid=" + appid
				+ ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign + "]";
	}
	
}
