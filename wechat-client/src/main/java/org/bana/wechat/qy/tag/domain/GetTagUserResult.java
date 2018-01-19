/**
* @Company 青鸟软通   
* @Title: AddTagUserResult.java 
* @Package org.bana.wechat.qy.tag.domain 
* @author Liu Wenjie   
* @date 2015-5-11 下午11:18:19 
* @version V1.0   
*/ 
package org.bana.wechat.qy.tag.domain;

import java.util.List;

import org.bana.wechat.qy.user.domain.SimpleUser;

/** 
 * @ClassName: AddTagUserResult 
 * @Description: 增加标签用户的返回结果
 *  
 */
public class GetTagUserResult{

	private List<SimpleUser> userlist; //不在权限内的成员ID列表，以“|”分隔
	private List<Integer> partylist; //不在权限内的部门ID列表
	/**
	 * @Description: 属性 userlist 的get方法 
	 * @return userlist
	 */
	public List<SimpleUser> getUserlist() {
		return userlist;
	}
	/**
	 * @Description: 属性 userlist 的set方法 
	 * @param userlist 
	 */
	public void setUserlist(List<SimpleUser> userlist) {
		this.userlist = userlist;
	}
	/**
	 * @Description: 属性 partylist 的get方法 
	 * @return partylist
	 */
	public List<Integer> getPartylist() {
		return partylist;
	}
	/**
	 * @Description: 属性 partylist 的set方法 
	 * @param partylist 
	 */
	public void setPartylist(List<Integer> partylist) {
		this.partylist = partylist;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-12 下午2:11:20 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "GetTagUserResult [userlist=" + userlist + ", partylist=" + partylist + "]";
	}

}
