/**
* @Company 青鸟软通   
* @Title: CardClient.java 
* @Package org.bana.wechat.mp.card 
* @author Han Tongyang   
* @date 2015-10-28 下午4:47:16 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.mp.card.domain.QrCodeCreateDomain;
import org.bana.wechat.mp.card.param.CardParam;
import org.bana.wechat.mp.card.param.PutOnCardParam;
import org.bana.wechat.mp.card.param.create.CreateCardParam;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/** 
 * @ClassName: CardClient 
 * @Description: 服务号卡券
 *  
 */
public class CardClient {
	private static final Logger LOG = LoggerFactory.getLogger(CardClient.class);
	
	/** 
	* @Description: 创建卡券
	* @author liuwenjie   
	* @date 2016-6-15 上午11:42:40 
	* @param createParam
	* @return  返回的是卡券的id
	*/ 
	public static String create(CreateCardParam createParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(createParam);
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("access_token", convertBean.get("access_token"));
		convertBean.remove("access_token");
		paramMap.put("card", convertBean);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.创建卡券.getValue(), paramMap);
		// 将结果进行转换
		JSON parse = (JSON)JSON.parse(result);
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			String cardId = json.getString("card_id");
			LOG.info("创建成功的卡券id为" + cardId);
			return cardId;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	/** 
	* @Description: 卡券投放-生成二维码
	* @author Han Tongyang   
	* @date 2015-10-28 下午5:12:18 
	* @param token
	* @return  
	*/ 
	public static QrCodeCreateDomain qrCodeCreate(String token, PutOnCardParam putOnCard){
		if(StringUtils.isBlank(token)){
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"卡券投放-生成二维码时token参数不能为空");
		}
		Map<String,Object> mapParam = new HashMap<String, Object>();
		mapParam.put("access_token", token);
		mapParam.put("action_name", "QR_CARD");
		if(putOnCard.getCard().getExpire_seconds() != null){
			mapParam.put("expire_seconds", putOnCard.getCard().getExpire_seconds());
		}
		mapParam.put("action_info", putOnCard);
		String result = WeChatConnection.post(Constants.投放卡券_生成二维码.getValue(), mapParam);
		JSONObject json = JSONObject.fromObject(result);
		
		if (WeChatConnection.isSuccess(json)) {
			QrCodeCreateDomain domain = (QrCodeCreateDomain)JSONObject.toBean(json, QrCodeCreateDomain.class);
			LOG.info("转化后的生成二维码为 " + domain);
			return domain;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	public static enum CodeCreateActionInfo{
		领取单张卡券二维码("QR_CARD"),领取多张卡券二维码("QR_MULTIPLE_CARD");
		private String value ;
		private CodeCreateActionInfo(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	/** 
	* @Description: 卡券投放-生成二维码
	* @author Han Tongyang   
	* @date 2015-10-28 下午5:12:18 
	* @param token
	* @return  
	*/ 
	public static QrCodeCreateDomain qrCodeCreate(String token, CodeCreateActionInfo action,Integer expire_seconds,Object cardParam){
		if(StringUtils.isBlank(token)){
			throw new BanaWeChatException(BanaWeChatException.BUSINESS_CODE,"卡券投放-生成二维码时token参数不能为空");
		}
		Map<String,Object> mapParam = new HashMap<String, Object>();
		mapParam.put("access_token", token);
		if(expire_seconds != null){
			mapParam.put("expire_seconds", expire_seconds);
		}
		mapParam.put("action_name", action.getValue());
		if(CodeCreateActionInfo.领取多张卡券二维码.equals(action)){
			List<CardParam> card_list = (List<CardParam>)cardParam;
			Map<String,Object> multiple_card = new HashMap<String,Object>();
			multiple_card.put("card_list", card_list);
			Map<String,Object> action_info = new HashMap<String,Object>();
			action_info.put("multiple_card", multiple_card);
			mapParam.put("action_info", action_info);
		}else{
			mapParam.put("action_info", cardParam);
		}
		String result = WeChatConnection.post(Constants.投放卡券_生成二维码.getValue(), mapParam);
		JSONObject json = JSONObject.fromObject(result);
		
		if (WeChatConnection.isSuccess(json)) {
			QrCodeCreateDomain domain = (QrCodeCreateDomain)JSONObject.toBean(json, QrCodeCreateDomain.class);
			LOG.info("转化后的生成二维码为 " + domain);
			return domain;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
//	public boolean update(){
//		https://api.weixin.qq.com/card/update?access_token=TOKEN
//	}
	
	
	
}
