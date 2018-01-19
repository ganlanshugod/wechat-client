/**
* @Company 青鸟软通   
* @Title: OrderQueryParam.java 
* @Package org.bana.wechat.pay.orderquery.param 
* @author Liu Wenjie   
* @date 2015-9-22 下午8:36:31 
* @version V1.0   
*/ 
package org.bana.wechat.pay.order.param;

import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.pay.common.WechatPayParam;

/** 
 * @ClassName: OrderQueryParam 
 * @Description: 查询订单的参数
 *  
 */
@XmlRootElement(name="xml")
public class OrderQueryParam extends WechatPayParam {

	
	private String transaction_id;//微信订单号  transaction_id  二选一 String(32)  1009660380201506130728806387 微信的订单号，优先使用  
	private String out_trade_no;//商户订单号  out_trade_no  String(32) 20150806125346  商户系统内部的订单号，当没提供transaction_id时需要传这个。  
	
	
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
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-22 下午8:37:53 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "OrderQueryParam [appid=" + appid + ", mch_id=" + mch_id + ", transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no + ", nonce_str=" + nonce_str
				+ ", sign=" + sign + "]";
	}

}
