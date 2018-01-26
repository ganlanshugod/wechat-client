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
	
	private String suiteToken;
	
	private String encodingAesKey;
	
	private String suiteSecret;
	

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

	public String getSuiteId() {
		return suiteId;
	}

	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}

	public String getSuiteToken() {
		return suiteToken;
	}

	public void setSuiteToken(String suiteToken) {
		this.suiteToken = suiteToken;
	}

	public String getEncodingAesKey() {
		return encodingAesKey;
	}

	public void setEncodingAesKey(String encodingAesKey) {
		this.encodingAesKey = encodingAesKey;
	}

	public String getSuiteSecret() {
		return suiteSecret;
	}

	public void setSuiteSecret(String suiteSecret) {
		this.suiteSecret = suiteSecret;
	}
	
}
