/**
* @Company 青鸟软通   
* @Title: Constants.java 
* @Package org.bana.wechat.qy.connection 
* @author Liu Wenjie   
* @date 2015-5-9 下午3:25:40 
* @version V1.0   
*/ 
package org.bana.wechat.cp.common;

/** 
 * @ClassName: Constants 
 * @Description: 定义企业号访问的一些公共变量
 *  
 */
public enum Constants {
	/*接口地址的公共*/
	接口根路径("https://qyapi.weixin.qq.com"),
	/*获取公共访问令牌的接口地址*/
	获取AccessToken(接口根路径.value + "/cgi-bin/gettoken"),
	获取SuiteToken(接口根路径.value + "/cgi-bin/service/get_suite_token"),
	获取JsApiTicket(接口根路径.value + "/cgi-bin/get_jsapi_ticket"),
	获取应用提供商凭证(接口根路径.value + "/cgi-bin/service/get_provider_token"),
	/*部门管理相关接口地址*/
	获取部门列表(接口根路径.value + "/cgi-bin/department/list"),
	创建部门(接口根路径.value + "/cgi-bin/department/create"),
	更新部门(接口根路径.value + "/cgi-bin/department/update"),
	删除部门(接口根路径.value + "/cgi-bin/department/delete"),
	/*用户相关接口*/
	创建成员(接口根路径.value + "/cgi-bin/user/create"),
	更新成员(接口根路径.value + "/cgi-bin/user/update"),
	删除成员(接口根路径.value + "/cgi-bin/user/delete"),
	批量删除成员(接口根路径.value + "/cgi-bin/user/batchdelete"),
	获取成员(接口根路径.value + "/cgi-bin/user/get"),
	获取部门成员(接口根路径.value + "/cgi-bin/user/simplelist"),
	获取部门成员详情(接口根路径.value + "/cgi-bin/user/list"),
	邀请成员关注(接口根路径.value + "/cgi-bin/invite/send"),
	userid转换成openid接口(接口根路径.value + "/cgi-bin/user/convert_to_openid"),
	openid转换成userid接口(接口根路径.value + "/cgi-bin/user/convert_to_userid"),
	/*标签相关的接口*/
	创建标签(接口根路径.value + "/cgi-bin/tag/create"),
	更新标签名字(接口根路径.value + "/cgi-bin/tag/update"),
	删除标签(接口根路径.value + "/cgi-bin/tag/delete"),
	获取标签成员(接口根路径.value + "/cgi-bin/tag/get"),
	增加标签成员(接口根路径.value + "/cgi-bin/tag/addtagusers"),
	删除标签成员(接口根路径.value + "/cgi-bin/tag/deltagusers"),
	获取标签列表(接口根路径.value + "/cgi-bin/tag/list"),
	/*========第三方应用接口===========*/
	获取预授权码(接口根路径.value + "/cgi-bin/service/get_pre_auth_code"),
	设置授权配置(接口根路径.value + "/cgi-bin/service/set_session_info"),
	获取企业号的永久授权码(接口根路径.value + "/cgi-bin/service/get_permanent_code"),
	获取企业号的授权信息(接口根路径.value + "/cgi-bin/service/get_auth_info"),
	获取企业号应用(接口根路径.value + "/cgi-bin/service/get_agent"),
	设置企业号应用(接口根路径.value + "/cgi-bin/service/set_agent"),
	获取企业号access_token(接口根路径.value + "/cgi-bin/service/get_corp_token"),
	设置应用得属性_测试临时接口(接口根路径.value + "/cgi-bin/service/mark_as_contacts_suite"),
	/*=========管理企业号应用============*/
	获取企业号应用_access(接口根路径.value + "/cgi-bin/agent/get"),
	设置企业号应用_access(接口根路径.value + "/cgi-bin/agent/set"),
	获取应用概况列表说明(接口根路径.value + "/cgi-bin/agent/list"),
	/*==========自定义菜单的接口==============*/
	获取菜单列表(接口根路径.value + "/cgi-bin/menu/get"),
	创建应用菜单(接口根路径.value + "/cgi-bin/menu/create"),
	删除菜单(接口根路径.value + "/cgi-bin/menu/delete"),
	/*===========根据code获取成员信息===========*/
	根据code获取成员信息(接口根路径.value + "/cgi-bin/user/getuserinfo"),
	/*===========发消息的接口=================*/
	发送消息(接口根路径.value + "/cgi-bin/message/send"),
	/*========消息类型===========*/
	text消息("text"),
	image消息("image"),
	voice消息("voice"),
	video消息("video"),
	file消息("file"),
	news消息("news"),
	mpnews消息("mpnews"),
	/*========素材管理=================*/
	上传临时素材文件(接口根路径.value + "/cgi-bin/media/upload"),
	图片素材("image"),
	语音素材("voice"),
	视频素材("video"),
	普通文件素材("file"),
	/*========摇一摇周边=================*/
	获取摇周边的设备及用户信息(接口根路径.value + "/cgi-bin/shakearound/getshakeinfo"),
	/*返回值属性的设置*/
	返回码("errcode"),
	返回信息("errmsg"),
	成功码("0"),
	/*=======微信单点登录=================*/
	微信单点登录获取用户登录信息(接口根路径.value + "/cgi-bin/service/get_login_info"),
	发送客服消息(接口根路径.value + "/cgi-bin/kf/send"),
	获取客服列表(接口根路径.value + "/cgi-bin/kf/list"),
	/*=======异步任务=================*/
	全量覆盖部门(接口根路径.value + "/cgi-bin/batch/replaceparty"),
	批量更新成员(接口根路径.value + "/cgi-bin/batch/syncUser"),
	;
	
	
	private String value;
	
	private Constants(String value){
		this.value = value;
	}
	/**
	 * @Description: 属性 value 的get方法 
	 * @return value
	 */
	public String getValue() {
		return value;
	}
	
}
