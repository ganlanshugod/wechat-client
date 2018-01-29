/**
 * @Company JBINFO
 * @Title: AuthCorpInfo.java
 * @Package org.bana.wechat.cp.suite.domain
 * @author Zhang Zhichao
 * @date 2018年1月29日 上午11:35:04
 * @version V1.0
 */
package org.bana.wechat.cp.suite.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: AuthCorpInfo
 * @Description: 授权方企业信息
 * @author Zhang Zhichao
 */
public class AuthCorpInfo implements Serializable {

	private static final long serialVersionUID = 2753109545409597443L;
	
	/**
	 * @Fields corpId : 授权方企业微信id
	 */
	@JSONField(name="corpid")
	private String corpId;
	
	/**
	 * @Fields corpName : 授权方企业微信名称
	 */
	@JSONField(name="corp_name")
	private String corpName;
	
	/**
	 * @Fields corpType : 授权方企业微信类型，认证号：verified, 注册号：unverified
	 */
	@JSONField(name="corp_type")
	private String corpType;
	
	/**
	 * @Fields corpSquareLogoUrl : 授权方企业微信方形头像
	 */
	@JSONField(name="corp_square_logo_url")
	private String corpSquareLogoUrl;
	
	/**
	 * @Fields corpUserMax : 授权方企业微信用户规模
	 */
	@JSONField(name="corp_user_max")
	private Integer corpUserMax;
	
	@JSONField(name="corp_agent_max")
	private Integer corpAgentMax;
	
	/**
	 * @Fields corpWxqrcode : 授权方企业微信二维码
	 */
	@JSONField(name="corp_wxqrcode")
	private String corpWxqrcode;
	
	/**
	 * @Fields corpFullName : 所绑定的企业微信主体名称
	 */
	@JSONField(name="corp_full_name")
	private String corpFullName;
	
	/**
	 * @Fields subjectType : 企业类型，1. 企业; 2. 政府以及事业单位; 3. 其他组织, 4.团队号
	 */
	@JSONField(name="subject_type")
	private String subjectType; 
	
	/**
	 * @Fields verifiedEndTime : 认证到期时间,到秒的long值，需要乘以1000转化为当前的毫秒数
	 */
	@JSONField(name="verified_end_time")
	private String verifiedEndTime;

	/**
	 * @Description: 属性 corpId 的get方法 
	 * @return corpId
	 */
	public String getCorpId() {
		return corpId;
	}

	/**
	 * @Description: 属性 corpId 的set方法 
	 * @param corpId
	 */
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	/**
	 * @Description: 属性 corpName 的get方法 
	 * @return corpName
	 */
	public String getCorpName() {
		return corpName;
	}

	/**
	 * @Description: 属性 corpName 的set方法 
	 * @param corpName
	 */
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	/**
	 * @Description: 属性 corpType 的get方法 
	 * @return corpType
	 */
	public String getCorpType() {
		return corpType;
	}

	/**
	 * @Description: 属性 corpType 的set方法 
	 * @param corpType
	 */
	public void setCorpType(String corpType) {
		this.corpType = corpType;
	}

	/**
	 * @Description: 属性 corpSquareLogoUrl 的get方法 
	 * @return corpSquareLogoUrl
	 */
	public String getCorpSquareLogoUrl() {
		return corpSquareLogoUrl;
	}

	/**
	 * @Description: 属性 corpSquareLogoUrl 的set方法 
	 * @param corpSquareLogoUrl
	 */
	public void setCorpSquareLogoUrl(String corpSquareLogoUrl) {
		this.corpSquareLogoUrl = corpSquareLogoUrl;
	}

	/**
	 * @Description: 属性 corpUserMax 的get方法 
	 * @return corpUserMax
	 */
	public Integer getCorpUserMax() {
		return corpUserMax;
	}

	/**
	 * @Description: 属性 corpUserMax 的set方法 
	 * @param corpUserMax
	 */
	public void setCorpUserMax(Integer corpUserMax) {
		this.corpUserMax = corpUserMax;
	}

	/**
	 * @Description: 属性 corpAgentMax 的get方法 
	 * @return corpAgentMax
	 */
	public Integer getCorpAgentMax() {
		return corpAgentMax;
	}

	/**
	 * @Description: 属性 corpAgentMax 的set方法 
	 * @param corpAgentMax
	 */
	public void setCorpAgentMax(Integer corpAgentMax) {
		this.corpAgentMax = corpAgentMax;
	}

	/**
	 * @Description: 属性 corpWxqrcode 的get方法 
	 * @return corpWxqrcode
	 */
	public String getCorpWxqrcode() {
		return corpWxqrcode;
	}

	/**
	 * @Description: 属性 corpWxqrcode 的set方法 
	 * @param corpWxqrcode
	 */
	public void setCorpWxqrcode(String corpWxqrcode) {
		this.corpWxqrcode = corpWxqrcode;
	}

	/**
	 * @Description: 属性 corpFullName 的get方法 
	 * @return corpFullName
	 */
	public String getCorpFullName() {
		return corpFullName;
	}

	/**
	 * @Description: 属性 corpFullName 的set方法 
	 * @param corpFullName
	 */
	public void setCorpFullName(String corpFullName) {
		this.corpFullName = corpFullName;
	}

	/**
	 * @Description: 属性 subjectType 的get方法 
	 * @return subjectType
	 */
	public String getSubjectType() {
		return subjectType;
	}

	/**
	 * @Description: 属性 subjectType 的set方法 
	 * @param subjectType
	 */
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	/**
	 * @Description: 属性 verifiedEndTime 的get方法 
	 * @return verifiedEndTime
	 */
	public String getVerifiedEndTime() {
		return verifiedEndTime;
	}

	/**
	 * @Description: 属性 verifiedEndTime 的set方法 
	 * @param verifiedEndTime
	 */
	public void setVerifiedEndTime(String verifiedEndTime) {
		this.verifiedEndTime = verifiedEndTime;
	}

	/**
	 * <p>Description: </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月29日 上午11:45:14
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthCorpInfo [corpId=" + corpId + ", corpName=" + corpName + ", corpType=" + corpType
				+ ", corpSquareLogoUrl=" + corpSquareLogoUrl + ", corpUserMax=" + corpUserMax + ", corpAgentMax="
				+ corpAgentMax + ", corpWxqrcode=" + corpWxqrcode + ", corpFullName=" + corpFullName + ", subjectType="
				+ subjectType + ", verifiedEndTime=" + verifiedEndTime + "]";
	}
	
}
