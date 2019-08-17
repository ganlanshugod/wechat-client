/**
 * @Company Elink
 * @Title: TemplateMessageResult.java
 * @Package org.bana.wechat.mp.message.result
 * @author Zhang Zhichao
 * @date 2018年9月4日 下午2:23:07
 * @version V1.0
 */
package org.bana.wechat.mp.message.result;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: AutoReplyInfoResult
 * @Description: 自动回复消息配置信息返回结果
 * @author Zhang Zhichao
 */
public class AutoReplyInfoResult implements Serializable {
	
	private static final long serialVersionUID = -2797100794607043604L;
	private String errcode;
	private String errmsg;
	@JSONField(name="is_add_friend_reply_open")
	private String isAddFriendReplyOpen; // 关注后自动回复是否开启，0代表未开启，1代表开启
	@JSONField(name="is_autoreply_open")
	private String isAutoreplyOpen; // 消息自动回复是否开启，0代表未开启，1代表开启
	
	
	public String getErrcode() {
		return errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
