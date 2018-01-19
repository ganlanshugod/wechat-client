/**
* @Company 青鸟软通   
* @Title: MessageClient.java 
* @Package org.bana.wechat.qy.message 
* @author Liu Wenjie   
* @date 2015-5-27 下午8:56:44 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message;

import java.util.Map;

import net.sf.json.JSONObject;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.Constants;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.message.domain.SendResult;
import org.bana.wechat.qy.message.param.MessageParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: MessageClient 
 * @Description: 消息客户端接口
 *  
 */
public class MessageClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(MessageClient.class);

	/** 
	* @Description: 发送消息的测试方法
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:02:06 
	* @param message
	* @return  
	*/ 
	public static SendResult send(MessageParam message){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(message);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.发送消息.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		String errcode = json.getString(Constants.返回码.getValue());
		if (WeChatConnection.isSuccess(errcode)) {
			SendResult bean = (SendResult)JSONObject.toBean(json, SendResult.class);
			LOG.info("发送消息后的返回值 为  " + bean);
			return bean;
		} else {
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
