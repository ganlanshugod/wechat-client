/**
* @Company 青鸟软通   
* @Title: UserDeleteParam.java 
* @Package org.bana.wechat.qy.user.domain 
* @author Liu Wenjie   
* @date 2015-5-11 下午6:31:59 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: UserDeleteParam 
 * @Description: 用户删除参数 
 *  
 */
public class UserDeleteParam extends WeChatParam {
	
	private String userid;

	/**
	 * @Description: 属性 userid 的get方法 
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @Description: 属性 userid 的set方法 
	 * @param userid 
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午6:33:18 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "UserDeleteParam [userid=" + userid + ", access_token=" + access_token + "]";
	}
	
}
