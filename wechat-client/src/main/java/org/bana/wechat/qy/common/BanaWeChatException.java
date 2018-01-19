/**
* @Company 青鸟软通   
* @Title: BanaWeChatException.java 
* @Package org.bana.wechat.qy.common 
* @author Liu Wenjie   
* @date 2015-5-9 下午3:40:54 
* @version V1.0   
*/ 
package org.bana.wechat.qy.common;

import org.bana.core.exception.BanaWeChatAndDingtalkException;

/** 
 * @ClassName: BanaWeChatException 
 * @Description: 微信客户端的统一异常封装类
 *  
 */
public class BanaWeChatException extends BanaWeChatAndDingtalkException{
	
	public static final String BUSINESS_CODE = "BWC001";
	public static final String SYSTEM_CODE = "BWS001";
	public static final String PAY_ERROR_CODE = "BWP001";
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 9115318424397040623L;

	private String errorCode;
	
	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2014-9-3 下午2:15:38  
	 */
	public BanaWeChatException() {
	}

	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2014-9-3 下午2:15:38 
	 * @param arg0 
	 */
	public BanaWeChatException(String errorCode ,String msg) {
		super(errorCode, msg);
		this.errorCode = errorCode;
	}

	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2014-9-3 下午2:15:38 
	 * @param arg0 
	 */
	public BanaWeChatException(Throwable e) {
		super(e);
	}

	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2014-9-3 下午2:15:38 
	 * @param arg0
	 * @param arg1 
	 */
	public BanaWeChatException(String errorCode,String msg, Throwable e) {
		super(errorCode, msg, e);
	}

	/**
	 * @Description: 属性 errorCode 的get方法 
	 * @return errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @Description: 属性 errorCode 的set方法 
	 * @param errorCode 
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
