package org.bana.wechat.common.util;

import java.util.Map;

/** 
 * @ClassName: MapRunable 
 * @Description: 可以传递map参数的执行方法
 *  
 */
public abstract class MapRunable implements Runnable {

	protected Map<String,Object> map;
	
	public MapRunable(Map<String,Object> map){
		this.map = map;
	}
	
}