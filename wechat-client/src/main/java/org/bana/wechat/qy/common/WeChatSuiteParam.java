/**
* @Company 青鸟软通   
* @Title: WeChatSuiteParam.java 
* @Package org.bana.wechat.qy.common 
* @author Liu Wenjie   
* @date 2015-5-12 下午9:02:32 
* @version V1.0   
*/ 
package org.bana.wechat.qy.common;

/** 
 * @ClassName: WeChatSuiteParam 
 * @Description: 调用企业号第三方应用授权API的接口参数
 *  
 */
public class WeChatSuiteParam {

	protected String suite_access_token;//应用套件令牌

	/**
	 * @Description: 属性 suite_access_token 的get方法 
	 * @return suite_access_token
	 */
	public String getSuite_access_token() {
		return suite_access_token;
	}

	/**
	 * @Description: 属性 suite_access_token 的set方法 
	 * @param suite_access_token 
	 */
	public void setSuite_access_token(String suite_access_token) {
		this.suite_access_token = suite_access_token;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-12 下午9:13:51 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "WeChatSuiteParam [suite_access_token=" + suite_access_token + "]";
	}
	
	
	
}
