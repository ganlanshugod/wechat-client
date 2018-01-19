/**
* @Company 青鸟软通   
* @Title: CardClientTest.java 
* @Package org.bana.wechat.mp.card 
* @author Han Tongyang   
* @date 2015-10-28 下午5:24:57 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.bana.common.util.basic.DateUtil;
import org.bana.wechat.BaseMPTestCase;
import org.bana.wechat.mp.card.CardClient.CodeCreateActionInfo;
import org.bana.wechat.mp.card.param.CardParam;
import org.bana.wechat.mp.card.param.PutOnCardParam;
import org.bana.wechat.mp.card.param.create.avancedinfo.AbstractObject;
import org.bana.wechat.mp.card.param.create.avancedinfo.CreateCardAdvancedInfo;
import org.bana.wechat.mp.card.param.create.baseinfo.CreateCardBaseInfo;
import org.bana.wechat.mp.card.param.create.baseinfo.FixTimeRangeDateInfo;
import org.bana.wechat.mp.card.param.create.baseinfo.Sku;
import org.bana.wechat.mp.card.param.create.baseinfo.SubMerchantInfo;
import org.bana.wechat.mp.card.param.create.gift.CreateGiftCard;
import org.bana.wechat.mp.card.param.create.gift.CreateGiftCardParam;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.media.MediaClient;
import org.bana.wechat.mp.media.result.MediaResult;
import org.bana.wechat.mp.message.MessageClient;
import org.bana.wechat.mp.message.MessageClient.CustomMessageType;
import org.bana.wechat.mp.message.param.CardExt;
import org.bana.wechat.mp.message.param.CardMesseage;
import org.bana.wechat.mp.token.TokenClient;
import org.bana.wechat.qy.connection.domain.ApiTicket;
import org.junit.Test;

import com.qq.weixin.mp.aes.WxCardSign;

/** 
 * @ClassName: CardClientTest 
 * @Description:  
 *  
 */
public class CardClientTest extends BaseMPTestCase{
	
	private String logoUrl = "http://mmbiz.qpic.cn/mmbiz/kaiaAUWqqvf3Wl7qlw3Mic1AibdvS5yAQnhHwQfHknwY4xFbB9E2efic0BQPvJehOAPw5QJOFvuyBib4LrcaS2cmI8g/0";

	@Test
	public void testUploadImg() throws FileNotFoundException{
		FileInputStream inputStream = new FileInputStream("D:/getheadimg2.png");
		MediaResult uploadPic = MediaClient.uploadContentPic(accessToken.getAccess_token(), "image", inputStream);
		System.out.println(uploadPic);
		System.out.println("url=========" + uploadPic.getMediaId());
		//上传后的url为   http://mmbiz.qpic.cn/mmbiz/kaiaAUWqqvf3Wl7qlw3Mic1AibdvS5yAQnhQtR9hRU3rxZLdUo02dgXRZBXPkEK381PZqhY9olYic5ibJwZibn686UOA/0
		//https://mp.weixin.qq.com/merchant/electroniccardmgr?action=update_card_page&cardid=p5gixt4rNId6LSbXOhvkp2gOgSJY&lang=zh_CN&token=1806891709&flag=0&is_sns_card=0
		//趣看立体书亲子票url=========http://mmbiz.qpic.cn/mmbiz/kaiaAUWqqvf3Wl7qlw3Mic1AibdvS5yAQnhlHxRPicUmiaG59LEVJg4PmgfnBeUvsluwfR6AFgkgbTKibSULxr3400Eg/0
		//022.jpg url=========http://mmbiz.qpic.cn/mmbiz/kaiaAUWqqvf3Wl7qlw3Mic1AibdvS5yAQnhHwQfHknwY4xFbB9E2efic0BQPvJehOAPw5QJOFvuyBib4LrcaS2cmI8g/0
		
	}
	
