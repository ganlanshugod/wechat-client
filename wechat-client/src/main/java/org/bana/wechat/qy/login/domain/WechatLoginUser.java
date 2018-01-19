/**
* @Company 青鸟软通   
* @Title: WechatLoginUser.java 
* @Package org.bana.wechat.qy.login.domain 
* @author Richard Core   
* @date 2016-3-18 下午2:13:20 
* @version V1.0   
*/ 
package org.bana.wechat.qy.login.domain;

import java.io.Serializable;

/** 
 * @ClassName: WechatLoginUser 
 * @Description: 微信单点登录用户信息
 *  
 */
public class WechatLoginUser implements Serializable{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 5319869504198598096L;
	private Integer usertype;     //登录用户的类型：1.企业号创建者 2.企业号内部系统管理员 3.企业号外部系统管理员 4.企业号分级管理员 5. 企业号成员
	private Boolean is_sys;
	private Boolean is_inner;
	private LoginSimpleUser user_info; //	登录管理员的信息
	
	private LoginCorpInfo corp_info;//	授权方企业信息
	
	private LoginAgentInfo[] agent;   //	该管理员在该提供商中能使用的应用列表
	
	private LoginAuthInfo auth_info;//	该管理员拥有的通讯录权限
	private RedirectLoginInfo redirect_login_info;//	登录跳转的票据信息
	
	/**
	 * @Description: 属性 usertype 的get方法 
	 * @return usertype
	 */
	public Integer getUsertype() {
		return usertype;
	}
	/**
	 * @Description: 属性 usertype 的set方法 
	 * @param usertype 
	 */
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	/**
	 * @Description: 属性 user_info 的get方法 
	 * @return user_info
	 */
	public LoginSimpleUser getUser_info() {
		return user_info;
	}
	/**
	 * @Description: 属性 user_info 的set方法 
	 * @param user_info 
	 */
	public void setUser_info(LoginSimpleUser user_info) {
		this.user_info = user_info;
	}
	/**
	 * @Description: 属性 corp_info 的get方法 
	 * @return corp_info
	 */
	public LoginCorpInfo getCorp_info() {
		return corp_info;
	}
	/**
	 * @Description: 属性 corp_info 的set方法 
	 * @param corp_info 
	 */
	public void setCorp_info(LoginCorpInfo corp_info) {
		this.corp_info = corp_info;
	}
	/**
	 * @Description: 属性 agent 的set方法 
	 * @param agent 
	 */
	public void setAgent(LoginAgentInfo[] agent) {
		this.agent = agent;
	}
	/**
	 * @Description: 属性 auth_info 的get方法 
	 * @return auth_info
	 */
	public LoginAuthInfo getAuth_info() {
		return auth_info;
	}
	/**
	 * @Description: 属性 auth_info 的set方法 
	 * @param auth_info 
	 */
	public void setAuth_info(LoginAuthInfo auth_info) {
		this.auth_info = auth_info;
	}
	/**
	 * @Description: 属性 redirect_login_info 的get方法 
	 * @return redirect_login_info
	 */
	public RedirectLoginInfo getRedirect_login_info() {
		return redirect_login_info;
	}
	/**
	 * @Description: 属性 redirect_login_info 的set方法 
	 * @param redirect_login_info 
	 */
	public void setRedirect_login_info(RedirectLoginInfo redirect_login_info) {
		this.redirect_login_info = redirect_login_info;
	}
	/**
	 * @Description: 属性 is_sys 的get方法 
	 * @return is_sys
	 */
	public Boolean getIs_sys() {
		return is_sys;
	}
	/**
	 * @Description: 属性 is_sys 的set方法 
	 * @param is_sys 
	 */
	public void setIs_sys(Boolean is_sys) {
		this.is_sys = is_sys;
	}
	/**
	 * @Description: 属性 is_inner 的get方法 
	 * @return is_inner
	 */
	public Boolean getIs_inner() {
		return is_inner;
	}
	/**
	 * @Description: 属性 is_inner 的set方法 
	 * @param is_inner 
	 */
	public void setIs_inner(Boolean is_inner) {
		this.is_inner = is_inner;
	}
	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-3-23 下午2:36:15 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "WechatLoginUser [usertype=" + usertype + ", is_sys=" + is_sys
				+ ", is_inner=" + is_inner + ", user_info=" + user_info
				+ ", corp_info=" + corp_info + ", agent=" + agent
				+ ", auth_info=" + auth_info + ", redirect_login_info="
				+ redirect_login_info + "]";
	}
	
}
