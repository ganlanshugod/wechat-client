/**
 * @Company JBINFO
 * @Title: CorpTokenParam.java
 * @Package org.bana.wechat.cp.token.param
 * @author Liu Wenjie
 * @date 2018年1月31日 下午12:10:46
 * @version V1.0
 */
package org.bana.wechat.cp.token.param;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: CorpTokenParam
 * @Description: corpTokenParam
 * @author Liu Wenjie
 */
public class CorpTokenParam implements Serializable{

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -6989521316658628247L;
	
	@JSONField(name="auth_corpid")
	private String authCorpId;
	
	@JSONField(name="permanent_code")
    private String permanentCode;
    
    
	public String getAuthCorpId() {
		return authCorpId;
	}
	public void setAuthCorpId(String authCorpId) {
		this.authCorpId = authCorpId;
	}
	public String getPermanentCode() {
		return permanentCode;
	}
	public void setPermanentCode(String permanentCode) {
		this.permanentCode = permanentCode;
	}
	@Override
	public String toString() {
		return "CorpTokenParam [authCorpId=" + authCorpId + ", permanentCode=" + permanentCode + "]";
	}
	
}
