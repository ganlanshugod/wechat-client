/**
 * @Company Elink
 * @Title: Code2SessionInfo.java
 * @Package org.bana.wechat.mp.auth.result
 * @author Zhang Zhichao
 * @date 2019年6月3日 下午3:50:18
 * @version V1.0
 */
package org.bana.wechat.mini.message.result;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: MsgCheckResult
 * @Description: 小程序内容安全
 * @author Zhang Zhichao
 */
public class MsgCheckResult implements Serializable {

	private static final long serialVersionUID = 2930153143308206939L;
	
	private String errcode;
	private String errMsg;
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	@Override
	public String toString() {
		return "MsgCheckResult [errcode=" + errcode + ", errMsg=" + errMsg + "]";
	}
	
}
