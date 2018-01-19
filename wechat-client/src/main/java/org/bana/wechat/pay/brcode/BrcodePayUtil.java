/**
* @Company 青鸟软通   
* @Title: BrcodePayUtil.java 
* @Package org.bana.wechat.pay.common 
* @author Liu Wenjie   
* @date 2015-9-29 下午3:46:40 
* @version V1.0   
*/ 
package org.bana.wechat.pay.brcode;

import java.util.HashMap;
import java.util.Map;

import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.pay.common.Constants;
import org.bana.wechat.qy.common.BanaWeChatException;

/** 
 * @ClassName: BrcodePayUtil 
 * @Description: 二维码支付的链接url方法
 *  
 */
public class BrcodePayUtil {
	
	/** 
	* @Description: brcode二维码url的获取方法
	* @author Liu Wenjie   
	* @date 2015-9-29 下午3:47:54 
	* @param param
	* @return  
	*/ 
	public static String getBrCodeUrl(BrcodeParam param){
		if(param == null){
			throw new BanaWeChatException(BanaWeChatException.PAY_ERROR_CODE,"获取brCodeUrl的参数为空");
		}
		Map<String,String> context = new HashMap<String, String>();
		context.put("appid", param.getAppid());
		context.put("mch_id", param.getMch_id());
		context.put("nonce_str", param.getNonce_str());
		context.put("product_id", param.getProduct_id());
		context.put("time_stamp", param.getTime_stamp());
		context.put("sign", param.getSign());
		return StringUtils.replaceAll(Constants.微信二维码字符串.getValue(), context);
	}
}
