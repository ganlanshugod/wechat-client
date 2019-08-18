/**
 * @Company Elink
 * @Title: MessageMpService.java
 * @Package org.bana.wechat.mp.message
 * @author Zhang Zhichao
 * @date 2018年9月4日 下午1:46:25
 * @version V1.0
 */
package org.bana.wechat.mp.message;

import org.bana.wechat.mp.message.param.CustomMsgMpParam;
import org.bana.wechat.mp.message.param.MaterialPageParam;
import org.bana.wechat.mp.message.param.TemplateMessageMpParam;
import org.bana.wechat.mp.message.result.TemplateMessageResult;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: MessageMpService
 * @Description: 服务号消息
 * @author Zhang Zhichao
 */
public interface MessageMpService {
	
	/** 
	* @Description: 获取公众号的自动回复规则
	* @author zhangzhichao   
	* @date 2019-08-17 10:24:37 
	* @param appId  
	*/ 
	public JSONObject getAutoReplyInfo(String appId);
	
	/** 
	* @Description: 获取素材列表
	* @author zhangzhichao   
	* @date 2019-08-18 13:53:07 
	* @param param
	* @return  
	*/ 
	public JSONObject getMaterialPage(MaterialPageParam param);
	
	/** 
	* @Description: 发送客服消息
	* @author zhangzhichao   
	* @date 2019-08-18 16:27:35 
	* @param param  
	*/ 
	public void sendCustomMsg(CustomMsgMpParam sendParam);
	
	/**
	 * Description: 发送模板消息
	 * @author Zhang Zhichao
	 * @date 2018年9月4日 下午2:27:00
	 * @param templateParam
	 * @return
	 */
	public TemplateMessageResult sendTemplateMessage(TemplateMessageMpParam templateParam);
}
