/**
* @Company 全域旅游
* @Title: AuthDetailInfo.java 
* @Package org.bana.wechat.mp.component.result 
* @author liuwenjie   
* @date Sep 18, 2020 3:44:52 PM 
* @version V1.0   
*/
package org.bana.wechat.mp.component.result;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: AuthDetailInfo
 * @Description: 授权的公众号的详细信息
 * @author liuwenjie
 */
public class AuthDetailInfo implements Serializable {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 6539148633605792452L;

	@JSONField(name = "authorization_info")
	private AuthorizationInfo authorizationInfo;

	@JSONField(name = "authorizer_info")
	private AuthorizerInfo authorizerInfo;

	public AuthorizationInfo getAuthorizationInfo() {
		return authorizationInfo;
	}

	public void setAuthorizationInfo(AuthorizationInfo authorizationInfo) {
		this.authorizationInfo = authorizationInfo;
	}

	public AuthorizerInfo getAuthorizerInfo() {
		return authorizerInfo;
	}

	public void setAuthorizerInfo(AuthorizerInfo authorizerInfo) {
		this.authorizerInfo = authorizerInfo;
	}

	@Override
	public String toString() {
		return "AuthDetailInfo [authorizationInfo=" + authorizationInfo + ", authorizerInfo=" + authorizerInfo + "]";
	}

}
