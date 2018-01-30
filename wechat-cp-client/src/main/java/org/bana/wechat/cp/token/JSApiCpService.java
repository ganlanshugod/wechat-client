/**
 * @Company JBINFO
 * @Title: JSApiTicketService.java
 * @Package org.bana.wechat.cp.token
 * @author Liu Wenjie
 * @date 2018年1月30日 下午3:24:04
 * @version V1.0
 */
package org.bana.wechat.cp.token;

import org.bana.wechat.cp.token.domain.JSSDKCpConfig;
import org.bana.wechat.cp.token.param.JsSdkParam;

/**
 * @ClassName: JSApiTicketService
 * @Description: JsApiTicket对应的service方法
 * @author Liu Wenjie
 */
public interface JSApiCpService {

	/**
	 * Description: JsSkdParam
	 * @author Liu Wenjie
	 * @date 2018年1月30日 下午3:25:22
	 * @param jsSkdParam
	 * @return
	 */
	JSSDKCpConfig getJsSdkConfig(JsSdkParam jsSkdParam);
}