	/** 
	* @Description: 子商户代制---趣看立体书亲子票
	* @author liuwenjie   
	* @date 2016-6-16 下午9:04:53 
	* @return  
	*/ 
	private CreateCardBaseInfo createBaseInfo(){
		CreateCardBaseInfo baseInfo = new CreateCardBaseInfo();
		//必填字段
		baseInfo.setLogo_url(logoUrl);//	是	string(128)	http://mmbiz.qpic.cn/	卡券的商户logo，建议像素为300*300。
		baseInfo.setCode_type(Constants.Code展示类型_二维码.getValue());//	是	string(16)	CODE_TYPE_TEXT	Code展示类型，"CODE_TYPE_TEXT"，文本；"CODE_TYPE_BARCODE"，一维码 ；"CODE_TYPE_QRCODE"，二维码；"CODE_TYPE_ONLY_QRCODE",二维码无code显示；"CODE_TYPE_ONLY_BARCODE",一维码无code显示；
		baseInfo.setBrand_name("青岛田翁文化传媒有限公司");//	是	string（36）	海底捞	商户名字,字数上限为12个汉字。
		baseInfo.setTitle("趣看立体书亲子票");//	是	string（27）	双人套餐100元兑换券	卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
		baseInfo.setSub_title("80元代金券,兑换实体票");//	否	string（54）	鸳鸯锅底+牛肉1份+土豆一份	券名，字数上限为18个汉字。
		baseInfo.setColor("Color080");//	是	string（16）	Color010	券颜色。按色彩规范标注填写Color010-Color100。详情见获取颜色列表接口
		baseInfo.setNotice("请在售票处出示电子票换取纸质票");//	是	string（48）	请出示二维码核销卡券	卡券使用提醒，字数上限为16个汉字。
		baseInfo.setDescription("价值80元代金券一张；	可与其他优惠同享");//	是	string（3072）	不可与其他优惠同享/n如需团购券发票，请向店员提出要求。	卡券使用说明，字数上限为1024个汉字。
		baseInfo.setSku(new Sku(5000));//	是	Json结构	见上述示例。	商品信息。
		FixTimeRangeDateInfo dateInfo = new FixTimeRangeDateInfo();
		long beginLong = DateUtil.formateToDate("2016-06-14").getTime()/1000;
		long endLong = DateUtil.formateToDate("2016-08-31").getTime()/1000;
		dateInfo.setBegin_timestamp(beginLong);
		dateInfo.setEnd_timestamp(endLong);
		baseInfo.setDate_info(dateInfo);// 是	Json结构	见上述示例。	使用日期，有效期的信息。
		
		//非必填字段
		baseInfo.setUse_custom_code(false);//	否	bool	true	是否自定义Code码。填写true或false，默认为false。通常自有优惠码系统的开发者选择自定义Code码，并在卡券投放时带入Code码，详情见是否自定义Code码。
		baseInfo.setBind_openid(true);//	否	bool	true	是否指定用户领取，填写true或false。默认为false。通常指定特殊用户群体投放卡券或防止刷券时选择指定用户领取。
		baseInfo.setService_phone("400943618");//	否	string（24）	40012234	客服电话。
//		baseInfo.setLocation_id_list(location_id_list);//	否	array	1234，2312	门店位置poiid。调用POI门店管理接口获取门店位置poiid。具备线下门店的商户为必填。
		baseInfo.setSource("艾美伴行");//	否	string（36）	大众点评	第三方来源名，例如同程旅游、大众点评。
//		baseInfo.setCustom_url_name("立即使用");//	否	string（15）	立即使用	自定义跳转外链的入口名字。详情见活用自定义入口
//		baseInfo.setCustom_url("");//	否	string（128）	"xxxx.com"	自定义跳转的URL。
//		baseInfo.setCustom_url_sub_title("更多惊喜");//	否	string（18）	更多惊喜	显示在入口右侧的提示语。
//		baseInfo.setPromotion_url_name("");//	否	string（15）	产品介绍	营销场景的自定义入口名称。
//		baseInfo.setPromotion_url(promotion_url);//	否	string（128）	XXXX.com	入口跳转外链的地址链接。
//		baseInfo.setPromotion_url_sub_title(promotion_url_sub_title);//	否	string（18）	卖场大优惠。	显示在营销入口右侧的提示语。
		baseInfo.setGet_limit(20);//	否	int	1	每人可领券的数量限制,不填写默认为50。
		baseInfo.setCan_share(false);//	否	bool	false	卡券领取页面是否可分享。
		baseInfo.setCan_give_friend(false);//
		
		//子商户信息
		SubMerchantInfo subMerchantInfo = new SubMerchantInfo();
		subMerchantInfo.setMerchant_id(404374473);
		baseInfo.setSub_merchant_info(subMerchantInfo);
		return baseInfo;
	}
	
