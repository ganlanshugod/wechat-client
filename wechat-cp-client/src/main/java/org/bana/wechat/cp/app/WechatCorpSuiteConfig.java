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
 * @Description: 配置企业微信的套件信息
 * @author Zhang Zhichao
 */
public class WechatCorpSuiteConfig {

	private String suiteId;
	private String suiteSecret;
	private String suiteTicket;
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
