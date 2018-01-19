/**
* @Company 青鸟软通   
* @Title: PermanentCodeParam.java 
* @Package org.bana.wechat.qy.suite.param 
* @author Liu Wenjie   
* @date 2015-5-14 上午11:54:22 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.param;

import org.bana.wechat.qy.common.WeChatSuiteParam;

/** 
 * @ClassName: PermanentCodeParam 
 * @Description: 获取企业号的永久授权码参数 
 *  
 */
public class PermanentCodeParam extends WeChatSuiteParam {

	private String suite_id;//应用套件id
	private String auth_code;//临时授权码会在授权成功时附加在redirect_uri中跳转回应用提供商网站。

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
	 * @Description: 属性 auth_code 的get方法 
	 * @return auth_code
	 */
	public String getAuth_code() {
		return auth_code;
	}

	/**
	 * @Description: 属性 auth_code 的set方法 
	 * @param auth_code 
	 */
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-14 上午11:56:27 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "PermanentCodeParam [suite_id=" + suite_id + ", auth_code=" + auth_code + ", suite_access_token=" + suite_access_token + "]";
	}
	
}