	/** 
	* @Description: 子商户代制---趣看立体书亲子票
	* @author liuwenjie   
	* @date 2016-6-16 下午9:37:10 
	* @return  
	*/ 
	private CreateCardAdvancedInfo createAdvancedInfo() {
		CreateCardAdvancedInfo advanceInfo = new CreateCardAdvancedInfo();
		AbstractObject abstractObject = new AbstractObject();
		abstractObject.setAbstractSummary("趣看立体书的奇幻王国");
		List<String> urlList = new ArrayList<String>();
		urlList.add("http://mmbiz.qpic.cn/mmbiz/kaiaAUWqqvf3lTKOMibPb8qIaEKIq68VMcJ2wBwEltU32cVJXtwl6o8amDcE0ViaU8RHGfB1hgmX4vYz6f9t3MpTw/0");
		abstractObject.setIcon_url_list(urlList);
		advanceInfo.setAbstractObject(abstractObject);
		return advanceInfo;
	}
	
	/** 
	* @Description: 子商户代制---趣看立体书早鸟票
	* @author liuwenjie   
	* @date 2016-6-16 下午9:04:53 
	* @return  
	*/ 
	private CreateCardBaseInfo createBaseInfo2(){
		CreateCardBaseInfo baseInfo = new CreateCardBaseInfo();
		//必填字段
		baseInfo.setLogo_url(logoUrl);//	是	string(128)	http://mmbiz.qpic.cn/	卡券的商户logo，建议像素为300*300。
		baseInfo.setCode_type(Constants.Code展示类型_二维码.getValue());//	是	string(16)	CODE_TYPE_TEXT	Code展示类型，"CODE_TYPE_TEXT"，文本；"CODE_TYPE_BARCODE"，一维码 ；"CODE_TYPE_QRCODE"，二维码；"CODE_TYPE_ONLY_QRCODE",二维码无code显示；"CODE_TYPE_ONLY_BARCODE",一维码无code显示；
		baseInfo.setBrand_name("青岛田翁文化传媒有限公司");//	是	string（36）	海底捞	商户名字,字数上限为12个汉字。
		baseInfo.setTitle("趣看立体书早鸟票");//	是	string（27）	双人套餐100元兑换券	卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
		baseInfo.setSub_title("50元代金券,兑换实体票");//	否	string（54）	鸳鸯锅底+牛肉1份+土豆一份	券名，字数上限为18个汉字。
		baseInfo.setColor("Color080");//	是	string（16）	Color010	券颜色。按色彩规范标注填写Color010-Color100。详情见获取颜色列表接口
		baseInfo.setNotice("请在售票处出示电子票换取纸质票");//	是	string（48）	请出示二维码核销卡券	卡券使用提醒，字数上限为16个汉字。
		baseInfo.setDescription("价值50元代金券一张；	请在售票处出示此电子票，管理人员核销后，换取正式纸质门票。");//	是	string（3072）	不可与其他优惠同享/n如需团购券发票，请向店员提出要求。	卡券使用说明，字数上限为1024个汉字。
		baseInfo.setSku(new Sku(5000));//	是	Json结构	见上述示例。	商品信息。
		FixTimeRangeDateInfo dateInfo = new FixTimeRangeDateInfo();
		long beginLong = DateUtil.formateToDate("2016-06-14").getTime()/1000;
		long endLong = DateUtil.formateToDate("2016-08-31").getTime()/1000;
		dateInfo.setBegin_timestamp(beginLong);
		dateInfo.setEnd_timestamp(endLong);
		baseInfo.setDate_info(dateInfo);// 是	Json结构	见上述示例。	使用日期，有效期的信息。
		
		//非必填字段
		baseInfo.setUse_custom_code(false);//	否	bool	true	是否自定义Code码。填写true或false，默认为false。通常自有优惠码系统的开发者选择自定义Code码，并在卡券投放时带入Code码，详情见是否自定义Code码。
		baseInfo.setBind_openid(true);//	否	bool	true	是否指定用户领取，填写true或false。默认为false。通常指定特殊用户群体投放卡券或防止刷券时选择指定用户领取。
		baseInfo.setService_phone("400943618");//	否	string（24）	40012234	客服电话。
//		baseInfo.setLocation_id_list(location_id_list);//	否	array	1234，2312	门店位置poiid。调用POI门店管理接口获取门店位置poiid。具备线下门店的商户为必填。
		baseInfo.setSource("艾美伴行");//	否	string（36）	大众点评	第三方来源名，例如同程旅游、大众点评。
//		baseInfo.setCustom_url_name("立即使用");//	否	string（15）	立即使用	自定义跳转外链的入口名字。详情见活用自定义入口
//		baseInfo.setCustom_url("");//	否	string（128）	"xxxx.com"	自定义跳转的URL。
//		baseInfo.setCustom_url_sub_title("更多惊喜");//	否	string（18）	更多惊喜	显示在入口右侧的提示语。
//		baseInfo.setPromotion_url_name("");//	否	string（15）	产品介绍	营销场景的自定义入口名称。
//		baseInfo.setPromotion_url(promotion_url);//	否	string（128）	XXXX.com	入口跳转外链的地址链接。
//		baseInfo.setPromotion_url_sub_title(promotion_url_sub_title);//	否	string（18）	卖场大优惠。	显示在营销入口右侧的提示语。
		baseInfo.setGet_limit(20);//	否	int	1	每人可领券的数量限制,不填写默认为50。
		baseInfo.setCan_share(false);//	否	bool	false	卡券领取页面是否可分享。
		baseInfo.setCan_give_friend(false);//
		
		//子商户信息
		SubMerchantInfo subMerchantInfo = new SubMerchantInfo();
		subMerchantInfo.setMerchant_id(404374473);
		baseInfo.setSub_merchant_info(subMerchantInfo);
		return baseInfo;
	}
	
