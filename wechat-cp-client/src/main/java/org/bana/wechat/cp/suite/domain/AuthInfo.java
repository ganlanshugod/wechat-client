/**
 * @Company JBINFO
 * @Title: AuthInfo.java
 * @Package org.bana.wechat.cp.suite.domain
 * @author Zhang Zhichao
 * @date 2018年1月29日 下午12:01:48
 * @version V1.0
 */
package org.bana.wechat.cp.suite.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: AuthInfo
 * @Description: 授权信息
 * @author Zhang Zhichao
 */
public class AuthInfo implements Serializable {

	private static final long serialVersionUID = -347396906634286933L;
	
	/**
	 * @Fields agent : 授权的应用信息
	 * 注意是一个数组，但仅旧的多应用套件授权时会返回多个agent，对新的单应用授权，永远只返回一个agent
	 */
	private List<Agent> agent;

	/**
	 * @Description: 属性 agent 的get方法 
	 * @return agent
	 */
	public List<Agent> getAgent() {
		return agent;
	}

	/**
	 * @Description: 属性 agent 的set方法 
	 * @param agent
	 */
	public void setAgent(List<Agent> agent) {
		this.agent = agent;
	}
	
}
