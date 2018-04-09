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
	private String token; // 自建应用接收消息的token
	private String encodingAeskey; // 自建应用接收消息的encoding_aes_key
	private String permanentCode;//第三方授权的应用存在属性
	private String suiteId; //第三方授权的应用存在的属性
	
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
	/**
	 * @Description: 属性 token 的get方法 
	 * @return token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @Description: 属性 token 的set方法 
	 * @param token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @Description: 属性 encodingAeskey 的get方法 
	 * @return encodingAeskey
	 */
	public String getEncodingAeskey() {
		return encodingAeskey;
	}
	/**
	 * @Description: 属性 encodingAeskey 的set方法 
	 * @param encodingAeskey
	 */
	public void setEncodingAeskey(String encodingAeskey) {
		this.encodingAeskey = encodingAeskey;
	}
	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年4月9日 下午3:02:08
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WechatCorpAppConfig [corpId=" + corpId + ", agentId=" + agentId + ", corpAppType=" + corpAppType
				+ ", secret=" + secret + ", token=" + token + ", encodingAeskey=" + encodingAeskey + ", permanentCode="
				+ permanentCode + ", suiteId=" + suiteId + "]";
	}
	
}