	/** 
	* @Description: 子商户代制---趣看立体书早鸟票
	* @author liuwenjie   
	* @date 2016-6-16 下午9:37:10 
	* @return  
	*/ 
	private CreateCardAdvancedInfo createAdvancedInfo2() {
		CreateCardAdvancedInfo advanceInfo = new CreateCardAdvancedInfo();
		AbstractObject abstractObject = new AbstractObject();
		abstractObject.setAbstractSummary("趣看立体书的奇幻王国");
		List<String> urlList = new ArrayList<String>();
		urlList.add("http://mmbiz.qpic.cn/mmbiz/kaiaAUWqqvf3lTKOMibPb8qIaEKIq68VMcJ2wBwEltU32cVJXtwl6o8amDcE0ViaU8RHGfB1hgmX4vYz6f9t3MpTw/0");
		abstractObject.setIcon_url_list(urlList);
		advanceInfo.setAbstractObject(abstractObject);
		return advanceInfo;
	}
	
	/** 
	* @Description: 子商户代制---趣看立体书亲子票
	* @author liuwenjie   
	* @date 2016-6-16 下午9:34:53   
	*/ 
	@Test
	public void testCreateCard() {
		CreateGiftCardParam giftCardParam = new CreateGiftCardParam();
		giftCardParam.setAccess_token(accessToken.getAccess_token());
		//
		CreateCardBaseInfo baseInfo = createBaseInfo2();
		CreateCardAdvancedInfo advancedInfo = createAdvancedInfo();
		CreateGiftCard gift = new CreateGiftCard();
		gift.setBase_info(baseInfo);
		if(advancedInfo != null){
			gift.setAdvanced_info(advancedInfo.toMap());
		}
		gift.setGift("可领取趣看立体书实体票，领取已核销为准");
		giftCardParam.setGift(gift);
//		Map<String,Object> param = BeanToMapUtil.convertBean(giftCardParam);
//		JSONObject fromObject = JSONObject.fromObject(param);
//		System.out.println(fromObject.toString());
		
		String cardId = CardClient.create(giftCardParam);
		System.out.println(cardId);
		//创建的票id为 ====  p5gixt-6WARIOxgTZoXOD2mM1BLg
		//创建的票id为-===  p5gixt92s5au9tqE5NpJiXGb8mgI
		
		//亲子票 ===     p5gixt2hGqmr1euse7PWvnliNoig
		//早鸟票 ===     p5gixt-E7c_geyRxAMyKurz3Fd44(没有给商户代制)
		
		//早鸟票 ====    p5gixt-7J3VBfMc1F-iZ-85J1zA4（微信后台制造）
		
		//亲子票 80 ==== p5gixt3d1IuXnnOcuzx73tgfenRw
		//早鸟票 50 ==== p5gixt4_g2hwA64cWXbjh0ye0PKc
		
		

	}
	
