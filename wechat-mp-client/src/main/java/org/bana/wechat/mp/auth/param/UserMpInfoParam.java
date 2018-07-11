/**
 * @Company JBINFO
 * @Title: UserMpInfoParam.java
 * @Package org.bana.wechat.mp.auth.param
 * @author Liu Wenjie
 * @date 2018年5月15日 上午10:41:28
 * @version V1.0
 */
package org.bana.wechat.mp.auth.param;

import org.bana.wechat.mp.common.WeChatMpParam;

/**
 * @ClassName: UserMpInfoParam
 * @Description: 
 * @author Liu Wenjie
 */
public class UserMpInfoParam extends WeChatMpParam{

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -8421736300118980369L;

	private String openId;
	
	private String lang; //zh_CN 简体，zh_TW 繁体，en 英语

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
}
