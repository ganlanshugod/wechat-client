/**
* @Company 青鸟软通   
* @Title; Agent.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 下午12:19:33 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

import java.util.List;

/** 
 * @ClassName: Agent 
 * @Description: 授权的应用信息
 *  
 */
public class Agent {

	 private String agentid ; //; 1,授权方应用id
	 private String name; //NAME,授权方应用名字
	 private String square_logo_url; //xxxxxx,授权方应用方形头像
	 private String round_logo_url; //yyyyyy,授权方应用圆形头像
	 private String appid; //1,服务商套件中的对应应用id
	 private Privilege privilege;
	 /** 
	* @Fields api_group : 新通讯录权限中，此属性已经注释掉，在新版本中兼容但是已经无法获取到对应的值
	*/ 
	 @Deprecated
	private List<String> api_group; // 授权方应用敏感权限组，目前仅有get_location，表示是否有权限设置应用获取地理位置的开关
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
	 * @Description: 属性 appid 的get方法 
	 * @return appid
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * @Description: 属性 appid 的set方法 
	 * @param appid 
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * @Description: 属性 api_group 的get方法 
	 * @return api_group
	 */
	@Deprecated
	public List<String> getApi_group() {
		return api_group;
	}
	/**
	 * @Description: 属性 api_group 的set方法 
	 * @param api_group 
	 */
	@Deprecated
	public void setApi_group(List<String> api_group) {
		this.api_group = api_group;
	}
	
	/**
	 * @Description: 属性 privilege 的get方法 
	 * @return privilege
	 */
	public Privilege getPrivilege() {
		return privilege;
	}
	/**
	 * @Description: 属性 privilege 的set方法 
	 * @param privilege 
	 */
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-12-16 下午12:40:44 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "Agent [agentid=" + agentid + ", name=" + name + ", square_logo_url=" + square_logo_url + ", round_logo_url=" + round_logo_url + ", appid=" + appid + ", privilege="
				+ privilege + ", api_group=" + api_group + "]";
	}
	
}
