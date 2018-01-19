/**
* @Company 青鸟软通   
* @Title: OpenIdUser.java 
* @Package org.bana.wechat.qy.user.domain 
* @author Liu Wenjie   
* @date 2015-9-16 下午4:37:29 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.domain;

/** 
 * @ClassName: OpenIdUser 
 * @Description: 
 *  
 */
public class OpenIdUser {

	private String openid;//企业号成员userid对应的openid，若有传参agentid，则是针对该agentid的openid。否则是针对企业号corpid的openid
	private String appid;	//应用的appid，若请求包中不包含agentid则不返回appid。该appid在使用微信红包时会用到
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
	 * @Description: 属性 appid 的get方法 
	 * @return appid
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * @Description: 属性 appid 的set方法 
	 * @param appid 
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-16 下午5:00:03 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "OpenIdUser [openid=" + openid + ", appid=" + appid + "]";
	}
	
}
