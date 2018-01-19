/**
* @Company 青鸟软通   
* @Title: CovertToUserIdParam.java 
* @Package org.bana.wechat.qy.user.param 
* @author Liu Wenjie   
* @date 2015-9-16 下午5:06:05 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: CovertToUserIdParam 
 * @Description: 
 *  
 */
public class CovertToUserIdParam extends WeChatParam {

	private String openid;//在使用微信支付、微信红包和企业转账之后，返回结果的openid

	/**
	 * @Description: 属性 openid 的get方法 
	 * @return openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @Description: 属性 openid 的set方法 
	 * @param openid 
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-16 下午5:06:56 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CovertToUserIdParam [openid=" + openid + ", access_token=" + access_token + "]";
	}
	
}
