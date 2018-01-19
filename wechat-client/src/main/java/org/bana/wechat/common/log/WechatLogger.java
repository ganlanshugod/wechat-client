/**
* @Company 青鸟软通   
* @Title: WechatLogger.java 
* @Package org.bana.wechat.qy.common.log 
* @author Liu Wenjie   
* @date 2015-5-27 下午2:28:15 
* @version V1.0   
*/ 
package org.bana.wechat.common.log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.bana.common.util.basic.MapRunable;
import org.bana.common.util.exception.ThrowableUtil;
import org.bana.wechat.qy.common.ThreadPoolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/** 
 * @ClassName: WechatLogger 
 * @Description: 微信的访问记录日志工具类
 *  
 */
public class WechatLogger {

	protected static ThreadLocal<WechatLogDomain> wechatLogThreadLocal = new ThreadLocal<WechatLogDomain>();

	private	static ExecutorService pool = ThreadPoolUtil.getThreadPool();
	
	private static final Logger LOG = LoggerFactory.getLogger(WechatLogger.class);
	
	/** 
	* @Description: 保存结束对象
	* @author Liu Wenjie   
	* @date 2015-5-27 下午4:15:19 
	* @param result  
	*/ 
	public void logEnd() {
		WechatLogDomain wechatLogDomain = getWechatLogDomain();
		Date endDate = new Date();
		wechatLogDomain.setEndTime(endDate);
		wechatLogDomain.setEndMillisecond(endDate.getTime());
		Long startMillisecond = wechatLogDomain.getStartMillisecond();
		if(startMillisecond != null ){
			wechatLogDomain.setDuration(endDate.getTime() - startMillisecond);
		}
	}

	/** 
	* @Description: 记录异常信息
	* @author Liu Wenjie   
	* @date 2015-5-27 下午4:15:25 
	* @param e  
	*/ 
	public void logException(Exception e) {
		WechatLogDomain wechatLogDomain = getWechatLogDomain();
		wechatLogDomain.setExceptionClass(e.getClass().toString());
		wechatLogDomain.setExceptionMessage(ThrowableUtil.getStackTrace(e));
	}

	/** 
	* @Description: 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午4:15:29   
	*/ 
	public final void saveLog() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monitorLog", getWechatLogDomain());
		pool.execute(new MapRunable(map) {
			@Override
			public void run() {
				WechatLogDomain logDomain = (WechatLogDomain) map.get("monitorLog");
				doSaveWechatLog(logDomain);
			}
		});
		wechatLogThreadLocal.remove();
	}
	
	/**
	* @Description: 需要具体的子类进行实现
	* @author Liu Wenjie   
	* @date 2015-5-27 下午4:50:31 
	* @param logDomain
	 */
	protected void doSaveWechatLog(WechatLogDomain logDomain){
		LOG.warn("===微信的日志没有保存，只是控制台打印=== " + logDomain);
		LOG.warn("url 地址为 " + logDomain.getWechatUrl());
		LOG.warn("参数为===" + JSON.toJSONString(logDomain.getParamData()));
		LOG.warn("HTTP Status code 为 ===" + logDomain.getStatusCode());
		LOG.warn("返回结果为==" + logDomain.getWechatResult());
	}
	/** 
	* @Description: 记录开始信息
	* @author Liu Wenjie   
	* @date 2015-5-27 下午4:17:31 
	* @param url
	* @param string
	* @param httpPost  
	*/ 
	public void logBegin(String url, String postData ,String method) {
		Date beginDate = new Date();
		WechatLogDomain wechatLogDomain = getWechatLogDomain();
		wechatLogDomain.setStartTime(beginDate);
		wechatLogDomain.setStartMillisecond(beginDate.getTime());
		wechatLogDomain.setWechatUrl(url);
		wechatLogDomain.setParamData(postData);
		wechatLogDomain.setExecuteMethod(method);
	}
	
	/**
	* @Description: 获取日志记录对象
	* @author Liu Wenjie   
	* @date 2015-5-27 下午4:51:08 
	* @return
	 */
	public WechatLogDomain getWechatLogDomain(){
		WechatLogDomain wechatLogDomain = wechatLogThreadLocal.get();
		if(wechatLogDomain == null){
			wechatLogDomain = new WechatLogDomain();
			wechatLogThreadLocal.set(wechatLogDomain);
		}
		return wechatLogDomain;
	}

}
