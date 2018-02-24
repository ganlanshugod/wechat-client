/**
* @Company 青鸟软通   
* @Title: MessageParam.java 
* @Package org.bana.wechat.qy.message.param 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:01:30 
* @version V1.0   
*/ 
package org.bana.wechat.cp.message.param;

import org.bana.wechat.cp.common.WeChatCPParam;

/** 
 * @ClassName: MessageParam 
 * @Description: 微信发送消息接口的统一对象
 *  
 */
public abstract class MessageParam extends WeChatCPParam {

	private static final long serialVersionUID = 3628798698808707944L;
	
	protected String touser; //	否	成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
	protected String toparty; //		否	部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
	protected String totag; //		否	标签ID列表，多个接收者用‘|’分隔。当touser为@all时忽略本参数
	protected String msgtype; //		是	消息类型，此时固定为：text
	protected Integer agentid; //		是	企业应用的id，整型。可在应用的设置页面查看
	protected Byte safe; //		否	表示是否是保密消息，0表示否，1表示是，默认0
	/**
	 * @Description: 属性 touser 的get方法 
	 * @return touser
	 */
	public String getTouser() {
		return touser;
	}
	/**
	 * @Description: 属性 touser 的set方法 
	 * @param touser 
	 */
	public void setTouser(String touser) {
		this.touser = touser;
	}
	/**
	 * @Description: 属性 toparty 的get方法 
	 * @return toparty
	 */
	public String getToparty() {
		return toparty;
	}
	/**
	 * @Description: 属性 toparty 的set方法 
	 * @param toparty 
	 */
	public void setToparty(String toparty) {
		this.toparty = toparty;
	}
	/**
	 * @Description: 属性 totag 的get方法 
	 * @return totag
	 */
	public String getTotag() {
		return totag;
	}
	/**
	 * @Description: 属性 totag 的set方法 
	 * @param totag 
	 */
	public void setTotag(String totag) {
		this.totag = totag;
	}
	/**
	 * @Description: 属性 msgtype 的get方法 
	 * @return msgtype
	 */
	public String getMsgtype() {
		return msgtype;
	}
	/**
	 * @Description: 属性 msgtype 的set方法 
	 * @param msgtype 
	 */
	protected void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	/**
	 * @Description: 属性 agentid 的get方法 
	 * @return agentid
	 */
	public Integer getAgentid() {
		return agentid;
	}
	/**
	 * @Description: 属性 agentid 的set方法 
	 * @param agentid 
	 */
	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}
	/**
	 * @Description: 属性 safe 的get方法 
	 * @return safe
	 */
	public Byte getSafe() {
		return safe;
	}
	/**
	 * @Description: 属性 safe 的set方法 
	 * @param safe 
	 */
	public void setSafe(Byte safe) {
		this.safe = safe;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:09:39 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "MessageParam ["
				+ "touser=" + touser 
				+ ", toparty=" + toparty 
				+ ", totag=" + totag 
				+ ", msgtype=" + msgtype 
				+ ", agentid=" + agentid 
				+ ", safe=" + safe
			 + "]";
	}
	
}
