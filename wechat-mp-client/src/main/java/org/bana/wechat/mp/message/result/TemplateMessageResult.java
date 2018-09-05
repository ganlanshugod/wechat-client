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

/**
 * @ClassName: TemplateMessageResult
 * @Description: 模板消息返回结果
 * @author Zhang Zhichao
 */
public class TemplateMessageResult implements Serializable {
	
	private static final long serialVersionUID = -9010136552791902049L;
	
	private String errcode;
	private String errmsg;
	private String msgid;
	
	
	public String getErrcode() {
		return errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	@Override
	public String toString() {
		return "TemplateMessageResult [errcode=" + errcode + ", errmsg=" + errmsg + ", msgid=" + msgid + "]";
	}
	
}
