package org.bana.wechat.mp.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: WechatResultHandler
 * @Description: 微信结构handler对象
 * @author Liu Wenjie
 */
public class WechatMpResultHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(WechatMpResultHandler.class);

	/**
	 * Description: handle json对象的返回值为需要返回的对象
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午2:35:55
	 * @param result
	 * @param cls
	 * @return
	 */
	public static <T> T handleResult(JSONObject result,Class<T> cls){
		if(isSuccess(result)){
			return JSON.parseObject(result.toJSONString(), cls);
		}else{
			String errcode = result.getString(Constants.返回码.getValue());
			String errmsg = result.getString(Constants.返回信息.getValue());
			throw new WeChatMpException(errcode, errmsg);
		}
	}
	
	/**
	 * Description: 根据key值返回list列表
	 * @author Zhang Zhichao
	 * @date 2018年2月1日 下午2:02:25
	 * @param result
	 * @param cls
	 * @param key
	 * @return
	 */
	public static <T> List<T> handleResult(JSONObject result,Class<T> cls,String key){
		if(isSuccess(result)){
			String keyObjectString = "{}";
			Object keyObject = result.get(key);
			if(keyObject!=null){
				keyObjectString = keyObject.toString();
			}
			List<T> arrayList = JSON.parseArray(keyObjectString,cls);
			return arrayList;
		}else{
			String errcode = result.getString(Constants.返回码.getValue());
			String errmsg = result.getString(Constants.返回信息.getValue());
			throw new WeChatMpException(errcode, errmsg);
		}
	}
	
	/**
	 * Description: handle json对象的返回值为需要返回的对象
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午2:35:55
	 * @param result
	 * @param cls
	 * @return
	 */
	public static void handleResult(JSONObject result){
		if(isSuccess(result)){
			LOG.info("===执行成功");
		}else{
			String errcode = result.getString(Constants.返回码.getValue());
			String errmsg = result.getString(Constants.返回信息.getValue());
			throw new WeChatMpException(errcode, errmsg);
		}
	}
	
	/** 
	* @Description: 根据微信返回码,判断是否访问成功的方法
	* @author Liu Wenjie   
	* @date 2015-5-15 下午8:18:45 
	* @param json
	* @return  
	*/ 
	public static boolean isSuccess(JSONObject json){
		try {
			String errcode = json.getString(Constants.返回码.getValue());
			return errcode == null || isSuccess(errcode);
		} catch (RuntimeException e) {
			LOG.info("没有返回码，认为执行成功",e.getMessage());
			return true;
		}
	}
	
	/**
	* @Description: 根据微信返回码,判断是否访问成功的方法
	* @author Liu Wenjie   
	* @date 2015-5-9 下午6:12:28 
	* @param errorCode
	 */
	public static boolean isSuccess(String errorCode){
		return Constants.成功码.getValue().equalsIgnoreCase(errorCode);
	}
}
