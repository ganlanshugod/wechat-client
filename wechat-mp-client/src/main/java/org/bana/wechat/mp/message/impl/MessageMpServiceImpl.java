/**
 * @Company Elink
 * @Title: MessageMpServiceImpl.java
 * @Package org.bana.wechat.mp.message.impl
 * @author Zhang Zhichao
 * @date 2018年9月4日 下午1:49:57
 * @version V1.0
 */
package org.bana.wechat.mp.message.impl;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.common.WeChatMpParam;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.common.WechatMpService;
import org.bana.wechat.mp.menu.result.MenuMpResult;
import org.bana.wechat.mp.message.MessageMpService;
import org.bana.wechat.mp.message.param.TemplateMessageMpParam;
import org.bana.wechat.mp.message.result.TemplateMessageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: MessageMpServiceImpl
 * @Description: 服务号消息
 * @author Zhang Zhichao
 */
public class MessageMpServiceImpl extends WechatMpService implements MessageMpService {
	private static final Logger LOG = LoggerFactory.getLogger(MessageMpServiceImpl.class);
	
	/**
	* <p>Description: 获取公众号的自动回复规则</p> 
	* @author zhangzhichao   
	* @date Aug 17, 2019 10:25:02 AM 
	* @param appId 
	* @see org.bana.wechat.mp.message.MessageMpService#getAutoReplyInfo(java.lang.String) 
	*/ 
	@Override
	public JSONObject getAutoReplyInfo(String appId) {
		// 非空校验
		if(StringUtils.isBlank(appId)){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"getAutoReplyInfo时参数不能为空,appId=,"+appId);
		}
		WeChatMpParam param = new WeChatMpParam();
		param.setAppId(appId);
		String url = this.addAccessToken(Constants.获取公众号的自动回复规则.getValue(), param);
		JSONObject resultObject = this.getHttpHelper().httpGet(url);
		return resultObject;
	}
	
	/**
	 * <p>Description: 发送模板消息</p>
	 * @author Zhang Zhichao
	 * @date 2018年9月4日 下午2:27:23
	 * @param templateParam
	 * @return
	 * @see org.bana.wechat.mp.message.MessageMpService#sendTemplateMessage(org.bana.wechat.mp.message.param.TemplateMessageMpParam)
	 */
	@Override
	public TemplateMessageResult sendTemplateMessage(TemplateMessageMpParam templateParam) {
		// 非空校验
		if(templateParam == null || StringUtils.isBlank(templateParam.getTouser(),templateParam.getTemplateId())){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"发送模板消息时参数不能为空 param=" + templateParam);
		}
		if(templateParam.getData()==null || templateParam.getData().isEmpty()){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"发送模板消息时模板参数不能为空");
		}
		String url = this.addAccessToken(Constants.模板消息接口.getValue(), templateParam);
		JSONObject resultObject = this.getHttpHelper().httpPost(url, templateParam);
		return WechatMpResultHandler.handleResult(resultObject,TemplateMessageResult.class);
	}
}
