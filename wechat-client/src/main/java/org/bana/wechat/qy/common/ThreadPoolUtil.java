/**
* @Company 青鸟软通   
* @Title: ThreadPoolUtil.java 
* @Package com.jbinfo.i3618.common 
* @author Guo Yuchao   
* @date 2015-4-27 下午9:47:42 
* @version V1.0   
*/ 
package org.bana.wechat.qy.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @ClassName: ThreadPoolUtil 
 * @Description: 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
 *  
 */
public class ThreadPoolUtil {
	private static ExecutorService POOL = Executors.newFixedThreadPool(100);
	
	/** 
	* @Description: 获取线程池
	* @author Guo Yuchao   
	* @date 2015-4-27 下午9:50:11 
	* @return  
	*/ 
	public static ExecutorService getThreadPool(){
		return POOL;
	}
}
