/**
* @Company 青鸟软通   
* @Title: ContactSyncResult.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author R.Core  
* @date 2016-4-19 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @ClassName: ContactSyncResult 
 * @Description: 微信回调的返回值结果对象
 * <xml><SuiteId><![CDATA[tj161090b557a68202]]></SuiteId>
	<Seq>56</Seq>
	<InfoType><![CDATA[contact_sync]]></InfoType>
	<TimeStamp>1461050718</TimeStamp>
	<AuthCorpId><![CDATA[wx9a29840ff7f00ffc]]></AuthCorpId>
	</xml>
 *  
 */
@XmlRootElement(name="xml")
public class ContactSyncResult implements Serializable{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 2567559801968336408L;
	
	private String suiteId;
	private String infoType;
	private String authCorpId;
	private Long timeStamp;
	private int seq;
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
	 * @Description: 属性 seq 的get方法 
	 * @return seq
	 */
	@XmlElement(name="Seq")
	public int getSeq() {
		return seq;
	}
	/**
	 * @Description: 属性 seq 的set方法 
	 * @param seq 
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-4-19 下午5:02:21 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "ContactSyncResult [suiteId=" + suiteId + ", infoType="
				+ infoType + ", authCorpId=" + authCorpId + ", timeStamp="
				+ timeStamp + ", seq=" + seq + "]";
	}
}
