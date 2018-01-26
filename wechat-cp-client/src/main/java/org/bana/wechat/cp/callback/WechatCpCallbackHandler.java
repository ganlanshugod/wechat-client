/**
 * @Company JBINFO
 * @Title: WechatCpCallbackHandler.java
 * @Package org.bana.wechat.cp.callback
 * @author Liu Wenjie
 * @date 2018年1月25日 下午7:09:37
 * @version V1.0
 */
package org.bana.wechat.cp.callback;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: WechatCpCallbackHandler
 * @Description: 微信企业号回调信息的处理类
 * @author Liu Wenjie
 */
public interface WechatCpCallbackHandler {

	/**
	 * Description: 处理套件回调消息内容
	 * @author Liu Wenjie
	 * @date 2018年1月25日 下午7:34:01
	 * @param suiteId
	 * @param msg
	 * @return
	 */
	String handleSuiteMessage(String suiteId,HttpServletRequest request);
}
