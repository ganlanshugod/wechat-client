/**
* @Company Elink   
* @Title: MaterialPageParam.java 
* @Package org.bana.wechat.mp.message.param 
* @author zhangzhichao   
* @date Aug 18, 2019 1:49:57 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.account.param;

import org.bana.wechat.mp.common.WeChatMpParam;

import com.alibaba.fastjson.annotation.JSONField;

/** 
* @ClassName: QrcodeMpParam 
* @Description: 二维码
* @author zhangzhichao   
*/
public class QrcodeMpParam extends WeChatMpParam {

	private static final long serialVersionUID = -1572674288383110114L;
	@JSONField(name="expire_seconds")
	private Integer expireSeconds; // 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
	@JSONField(name="action_name")
	private String actionName; // 二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
	@JSONField(name="action_info")
	private QrcodeActionInfoParam actionInfo; // 二维码详细信息
	
	public Integer getExpireSeconds() {
		return expireSeconds;
	}
	public void setExpireSeconds(Integer expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public QrcodeActionInfoParam getActionInfo() {
		return actionInfo;
	}
	public void setActionInfo(QrcodeActionInfoParam actionInfo) {
		this.actionInfo = actionInfo;
	}
	@Override
	public String toString() {
		return "QrcodeMpParam [expireSeconds=" + expireSeconds + ", actionName=" + actionName + ", actionInfo="
				+ actionInfo + "]";
	}
}
