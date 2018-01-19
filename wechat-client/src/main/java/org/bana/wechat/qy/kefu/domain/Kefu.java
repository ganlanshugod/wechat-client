/**
 * @Company 艾美伴行   
 * @Title: Kefu.java 
 * @Package org.bana.wechat.qy.kefu.domain 
 * @author Yang Shuangshuang   
 * @date 2015-5-10 下午3:27:30 
 * @version V1.0   
 */
package org.bana.wechat.qy.kefu.domain;

import java.util.List;

/**
 * @ClassName: Kefu
 * @Description: 客服人员
 * 
 */
public class Kefu {

	private List<String> user; // 成员列表
	private List<Integer> party; // 部门列表
	private List<Integer> tag; // 标签列表

	/* ===========getter setter toString hashCode equals =========== */
	public List<String> getUser() {
		return user;
	}

	public void setUser(List<String> user) {
		this.user = user;
	}

	public List<Integer> getParty() {
		return party;
	}

	public void setParty(List<Integer> party) {
		this.party = party;
	}

	public List<Integer> getTag() {
		return tag;
	}

	public void setTag(List<Integer> tag) {
		this.tag = tag;
	}

}
