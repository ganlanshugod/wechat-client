/**
 * @Company JBINFO
 * @Title: WechatCpProperties.java
 * @Package org.bana.springboot.wechat.cp
 * @author Liu Wenjie
 * @date 2018年1月22日 上午10:06:28
 * @version V1.0
 */
package org.bana.springboot.wechat.cp;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: WechatCpProperties
 * @Description: 微信的配置项
 * @author Liu Wenjie
 */
@ConfigurationProperties(prefix=WechatCpProperties.WECHAT_CP_PREFIX)
public class WechatCpProperties {

	public static final String WECHAT_CP_PREFIX = "wechat.cp";
	
	private String corpId;
	
	private String secret;
	
	private String agentId;
	
	private String suiteId;
	
	private String suiteSecret;
	
	private String suiteTicket;

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
	 * @Description: 属性 suiteId 的get方法 
	 * @return suiteId
	 */
	public String getSuiteId() {
		return suiteId;
	}

	/**
	 * @Description: 属性 suiteId 的set方法 
	 * @param suiteId
	 */
	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}

	/**
	 * @Description: 属性 suiteSecret 的get方法 
	 * @return suiteSecret
	 */
	public String getSuiteSecret() {
		return suiteSecret;
	}

	/**
	 * @Description: 属性 suiteSecret 的set方法 
	 * @param suiteSecret
	 */
	public void setSuiteSecret(String suiteSecret) {
		this.suiteSecret = suiteSecret;
	}

	/**
	 * @Description: 属性 suiteTicket 的get方法 
	 * @return suiteTicket
	 */
	public String getSuiteTicket() {
		return suiteTicket;
	}

	/**
	 * @Description: 属性 suiteTicket 的set方法 
	 * @param suiteTicket
	 */
	public void setSuiteTicket(String suiteTicket) {
		this.suiteTicket = suiteTicket;
	}
	
}
