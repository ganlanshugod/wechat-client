/**
 * @Company JBINFO
 * @Title: Privilege.java
 * @Package org.bana.wechat.cp.suite.domain
 * @author Zhang Zhichao
 * @date 2018年1月29日 上午11:55:08
 * @version V1.0
 */
package org.bana.wechat.cp.suite.domain;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: Privilege
 * @Description: 应用对应的权限
 * @author Zhang Zhichao
 */
public class Privilege implements Serializable {

	private static final long serialVersionUID = -7954260290601052257L;
	
	/**
	 * @Fields level : 权限等级。
					1:通讯录基本信息只读
					2:通讯录全部信息只读
					3:通讯录全部信息读写
					4:单个基本信息只读
					5:通讯录全部信息只写
	 */
	@JSONField(name="level")
	private Integer level; 
	
	@JSONField(name="allow_party")
	private Integer[] allowParty; //应用可见范围（部门）:[1,2,3],
	
	@JSONField(name="allow_user")
	private String[] allowUser; //应用可见范围（成员）:["zhansan","lisi"], 
	
	@JSONField(name="allow_tag")
	private Integer[] allowTag; //应用可见范围（标签）:[1,2,3], 
	
	@JSONField(name="extra_party")
	private Integer[] extraParty; //额外通讯录（部门）:[4,5,6], 
	
	@JSONField(name="extra_user")
	private String[] extraUser; //额外通讯录（成员）:["wangwu"], 
	
	@JSONField(name="extra_tag")
	private Integer[] extraTag; //额外通讯录（标签）:[4,5,6]

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
	 * @Description: 属性 allowParty 的get方法 
	 * @return allowParty
	 */
	public Integer[] getAllowParty() {
		return allowParty;
	}

	/**
	 * @Description: 属性 allowParty 的set方法 
	 * @param allowParty
	 */
	public void setAllowParty(Integer[] allowParty) {
		this.allowParty = allowParty;
	}

	/**
	 * @Description: 属性 allowUser 的get方法 
	 * @return allowUser
	 */
	public String[] getAllowUser() {
		return allowUser;
	}

	/**
	 * @Description: 属性 allowUser 的set方法 
	 * @param allowUser
	 */
	public void setAllowUser(String[] allowUser) {
		this.allowUser = allowUser;
	}

	/**
	 * @Description: 属性 allowTag 的get方法 
	 * @return allowTag
	 */
	public Integer[] getAllowTag() {
		return allowTag;
	}

	/**
	 * @Description: 属性 allowTag 的set方法 
	 * @param allowTag
	 */
	public void setAllowTag(Integer[] allowTag) {
		this.allowTag = allowTag;
	}

	/**
	 * @Description: 属性 extraParty 的get方法 
	 * @return extraParty
	 */
	public Integer[] getExtraParty() {
		return extraParty;
	}

	/**
	 * @Description: 属性 extraParty 的set方法 
	 * @param extraParty
	 */
	public void setExtraParty(Integer[] extraParty) {
		this.extraParty = extraParty;
	}

	/**
	 * @Description: 属性 extraUser 的get方法 
	 * @return extraUser
	 */
	public String[] getExtraUser() {
		return extraUser;
	}

	/**
	 * @Description: 属性 extraUser 的set方法 
	 * @param extraUser
	 */
	public void setExtraUser(String[] extraUser) {
		this.extraUser = extraUser;
	}

	/**
	 * @Description: 属性 extraTag 的get方法 
	 * @return extraTag
	 */
	public Integer[] getExtraTag() {
		return extraTag;
	}

	/**
	 * @Description: 属性 extraTag 的set方法 
	 * @param extraTag
	 */
	public void setExtraTag(Integer[] extraTag) {
		this.extraTag = extraTag;
	}
	
}
