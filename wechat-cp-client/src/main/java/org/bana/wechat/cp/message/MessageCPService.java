/**
 * @Company JBINFO
 * @Title: MessageCPService.java
 * @Package org.bana.wechat.cp.message
 * @author Huang Nana
 * @date 2018年2月6日 下午1:39:23
 * @version V1.0
 */
package org.bana.wechat.cp.message;

import org.bana.wechat.cp.message.domain.SendResult;
import org.bana.wechat.cp.message.param.MessageParam;

/**
 * @ClassName: MessageCPService
 * @Description: 微信企业号的message
 * @author Huang Nana
 */
public interface MessageCPService {

	/**
	 * Description: 发送消息
	 * @author Huang Nana
	 * @date 2018年2月6日 下午1:41:55
	 * @param createParam
	 */
	public SendResult create(MessageParam createParam);
}
