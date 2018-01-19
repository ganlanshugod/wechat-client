/**
* @Company 青鸟软通   
* @Title: CloseOrderParam.java 
* @Package org.bana.wechat.pay.order.param 
* @author Liu Wenjie   
* @date 2015-9-22 下午9:18:00 
* @version V1.0   
*/ 
package org.bana.wechat.pay.order.param;

import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.pay.common.WechatPayParam;

/** 
 * @ClassName: CloseOrderParam 
 * @Description: payParam 
 *  
 */
@XmlRootElement(name="xml")
public class CloseOrderParam extends WechatPayParam {

	private String out_trade_no;//商户订单号 out_trade_no 是 String(32) 1217752501201407033233368018 商户系统内部的订单号 

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
	* @date 2015-9-22 下午9:19:05 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CloseOrderParam [out_trade_no=" + out_trade_no + ", nonce_str=" + nonce_str + ", sign=" + sign + "]";
	}
	
}
