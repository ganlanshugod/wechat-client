/**
* @Company 青鸟软通   
* @Title: WeChatParam.java 
* @Package org.bana.wechat.qy.common 
* @author Liu Wenjie   
* @date 2015-5-9 下午5:16:10 
* @version V1.0   
*/ 
package org.bana.wechat.qy.common;

/** 
 * @ClassName: WeChatParam 
 * @Description: 访问微信接口连接的通用接口类
 *  
 */
public class WeChatParam {
	
	/** 
	* @Fields access_token : 访问参数的令牌参数
	*/ 
	protected String access_token;

	
	/*============getter and setter ===============*/
	/**
	 * @Description: 属性 access_token 的get方法 
	 * @return access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * @Description: 属性 access_token 的set方法 
	 * @param access_token 
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
}
