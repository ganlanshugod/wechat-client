/**
* @Company Elink   
* @Title: MaterialPageParam.java 
* @Package org.bana.wechat.mp.message.param 
* @author zhangzhichao   
* @date Aug 18, 2019 1:49:57 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.account.result;

import java.io.Serializable;

import org.bana.wechat.mp.common.WeChatMpParam;

import com.alibaba.fastjson.annotation.JSONField;

/** 
* @ClassName: QrcodeMpResult 
* @Description: 二维码
* @author zhangzhichao   
*/
public class QrcodeMpResult implements Serializable {
	
	private static final long serialVersionUID = -3625024775923799255L;
	
	private String ticket; // 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	@JSONField(name="expireSeconds")
	private Integer expire_seconds; // 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
	private String url; // 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Integer getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Integer expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "QrcodeMpResult [ticket=" + ticket + ", expire_seconds=" + expire_seconds + ", url=" + url + "]";
	}
	
}
