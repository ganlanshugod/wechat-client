/**
* @Company 青鸟软通   
* @Title: Privilege.java 
* @Package org.bana.wechat.qy.suite.domain 
* @author Liu Wenjie   
* @date 2015-12-16 下午12:36:46 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.domain;

import java.util.Arrays;

/** 
 * @ClassName: Privilege 
 * @Description: 授权应用的权限信息
 *  
 */
public class Privilege {

	private Integer level; //:1,//(1,2,3表示不同的权限等级) 
	private Integer[] allow_party; //:[1,2,3], 
	private String[] allow_user; //:["zhansan","lisi"], 
	private Integer[] allow_tag; //:[1,2,3], 
	private Integer[] extra_party; //:[4,5,6], 
	private String[] extra_user; //:["wangwu"], 
	private Integer[] extra_tag; //:[4,5,6]
	
	/*=============getter and setter ==========*/
	/**
	 * @Description: 属性 level 的get方法 
	 * @return level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @Description: 属性 level 的set方法 
	 * @param level 
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * @Description: 属性 allow_party 的get方法 
	 * @return allow_party
	 */
	public Integer[] getAllow_party() {
		return allow_party;
	}
	/**
	 * @Description: 属性 allow_party 的set方法 
	 * @param allow_party 
	 */
	public void setAllow_party(Integer[] allow_party) {
		this.allow_party = allow_party;
	}
	/**
	 * @Description: 属性 allow_user 的get方法 
	 * @return allow_user
	 */
	public String[] getAllow_user() {
		return allow_user;
	}
	/**
	 * @Description: 属性 allow_user 的set方法 
	 * @param allow_user 
	 */
	public void setAllow_user(String[] allow_user) {
		this.allow_user = allow_user;
	}
	/**
	 * @Description: 属性 allow_tag 的get方法 
	 * @return allow_tag
	 */
	public Integer[] getAllow_tag() {
		return allow_tag;
	}
	/**
	 * @Description: 属性 allow_tag 的set方法 
	 * @param allow_tag 
	 */
	public void setAllow_tag(Integer[] allow_tag) {
		this.allow_tag = allow_tag;
	}
	/**
	 * @Description: 属性 extra_party 的get方法 
	 * @return extra_party
	 */
	public Integer[] getExtra_party() {
		return extra_party;
	}
	/**
	 * @Description: 属性 extra_party 的set方法 
	 * @param extra_party 
	 */
	public void setExtra_party(Integer[] extra_party) {
		this.extra_party = extra_party;
	}
	/**
	 * @Description: 属性 extra_user 的get方法 
	 * @return extra_user
	 */
	public String[] getExtra_user() {
		return extra_user;
	}
	/**
	 * @Description: 属性 extra_user 的set方法 
	 * @param extra_user 
	 */
	public void setExtra_user(String[] extra_user) {
		this.extra_user = extra_user;
	}
	/**
	 * @Description: 属性 extra_tag 的get方法 
	 * @return extra_tag
	 */
	public Integer[] getExtra_tag() {
		return extra_tag;
	}
	/**
	 * @Description: 属性 extra_tag 的set方法 
	 * @param extra_tag 
	 */
	public void setExtra_tag(Integer[] extra_tag) {
		this.extra_tag = extra_tag;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-12-16 下午12:40:02 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "Privilege [level=" + level + ", allow_party=" + Arrays.toString(allow_party) + ", allow_user=" + Arrays.toString(allow_user) + ", allow_tag="
				+ Arrays.toString(allow_tag) + ", extra_party=" + Arrays.toString(extra_party) + ", extra_user=" + Arrays.toString(extra_user) + ", extra_tag="
				+ Arrays.toString(extra_tag) + "]";
	}
	
}
