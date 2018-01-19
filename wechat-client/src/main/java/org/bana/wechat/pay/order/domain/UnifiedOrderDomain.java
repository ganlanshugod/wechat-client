/**
* @Company 青鸟软通   
* @Title: UnifiedOrderDomain.java 
* @Package org.bana.wechat.pay.unifiedorder.domain 
* @author Liu Wenjie   
* @date 2015-9-17 下午5:38:58 
* @version V1.0   
*/ 
package org.bana.wechat.pay.order.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.pay.common.WechatPayResult;

/** 
 * @ClassName: UnifiedOrderDomain 
 * @Description: 统一下单的接口
 *  
 */
@XmlRootElement(name="xml")
public class UnifiedOrderDomain extends WechatPayResult{

	
	private String device_info;//设备号	device_info	否	String(32)	013467007045764	调用接口提交的终端设备号，

	//以下字段在return_code 和result_code都为SUCCESS的时候有返回
	private String trade_type;//交易类型	trade_type	是	String(16)	JSAPI	调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，详细说明见参数规定
	private String prepay_id;//预支付交易会话标识	prepay_id	是	String(64)	wx201410272009395522657a690389285100	微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
	private String code_url;//二维码链接	code_url	否	String(64)	URl：weixin：//wxpay/s/An4baqw	trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
	
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
	 * @Description: 属性 prepay_id 的get方法 
	 * @return prepay_id
	 */
	public String getPrepay_id() {
		return prepay_id;
	}
	/**
	 * @Description: 属性 prepay_id 的set方法 
	 * @param prepay_id 
	 */
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	/**
	 * @Description: 属性 code_url 的get方法 
	 * @return code_url
	 */
	public String getCode_url() {
		return code_url;
	}
	/**
	 * @Description: 属性 code_url 的set方法 
	 * @param code_url 
	 */
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-17 下午7:38:50 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "UnifiedOrderDomain [appid=" + appid + ", mch_id=" + mch_id + ", device_info=" + device_info + ", nonce_str=" + nonce_str + ", sign=" + sign + ", result_code="
				+ result_code + ", err_code=" + err_code + ", err_code_des=" + err_code_des + ", trade_type=" + trade_type + ", prepay_id=" + prepay_id + ", code_url=" + code_url
				+ ", return_code=" + return_code + ", return_msg=" + return_msg + "]";
	}
	
}
