/**
* @Company 青鸟软通   
* @Title: WechatPayResult.java 
* @Package org.bana.wechat.pay.common 
* @author Liu Wenjie   
* @date 2015-9-17 下午7:07:05 
* @version V1.0   
*/ 
package org.bana.wechat.pay.common;


/** 
 * @ClassName: WechatPayResult 
 * @Description: 统一的微信支付返回值结果参数
 *  
 */
public class WechatPayResult {
	/**
	 * SUCCESS/FAIL
	此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	 */
	protected String return_code ; //返回状态码	return_code	是	String(16)	SUCCESS	
	
	/**
	 * 返回信息，如非空，为错误原因
		签名失败
		参数格式校验错误
	 */
	protected String return_msg;//返回信息	return_msg	否	String(128)	签名失败	
	
	
	protected String result_code;//业务结果	result_code	是	String(16)	SUCCESS	SUCCESS/FAIL
	protected String err_code;//错误代码	err_code	否	String(32)	SYSTEMERROR	详细参见第6节错误列表
	protected String err_code_des;//错误代码描述	err_code_des	否	String(128)	系统错误	错误返回的信息描述

	protected String appid;//公众账号ID	appid	是	String(32)	wx8888888888888888	调用接口提交的公众账号ID
	protected String mch_id;//商户号	mch_id	是	String(32)	1900000109	调用接口提交的商户号
	protected String nonce_str;//随机字符串	nonce_str	是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	微信返回的随机字符串
	protected String sign;//签名	sign	是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	微信返回的签名，详见签名算法

	/**
	 * @Description: 属性 appid 的get方法 
	 * @return appid
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * @Description: 属性 appid 的set方法 
	 * @param appid 
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * @Description: 属性 mch_id 的get方法 
	 * @return mch_id
	 */
	public String getMch_id() {
		return mch_id;
	}
	/**
	 * @Description: 属性 mch_id 的set方法 
	 * @param mch_id 
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	/**
	 * @Description: 属性 nonce_str 的get方法 
	 * @return nonce_str
	 */
	public String getNonce_str() {
		return nonce_str;
	}
	/**
	 * @Description: 属性 nonce_str 的set方法 
	 * @param nonce_str 
	 */
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	/**
	 * @Description: 属性 sign 的get方法 
	 * @return sign
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * @Description: 属性 sign 的set方法 
	 * @param sign 
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * @Description: 属性 return_code 的get方法 
	 * @return return_code
	 */
	public String getReturn_code() {
		return return_code;
	}

	/**
	 * @Description: 属性 return_code 的set方法 
	 * @param return_code 
	 */
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	/**
	 * @Description: 属性 return_msg 的get方法 
	 * @return return_msg
	 */
	public String getReturn_msg() {
		return return_msg;
	}

	/**
	 * @Description: 属性 return_msg 的set方法 
	 * @param return_msg 
	 */
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	
	/**
	 * @Description: 属性 result_code 的get方法 
	 * @return result_code
	 */
	public String getResult_code() {
		return result_code;
	}
	/**
	 * @Description: 属性 result_code 的set方法 
	 * @param result_code 
	 */
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	/**
	 * @Description: 属性 err_code 的get方法 
	 * @return err_code
	 */
	public String getErr_code() {
		return err_code;
	}
	/**
	 * @Description: 属性 err_code 的set方法 
	 * @param err_code 
	 */
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	/**
	 * @Description: 属性 err_code_des 的get方法 
	 * @return err_code_des
	 */
	public String getErr_code_des() {
		return err_code_des;
	}
	/**
	 * @Description: 属性 err_code_des 的set方法 
	 * @param err_code_des 
	 */
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-22 下午8:41:15 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "WechatPayResult [return_code=" + return_code + ", return_msg=" + return_msg + ", result_code=" + result_code + ", err_code=" + err_code + ", err_code_des="
				+ err_code_des + "]";
	}

}
