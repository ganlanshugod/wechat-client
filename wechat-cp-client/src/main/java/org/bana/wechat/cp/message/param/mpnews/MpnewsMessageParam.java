/**
* @Company 青鸟软通   
* @Title: MpnewsMessageParam.java 
* @Package org.bana.wechat.qy.message.param.mpnews 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:34:37 
* @version V1.0   
*/ 
package org.bana.wechat.cp.message.param.mpnews;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.message.param.MessageParam;

/** 
 * @ClassName: MpnewsMessageParam 
 * @Description: mpnews消息
 *  
 */
public class MpnewsMessageParam extends MessageParam {

	private static final long serialVersionUID = -8835885654724634494L;
	private MpnewsMessage mpnews;
	
	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2015-5-27 下午9:42:52  
	 */
	public MpnewsMessageParam() {
		setMsgtype(Constants.mpnews消息.getValue());
	}

	/**
	 * @Description: 属性 mpnews 的get方法 
	 * @return mpnews
	 */
	public MpnewsMessage getMpnews() {
		return mpnews;
	}

	/**
	 * @Description: 属性 mpnews 的set方法 
	 * @param mpnews 
	 */
	public void setMpnews(MpnewsMessage mpnews) {
		this.mpnews = mpnews;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:38:42 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "MpnewsMessageParam [mpnews=" + mpnews + ", touser=" + touser + ", toparty=" + toparty + ", totag=" + totag + ", msgtype=" + msgtype + ", agentid=" + agentid
				+ ", safe=" + safe + "]";
	}
	
}
