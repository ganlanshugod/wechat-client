/**
* @Company 青鸟软通   
* @Title: AuthCorpInfo.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 下午12:00:02 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

/** 
 * @ClassName: AuthCorpInfo 
 * @Description: 授权方企业信息
 *  
 */
public class AuthCorpInfo {

	private String corpid;
	private String corp_name;
	private String corp_type;
	private String corp_round_logo_url;
	private String corp_square_logo_url;
	private Integer corp_user_max;
	private Integer corp_agent_max;
	private String corp_wxqrcode;
	
	//since 2017-04-25
	private String corp_full_name;
	//since 2017-04-25
	private String subject_type; //企业类型，1. 企业; 2. 政府以及事业单位; 3. 其他组织, 4.团队号
	//since 2017-04-25
	private String verified_end_time; //认证到期时间,到秒的long值，需要乘以1000转化为当前的毫秒数
	
	
	
	/**
	 * @Description: 属性 corpid 的get方法 
	 * @return corpid
	 */
	public String getCorpid() {
		return corpid;
	}
	/**
	 * @Description: 属性 corpid 的set方法 
	 * @param corpid 
	 */
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}
	/**
	 * @Description: 属性 corp_name 的get方法 
	 * @return corp_name
	 */
	public String getCorp_name() {
		return corp_name;
	}
	/**
	 * @Description: 属性 corp_name 的set方法 
	 * @param corp_name 
	 */
	public void setCorp_name(String corp_name) {
		this.corp_name = corp_name;
	}
	/**
	 * @Description: 属性 corp_type 的get方法 
	 * @return corp_type
	 */
	public String getCorp_type() {
		return corp_type;
	}
	/**
	 * @Description: 属性 corp_type 的set方法 
	 * @param corp_type 
	 */
	public void setCorp_type(String corp_type) {
		this.corp_type = corp_type;
	}
	/**
	 * @Description: 属性 corp_round_logo_url 的get方法 
	 * @return corp_round_logo_url
	 */
	public String getCorp_round_logo_url() {
		return corp_round_logo_url;
	}
	/**
	 * @Description: 属性 corp_round_logo_url 的set方法 
	 * @param corp_round_logo_url 
	 */
	public void setCorp_round_logo_url(String corp_round_logo_url) {
		this.corp_round_logo_url = corp_round_logo_url;
	}
	/**
	 * @Description: 属性 corp_square_logo_url 的get方法 
	 * @return corp_square_logo_url
	 */
	public String getCorp_square_logo_url() {
		return corp_square_logo_url;
	}
	/**
	 * @Description: 属性 corp_square_logo_url 的set方法 
	 * @param corp_square_logo_url 
	 */
	public void setCorp_square_logo_url(String corp_square_logo_url) {
		this.corp_square_logo_url = corp_square_logo_url;
	}
	/**
	 * @Description: 属性 corp_user_max 的get方法 
	 * @return corp_user_max
	 */
	public Integer getCorp_user_max() {
		return corp_user_max;
	}
	/**
	 * @Description: 属性 corp_user_max 的set方法 
	 * @param corp_user_max 
	 */
	public void setCorp_user_max(Integer corp_user_max) {
		this.corp_user_max = corp_user_max;
	}
	/**
	 * @Description: 属性 corp_agent_max 的get方法 
	 * @return corp_agent_max
	 */
	public Integer getCorp_agent_max() {
		return corp_agent_max;
	}
	/**
	 * @Description: 属性 corp_agent_max 的set方法 
	 * @param corp_agent_max 
	 */
	public void setCorp_agent_max(Integer corp_agent_max) {
		this.corp_agent_max = corp_agent_max;
	}
	/**
	 * @Description: 属性 corp_wxqrcode 的get方法 
	 * @return corp_wxqrcode
	 */
	public String getCorp_wxqrcode() {
		return corp_wxqrcode;
	}
	/**
	 * @Description: 属性 corp_wxqrcode 的set方法 
	 * @param corp_wxqrcode 
	 */
	public void setCorp_wxqrcode(String corp_wxqrcode) {
		this.corp_wxqrcode = corp_wxqrcode;
	}
	
	public String getCorp_full_name() {
		return corp_full_name;
	}
	public void setCorp_full_name(String corp_full_name) {
		this.corp_full_name = corp_full_name;
	}
	public String getSubject_type() {
		return subject_type;
	}
	public void setSubject_type(String subject_type) {
		this.subject_type = subject_type;
	}
	public String getVerified_end_time() {
		return verified_end_time;
	}
	public void setVerified_end_time(String verified_end_time) {
		this.verified_end_time = verified_end_time;
	}
	@Override
	public String toString() {
		return "AuthCorpInfo [corpid=" + corpid + ", corp_name=" + corp_name + ", corp_type=" + corp_type
				+ ", corp_round_logo_url=" + corp_round_logo_url + ", corp_square_logo_url=" + corp_square_logo_url
				+ ", corp_user_max=" + corp_user_max + ", corp_agent_max=" + corp_agent_max + ", corp_wxqrcode="
				+ corp_wxqrcode + ", corp_full_name=" + corp_full_name + ", subject_type=" + subject_type
				+ ", verified_end_time=" + verified_end_time + "]";
	}
	
	
}
