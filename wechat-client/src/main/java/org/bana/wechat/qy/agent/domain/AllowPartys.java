/**
* @Company 青鸟软通   
* @Title: AllowPartys.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 下午1:50:40 
* @version V1.0   
*/ 
package org.bana.wechat.qy.agent.domain;

import java.util.List;

/** 
 * @ClassName: AllowPartys 
 * @Description: 允许访问的组织机构
 *  
 */
public class AllowPartys {

	private List<Integer> partyid;

	/**
	 * @Description: 属性 partyid 的get方法 
	 * @return partyid
	 */
	public List<Integer> getPartyid() {
		return partyid;
	}

	/**
	 * @Description: 属性 partyid 的set方法 
	 * @param partyid 
	 */
	public void setPartyid(List<Integer> partyid) {
		this.partyid = partyid;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 下午1:51:26 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AllowPartys [partyid=" + partyid + "]";
	}
	
}
