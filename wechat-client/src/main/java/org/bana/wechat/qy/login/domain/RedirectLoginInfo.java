/**
* @Company 青鸟软通   
* @Title: RedirectLoginInfo.java 
* @Package org.bana.wechat.qy.login.domain 
* @author Richard Core   
* @date 2016-3-18 下午5:17:01 
* @version V1.0   
*/ 
package org.bana.wechat.qy.login.domain;

/** 
 * @ClassName: RedirectLoginInfo 
 * @Description:  
 *  
 */
public class RedirectLoginInfo {
	private String login_ticket;//	登录跳转的票据
	private Long expires_in;//	登录跳转票据的有效时长，单位为秒
	/**
	 * @Description: 属性 login_ticket 的get方法 
	 * @return login_ticket
	 */
	public String getLogin_ticket() {
		return login_ticket;
	}
	/**
	 * @Description: 属性 login_ticket 的set方法 
	 * @param login_ticket 
	 */
	public void setLogin_ticket(String login_ticket) {
		this.login_ticket = login_ticket;
	}
	/**
	 * @Description: 属性 expires_in 的get方法 
	 * @return expires_in
	 */
	public Long getExpires_in() {
		return expires_in;
	}
	/**
	 * @Description: 属性 expires_in 的set方法 
	 * @param expires_in 
	 */
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}
	/**
	* <p>Description: </p> 
	* @author Richard Core   
	* @date 2016-3-18 下午5:30:54 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "RedirectLoginInfo [login_ticket=" + login_ticket
				+ ", expires_in=" + expires_in + "]";
	}
	
}
