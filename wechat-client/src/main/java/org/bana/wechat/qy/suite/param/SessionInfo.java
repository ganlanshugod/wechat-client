/**
* @Company 青鸟软通   
* @Title: SessionInfo.java 
* @Package org.bana.wechat.qy.suite.param 
* @author Liu Wenjie   
* @date 2016-1-8 上午10:54:51 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.param;

import java.util.List;

/** 
 * @ClassName: SessionInfo 
 * @Description: 设置sessionINfo对象
 *  
 */
public class SessionInfo {

	/** 
	* @Fields appid : 本次允许授权的应用列表 允许进行授权的应用id，如1、2、3
	*/ 
	private List<Integer> appid;//	是	允许进行授权的应用id，如1、2、3

	/**
	 * @Description: 属性 appid 的get方法 
	 * @return appid
	 */
	public List<Integer> getAppid() {
		return appid;
	}

	/**
	 * @Description: 属性 appid 的set方法 
	 * @param appid 
	 */
	public void setAppid(List<Integer> appid) {
		this.appid = appid;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2016-1-8 上午10:56:58 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "SessionInfo [appid=" + appid + "]";
	}
	
	
}