	@Test
	public void testQrCodeCreate(){
//		AccessToken token = TokenClient.token(grantType, "wx51f3ec8ba8f232fc", "f78caf489598b239c59d12807ec52874");
		PutOnCardParam param = new PutOnCardParam();
		CardParam card = new CardParam();
		card.setCard_id("p5gixt1qQDfOuY2YPYjKi5DPABB0");
		card.setIs_unique_code(false);
		card.setOpenid("o5gixtzPvG78kmxltdHmhWnwfiwc"); //刘文杰
//		card.setOpenid("o5gixt1iegc8Bjqdd9yytlYWD6Ow"); //陈鑫
	
		param.setCard(card);
		System.out.println(CardClient.qrCodeCreate(accessToken.getAccess_token(), param));;
	}
	
	@Test
	public void testQrCodeCreate2(){
//		AccessToken token = TokenClient.token(grantType, "wx51f3ec8ba8f232fc", "f78caf489598b239c59d12807ec52874");
		PutOnCardParam param = new PutOnCardParam();
		CardParam card = new CardParam();
		card.setCard_id("p5gixt92s5au9tqE5NpJiXGb8mgI");
		card.setIs_unique_code(true);
		card.setOpenid("o5gixtzPvG78kmxltdHmhWnwfiwc"); //刘文杰
//		card.setOpenid("o5gixt1iegc8Bjqdd9yytlYWD6Ow"); //陈鑫
	
		param.setCard(card);
		System.out.println(CardClient.qrCodeCreate(accessToken.getAccess_token(), CodeCreateActionInfo.领取单张卡券二维码,null,param));;
	}
	
