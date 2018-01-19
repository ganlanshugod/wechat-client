/**
 * @Company 青鸟软通   
 * @Title: WappDomain.java 
 * @Package org.bana.wechat.wapp.login.domain 
 * @author Yang Shuangshuang   
 * @date 2017年01月04日  14:28:15 
 * @version V1.0   
 */
package org.bana.wechat.wapp.login.domain;

import java.io.Serializable;

/**
 * @ClassName: WappDomain
 * @Description: t_bs_w_app 自动生成的对应的实体对象
 * 
 */
public class WappSession implements Serializable {

	private static final long serialVersionUID = -1483511295053L;

	/**
	 * @Fields openid : 用户唯一标识
	 */
	private String openid;
	/**
	 * @Fields session_key : 会话密钥
	 */
	private String session_key;
	/**
	 * @Fields expires_in : 失效时间
	 */
	private String expires_in;

	/* =========================getter and setter =================== */

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

}
