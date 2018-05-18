/**
 * @Company JBINFO
 * @Title: JsApiTicketService.java
 * @Package org.bana.wechat.cp.token
 * @author Liu Wenjie
 * @date 2018年1月31日 下午12:01:32
 * @version V1.0
 */
package org.bana.wechat.mp.token;

/**
 * @ClassName: JsApiTicketService
 * @Description: JsApiTicketService的处理接口
 * @author Liu Wenjie
 */
public interface JsApiTicketMpService {

	/**
	 * Description: 根据企业微信的corpId和agentId获取对应的jsApiTicket
	 * @author Liu Wenjie
	 * @date 2018年1月30日 下午3:38:33
	 * @param corpId
	 * @param agentId
	 * @return
	 */
	String getJsApiTicket(String appId);
}
