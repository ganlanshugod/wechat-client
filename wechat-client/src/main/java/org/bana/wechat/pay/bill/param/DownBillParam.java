/**
* @Company 青鸟软通   
* @Title: DownBillParam.java 
* @Package org.bana.wechat.pay.bill.param 
* @author Liu Wenjie   
* @date 2015-9-24 下午2:13:57 
* @version V1.0   
*/ 
package org.bana.wechat.pay.bill.param;

import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.pay.common.WechatPayParam;

/** 
 * @ClassName: DownBillParam 
 * @Description: 下载账单的参数
 *  
 */
@XmlRootElement(name="xml")
public class DownBillParam extends WechatPayParam{

	public static final String BILL_TYPE_ALL = "ALL";//返回当日所有订单信息，默认值 
	public static final String BILL_TYPE_SUCCESS = "SUCCESS";//返回当日成功支付的订单 
	public static final String BILL_TYPE_REFUND = "REFUND";//，返回当日退款订单 
	public static final String BILL_TYPE_REVOKED = "REVOKED";//已撤销的订单

	private String bill_date;//对账单日期 bill_date 是 String(8) 20140603 下载对账单的日期，格式：20140603 
	private String bill_type;//账单类型 bill_type 否 String(8) ALL ALL，返回当日所有订单信息，默认值 	SUCCESS，返回当日成功支付的订单 	REFUND，返回当日退款订单REVOKED，已撤销的订单 
	
	/**
	 * @Description: 属性 bill_date 的get方法 
	 * @return bill_date
	 */
	public String getBill_date() {
		return bill_date;
	}
	/**
	 * @Description: 属性 bill_date 的set方法 
	 * @param bill_date 
	 */
	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}
	/**
	 * @Description: 属性 bill_type 的get方法 
	 * @return bill_type
	 */
	public String getBill_type() {
		return bill_type;
	}
	/**
	 * @Description: 属性 bill_type 的set方法 
	 * @param bill_type 
	 */
	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-24 下午2:20:17 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "DownBillParam [bill_date=" + bill_date + ", bill_type=" + bill_type + ", appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign
				+ "]";
	}

}
