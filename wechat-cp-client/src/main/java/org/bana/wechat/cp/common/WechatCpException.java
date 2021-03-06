/**
 * @Company JBINFO
 * @Title: WechatCpException.java
 * @Package org.bana.wechat.common
 * @author Liu Wenjie
 * @date 2018年1月19日 上午10:37:06
 * @version V1.0
 */
package org.bana.wechat.cp.common;

import org.bana.wechat.common.WechatException;

/**
 * @ClassName: WechatCpException
 * @Description: 企业号的异常信息
 * @author Liu Wenjie
 */
public class WechatCpException extends WechatException {
	
	public static final String PARAM_ERROR = "CP-001";
	
	public static final String CALLBACK_NO_SUITE = "CB_001";
	public static final String CALLBACK_NO_SUITE_CONFIG = "CB_002";
	public static final String CALLBACK_GETPOST = "CB_003";
	public static final String CALLBACK_HandleException = "CB_005";
	public static final String CALLBACK_ParseTypeException = "CB_006";
	
	public static final String APP_PARAM_ERROR1 = "CP-a001";
	public static final String APP_PARAM_ERROR2 = "CP-a002";
	public static final String APP_PARAM_ERROR3 = "CP-a003";
	public static final String JSSKD_ERROR1="js-001";
	public static final String SUITE_PARAM_ERROR1 = "CP-s001";
	public static final String SUITE_PARAM_ERROR2 = "CP-s002";
	public static final String SUITE_PARAM_ERROR3 = "CP-s002";
	
	public static final String CALLBACK_NO_CORPID = "CC_001";
	public static final String CALLBACK_NO_AGENTID = "CC_002";
	public static final String CALLBACK_NO_APP_CONFIG = "CC_003";

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -4242079934972703448L;

	
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午2:17:07
	 */
	public WechatCpException() {
		super();
	}


	public WechatCpException(String code, String message, Throwable t) {
		super(code, message, t);
	}


	public WechatCpException(String code, String message) {
		super(code, message);
	}
	
}
