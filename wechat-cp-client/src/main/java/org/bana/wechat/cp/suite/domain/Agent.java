/**
 * @Company JBINFO
 * @Title: Agent.java
 * @Package org.bana.wechat.cp.suite.domain
 * @author Zhang Zhichao
 * @date 2018年1月29日 上午11:47:09
 * @version V1.0
 */
package org.bana.wechat.cp.suite.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: Agent
 * @Description: 授权的应用信息
 * @author Zhang Zhichao
 */
public class Agent implements Serializable {

	private static final long serialVersionUID = 1067829690181747252L;
	
	@JSONField(name="agentid")
	private String agentId ; //; 1,授权方应用id
	
	private String name; //NAME,授权方应用名字
	
	@JSONField(name="square_logo_url")
	private String squareLogoUrl; //xxxxxx,授权方应用方形头像
	
	@JSONField(name="round_logo_url")
	private String roundLogoUrl; //yyyyyy,授权方应用圆形头像
	
	@JSONField(name="appid")
	private String appId; //旧的多应用套件中的对应应用id，新开发者请忽略
	
	@JSONField(name="privilege")
	private Privilege privilege; // 应用对应的权限

	/**
	 * @Description: 属性 agentId 的get方法 
	 * @return agentId
	 */
	public String getAgentId() {
		return agentId;
	}

	/**
	 * @Description: 属性 agentId 的set方法 
	 * @param agentId
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
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
	 * @Description: 属性 squareLogoUrl 的get方法 
	 * @return squareLogoUrl
	 */
	public String getSquareLogoUrl() {
		return squareLogoUrl;
	}

	/**
	 * @Description: 属性 squareLogoUrl 的set方法 
	 * @param squareLogoUrl
	 */
	public void setSquareLogoUrl(String squareLogoUrl) {
		this.squareLogoUrl = squareLogoUrl;
	}

	/**
	 * @Description: 属性 roundLogoUrl 的get方法 
	 * @return roundLogoUrl
	 */
	public String getRoundLogoUrl() {
		return roundLogoUrl;
	}

	/**
	 * @Description: 属性 roundLogoUrl 的set方法 
	 * @param roundLogoUrl
	 */
	public void setRoundLogoUrl(String roundLogoUrl) {
		this.roundLogoUrl = roundLogoUrl;
	}

	/**
	 * @Description: 属性 appId 的get方法 
	 * @return appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @Description: 属性 appId 的set方法 
	 * @param appId
	 */
	public void setAppId(String appId) {
		this.appId = appId;
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
	
}
