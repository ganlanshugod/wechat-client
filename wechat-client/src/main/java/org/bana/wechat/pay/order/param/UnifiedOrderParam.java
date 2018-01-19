/**
* @Company 青鸟软通   
* @Title: UnifiedOrderParam.java 
* @Package org.bana.wechat.pay.unifiedorder.param 
* @author Liu Wenjie   
* @date 2015-9-17 下午5:31:58 
* @version V1.0   
*/ 
package org.bana.wechat.pay.order.param;

import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.pay.common.WechatPayParam;

/** 
 * @ClassName: UnifiedOrderParam 
 * @Description: 统一下单的接口参数
 *  
 */
@XmlRootElement(name="xml")
public class UnifiedOrderParam extends WechatPayParam {

	private String appid;//公众账号ID	appid	是	String(32)	wx8888888888888888	微信分配的公众账号ID（企业号corpid即为此appId）
	private String mch_id;//商户号	mch_id	是	String(32)	1900000109	微信支付分配的商户号
	private String device_info;//设备号	device_info	否	String(32)	013467007045764	终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
	private String body;//商品描述	body	是	String(32)	Ipad mini  16G  白色	商品或支付单简要描述
	private String detail;//商品详情	detail	否	String(8192)	Ipad mini  16G  白色	商品名称明细列表
	private String attach;//附加数据	attach	否	String(127)	说明	附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	private String out_trade_no;//商户订单号	out_trade_no	是	String(32)	1217752501201407033233368018	商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
	private String fee_type;//货币类型	fee_type	否	String(16)	CNY	符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	private Integer total_fee;//总金额	total_fee	是	Int	888	订单总金额，只能为整数，详见支付金额
	private String spbill_create_ip;//终端IP	spbill_create_ip	是	String(16)	8.8.8.8	APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	private String time_start;//交易起始时间	time_start	否	String(14)	20091225091010	订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
	private String time_expire;//交易结束时间	time_expire	否	String(14)	20091227091010      订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则
	//注意：最短失效时间间隔必须大于5分钟
	private String goods_tag;//商品标记	goods_tag	否	String(32)	WXG	商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
	private String notify_url;//通知地址	notify_url	是	String(256)	http://www.baidu.com	接收微信支付异步通知回调地址
	private String trade_type;//交易类型	trade_type	是	String(16)	JSAPI	取值如下：JSAPI，NATIVE，APP，WAP,详细说明见参数规定
	private String product_id;//商品ID	product_id	否	String(32)	12235413214070356458058	trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
	private String limit_pay;//指定支付方式	limit_pay	否	String(32)	no_credit	no_credit--指定不能使用信用卡支付
	private String openid;//用户标识	openid	否	String(128)	oUpF8uMuAJO_M2pxb1Q9zNjWeS6o	trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
	/**
	 * @Description: 属性 appid 的get方法 
	 * @return appid
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * @Description: 属性 appid 的set方法 
	 * @param appid 
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * @Description: 属性 mch_id 的get方法 
	 * @return mch_id
	 */
	public String getMch_id() {
		return mch_id;
	}
	/**
	 * @Description: 属性 mch_id 的set方法 
	 * @param mch_id 
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	/**
	 * @Description: 属性 device_info 的get方法 
	 * @return device_info
	 */
	public String getDevice_info() {
		return device_info;
	}
	/**
	 * @Description: 属性 device_info 的set方法 
	 * @param device_info 
	 */
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	/**
	 * @Description: 属性 body 的get方法 
	 * @return body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @Description: 属性 body 的set方法 
	 * @param body 
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * @Description: 属性 detail 的get方法 
	 * @return detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @Description: 属性 detail 的set方法 
	 * @param detail 
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * @Description: 属性 attach 的get方法 
	 * @return attach
	 */
	public String getAttach() {
		return attach;
	}
	/**
	 * @Description: 属性 attach 的set方法 
	 * @param attach 
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}
	/**
	 * @Description: 属性 out_trade_no 的get方法 
	 * @return out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}
	/**
	 * @Description: 属性 out_trade_no 的set方法 
	 * @param out_trade_no 
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	/**
	 * @Description: 属性 fee_type 的get方法 
	 * @return fee_type
	 */
	public String getFee_type() {
		return fee_type;
	}
	/**
	 * @Description: 属性 fee_type 的set方法 
	 * @param fee_type 
	 */
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	/**
	 * @Description: 属性 total_fee 的get方法 
	 * @return total_fee
	 */
	public Integer getTotal_fee() {
		return total_fee;
	}
	/**
	 * @Description: 属性 total_fee 的set方法 
	 * @param total_fee 
	 */
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}
	/**
	 * @Description: 属性 spbill_create_ip 的get方法 
	 * @return spbill_create_ip
	 */
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	/**
	 * @Description: 属性 spbill_create_ip 的set方法 
	 * @param spbill_create_ip 
	 */
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	/**
	 * @Description: 属性 time_start 的get方法 
	 * @return time_start
	 */
	public String getTime_start() {
		return time_start;
	}
	/**
	 * @Description: 属性 time_start 的set方法 
	 * @param time_start 
	 */
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	/**
	 * @Description: 属性 time_expire 的get方法 
	 * @return time_expire
	 */
	public String getTime_expire() {
		return time_expire;
	}
	/**
	 * @Description: 属性 time_expire 的set方法 
	 * @param time_expire 
	 */
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	/**
	 * @Description: 属性 goods_tag 的get方法 
	 * @return goods_tag
	 */
	public String getGoods_tag() {
		return goods_tag;
	}
	/**
	 * @Description: 属性 goods_tag 的set方法 
	 * @param goods_tag 
	 */
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	/**
	 * @Description: 属性 notify_url 的get方法 
	 * @return notify_url
	 */
	public String getNotify_url() {
		return notify_url;
	}
	/**
	 * @Description: 属性 notify_url 的set方法 
	 * @param notify_url 
	 */
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	/**
	 * @Description: 属性 trade_type 的get方法 
	 * @return trade_type
	 */
	public String getTrade_type() {
		return trade_type;
	}
	/**
	 * @Description: 属性 trade_type 的set方法 
	 * @param trade_type 
	 */
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	/**
	 * @Description: 属性 product_id 的get方法 
	 * @return product_id
	 */
	public String getProduct_id() {
		return product_id;
	}
	/**
	 * @Description: 属性 product_id 的set方法 
	 * @param product_id 
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	/**
	 * @Description: 属性 limit_pay 的get方法 
	 * @return limit_pay
	 */
	public String getLimit_pay() {
		return limit_pay;
	}
	/**
	 * @Description: 属性 limit_pay 的set方法 
	 * @param limit_pay 
	 */
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	/**
	 * @Description: 属性 openid 的get方法 
	 * @return openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * @Description: 属性 openid 的set方法 
	 * @param openid 
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-17 下午5:36:18 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "UnifiedOrderParam [appid=" + appid + ", mch_id=" + mch_id + ", device_info=" + device_info + ", nonce_str=" + nonce_str + ", sign=" + sign + ", body=" + body
				+ ", detail=" + detail + ", attach=" + attach + ", out_trade_no=" + out_trade_no + ", fee_type=" + fee_type + ", total_fee=" + total_fee + ", spbill_create_ip="
				+ spbill_create_ip + ", time_start=" + time_start + ", time_expire=" + time_expire + ", goods_tag=" + goods_tag + ", notify_url=" + notify_url + ", trade_type="
				+ trade_type + ", product_id=" + product_id + ", limit_pay=" + limit_pay + ", openid=" + openid + "]";
	}

}
