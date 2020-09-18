/**
* @Company 全域旅游
* @Title: AuthorizationInfo.java 
* @Package org.bana.wechat.mp.component.result 
* @author liuwenjie   
* @date Sep 18, 2020 2:04:14 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.result;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/** 
* @ClassName: AuthorizationInfo 
* @Description: 授权成功后查询到的授权返回结果
* @author liuwenjie   
*/
public class AuthorizationInfo implements Serializable{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -7601257141888027951L;
	
	@JSONField(name="authorizer_appid")
	private String authorizerAppid; //	string	授权方 appid
	
	@JSONField(name="authorizer_access_token")
	private String authorizerAccessToken; //	string	接口调用令牌（在授权的公众号/小程序具备 API 权限时，才有此返回值）
	
	@JSONField(name="expires_in")
	private int expiresIn; //	number	authorizer_access_token 的有效期（在授权的公众号/小程序具备API权限时，才有此返回值），单位：秒
	
	@JSONField(name="authorizer_refresh_token")
	private String authorizerRefreshToken; //	string	刷新令牌（在授权的公众号具备API权限时，才有此返回值），刷新令牌主要用于第三方平台获取和刷新已授权用户的 authorizer_access_token。一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌。用户重新授权后，之前的刷新令牌会失效
	
	@JSONField(name="func_info")
	private JSONArray funcInfo; //		授权给开发者的权限集列表
	

	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}

	public void setAuthorizerAccessToken(String authorizerAccessToken) {
		this.authorizerAccessToken = authorizerAccessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}

	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}

	public JSONArray getFuncInfo() {
		return funcInfo;
	}

	public void setFuncInfo(JSONArray funcInfo) {
		this.funcInfo = funcInfo;
	}
	
	public List<String> getFuncIdList(){
		if(funcInfo != null) {
			return funcInfo.stream().map(item -> {
		    	JSONObject obj = (JSONObject)item;
		    	return obj.getJSONObject("funcscope_category").getString("id");
		    }).collect(Collectors.toList());
			
		}
		return null;
	}

	
	@Override
	public String toString() {
		return "AuthorizationInfo [authorizerAppid=" + authorizerAppid + ", authorizerAccessToken="
				+ authorizerAccessToken + ", expiresIn=" + expiresIn + ", authorizerRefreshToken="
				+ authorizerRefreshToken + ", funcInfo=" + funcInfo + "]";
	}
	

}
