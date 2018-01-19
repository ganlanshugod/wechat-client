/**
* @Company 青鸟软通   
* @Title: AgentInfo.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 下午1:44:39 
* @version V1.0   
*/ 
package org.bana.wechat.qy.agent.domain;


/** 
 * @ClassName: AgentInfo 
 * @Description: 授权方企业应用信息
 *  
 */
public class AgentInfo {

	private String agentid	;//授权方企业应用id
	private String name	;//授权方企业应用名称
	private String square_logo_url;//	授权方企业应用方形头像
	private String round_logo_url;//	授权方企业应用圆形头像
	private String description;//	授权方企业应用详情
	private AllowUsers allow_userinfos	;//授权方企业应用可见范围（人员），其中包括userid和关注状态state
	private AllowPartys allow_partys	;//授权方企业应用可见范围（部门）
	private AllowTags allow_tags;//	授权方企业应用可见范围（标签）
	private String close	;//授权方企业应用是否被禁用
	private String redirect_domain;//	授权方企业应用可信域名
	private String report_location_flag	;//授权方企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；2：持续上报
	private String isreportuser	;//是否接收用户变更通知。0：不接收；1：接收
	private String isreportenter	;//是否上报用户进入应用事件。0：不接收；1：接收
	/**
	 * @Description: 属性 agentid 的get方法 
	 * @return agentid
	 */
	public String getAgentid() {
		return agentid;
	}
	/**
	 * @Description: 属性 agentid 的set方法 
	 * @param agentid 
	 */
	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}
	/**
	 * @Description: 属性 name 的get方法 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @Description: 属性 name 的set方法 
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @Description: 属性 square_logo_url 的get方法 
	 * @return square_logo_url
	 */
	public String getSquare_logo_url() {
		return square_logo_url;
	}
	/**
	 * @Description: 属性 square_logo_url 的set方法 
	 * @param square_logo_url 
	 */
	public void setSquare_logo_url(String square_logo_url) {
		this.square_logo_url = square_logo_url;
	}
	/**
	 * @Description: 属性 round_logo_url 的get方法 
	 * @return round_logo_url
	 */
	public String getRound_logo_url() {
		return round_logo_url;
	}
	/**
	 * @Description: 属性 round_logo_url 的set方法 
	 * @param round_logo_url 
	 */
	public void setRound_logo_url(String round_logo_url) {
		this.round_logo_url = round_logo_url;
	}
	/**
	 * @Description: 属性 description 的get方法 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @Description: 属性 description 的set方法 
	 * @param description 
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * @Description: 属性 allow_userinfos 的get方法 
	 * @return allow_userinfos
	 */
	public AllowUsers getAllow_userinfos() {
		return allow_userinfos;
	}
	/**
	 * @Description: 属性 allow_userinfos 的set方法 
	 * @param allow_userinfos 
	 */
	public void setAllow_userinfos(AllowUsers allow_userinfos) {
		this.allow_userinfos = allow_userinfos;
	}
	/**
	 * @Description: 属性 allow_partys 的get方法 
	 * @return allow_partys
	 */
	public AllowPartys getAllow_partys() {
		return allow_partys;
	}
	/**
	 * @Description: 属性 allow_partys 的set方法 
	 * @param allow_partys 
	 */
	public void setAllow_partys(AllowPartys allow_partys) {
		this.allow_partys = allow_partys;
	}
	/**
	 * @Description: 属性 allow_tags 的get方法 
	 * @return allow_tags
	 */
	public AllowTags getAllow_tags() {
		return allow_tags;
	}
	/**
	 * @Description: 属性 allow_tags 的set方法 
	 * @param allow_tags 
	 */
	public void setAllow_tags(AllowTags allow_tags) {
		this.allow_tags = allow_tags;
	}
	/**
	 * @Description: 属性 close 的get方法 
	 * @return close
	 */
	public String getClose() {
		return close;
	}
	/**
	 * @Description: 属性 close 的set方法 
	 * @param close 
	 */
	public void setClose(String close) {
		this.close = close;
	}
	/**
	 * @Description: 属性 redirect_domain 的get方法 
	 * @return redirect_domain
	 */
	public String getRedirect_domain() {
		return redirect_domain;
	}
	/**
	 * @Description: 属性 redirect_domain 的set方法 
	 * @param redirect_domain 
	 */
	public void setRedirect_domain(String redirect_domain) {
		this.redirect_domain = redirect_domain;
	}
	/**
	 * @Description: 属性 report_location_flag 的get方法 
	 * @return report_location_flag
	 */
	public String getReport_location_flag() {
		return report_location_flag;
	}
	/**
	 * @Description: 属性 report_location_flag 的set方法 
	 * @param report_location_flag 
	 */
	public void setReport_location_flag(String report_location_flag) {
		this.report_location_flag = report_location_flag;
	}
	/**
	 * @Description: 属性 isreportuser 的get方法 
	 * @return isreportuser
	 */
	public String getIsreportuser() {
		return isreportuser;
	}
	/**
	 * @Description: 属性 isreportuser 的set方法 
	 * @param isreportuser 
	 */
	public void setIsreportuser(String isreportuser) {
		this.isreportuser = isreportuser;
	}
	/**
	 * @Description: 属性 isreportenter 的get方法 
	 * @return isreportenter
	 */
	public String getIsreportenter() {
		return isreportenter;
	}
	/**
	 * @Description: 属性 isreportenter 的set方法 
	 * @param isreportenter 
	 */
	public void setIsreportenter(String isreportenter) {
		this.isreportenter = isreportenter;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 下午2:05:22 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AgentInfo [agentid=" + agentid + ", name=" + name + ", square_logo_url=" + square_logo_url + ", round_logo_url=" + round_logo_url + ", description=" + description
				+ ", allow_userinfos=" + allow_userinfos + ", allow_partys=" + allow_partys + ", allow_tags=" + allow_tags + ", close=" + close + ", redirect_domain="
				+ redirect_domain + ", report_location_flag=" + report_location_flag + ", isreportuser=" + isreportuser + ", isreportenter=" + isreportenter + "]";
	}
	
	
}
