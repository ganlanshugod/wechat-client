/**
* @Company 青鸟软通   
* @Title: GetCorpTokenParam.java 
* @Package org.bana.wechat.qy.suite.param 
* @author Liu Wenjie   
* @date 2015-5-14 下午2:16:54 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.param;

import org.bana.wechat.qy.common.WeChatSuiteParam;

/** 
 * @ClassName: GetCorpTokenParam 
 * @Description: 获取企业号access_token的参数
 *  
 */
public class GetCorpTokenParam extends WeChatSuiteParam {

	private String suite_id	;//应用套件id
	private String auth_corpid	;//授权方corpid
	private String permanent_code	;//永久授权码，通过get_permanent_code获取
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
	 * @Description: 属性 auth_corpid 的get方法 
	 * @return auth_corpid
	 */
	public String getAuth_corpid() {
		return auth_corpid;
	}
	/**
	 * @Description: 属性 auth_corpid 的set方法 
	 * @param auth_corpid 
	 */
	public void setAuth_corpid(String auth_corpid) {
		this.auth_corpid = auth_corpid;
	}
	/**
	 * @Description: 属性 permanent_code 的get方法 
	 * @return permanent_code
	 */
	public String getPermanent_code() {
		return permanent_code;
	}
	/**
	 * @Description: 属性 permanent_code 的set方法 
	 * @param permanent_code 
	 */
	public void setPermanent_code(String permanent_code) {
		this.permanent_code = permanent_code;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 下午2:18:27 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "GetCorpTokenParam [suite_id=" + suite_id + ", auth_corpid=" + auth_corpid + ", permanent_code=" + permanent_code + ", suite_access_token=" + suite_access_token
				+ "]";
	}
}
