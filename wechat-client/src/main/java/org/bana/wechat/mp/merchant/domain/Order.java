/**
* @Company 艾美伴行   
* @Title: Order.java 
* @Package org.bana.wechat.mp.merchant.domain 
* @author liuwenjie   
* @date 2016-6-16 下午7:03:10 
* @version V1.0   
*/ 
package org.bana.wechat.mp.merchant.domain;

/** 
 * @ClassName: Order 
 * @Description: 订单详情接口
 *  
 */
public class Order {

	private String order_id;//	订单ID
	private Integer order_status;//	订单状态
	private Integer order_total_price;//	订单总价格(单位 : 分)
	private Long order_create_time;//	订单创建时间
	private Integer order_express_price;//	订单运费价格(单位 : 分)
	private String buyer_openid	;//买家微信OPENID
	private String buyer_nick;//	买家微信昵称
	private String receiver_name;//	收货人姓名
	private String receiver_province;//	收货地址省份
	private String receiver_city;//	收货地址城市
	private String receiver_zone;//	收货地址区/县
	private String receiver_address;//	收货详细地址
	private String receiver_mobile;//	收货人移动电话
	private String receiver_phone;//	收货人固定电话
	private String product_id	;//商品ID
	private String product_name	;//商品名称
	private Integer product_price;//	商品价格(单位 : 分)
	private String product_sku;//	商品SKU
	private Integer product_count;//	商品个数
	private String product_img;//	商品图片
	private String delivery_id;//	运单ID
	private String delivery_company;//	物流公司编码
	private String trans_id;//	交易ID
	/**
	 * @Description: 属性 order_id 的get方法 
	 * @return order_id
	 */
	public String getOrder_id() {
		return order_id;
	}
	/**
	 * @Description: 属性 order_id 的set方法 
	 * @param order_id 
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	/**
	 * @Description: 属性 order_status 的get方法 
	 * @return order_status
	 */
	public Integer getOrder_status() {
		return order_status;
	}
	/**
	 * @Description: 属性 order_status 的set方法 
	 * @param order_status 
	 */
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	/**
	 * @Description: 属性 order_total_price 的get方法 
	 * @return order_total_price
	 */
	public Integer getOrder_total_price() {
		return order_total_price;
	}
	/**
	 * @Description: 属性 order_total_price 的set方法 
	 * @param order_total_price 
	 */
	public void setOrder_total_price(Integer order_total_price) {
		this.order_total_price = order_total_price;
	}
	/**
	 * @Description: 属性 order_create_time 的get方法 
	 * @return order_create_time
	 */
	public Long getOrder_create_time() {
		return order_create_time;
	}
	/**
	 * @Description: 属性 order_create_time 的set方法 
	 * @param order_create_time 
	 */
	public void setOrder_create_time(Long order_create_time) {
		this.order_create_time = order_create_time;
	}
	/**
	 * @Description: 属性 order_express_price 的get方法 
	 * @return order_express_price
	 */
	public Integer getOrder_express_price() {
		return order_express_price;
	}
	/**
	 * @Description: 属性 order_express_price 的set方法 
	 * @param order_express_price 
	 */
	public void setOrder_express_price(Integer order_express_price) {
		this.order_express_price = order_express_price;
	}
	/**
	 * @Description: 属性 buyer_openid 的get方法 
	 * @return buyer_openid
	 */
	public String getBuyer_openid() {
		return buyer_openid;
	}
	/**
	 * @Description: 属性 buyer_openid 的set方法 
	 * @param buyer_openid 
	 */
	public void setBuyer_openid(String buyer_openid) {
		this.buyer_openid = buyer_openid;
	}
	/**
	 * @Description: 属性 buyer_nick 的get方法 
	 * @return buyer_nick
	 */
	public String getBuyer_nick() {
		return buyer_nick;
	}
	/**
	 * @Description: 属性 buyer_nick 的set方法 
	 * @param buyer_nick 
	 */
	public void setBuyer_nick(String buyer_nick) {
		this.buyer_nick = buyer_nick;
	}
	/**
	 * @Description: 属性 receiver_name 的get方法 
	 * @return receiver_name
	 */
	public String getReceiver_name() {
		return receiver_name;
	}
	/**
	 * @Description: 属性 receiver_name 的set方法 
	 * @param receiver_name 
	 */
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	/**
	 * @Description: 属性 receiver_province 的get方法 
	 * @return receiver_province
	 */
	public String getReceiver_province() {
		return receiver_province;
	}
	/**
	 * @Description: 属性 receiver_province 的set方法 
	 * @param receiver_province 
	 */
	public void setReceiver_province(String receiver_province) {
		this.receiver_province = receiver_province;
	}
	/**
	 * @Description: 属性 receiver_city 的get方法 
	 * @return receiver_city
	 */
	public String getReceiver_city() {
		return receiver_city;
	}
	/**
	 * @Description: 属性 receiver_city 的set方法 
	 * @param receiver_city 
	 */
	public void setReceiver_city(String receiver_city) {
		this.receiver_city = receiver_city;
	}
	/**
	 * @Description: 属性 receiver_zone 的get方法 
	 * @return receiver_zone
	 */
	public String getReceiver_zone() {
		return receiver_zone;
	}
	/**
	 * @Description: 属性 receiver_zone 的set方法 
	 * @param receiver_zone 
	 */
	public void setReceiver_zone(String receiver_zone) {
		this.receiver_zone = receiver_zone;
	}
	/**
	 * @Description: 属性 receiver_address 的get方法 
	 * @return receiver_address
	 */
	public String getReceiver_address() {
		return receiver_address;
	}
	/**
	 * @Description: 属性 receiver_address 的set方法 
	 * @param receiver_address 
	 */
	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}
	/**
	 * @Description: 属性 receiver_mobile 的get方法 
	 * @return receiver_mobile
	 */
	public String getReceiver_mobile() {
		return receiver_mobile;
	}
	/**
	 * @Description: 属性 receiver_mobile 的set方法 
	 * @param receiver_mobile 
	 */
	public void setReceiver_mobile(String receiver_mobile) {
		this.receiver_mobile = receiver_mobile;
	}
	/**
	 * @Description: 属性 receiver_phone 的get方法 
	 * @return receiver_phone
	 */
	public String getReceiver_phone() {
		return receiver_phone;
	}
	/**
	 * @Description: 属性 receiver_phone 的set方法 
	 * @param receiver_phone 
	 */
	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
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
	 * @Description: 属性 product_name 的get方法 
	 * @return product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @Description: 属性 product_name 的set方法 
	 * @param product_name 
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/**
	 * @Description: 属性 product_price 的get方法 
	 * @return product_price
	 */
	public Integer getProduct_price() {
		return product_price;
	}
	/**
	 * @Description: 属性 product_price 的set方法 
	 * @param product_price 
	 */
	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}
	/**
	 * @Description: 属性 product_sku 的get方法 
	 * @return product_sku
	 */
	public String getProduct_sku() {
		return product_sku;
	}
	/**
	 * @Description: 属性 product_sku 的set方法 
	 * @param product_sku 
	 */
	public void setProduct_sku(String product_sku) {
		this.product_sku = product_sku;
	}
	/**
	 * @Description: 属性 product_count 的get方法 
	 * @return product_count
	 */
	public Integer getProduct_count() {
		return product_count;
	}
	/**
	 * @Description: 属性 product_count 的set方法 
	 * @param product_count 
	 */
	public void setProduct_count(Integer product_count) {
		this.product_count = product_count;
	}
	/**
	 * @Description: 属性 product_img 的get方法 
	 * @return product_img
	 */
	public String getProduct_img() {
		return product_img;
	}
	/**
	 * @Description: 属性 product_img 的set方法 
	 * @param product_img 
	 */
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	/**
	 * @Description: 属性 delivery_id 的get方法 
	 * @return delivery_id
	 */
	public String getDelivery_id() {
		return delivery_id;
	}
	/**
	 * @Description: 属性 delivery_id 的set方法 
	 * @param delivery_id 
	 */
	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
	}
	/**
	 * @Description: 属性 delivery_company 的get方法 
	 * @return delivery_company
	 */
	public String getDelivery_company() {
		return delivery_company;
	}
	/**
	 * @Description: 属性 delivery_company 的set方法 
	 * @param delivery_company 
	 */
	public void setDelivery_company(String delivery_company) {
		this.delivery_company = delivery_company;
	}
	/**
	 * @Description: 属性 trans_id 的get方法 
	 * @return trans_id
	 */
	public String getTrans_id() {
		return trans_id;
	}
	/**
	 * @Description: 属性 trans_id 的set方法 
	 * @param trans_id 
	 */
	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-16 下午7:51:56 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_status=" + order_status + ", order_total_price=" + order_total_price + ", order_create_time=" + order_create_time
				+ ", order_express_price=" + order_express_price + ", buyer_openid=" + buyer_openid + ", buyer_nick=" + buyer_nick + ", receiver_name=" + receiver_name
				+ ", receiver_province=" + receiver_province + ", receiver_city=" + receiver_city + ", receiver_zone=" + receiver_zone + ", receiver_address=" + receiver_address
				+ ", receiver_mobile=" + receiver_mobile + ", receiver_phone=" + receiver_phone + ", product_id=" + product_id + ", product_name=" + product_name
				+ ", product_price=" + product_price + ", product_sku=" + product_sku + ", product_count=" + product_count + ", product_img=" + product_img + ", delivery_id="
				+ delivery_id + ", delivery_company=" + delivery_company + ", trans_id=" + trans_id + "]";
	}

}
