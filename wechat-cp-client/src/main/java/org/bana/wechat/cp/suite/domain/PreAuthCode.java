/**
 * @Company JBINFO
 * @Title: PreAuthCode.java
 * @Package org.bana.wechat.cp.suite.domain
 * @author Zhang Zhichao
 * @date 2018年1月30日 下午5:34:14
 * @version V1.0
 */
package org.bana.wechat.cp.suite.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: PreAuthCode
 * @Description: 预授权码对象
 * @author Zhang Zhichao
 */
public class PreAuthCode implements Serializable {

	private static final long serialVersionUID = -7451744322575368561L;
	
	@JSONField(name="pre_auth_code")
	private String preAuthCode;
	@JSONField(name="expires_in")
	private Integer expiresIn;
	/**
	 * @Description: 属性 preAuthCode 的get方法 
	 * @return preAuthCode
	 */
	public String getPreAuthCode() {
		return preAuthCode;
	}
	/**
	 * @Description: 属性 preAuthCode 的set方法 
	 * @param preAuthCode
	 */
	public void setPreAuthCode(String preAuthCode) {
		this.preAuthCode = preAuthCode;
	}
	/**
	 * @Description: 属性 expiresIn 的get方法 
	 * @return expiresIn
	 */
	public Integer getExpiresIn() {
		return expiresIn;
	}
	/**
	 * @Description: 属性 expiresIn 的set方法 
	 * @param expiresIn
	 */
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月30日 下午5:47:58
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PreAuthCode [preAuthCode=" + preAuthCode + ", expiresIn=" + expiresIn + "]";
	}
	
}