	@Test
	public void testQrCodeMutiCreate(){
//		AccessToken token = TokenClient.token(grantType, "wx51f3ec8ba8f232fc", "f78caf489598b239c59d12807ec52874");
		CardParam card = new CardParam();
		card.setCard_id("p5gixt92s5au9tqE5NpJiXGb8mgI");
		card.setIs_unique_code(true);
		card.setOpenid("o5gixtzPvG78kmxltdHmhWnwfiwc"); //刘文杰
//		card.setOpenid("o5gixt1iegc8Bjqdd9yytlYWD6Ow"); //陈鑫
		CardParam card2 = new CardParam();
		card2.setCard_id("p5gixt-6WARIOxgTZoXOD2mM1BLg");
		card2.setIs_unique_code(true);
		card2.setOpenid("o5gixtzPvG78kmxltdHmhWnwfiwc"); //刘文杰
		List<CardParam> cardList = new ArrayList<CardParam>();
		cardList.add(card);
		cardList.add(card2);
		System.out.println(CardClient.qrCodeCreate(accessToken.getAccess_token(), CodeCreateActionInfo.领取多张卡券二维码,1800,cardList));;
	}
	
	@Test
	public void testWxCardTicket(){
		ApiTicket ticket = TokenClient.getTicket(accessToken.getAccess_token(), "wx_card");
		System.out.println(ticket); 
		//WxCardTicket = ticket=
		//E0o2-at6NcC2OsJiQTlwlDCR7_NUszHIvg4dtX3sT7dWGxyqwUTYGQgBsF95D6wG_kz1xuiCjRYle9j2Cq7dSg
	}
	
	@Test
	public void testJSONObject(){
		//亲子票 80 ==== p5gixt3d1IuXnnOcuzx73tgfenRw
		//早鸟票 50 ==== p5gixt4_g2hwA64cWXbjh0ye0PKc
		String cardId = "{"+
		    "\"$趣看立体书的奇幻王国:$亲子家庭票\": \"p5gixt2hGqmr1euse7PWvnliNoig\","+
		    "\"$趣看立体书的奇幻王国:$早鸟亲子票\": \"p5gixt2hGqmr1euse7PWvnliNoig\","+
		    "\"$趣看立体书的奇幻王国:$早鸟特权票\": \"p5gixt-E7c_geyRxAMyKurz3Fd44\","+
		    "\"$趣看立体书的奇幻王国:$正式票（1大1小）\": \"p5gixt-E7c_geyRxAMyKurz3Fd44\""+
		"}";
		
		JSONObject cardIdJson = JSONObject.fromObject(cardId);
		String sku = "$趣看立体书的奇幻王国:$早鸟亲子票";
		cardId = cardIdJson.getString(sku);
		System.out.println(cardId);
	}
	
	@Test
	public void testCardKfMessageSend(){
		//构造signature
//		String code = "jonyqin_1434008071";
		int timestamp = (int)new Date().getTime()/1000;
		String card_id = "p5gixt-6WARIOxgTZoXOD2mM1BLg";
		String api_ticket = "E0o2-at6NcC2OsJiQTlwlDCR7_NUszHIvg4dtX3sT7dWGxyqwUTYGQgBsF95D6wG_kz1xuiCjRYle9j2Cq7dSg";
		String nonce_str = "jonyqin";
		WxCardSign signer = new WxCardSign();
		signer.AddData(timestamp);
		signer.AddData(card_id);
		signer.AddData(api_ticket);
//		signer.AddData(code);
		signer.AddData(nonce_str);
		String signature = signer.GetSignature();
		//消息内容那个
		String openid = "o5gixtzPvG78kmxltdHmhWnwfiwc"; //刘文杰
//		String openid = "o5gixt1iegc8Bjqdd9yytlYWD6Ow"; //陈鑫
//		String openid = "o5gixt2fYWJMXa1c6K2OZsxpGVx8";//刘景军
		CardMesseage messageObject = new CardMesseage();
		CardExt ext = new CardExt();
		JSONObject extJson = JSONObject.fromObject(ext);
//		ext.setCode(code);
		ext.setOpenid(openid);
		ext.setSignature(signature);
		ext.setTimestamp(timestamp);
		messageObject.setCard_id(card_id);
		messageObject.setCard_ext(extJson.toString());
		String result = MessageClient.customSend(accessToken.getAccess_token(), openid, CustomMessageType.卡券, messageObject);
		System.out.println(result);
	}
}
