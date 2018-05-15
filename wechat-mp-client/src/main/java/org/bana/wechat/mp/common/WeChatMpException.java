/**
 * @Company JBINFO
 * @Title: WeChatMpException.java
 * @Package org.bana.wechat.mp.common
 * @author Liu Wenjie
 * @date 2018年5月15日 上午11:32:17
 * @version V1.0
 */
package org.bana.wechat.mp.common;

import org.bana.wechat.common.WechatException;

/**
 * @ClassName: WeChatMpException
 * @Description: 
 * @author Liu Wenjie
 */
public class WeChatMpException extends WechatException {

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -6752711322451315524L;

	public static final String PARAM_ERROR = "MP-001";
	
	// APP
	public static final String APP_PARAM_ERROR1 = "MP-APP-001";
	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午2:17:07
	 */
	public WeChatMpException() {
		super();
	}


	public WeChatMpException(String code, String message, Throwable t) {
		super(code, message, t);
	}


	public WeChatMpException(String code, String message) {
		super(code, message);
	}
}
