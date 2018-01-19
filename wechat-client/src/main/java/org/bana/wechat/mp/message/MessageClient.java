package org.bana.wechat.mp.message;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.MessageUtil;
import org.bana.wechat.mp.common.MpConstants;
import org.bana.wechat.mp.media.MediaClient;
import org.bana.wechat.mp.media.param.Article;
import org.bana.wechat.mp.media.result.MediaResult;
import org.bana.wechat.mp.media.util.MedicTypeEnum;
import org.bana.wechat.mp.message.param.BaseMessage;
import org.bana.wechat.mp.message.param.BaseMpMessageParam;
import org.bana.wechat.mp.message.param.MediaMessage;
import org.bana.wechat.mp.message.param.MpMessageFilterParam;
import org.bana.wechat.mp.message.param.MpNewsMessageParam;
import org.bana.wechat.mp.message.param.MusicMessage;
import org.bana.wechat.mp.message.param.NewsMessage;
import org.bana.wechat.mp.message.param.TextMessage;
import org.bana.wechat.mp.message.param.VideoMessage;
import org.bana.wechat.mp.message.util.MessageTypeEnum;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: MessageService
 * @Description: 消息处理
 * 
 */
public class MessageClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(MessageClient.class);

	public static Map<String, BaseMessage> bulidMessageMap = new HashMap<String, BaseMessage>();
	public static final int MP_SUBSCRIPTION_REMINDER_COUNT = 1; //订阅号每天数量限制
	public static final int MP_SERVICE_REMINDER_COUNT = 4; //服务号每月数量限制
	public static final boolean IS_TO_ALL = false; //消息是否保存到历史消息中

	static {
		bulidMessageMap.put(MpConstants.RESP_MESSAGE_TYPE_TEXT,
				new TextMessage());
		bulidMessageMap.put(MpConstants.RESP_MESSAGE_TYPE_NEWS,
				new NewsMessage());
		bulidMessageMap.put(MpConstants.RESP_MESSAGE_TYPE_IMAGE,
				new MediaMessage());
		bulidMessageMap.put(MpConstants.RESP_MESSAGE_TYPE_VOICE,
				new MediaMessage());
		bulidMessageMap.put(MpConstants.RESP_MESSAGE_TYPE_VIDEO,
				new VideoMessage());
		bulidMessageMap.put(MpConstants.RESP_MESSAGE_TYPE_MUSIC,
				new MusicMessage());
	}

	/**
	 * 构建基本消息
	 * 
	 * @param requestMap xml请求解析后的map
	 * @param msgType 消息类型
	 * @return BaseMessage 基本消息对象
	 */
	public static Object bulidBaseMessage(Map<String, String> requestMap,
			String msgType) {
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		BaseMessage message = bulidMessageMap.get(msgType);
		message.setToUserName(fromUserName);
		message.setFromUserName(toUserName);
		message.setCreateTime(new Date().getTime());
		message.setMsgType(msgType);
		message.setFuncFlag(0);
		return message;
	}

	/**
	 * 发送消息接口
	 * 
	 * @param obj 消息对象
	 * @param msgType 消息类型
	 * @return 返回xml格式数据给微信
	 */
	public static String bulidSendMessage(Object obj, String msgType) {
		String responseMessage = "";
		// 图文消息处理
		if (msgType == MpConstants.RESP_MESSAGE_TYPE_NEWS) {
			responseMessage = MessageUtil.newsMessageToXml((NewsMessage) obj);
		} else {// 其他消息处理
			responseMessage = MessageUtil.messageToXml(obj);
		}
		return responseMessage;
	}

	
	/******************群发消息*************************************************************************************/
	/** 
	* @Description: 群发图文消息
	* @author Han Tongyang   
	* @date 2016-3-21 下午6:13:10 
	* @param accessToken
	* @param article
	* @param picUrl
	* @return  
	*/ 
	public static String sendMpMessage(String accessToken, Article article, String picUrl, boolean isToAll){
		LOG.info("群发图文消息开始：picUrl=" + picUrl + "|isToAll=" + isToAll + "|article=" + article + "|token=" + accessToken);
		//1、图文消息内的图片，获取URL
		MediaResult picResult = MediaClient.uploadPic(accessToken, MedicTypeEnum.缩略图.getMediaType(), picUrl, Constants.上传媒体文件.getValue(), null);
		//2、上传素材
		article.setThumb_media_id(picResult.getMediaId());
		MediaResult newsResult = MediaClient.uploadNews(accessToken, article);
		//3、发送消息
		BaseMpMessageParam param = initBaseMpMessageParam(accessToken, newsResult, isToAll);
		LOG.info("获取群发图文消息结果：" + param);
		String json = WeChatConnection.post(Constants.群发消息.getValue(), BeanToMapUtil.convertBean(param));
		return json;
	}
	
	/** 
	* @Description: 初始化群发消息参数
	* @author Han Tongyang   
	* @date 2016-3-21 下午7:09:42 
	* @param accessToken
	* @param newsResult
	* @return  
	*/ 
	private static BaseMpMessageParam initBaseMpMessageParam(String accessToken, MediaResult newsResult, boolean isToAll){
		BaseMpMessageParam param = new BaseMpMessageParam();
		param.setAccess_token(accessToken);
		param.setMsgtype(MessageTypeEnum.图文消息.getMessageType());
		
		MpMessageFilterParam filterParam = new MpMessageFilterParam();
		filterParam.setIs_to_all(isToAll);
		param.setFilter(filterParam);
		
		MpNewsMessageParam newsParam = new MpNewsMessageParam();
		newsParam.setMedia_id(newsResult.getMediaId());
		param.setMpnews(newsParam);
		return param;
	}
	
	public static enum CustomMessageType{
		文本("text"),图片("image"),语音("voice"),视频("video"),
		音乐("music"),外链图文("news"),图文("mpnews"),卡券("wxcard");
		private String value;
		private CustomMessageType(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	
	/** 
	* @Description: 客服接口发送
	* @author liuwenjie   
	* @date 2016-6-15 下午4:18:51 
	* @param openId
	* @param type
	* @param messageObject
	* @return  
	*/ 
	public static String customSend(String access_token,String openId,CustomMessageType type,Object messageObject){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(messageObject);
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("access_token", access_token);
		paramMap.put("touser", openId);
		paramMap.put("msgtype", type.getValue());
		paramMap.put(type.getValue(), convertBean);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.客服消息接口.getValue(), paramMap);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
//			String cardId = json.getString("card_id");
			LOG.info("创建成功的卡券id为" + json);
			return "sucess";
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
