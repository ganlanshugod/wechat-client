/**
* @Company 青鸟软通   
* @Title: UserBatchDeleteParam.java 
* @Package org.bana.wechat.qy.user.domain 
* @author Liu Wenjie   
* @date 2015-5-11 下午7:05:29 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.param;

import java.util.List;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: UserBatchDeleteParam 
 * @Description: 用户批量删除参数
 *  
 */
public class UserBatchDeleteParam extends WeChatParam {

	private List<String> useridlist;

	/**
	 * @Description: 属性 useridlist 的get方法 
	 * @return useridlist
	 */
	public List<String> getUseridlist() {
		return useridlist;
	}

	/**
	 * @Description: 属性 useridlist 的set方法 
	 * @param useridlist 
	 */
	public void setUseridlist(List<String> useridlist) {
		this.useridlist = useridlist;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午7:06:07 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "UserBatchDeleteParam [useridlist=" + useridlist + ", access_token=" + access_token + "]";
	}
	
}
