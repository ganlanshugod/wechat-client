/**
 * @Company JBINFO
 * @Title: UserCpInfoParam.java
 * @Package org.bana.wechat.cp.oauth.impl
 * @author Liu Wenjie
 * @date 2018年1月31日 下午5:48:55
 * @version V1.0
 */
package org.bana.wechat.cp.oauth.param;

import org.bana.wechat.cp.common.WeChatCPParam;

/**
 * @ClassName: UserCpInfoParam
 * @Description: 
 * @author Liu Wenjie
 */
public class UserCpInfoParam extends WeChatCPParam {

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -4489462963308663737L;
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "UserCpInfoParam [code=" + code + ", corpId=" + corpId + ", agentId=" + agentId + "]";
	}

	
}
