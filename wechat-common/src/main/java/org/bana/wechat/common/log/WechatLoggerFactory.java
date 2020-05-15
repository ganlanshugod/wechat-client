/**
* @Company 青鸟软通   
* @Title: WechatLogger.java 
* @Package org.bana.wechat.qy.common.log 
* @author Liu Wenjie   
* @date 2015-5-27 下午2:28:15 
* @version V1.0   
*/ 
package org.bana.wechat.common.log;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.common.WechatException;

/** 
 * @ClassName: WechatLogger 
 * @Description: 微信的访问记录日志工具类
 *  
 */
public class WechatLoggerFactory {
	
	private static Class<? extends WechatLogger> cls;
	
	private static Map<String,WechatLogger> cacheMap = new HashMap<String, WechatLogger>();

	/**
	* @Description: 获取一条微信登录记录日志对象
	* @author Liu Wenjie   
	* @date 2015-5-27 下午2:42:17 
	* @return
	 */
	public static WechatLogger getWechatLogger(){
		if(cls != null){
			if(WechatLogger.class.isAssignableFrom(cls)){
				WechatLogger logger = cacheMap.get(cls.getName());
				if(logger == null) {
					try {
						logger = cls.newInstance();
					} catch (Exception e) {
						throw new WechatException(WechatException.LOG_ERROR,"获取日志记录的指定实现类时出现异常!",e);
					}
				}
				return logger;
			}
		}
		return new WechatLogger();
	}

	/**
	 * @Description: 属性 cls 的set方法 
	 * @param cls 
	 */
	public static void setCls(Class<? extends WechatLogger> cls) {
		WechatLoggerFactory.cls = cls;
	}
	
	/**
	 * @Description: 属性 cls 的set方法 
	 * @param cls 
	 */
	public static void setCls(Class<? extends WechatLogger> cls, WechatLogger logger) {
		WechatLoggerFactory.cls = cls;
		cacheMap.put(cls.getName(), logger);
	}
	
}
