/**
 * @Company Elink
 * @Title: Code2SessionInfo.java
 * @Package org.bana.wechat.mp.auth.result
 * @author Zhang Zhichao
 * @date 2019年6月3日 下午3:50:18
 * @version V1.0
 */
package org.bana.wechat.mini.token.result;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: Code2SessionInfo
 * @Description: 小程序登陆凭证：session_key
 * @author Zhang Zhichao
 */
public class Code2SessionInfo implements Serializable {

	private static final long serialVersionUID = -8134145069246249206L;
	
	@JSONField(name="openid")
	private String openId;
	@JSONField(name="session_key")
	private String sessionKey;
	private String unionid;
	private String errcode;
	private String errmsg;
	public String getOpenId() {
		return openId;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public String getUnionid() {
		return unionid;
	}
	public String getErrcode() {
		return errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	@Override
	public String toString() {
		return "Code2SessionInfo [openId=" + openId + ", sessionKey=" + sessionKey + ", unionid=" + unionid
				+ ", errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}
}
