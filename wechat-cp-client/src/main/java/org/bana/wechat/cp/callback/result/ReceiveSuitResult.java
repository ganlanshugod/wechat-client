/**
* @Company 青鸟软通   
* @Title: ReceiveSuitResult.java 
* @Package org.bana.wechat.qy.common 
* @author Liu Wenjie   
* @date 2015-5-13 下午2:32:44 
* @version V1.0   
*/ 
package org.bana.wechat.cp.callback.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @ClassName: ReceiveSuitResult 
 * @Description: 微信回调的返回值结果
 *  
 */
@XmlRootElement(name="xml")
public class ReceiveSuitResult implements Serializable{
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -906959658283195763L;
	protected String suiteId;
	protected String infoType;
	protected Long timeStamp;
	protected String authCorpId;
	private String authCode;
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
	 * @Description: 属性 authCode 的get方法 
	 * @return authCode
	 */
	@XmlElement(name="AuthCode")
	public String getAuthCode() {
		return authCode;
	}
	/**
	 * @Description: 属性 authCode 的set方法 
	 * @param authCode 
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-21 下午10:28:22 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "ReceiveSuitResult [suiteId=" + suiteId + ", infoType=" + infoType + ", timeStamp=" + timeStamp + ", authCorpId=" + authCorpId + ", authCode=" + authCode + "]";
	}

}
