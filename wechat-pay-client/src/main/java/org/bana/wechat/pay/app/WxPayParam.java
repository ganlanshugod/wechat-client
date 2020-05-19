/**
* @Company 全域旅游
* @Title: WxPayConfig.java 
* @Package org.bana.wechat.pay.app 
* @author liuwenjie   
* @date May 15, 2020 5:38:45 PM 
* @version V1.0   
*/ 
package org.bana.wechat.pay.app;

/** 
* @ClassName: WxPayConfig 
* @Description: 微信支付的配置请求
* @author liuwenjie   
*/
public class WxPayParam {
	
	private String appId;  // appId
	private String mchId;  // 商户id
	
	/** 
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date May 18, 2020 1:17:22 PM 
	* @param appId
	* @param mchId 
	*/ 
	public WxPayParam(String appId, String mchId) {
		super();
		this.appId = appId;
		this.mchId = mchId;
	}
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	@Override
	public String toString() {
		return "WxPayParam [appId=" + appId + ", mchId=" + mchId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + ((mchId == null) ? 0 : mchId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WxPayParam other = (WxPayParam) obj;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (mchId == null) {
			if (other.mchId != null)
				return false;
		} else if (!mchId.equals(other.mchId))
			return false;
		return true;
	}
	
	
}
