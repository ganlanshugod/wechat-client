/**
 * @Company JBINFO
 * @Title: WeChatMpException.java
 * @Package org.bana.wechat.mp.common
 * @author Liu Wenjie
 * @date 2018年5月15日 上午11:32:17
 * @version V1.0
 */
package org.bana.wechat.pay.common;

import org.bana.wechat.common.WechatException;

/**
 * @ClassName: WeChatMpException
 * @Description: 
 * @author Liu Wenjie
 */
public class WeChatPayException extends WechatException {

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -6752711322451315524L;

	public static final String PARAM_ERROR = "WXPAY-001";
	
	// APP
	public static final String APP_PARAM_ERROR1 = "WXPAY-APP-001";
	
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午2:17:07
	 */
	public WeChatPayException() {
		super();
	}


	public WeChatPayException(String code, String message, Throwable t) {
		super(code, message, t);
	}


	public WeChatPayException(String code, String message) {
		super(code, message);
	}
}
