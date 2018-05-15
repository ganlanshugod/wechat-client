/**
 * @Company JBINFO
 * @Title: WeChatMPParam.java
 * @Package org.bana.wechat.mp.common
 * @author Liu Wenjie
 * @date 2018年5月15日 上午10:42:39
 * @version V1.0
 */
package org.bana.wechat.mp.common;

import java.io.Serializable;

/**
 * @ClassName: WeChatMPParam
 * @Description: 服务号的通用参数
 * @author Liu Wenjie
 */
public class WeChatMpParam implements Serializable{

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -3568410719417107194L;

	private String appId;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	@Override
	public String toString() {
		return "WeChatMpParam [appId=" + appId + "]";
	}
	
}
