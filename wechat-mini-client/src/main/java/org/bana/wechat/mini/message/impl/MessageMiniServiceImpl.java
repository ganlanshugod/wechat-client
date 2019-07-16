/**
* @Company Elink   
* @Title: MessageMiniServiceImpl.java 
* @Package org.bana.wechat.mini.message.impl 
* @author zhangzhichao   
* @date Jul 15, 2019 2:46:25 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mini.message.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mini.common.Constants;
import org.bana.wechat.mini.common.WeChatMiniException;
import org.bana.wechat.mini.common.WechatMiniResultHandler;
import org.bana.wechat.mini.message.MessageMiniService;
import org.bana.wechat.mini.message.result.MsgCheckResult;

import com.alibaba.fastjson.JSONObject;

/** 
* @ClassName: MessageMiniServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhangzhichao   
*/
public class MessageMiniServiceImpl implements MessageMiniService {

	/**
	* <p>Description: </p> 
	* @author zhangzhichao   
	* @date Jul 15, 2019 2:46:25 PM 
	* @param accessToken
	* @param content
	* @return 
	* @see org.bana.wechat.mini.message.MessageMiniService#checkMsgSec(java.lang.String, java.lang.String) 
	*/
	@Override
	public MsgCheckResult checkMsgSec(String accessToken, String content) {
		if(StringUtils.isBlank(accessToken,content)){
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR,"checkMsgSec时参数不能为空 accessToken=" + accessToken + ",content=" + content);
		}
		HttpHelper httpHelper = new HttpHelper();
		Map<String,String> param = new HashMap<String,String>();
		param.put("content", content);
		String url = Constants.内容安全文本.getValue()+"?access_token="+accessToken;
		JSONObject resultObject = httpHelper.httpPost(url, param);
		return WechatMiniResultHandler.handleResult(resultObject,MsgCheckResult.class);
	}
	/**
	* <p>Description: </p> 
	* @author zhangzhichao   
	* @date Jul 16, 2019 9:07:56 AM 
	* @param accessToken
	* @param imgUrl
	* @return 
	* @see org.bana.wechat.mini.message.MessageMiniService#checkImgSec(java.lang.String, java.lang.String) 
	*/ 
	@Override
	public MsgCheckResult checkImgSec(String accessToken, String imgUrl) {
		if(StringUtils.isBlank(accessToken,imgUrl)){
			throw new WeChatMiniException(WeChatMiniException.PARAM_ERROR,"checkImgSec时参数不能为空 accessToken=" + accessToken + ",imgUrl=" + imgUrl);
		}
		return null;
	}

}