/**
* @Company 青鸟软通   
* @Title: AddTagUserParam.java 
* @Package org.bana.wechat.qy.tag.param 
* @author Liu Wenjie   
* @date 2015-5-11 下午11:13:19 
* @version V1.0   
*/ 
package org.bana.wechat.qy.tag.param;

import java.util.List;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: AddTagUserParam 
 * @Description: 管理标签对应的用户信息的参数
 *  
 */
public class TagUserParam extends WeChatParam{

	private String tagid;
	private List<String> userlist; //企业成员ID列表，注意：userlist、partylist不能同时为空
	private List<Integer> partylist; //企业部门ID列表，注意：userlist、partylist不能同时为空
	/**
	 * @Description: 属性 tagid 的get方法 
	 * @return tagid
	 */
	public String getTagid() {
		return tagid;
	}
	/**
	 * @Description: 属性 tagid 的set方法 
	 * @param tagid 
	 */
	public void setTagid(String tagid) {
		this.tagid = tagid;
	}
	/**
	 * @Description: 属性 userlist 的get方法 
	 * @return userlist
	 */
	public List<String> getUserlist() {
		return userlist;
	}
	/**
	 * @Description: 属性 userlist 的set方法 
	 * @param userlist 
	 */
	public void setUserlist(List<String> userlist) {
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
	* @date 2015-5-11 下午11:17:44 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AddTagUserParam [tagid=" + tagid + ", userlist=" + userlist + ", partylist=" + partylist + ", access_token=" + access_token + "]";
	}
	
	
}
