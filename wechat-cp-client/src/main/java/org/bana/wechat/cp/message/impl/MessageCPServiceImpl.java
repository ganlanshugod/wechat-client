/**
 * @Company JBINFO
 * @Title: MessageCPServiceImpl.java
 * @Package org.bana.wechat.cp.message.impl
 * @author Huang Nana
 * @date 2018年2月6日 下午1:46:15
 * @version V1.0
 */
package org.bana.wechat.cp.message.impl;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.common.WechatCpService;
import org.bana.wechat.cp.message.MessageCPService;
import org.bana.wechat.cp.message.domain.SendResult;
import org.bana.wechat.cp.message.param.MessageParam;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: MessageCPServiceImpl
 * @Description: 微信企业号发消息接口实现
 * @author Huang Nana
 */
public class MessageCPServiceImpl extends WechatCpService implements MessageCPService {

	/**
	 * <p>Description: </p>
	 * @author Huang Nana
	 * @date 2018年2月6日 下午1:46:15
	 * @param createParam
	 * @return
	 * @see org.bana.wechat.cp.message.MessageCPService#create(org.bana.wechat.cp.message.param.MessageParam)
	 */
	@Override
	public SendResult create(MessageParam createParam) {
		JSONObject result = this.post(Constants.发送消息.getValue(), createParam);
		SendResult sendResult = WechatCpResultHandler.handleResult(result, SendResult.class);
		return sendResult;
	}

}
