/**
* @Company 全域旅游
* @Title: AuthorizerInfo.java 
* @Package org.bana.wechat.mp.component.result 
* @author liuwenjie   
* @date Sep 18, 2020 3:52:11 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.result;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/** 
* @ClassName: AuthorizerInfo 
* @Description: 授权的公众号对应的信息
* @author liuwenjie   
*/
public class AuthorizerInfo implements Serializable{
	
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -2123897690396468413L;
	
	@JSONField(name="nick_name")
	private String nickName; // string	昵称
	
	@JSONField(name="head_img")
	private String headImg; //	string	头像
	
	@JSONField(name="service_type_info")
	private JSONObject serviceTypeInfo;//	object	默认为 0
	
	@JSONField(name="verify_type_info")
	private JSONObject verifyTypeInfo;//	object	小程序认证类型
	
	@JSONField(name="user_name")
	private String userName;//	string	原始 ID
	
	@JSONField(name="principal_name")
	private String principalName;//	string	主体名称
	
	@JSONField(name="alias")
	private String alias; //	string	公众号所设置的微信号，可能为空
	
	@JSONField(name="signature")
	private String signature;//	string	帐号介绍
	
	@JSONField(name="business_info")
	private BusinessInfo businessInfo;//	object	用以了解功能的开通状况（0代表未开通，1代表已开通），详见business_info 说明
	
	@JSONField(name="qrcode_url")
	private String qrcodeUrl;//	string	二维码图片的 URL，开发者最好自行也进行保存
	
	@JSONField(name="MiniProgramInfo")
	private JSONObject miniProgramInfo;//	object	小程序配置，根据这个字段判断是否为小程序类型授权

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public JSONObject getServiceTypeInfo() {
		return serviceTypeInfo;
	}

	public void setServiceTypeInfo(JSONObject serviceTypeInfo) {
		this.serviceTypeInfo = serviceTypeInfo;
	}

	public JSONObject getVerifyTypeInfo() {
		return verifyTypeInfo;
	}

	public void setVerifyTypeInfo(JSONObject verifyTypeInfo) {
		this.verifyTypeInfo = verifyTypeInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public BusinessInfo getBusinessInfo() {
		return businessInfo;
	}

	public void setBusinessInfo(BusinessInfo businessInfo) {
		this.businessInfo = businessInfo;
	}

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}

	public JSONObject getMiniProgramInfo() {
		return miniProgramInfo;
	}

	public void setMiniProgramInfo(JSONObject miniProgramInfo) {
		this.miniProgramInfo = miniProgramInfo;
	}
	
	public boolean isMiniApp() {
		return this.miniProgramInfo == null;
	}

	@Override
	public String toString() {
		return "AuthorizerInfo [nickName=" + nickName + ", headImg=" + headImg + ", serviceTypeInfo=" + serviceTypeInfo
				+ ", verifyTypeInfo=" + verifyTypeInfo + ", userName=" + userName + ", principalName=" + principalName
				+ ", alias=" + alias + ", signature=" + signature + ", businessInfo=" + businessInfo + ", qrcodeUrl="
				+ qrcodeUrl + ", miniProgramInfo=" + miniProgramInfo + "]";
	}
	
}
