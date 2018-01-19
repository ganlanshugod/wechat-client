/**
* @Company 青鸟软通   
* @Title: PreAuthCodeParam.java 
* @Package org.bana.wechat.qy.suite.param 
* @author Liu Wenjie   
* @date 2015-5-14 上午9:48:22 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.param;

import java.util.List;

import org.bana.wechat.qy.common.WeChatSuiteParam;

/** 
 * @ClassName: PreAuthCodeParam 
 * @Description: 获取预授权码的参数
 *  
 */
public class PreAuthCodeParam extends WeChatSuiteParam {

	private String suite_id;
	private List<Integer> appid;
	/**
	 * @Description: 属性 suite_id 的get方法 
	 * @return suite_id
	 */
	public String getSuite_id() {
		return suite_id;
	}
	/**
	 * @Description: 属性 suite_id 的set方法 
	 * @param suite_id 
	 */
	public void setSuite_id(String suite_id) {
		this.suite_id = suite_id;
	}
	/**
	 * @Description: 属性 appid 的get方法 
	 * @return appid
	 */
	public List<Integer> getAppid() {
		return appid;
	}
	/**
	 * @Description: 属性 appid 的set方法 
	 * @param appid 
	 */
	public void setAppid(List<Integer> appid) {
		this.appid = appid;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 上午9:50:19 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "PreAuthCodeParam [suite_id=" + suite_id + ", appid=" + appid + ", suite_access_token=" + suite_access_token + "]";
	}
	
	
}
