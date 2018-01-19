/**
* @Company 青鸟软通   
* @Title: SetSessionInfoParam.java 
* @Package org.bana.wechat.qy.suite.param 
* @author Liu Wenjie   
* @date 2016-1-8 上午10:50:34 
* @version V1.0   
*/ 
package org.bana.wechat.qy.suite.param;

import org.bana.wechat.qy.common.WeChatSuiteParam;

/** 
 * @ClassName: SetSessionInfoParam 
 * @Description: 设置企业号应用sesion信息参数
 *  
 */
public class SetSessionInfoParam extends WeChatSuiteParam{

	private String pre_auth_code;//	是	预授权码
	private SessionInfo session_info;//	是	本次授权过程中需要用到的会话信息
	/**
	 * @Description: 属性 pre_auth_code 的get方法 
	 * @return pre_auth_code
	 */
	public String getPre_auth_code() {
		return pre_auth_code;
	}
	/**
	 * @Description: 属性 pre_auth_code 的set方法 
	 * @param pre_auth_code 
	 */
	public void setPre_auth_code(String pre_auth_code) {
		this.pre_auth_code = pre_auth_code;
	}
	/**
	 * @Description: 属性 session_info 的get方法 
	 * @return session_info
	 */
	public SessionInfo getSession_info() {
		return session_info;
	}
	/**
	 * @Description: 属性 session_info 的set方法 
	 * @param session_info 
	 */
	public void setSession_info(SessionInfo session_info) {
		this.session_info = session_info;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2016-1-8 上午10:57:38 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "SetSessionInfoParam [pre_auth_code=" + pre_auth_code + ", session_info=" + session_info + "]";
	}
	 
}
