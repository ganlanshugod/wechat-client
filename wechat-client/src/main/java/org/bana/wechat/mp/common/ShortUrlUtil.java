/**
* @Company 青鸟软通   
* @Title: ShortUrlUtil.java 
* @Package org.bana.wechat.mp.common 
* @author Liu Wenjie   
* @date 2015-10-29 下午4:54:10 
* @version V1.0   
*/ 
package org.bana.wechat.mp.common;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: ShortUrlUtil 
 * @Description: 长连接转短连接的工具方法 
 *  
 */
public class ShortUrlUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(ShortUrlUtil.class);

	/** 
	* @Description: 返回短连接
	* @author Liu Wenjie   
	* @date 2015-10-29 下午4:55:34 
	* @param accessToken
	* @param longUrl
	* @return  
	*/ 
	public static String shortUrl(String accessToken,String longUrl){
		// 转化为Map对象
		Map<String, Object> convertBean = new HashMap<String,Object>();
		convertBean.put("access_token", accessToken);
		convertBean.put("long_url", longUrl);
		convertBean.put("action","long2short");
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.长链接转短链接.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			String shortUrl = json.getString("short_url");
			LOG.info("转化后的短连接为 " + shortUrl);
			return shortUrl;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
