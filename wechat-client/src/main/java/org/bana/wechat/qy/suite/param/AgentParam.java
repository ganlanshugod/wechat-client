/**
* @Company 青鸟软通   
* @Title: AgentParam.java 
* @Package org.bana.wechat.qy.suite.param 
* @author Liu Wenjie   
* @date 2015-5-14 下午2:10:24 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.param;

/** 
 * @ClassName: AgentParam 
 * @Description: 要设置的企业应用的信息
 *  
 */
public class AgentParam {

	private String agentid	;//企业应用的id
	private String report_location_flag	;//企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；2：持续上报
	private String logo_mediaid	;//企业应用头像的mediaid，通过多媒体接口上传图片获得mediaid，上传后会自动裁剪成方形和圆形两个头像
	private String name	;//企业应用名称
	private String description	;//企业应用详情
	private String redirect_domain	;//企业应用可信域名
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
	 * @Description: 属性 logo_mediaid 的get方法 
	 * @return logo_mediaid
	 */
	public String getLogo_mediaid() {
		return logo_mediaid;
	}
	/**
	 * @Description: 属性 logo_mediaid 的set方法 
	 * @param logo_mediaid 
	 */
	public void setLogo_mediaid(String logo_mediaid) {
		this.logo_mediaid = logo_mediaid;
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
	* @date 2015-5-14 下午2:11:38 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AgentParam [agentid=" + agentid + ", report_location_flag=" + report_location_flag + ", logo_mediaid=" + logo_mediaid + ", name=" + name + ", description="
				+ description + ", redirect_domain=" + redirect_domain + ", isreportuser=" + isreportuser + ", isreportenter=" + isreportenter + "]";
	}
	
}
