/**
 * @Company JBINFO
 * @Title: WeChatMPParam.java
 * @Package org.bana.wechat.mp.common
 * @author Liu Wenjie
 * @date 2018年5月15日 上午10:42:39
 * @version V1.0
 */
package org.bana.wechat.mini.common;

import java.io.Serializable;

/**
 * @ClassName: WeChatMiniParam
 * @Description: 小程序的通用参数
 * @author Liu Wenjie
 */
public class WeChatMiniParam implements Serializable{
	
	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -2583859515574939716L;
	private String appId;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	@Override
	public String toString() {
		return "WeChatMiniParam [appId=" + appId + "]";
	}
	
}
