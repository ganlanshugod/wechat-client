/**
 * @Company 青鸟软通   
 * @Title: BaseMpMessageParam.java 
 * @Package org.bana.wechat.mp.message.param 
 * @author Han Tongyang   
 * @date 2016-3-21 下午6:58:21 
 * @version V1.0   
 */
package org.bana.wechat.mp.message.param;

import org.bana.wechat.mp.common.WeChatMpParam;

/**
 * @ClassName: BaseMpMessageParam
 * @Description: 图文消息基础参数
 * 
 */
public class BaseMpMessageParam extends WeChatMpParam{

	private MpMessageFilterParam filter;
	private MpNewsMessageParam mpnews;
	private String msgtype;

	public MpMessageFilterParam getFilter() {
		return filter;
	}

	public void setFilter(MpMessageFilterParam filter) {
		this.filter = filter;
	}

	public MpNewsMessageParam getMpnews() {
		return mpnews;
	}

	public void setMpnews(MpNewsMessageParam mpnews) {
		this.mpnews = mpnews;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	/**
	* <p>Description: </p> 
	* @author Han Tongyang   
	* @date 2016-4-5 下午12:21:31 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "BaseMpMessageParam [filter=" + filter + ", mpnews=" + mpnews
				+ ", msgtype=" + msgtype + "]";
	}

}
