/**
* @Company 青鸟软通   
* @Title: InviteSendParam.java 
* @Package org.bana.wechat.qy.invite.param 
* @author Liu Wenjie   
* @date 2015-5-11 下午9:59:02 
* @version V1.0   
*/ 
package org.bana.wechat.qy.invite.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: InviteSendParam 
 * @Description: 邀请成员关注 的参数
 *  
 */
public class InviteSendParam extends WeChatParam{

	private String userid; //成员UserID。对应管理端的帐号
	private String invite_tips; //推送到微信上的提示语（只有认证号可以使用）。当使用微信推送时，该字段默认为“请关注XXX企业号”，邮件邀请时，该字段无效。
	/**
	 * @Description: 属性 userid 的get方法 
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @Description: 属性 userid 的set方法 
	 * @param userid 
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @Description: 属性 invite_tips 的get方法 
	 * @return invite_tips
	 */
	public String getInvite_tips() {
		return invite_tips;
	}
	/**
	 * @Description: 属性 invite_tips 的set方法 
	 * @param invite_tips 
	 */
	public void setInvite_tips(String invite_tips) {
		this.invite_tips = invite_tips;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午10:00:55 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "InviteSendParam [userid=" + userid + ", invite_tips=" + invite_tips + ", access_token=" + access_token + "]";
	}

}
