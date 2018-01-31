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
	private String secret; //自建类型会有的属性
	private String permanentCode;//第三方授权的应用存在属性
	private String suiteId; //存在的属性
	
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
	public String getPermanentCode() {
		return permanentCode;
	}
	public void setPermanentCode(String permanentCode) {
		this.permanentCode = permanentCode;
	}
	public String getSuiteId() {
		return suiteId;
	}
	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}
	@Override
	public String toString() {
		return "WechatCorpAppConfig [corpId=" + corpId + ", agentId=" + agentId + ", corpAppType=" + corpAppType
				+ ", secret=" + secret + ", permanentCode=" + permanentCode + ", suiteId=" + suiteId + "]";
	}
	
}
