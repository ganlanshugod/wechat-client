/**
* @Company 青鸟软通   
* @Title: User.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 下午1:47:01 
* @version V1.0   
*/ 
package org.bana.wechat.qy.agent.domain;

/** 
 * @ClassName: User 
 * @Description: 企业应用中的用户信息
 *  
 */
public class User {

	private String userid ;
	private String status ; //:"1"//关注状态
	/**
	 * @Description: 属性 userid 的get方法 
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @Description: 属性 userid 的set方法 
	 * @param userid 
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @Description: 属性 status 的get方法 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @Description: 属性 status 的set方法 
	 * @param status 
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 下午1:48:25 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "User [userid=" + userid + ", status=" + status + "]";
	}
	
}
