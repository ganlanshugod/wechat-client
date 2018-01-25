/**
 * @Company JBINFO
 * @Title: WechatCorpConfig.java
 * @Package org.bana.wechat.cp.common
 * @author Liu Wenjie
 * @date 2018年1月19日 下午2:40:07
 * @version V1.0
 */
package org.bana.wechat.cp.app;

/**
 * @ClassName: WechatCorpConfig
 * @Description: 配置微信企业号的配置信息
 * @author Liu Wenjie
 */
public class WechatCorpAppConfig {

	private String corpId;
	private String agentId;
	private CorpAppType corpAppType; 
	private String secret;
	
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	public CorpAppType getCorpAppType() {
		return corpAppType;
	}
	public void setCorpAppType(CorpAppType corpAppType) {
		this.corpAppType = corpAppType;
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
	
}
