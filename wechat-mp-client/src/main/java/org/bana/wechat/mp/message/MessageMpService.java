/**
 * @Company Elink
 * @Title: MessageMpService.java
 * @Package org.bana.wechat.mp.message
 * @author Zhang Zhichao
 * @date 2018年9月4日 下午1:46:25
 * @version V1.0
 */
package org.bana.wechat.mp.message;

import org.bana.wechat.mp.message.param.TemplateMessageMpParam;
import org.bana.wechat.mp.message.result.TemplateMessageResult;

/**
 * @ClassName: MessageMpService
 * @Description: 服务号消息
 * @author Zhang Zhichao
 */
public interface MessageMpService {
	
	/**
	 * Description: 发送模板消息
	 * @author Zhang Zhichao
	 * @date 2018年9月4日 下午2:27:00
	 * @param templateParam
	 * @return
	 */
	public TemplateMessageResult sendTemplateMessage(TemplateMessageMpParam templateParam);
}