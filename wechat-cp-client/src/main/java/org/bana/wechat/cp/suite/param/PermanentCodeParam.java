/**
 * @Company JBINFO
 * @Title: PermanentCodeParam.java
 * @Package org.bana.wechat.cp.suite.param
 * @author Zhang Zhichao
 * @date 2018年1月29日 下午1:20:07
 * @version V1.0
 */
package org.bana.wechat.cp.suite.param;

import org.bana.wechat.cp.common.WeChatCPSuiteParam;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: PermanentCodeParam
 * @Description: 获取永久授权码参数
 * @author Zhang Zhichao
 */
public class PermanentCodeParam extends WeChatCPSuiteParam {

	private static final long serialVersionUID = 55486392249321065L;
	
	/**
	 * @Fields authCode : 临时授权码
	 */
	@JSONField(name="auth_code")
	private String authCode;

	/**
	 * @Description: 属性 authCode 的get方法 
	 * @return authCode
	 */
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * @Description: 属性 authCode 的set方法 
	 * @param authCode
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
}
