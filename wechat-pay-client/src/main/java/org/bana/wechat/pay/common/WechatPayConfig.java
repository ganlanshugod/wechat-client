/**
* @Company 全域旅游
* @Title: WechatPayConfig.java 
* @Package org.bana.wechat.pay.common 
* @author liuwenjie   
* @date May 15, 2020 5:09:25 PM 
* @version V1.0   
*/ 
package org.bana.wechat.pay.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import com.github.wxpay.sdk.WXPayConfig;

/** 
* @ClassName: WechatPayConfig 
* @Description: 通用的微信Config实体对象
* @author liuwenjie   
*/
public class WechatPayConfig implements WXPayConfig{
	
	 private int httpConnectTimeoutMs = 8000;

	 private int httpReadTimeoutMs = 10000;
	 
	 private String appID;
	 
	 private String mchID;
	 
	 private String key;
	 
	 private byte[] certData;

	public int getHttpConnectTimeoutMs() {
		return httpConnectTimeoutMs;
	}


	public void setHttpConnectTimeoutMs(int httpConnectTimeoutMs) {
		this.httpConnectTimeoutMs = httpConnectTimeoutMs;
	}


	public int getHttpReadTimeoutMs() {
		return httpReadTimeoutMs;
	}


	public void setHttpReadTimeoutMs(int httpReadTimeoutMs) {
		this.httpReadTimeoutMs = httpReadTimeoutMs;
	}

	public String getMchID() {
		return mchID;
	}


	public void setMchID(String mchID) {
		this.mchID = mchID;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date May 15, 2020 5:09:53 PM 
	* @return 
	* @see com.github.wxpay.sdk.WXPayConfig#getCertStream() 
	*/ 
	@Override
	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
	}


	public String getAppID() {
		return appID;
	}


	public void setAppID(String appID) {
		this.appID = appID;
	}


	public byte[] getCertData() {
		return certData;
	}


	public void setCertData(byte[] certData) {
		this.certData = certData;
	}


	@Override
	public String toString() {
		return "WechatPayConfig [httpConnectTimeoutMs=" + httpConnectTimeoutMs + ", httpReadTimeoutMs="
				+ httpReadTimeoutMs + ", appID=" + appID + ", mchID=" + mchID + ", key=" + key + ", certData="
				+ Arrays.toString(certData) + "]";
	}
	

}
