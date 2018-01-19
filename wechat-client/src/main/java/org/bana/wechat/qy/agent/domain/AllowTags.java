/**
* @Company 青鸟软通   
* @Title: AllowTags.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-5-14 下午2:03:20 
* @version V1.0   
*/ 
package org.bana.wechat.qy.agent.domain;

import java.util.List;

/** 
 * @ClassName: AllowTags 
 * @Description: 允许访问的标签组
 *  
 */
public class AllowTags {
	
	private List<Integer> tagid;//授权方企业应用可见范围（部门）

	/**
	 * @Description: 属性 tagid 的get方法 
	 * @return tagid
	 */
	public List<Integer> getTagid() {
		return tagid;
	}

	/**
	 * @Description: 属性 tagid 的set方法 
	 * @param tagid 
	 */
	public void setTagid(List<Integer> tagid) {
		this.tagid = tagid;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 下午2:04:03 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AllowTags [tagid=" + tagid + "]";
	}
	
}
