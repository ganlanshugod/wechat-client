/**
 * @Company JBINFO
 * @Title: UserMpInfoParam.java
 * @Package org.bana.wechat.mp.auth.param
 * @author Liu Wenjie
 * @date 2018年5月15日 上午10:41:28
 * @version V1.0
 */
package org.bana.wechat.mp.auth.param;

import org.bana.wechat.mp.common.WeChatMpParam;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: UserPaidInfoParam
 * @Description: 用户支付完成后，获取该用户的 UnionId，无需用户授权。本接口支持第三方平台代理查询。
					注意：调用前需要用户完成支付，且在支付后的五分钟内有效。
 * @author zhang zhichao
 */
public class UserPaidInfoParam extends WeChatMpParam{
	private static final long serialVersionUID = -4373968740680724432L;
	
	@JSONField(name = "openid")
	private String openId;
	@JSONField(name = "transaction_id")
	private String transactionId; // 微信支付订单号。不可与out_trade_no 及 mch_id同时为空
	@JSONField(name = "mch_id")
	private String mchId; // 微信支付分配的商户号，和商户订单号配合使用
	@JSONField(name = "out_trade_no")
	private String outTradeNo; // 微信支付商户订单号，和商户号配合使用
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	
}
