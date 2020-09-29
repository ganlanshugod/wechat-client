/**
* @Company 全域旅游
* @Title: CallBackHandler.java 
* @Package org.bana.springboot.wechat.mp 
* @author liuwenjie   
* @date Sep 28, 2020 1:25:01 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.callback;

import org.apache.commons.lang3.StringUtils;
import org.bana.wechat.common.MsgType;
import org.bana.wechat.common.util.BeanXmlUtil;
import org.bana.wechat.mp.callback.CallBackHandler;
import org.bana.wechat.mp.callback.CallBackObj;
import org.bana.wechat.mp.callback.event.CallBackEvent;
import org.bana.wechat.mp.callback.msg.CallBackMessage;
import org.bana.wechat.mp.callback.result.ArticleCallBackResult;
import org.bana.wechat.mp.callback.result.CallBackResult;
import org.bana.wechat.mp.message.param.MessageParam;
import org.bana.wechat.mp.message.param.image.ImageMessage;
import org.bana.wechat.mp.message.param.music.MusicMessage;
import org.bana.wechat.mp.message.param.news.NewsMessage;
import org.bana.wechat.mp.message.param.text.TextMessage;
import org.bana.wechat.mp.message.param.video.VideoMessage;
import org.bana.wechat.mp.message.param.voice.VoiceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/** 
* @ClassName: CallBackHandler 
* @Description: 处理消息的回调通知
* @author liuwenjie   
*/
public class BasicCallBackHandler implements CallBackHandler {

	@Autowired
	private WechatMpCallBackHandler wechatMpCallBackHandler;
	
	@Autowired
	private ApplicationContext applicationContext;
	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 28, 2020 1:49:55 PM 
	* @param message
	* @return 
	* @see org.bana.wechat.mp.callback.CallBackHandler#handleCallBackMessage(org.bana.wechat.mp.callback.msg.CallBackMessage) 
	*/ 
	@Override
	public String handleCallBackMessage(CallBackMessage message) {
		MessageParam result = wechatMpCallBackHandler.handleCallBackMessage(message);
		CallBackMessageEvent event = new CallBackMessageEvent(this, message);
		applicationContext.publishEvent(event);
		return parseResut2String(message, result);
	}
	
	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 29, 2020 10:50:49 AM 
	* @param event
	* @return 
	* @see org.bana.wechat.mp.callback.CallBackHandler#handleCallBackEvent(org.bana.wechat.mp.callback.event.CallBackEvent) 
	*/ 
	@Override
	public String handleCallBackEvent(CallBackEvent callBackEvent) {
		MessageParam result = wechatMpCallBackHandler.handleCallBackEvent(callBackEvent);
		CallBackEventEvent callBackEventEvent = new CallBackEventEvent(this,callBackEvent);
		applicationContext.publishEvent(callBackEventEvent);
		return parseResut2String(callBackEvent, result);
	}
	
	private String parseResut2String(CallBackObj callbackObj, MessageParam result) {
		// 构造如下返回结果的对象
		/*<xml>
		  <ToUserName><![CDATA[toUser]]></ToUserName>
		  <FromUserName><![CDATA[fromUser]]></FromUserName>
		  <CreateTime>12345678</CreateTime>
		  <MsgType><![CDATA[text]]></MsgType>
		  <Content><![CDATA[你好]]></Content>
		</xml>*/
		if(result == null) {
			return null;
		}
		CallBackResult callBackResult = null;
		if(result instanceof NewsMessage) {
			ArticleCallBackResult articleResult = new ArticleCallBackResult();
			NewsMessage newsMessage = (NewsMessage)result;
			articleResult.setArticleCount(newsMessage.getArticleCount());
			articleResult.setArticles(newsMessage.getArticles());
			callBackResult = articleResult;
			callBackResult.setMsgType(MsgType.图文.getValue());
		}else {
			callBackResult = new CallBackResult();
			if(result instanceof TextMessage) {
				TextMessage textMessage = (TextMessage)result;
				callBackResult.setResult(textMessage.getContent());
				callBackResult.setMsgType(MsgType.文本.getValue());
			}else if(result instanceof ImageMessage) {
				ImageMessage imgMessage = (ImageMessage)result;
				callBackResult.setResult(imgMessage);
				callBackResult.setMsgType(MsgType.图片.getValue());
			}else if(result instanceof VoiceMessage) {
				VoiceMessage voiceMessage = (VoiceMessage)result;
				callBackResult.setResult(voiceMessage);
				callBackResult.setMsgType(MsgType.语音.getValue());
			}else if(result instanceof VideoMessage ) {
				VideoMessage videoMessage = (VideoMessage)result;
				callBackResult.setResult(videoMessage);
				callBackResult.setMsgType(MsgType.视频.getValue());
			}else if(result instanceof MusicMessage ) {
				MusicMessage musicMessage = (MusicMessage)result;
				callBackResult.setResult(musicMessage);
				callBackResult.setMsgType(MsgType.音乐.getValue());
			}
		}
		if(StringUtils.isNotBlank(callBackResult.getMsgType())) {
			callBackResult.setFromUserName(callbackObj.getAppId());
			callBackResult.setToUserName(callbackObj.getOpenId());
			callBackResult.setCreateTime(System.currentTimeMillis()/1000+"");
			return BeanXmlUtil.beanToXml(callBackResult);
		}
		return null;
	}

}
