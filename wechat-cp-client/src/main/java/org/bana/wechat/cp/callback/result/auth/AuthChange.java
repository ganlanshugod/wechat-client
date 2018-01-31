/**
 * @Company JBINFO
 * @Title: AuthChange.java
 * @Package org.bana.wechat.cp.callback.result.auth
 * @author Zhang Zhichao
 * @date 2018年1月31日 上午9:32:25
 * @version V1.0
 */
package org.bana.wechat.cp.callback.result.auth;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: AuthChange
 * @Description: 微信第三方应用，授权变更、删除消息
 * @author Zhang Zhichao
 */
@XmlRootElement(name="xml")
public class AuthChange implements Serializable {

	private static final long serialVersionUID = -9006868351176499455L;
	
	private String suiteId;
	private String infoType;
	private Long timeStamp;
	private String authCorpId;
	/**
	 * @Description: 属性 suiteId 的get方法 
	 * @return suiteId
	 */
	@XmlElement(name="SuiteId")
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
	 * @Description: 属性 infoType 的get方法 
	 * @return infoType
	 */
	@XmlElement(name="InfoType")
	public String getInfoType() {
		return infoType;
	}
	/**
	 * @Description: 属性 infoType 的set方法 
	 * @param infoType
	 */
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	/**
	 * @Description: 属性 timeStamp 的get方法 
	 * @return timeStamp
	 */
	@XmlElement(name="TimeStamp")
	public Long getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @Description: 属性 timeStamp 的set方法 
	 * @param timeStamp
	 */
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @Description: 属性 authCorpId 的get方法 
	 * @return authCorpId
	 */
	@XmlElement(name="AuthCorpId")
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
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月31日 上午10:09:02
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthChange [suiteId=" + suiteId + ", infoType=" + infoType + ", timeStamp=" + timeStamp
				+ ", authCorpId=" + authCorpId + "]";
	}
	
}
