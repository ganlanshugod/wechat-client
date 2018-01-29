/**
 * @Company JBINFO
 * @Title: SuiteTokenParam.java
 * @Package org.bana.wechat.cp.token.param
 * @author Liu Wenjie
 * @date 2018年1月26日 下午5:14:43
 * @version V1.0
 */
package org.bana.wechat.cp.token.param;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: SuiteTokenParam
 * @Description: 调用suiteToken的参数
 * @author Liu Wenjie
 * {
    "suite_id":"id_value" ,
    "suite_secret": "secret_value", 
    "suite_ticket": "ticket_value" 
   }
 */
public class SuiteTokenParam implements Serializable{

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 1987263324176511562L;

	@JSONField(name="suite_id")
	private String suiteId;
	@JSONField(name="suite_secret")
	private String suiteSecret;
	@JSONField(name="suite_ticket")
	private String suiteTicket;
	public String getSuiteId() {
		return suiteId;
	}
	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}
	public String getSuiteSecret() {
		return suiteSecret;
	}
	public void setSuiteSecret(String suiteSecret) {
		this.suiteSecret = suiteSecret;
	}
	public String getSuiteTicket() {
		return suiteTicket;
	}
	public void setSuiteTicket(String suiteTicket) {
		this.suiteTicket = suiteTicket;
	}
	@Override
	public String toString() {
		return "SuiteTokenParam [suiteId=" + suiteId + ", suiteSecret=" + suiteSecret + ", suiteTicket=" + suiteTicket
				+ "]";
	}
}
