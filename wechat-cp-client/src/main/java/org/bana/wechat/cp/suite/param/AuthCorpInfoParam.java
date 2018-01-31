/**
 * @Company JBINFO
 * @Title: AuthCorpInfoParam.java
 * @Package org.bana.wechat.cp.suite.param
 * @author Zhang Zhichao
 * @date 2018年1月31日 上午10:55:55
 * @version V1.0
 */
package org.bana.wechat.cp.suite.param;

import org.bana.wechat.cp.common.WeChatCPSuiteParam;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: AuthCorpInfoParam
 * @Description: 获取企业授权信息
 * @author Zhang Zhichao
 */
public class AuthCorpInfoParam extends WeChatCPSuiteParam {

	private static final long serialVersionUID = 3249531329163919389L;
	
	/**
	 * @Fields authCorpId : 企业号corpID
	 */
	@JSONField(name="auth_corpid")
	private String authCorpId;
	/**
	 * @Fields permanentCode : 永久授权码
	 */
	@JSONField(name="permanent_code")
	private String permanentCode;
	/**
	 * @Description: 属性 authCorpId 的get方法 
	 * @return authCorpId
	 */
	public String getAuthCorpId() {
		return authCorpId;
	}
	/**
	 * @Description: 属性 authCorpId 的set方法 
	 * @param authCorpId
	 */
	public void setAuthCorpId(String authCorpId) {
		this.authCorpId = authCorpId;
	}
	/**
	 * @Description: 属性 permanentCode 的get方法 
	 * @return permanentCode
	 */
	public String getPermanentCode() {
		return permanentCode;
	}
	/**
	 * @Description: 属性 permanentCode 的set方法 
	 * @param permanentCode
	 */
	public void setPermanentCode(String permanentCode) {
		this.permanentCode = permanentCode;
	}
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月31日 上午10:59:09
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthCorpInfoParam [authCorpId=" + authCorpId + ", permanentCode=" + permanentCode + "]";
	}
	
}
