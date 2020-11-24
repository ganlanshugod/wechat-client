/**
* @Company 青鸟软通   
* @Title: Constants.java 
* @Package org.bana.wechat.mp.common 
* @author Liu Wenjie   
* @date 2015-8-18 下午5:02:25 
* @version V1.0   
*/ 
package org.bana.wechat.mp.common;

/** 
 * @ClassName: Constants 
 * @Description: 服务号的常量对象
 *  
 */
public enum Constants {

	/*接口地址的公共*/
	接口根路径("https://api.weixin.qq.com"),
	MP_BASE_AUTH_URL("https://open.weixin.qq.com/connect/oauth2/authorize?appid=${APPID}&redirect_uri=${REDIRECT_URI}&response_type=code&scope=snsapi_base&state=${state}&#wechat_redirect"),
	MP_USERINFO_AUTH_URL("https://open.weixin.qq.com/connect/oauth2/authorize?appid=${APPID}&redirect_uri=${REDIRECT_URI}&response_type=code&scope=snsapi_userinfo&state=${state}&#wechat_redirect"),
	获取服务号access_token(接口根路径.value + "/cgi-bin/token"),
	获取服务号JsApiTicket(接口根路径.value + "/cgi-bin/ticket/getticket"),
	/*生成短连接的方法*/
	长链接转短链接(接口根路径.value + "/cgi-bin/shorturl"),
	/*用户管理*/
	获取用户基本信息(接口根路径.value + "/cgi-bin/user/info"),
	获取关注者列表(接口根路径.value + "/cgi-bin/user/get"),
	支付完成后获取用户信息(接口根路径.value + "/wxa/getpaidunionid"),
	/*菜单管理*/
	创建自定义菜单(接口根路径.value + "/cgi-bin/menu/create"),
	查询自定义菜单(接口根路径.value + "/cgi-bin/menu/get"),
	获取自定义菜单配置(接口根路径.value + "/cgi-bin/get_current_selfmenu_info"),
	删除自定义菜单(接口根路径.value + "/cgi-bin/menu/delete"),
	/*自动回复*/
	获取公众号的自动回复规则(接口根路径.value + "/cgi-bin/get_current_autoreply_info"),
	/*素材管理*/
	获取素材列表(接口根路径.value + "/cgi-bin/material/batchget_material"),
	/*页面认证*/
	页面认证获取TOKEN(接口根路径.value + "/sns/oauth2/access_token"),
	页面认证拉取用户信息(接口根路径.value + "/sns/userinfo"),
	/*小程序登陆*/
	小程序登录凭证校验(接口根路径.value + "/sns/jscode2session"),
	/*卡券*/
	团购券("GROUPON"),代金券("CASH"),折扣券("DISCOUNT"),礼品券("GIFT"),优惠券("GENERAL_COUPON"),
	Code展示类型_文本("CODE_TYPE_TEXT"),Code展示类型_一维码("CODE_TYPE_BARCODECode"),Code展示类型_二维码("CODE_TYPE_QRCODE"),
	Code展示类型_二维码无code("CODE_TYPE_ONLY_QRCODE"),Code展示类型_一维码无code("CODE_TYPE_ONLY_BARCODE"),
	卡券时间_固定时间段("DATE_TYPE_FIX_TIME_RANGE"),卡券时间_固定时长("DATE_TYPE_FIX_TERM"),
	创建卡券(接口根路径.value +  "/card/create"),
	投放卡券_生成二维码(接口根路径.value + "/card/qrcode/create"),
	/*账号管理*/
	账号管理_生成二维码(接口根路径.value + "/cgi-bin/qrcode/create"),
	/*上传媒体文件*/
	上传媒体文件(接口根路径.value + "/cgi-bin/media/upload"),
	上传图文消息素材(接口根路径.value + "/cgi-bin/media/uploadnews"),
	上传图文消息内容图片(接口根路径.value + "/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN&type=TYPE"),
	/*收发消息*/
	群发消息(接口根路径.value + "/cgi-bin/message/mass/sendall"),
	客服消息接口(接口根路径.value + "/cgi-bin/message/custom/send"),
	模板消息接口(接口根路径.value + "/cgi-bin/message/template/send"),
	/*收发消息*/
	获取订单详情接口(接口根路径.value + "/merchant/order/getbyid"),
	
	
	/* 第三方服务商相关的接口地址 */
    第三方获取令牌(接口根路径.value+"/cgi-bin/component/api_component_token"),
    第三方获取预授权码(接口根路径.value+"/cgi-bin/component/api_create_preauthcode"),
    第三方获取授权信息(接口根路径.value+"/cgi-bin/component/api_query_auth"),
    第三方获取服务号AccessToken(接口根路径.value+"/cgi-bin/component/api_authorizer_token"),
    第三方获取授权详细信息(接口根路径.value+"/cgi-bin/component/api_get_authorizer_info"),
    第三方获取授权方配置开关(接口根路径.value+"/cgi-bin/component/api_get_authorizer_option"),
    第三方设置授权方配置开关(接口根路径.value+"/cgi-bin/component/api_set_authorizer_option"),
    第三方获取页面认证token的接口(接口根路径.value+"/sns/oauth2/component/access_token"),
    第三方获取授权公众号列表(接口根路径.value+"/cgi-bin/component/api_get_authorizer_list"),
    
	
	/*返回值属性的设置*/
	返回码("errcode"),
	返回信息("errmsg"),
	成功码("0");
	
	
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
