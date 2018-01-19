/**
* @Company 艾美伴行   
* @Title: CreateCardBaseInfo.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 上午10:39:16 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.baseinfo;

import java.util.Arrays;

/** 
 * @ClassName: CreateCardBaseInfo 
 * @Description: 创建卡券的基础对象
 *  
 */
public class CreateCardBaseInfo {
	
	//必填字段列表
	private String logo_url;//	是	string(128)	http://mmbiz.qpic.cn/	卡券的商户logo，建议像素为300*300。
	private String code_type;//	是	string(16)	CODE_TYPE_TEXT	Code展示类型，"CODE_TYPE_TEXT"，文本；"CODE_TYPE_BARCODE"，一维码 ；"CODE_TYPE_QRCODE"，二维码；"CODE_TYPE_ONLY_QRCODE",二维码无code显示；"CODE_TYPE_ONLY_BARCODE",一维码无code显示；
	private String brand_name;//	是	string（36）	海底捞	商户名字,字数上限为12个汉字。
	private String title;//	是	string（27）	双人套餐100元兑换券	卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
	private String sub_title;//	否	string（54）	鸳鸯锅底+牛肉1份+土豆一份	券名，字数上限为18个汉字。
	private String color;//	是	string（16）	Color010	券颜色。按色彩规范标注填写Color010-Color100。详情见获取颜色列表接口
	private String notice;//	是	string（48）	请出示二维码核销卡券	卡券使用提醒，字数上限为16个汉字。
	private String description;//	是	string（3072）	不可与其他优惠同享/n如需团购券发票，请向店员提出要求。	卡券使用说明，字数上限为1024个汉字。
	private Sku sku;//	是	Json结构	见上述示例。	商品信息。
	private DateInfo date_info;//	是	Json结构	见上述示例。	使用日期，有效期的信息。

	//非必填字段
	private Boolean use_custom_code;//	否	bool	true	是否自定义Code码。填写true或false，默认为false。通常自有优惠码系统的开发者选择自定义Code码，并在卡券投放时带入Code码，详情见是否自定义Code码。
	private Boolean bind_openid;//	否	bool	true	是否指定用户领取，填写true或false。默认为false。通常指定特殊用户群体投放卡券或防止刷券时选择指定用户领取。
	private String service_phone;//	否	string（24）	40012234	客服电话。
	private int[] location_id_list;//	否	array	1234，2312	门店位置poiid。调用POI门店管理接口获取门店位置poiid。具备线下门店的商户为必填。
	private String source;//	否	string（36）	大众点评	第三方来源名，例如同程旅游、大众点评。
	private String custom_url_name;//	否	string（15）	立即使用	自定义跳转外链的入口名字。详情见活用自定义入口
	private String custom_url;//	否	string（128）	"xxxx.com"	自定义跳转的URL。
	private String custom_url_sub_title;//	否	string（18）	更多惊喜	显示在入口右侧的提示语。
	private String promotion_url_name;//	否	string（15）	产品介绍	营销场景的自定义入口名称。
	private String promotion_url;//	否	string（128）	XXXX.com	入口跳转外链的地址链接。
	private String promotion_url_sub_title;//	否	string（18）	卖场大优惠。	显示在营销入口右侧的提示语。
	private int get_limit;//	否	int	1	每人可领券的数量限制,不填写默认为50。
	private Boolean can_share;//	否	bool	false	卡券领取页面是否可分享。
	private Boolean can_give_friend;//	否	bool	false	卡券是否可转赠。
	private SubMerchantInfo sub_merchant_info;//子商户信息，代制卡券
	/**
	 * @Description: 属性 logo_url 的get方法 
	 * @return logo_url
	 */
	public String getLogo_url() {
		return logo_url;
	}
	/**
	 * @Description: 属性 logo_url 的set方法 
	 * @param logo_url 
	 */
	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}
	/**
	 * @Description: 属性 code_type 的get方法 
	 * @return code_type
	 */
	public String getCode_type() {
		return code_type;
	}
	/**
	 * @Description: 属性 code_type 的set方法 
	 * @param code_type 
	 */
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}
	/**
	 * @Description: 属性 brand_name 的get方法 
	 * @return brand_name
	 */
	public String getBrand_name() {
		return brand_name;
	}
	/**
	 * @Description: 属性 brand_name 的set方法 
	 * @param brand_name 
	 */
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	/**
	 * @Description: 属性 title 的get方法 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @Description: 属性 title 的set方法 
	 * @param title 
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @Description: 属性 sub_title 的get方法 
	 * @return sub_title
	 */
	public String getSub_title() {
		return sub_title;
	}
	/**
	 * @Description: 属性 sub_title 的set方法 
	 * @param sub_title 
	 */
	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	/**
	 * @Description: 属性 color 的get方法 
	 * @return color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @Description: 属性 color 的set方法 
	 * @param color 
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @Description: 属性 notice 的get方法 
	 * @return notice
	 */
	public String getNotice() {
		return notice;
	}
	/**
	 * @Description: 属性 notice 的set方法 
	 * @param notice 
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}
	/**
	 * @Description: 属性 description 的get方法 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @Description: 属性 description 的set方法 
	 * @param description 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @Description: 属性 sku 的get方法 
	 * @return sku
	 */
	public Sku getSku() {
		return sku;
	}
	/**
	 * @Description: 属性 sku 的set方法 
	 * @param sku 
	 */
	public void setSku(Sku sku) {
		this.sku = sku;
	}
	/**
	 * @Description: 属性 date_info 的get方法 
	 * @return date_info
	 */
	public DateInfo getDate_info() {
		return date_info;
	}
	/**
	 * @Description: 属性 date_info 的set方法 
	 * @param date_info 
	 */
	public void setDate_info(DateInfo date_info) {
		this.date_info = date_info;
	}
	/**
	 * @Description: 属性 use_custom_code 的get方法 
	 * @return use_custom_code
	 */
	public Boolean getUse_custom_code() {
		return use_custom_code;
	}
	/**
	 * @Description: 属性 use_custom_code 的set方法 
	 * @param use_custom_code 
	 */
	public void setUse_custom_code(Boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}
	/**
	 * @Description: 属性 bind_openid 的get方法 
	 * @return bind_openid
	 */
	public Boolean getBind_openid() {
		return bind_openid;
	}
	/**
	 * @Description: 属性 bind_openid 的set方法 
	 * @param bind_openid 
	 */
	public void setBind_openid(Boolean bind_openid) {
		this.bind_openid = bind_openid;
	}
	/**
	 * @Description: 属性 service_phone 的get方法 
	 * @return service_phone
	 */
	public String getService_phone() {
		return service_phone;
	}
	/**
	 * @Description: 属性 service_phone 的set方法 
	 * @param service_phone 
	 */
	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}
	/**
	 * @Description: 属性 location_id_list 的get方法 
	 * @return location_id_list
	 */
	public int[] getLocation_id_list() {
		return location_id_list;
	}
	/**
	 * @Description: 属性 location_id_list 的set方法 
	 * @param location_id_list 
	 */
	public void setLocation_id_list(int[] location_id_list) {
		this.location_id_list = location_id_list;
	}
	/**
	 * @Description: 属性 source 的get方法 
	 * @return source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @Description: 属性 source 的set方法 
	 * @param source 
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @Description: 属性 custom_url_name 的get方法 
	 * @return custom_url_name
	 */
	public String getCustom_url_name() {
		return custom_url_name;
	}
	/**
	 * @Description: 属性 custom_url_name 的set方法 
	 * @param custom_url_name 
	 */
	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}
	/**
	 * @Description: 属性 custom_url 的get方法 
	 * @return custom_url
	 */
	public String getCustom_url() {
		return custom_url;
	}
	/**
	 * @Description: 属性 custom_url 的set方法 
	 * @param custom_url 
	 */
	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}
	/**
	 * @Description: 属性 custom_url_sub_title 的get方法 
	 * @return custom_url_sub_title
	 */
	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}
	/**
	 * @Description: 属性 custom_url_sub_title 的set方法 
	 * @param custom_url_sub_title 
	 */
	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}
	/**
	 * @Description: 属性 promotion_url_name 的get方法 
	 * @return promotion_url_name
	 */
	public String getPromotion_url_name() {
		return promotion_url_name;
	}
	/**
	 * @Description: 属性 promotion_url_name 的set方法 
	 * @param promotion_url_name 
	 */
	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}
	/**
	 * @Description: 属性 promotion_url 的get方法 
	 * @return promotion_url
	 */
	public String getPromotion_url() {
		return promotion_url;
	}
	/**
	 * @Description: 属性 promotion_url 的set方法 
	 * @param promotion_url 
	 */
	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}
	/**
	 * @Description: 属性 promotion_url_sub_title 的get方法 
	 * @return promotion_url_sub_title
	 */
	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}
	/**
	 * @Description: 属性 promotion_url_sub_title 的set方法 
	 * @param promotion_url_sub_title 
	 */
	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}
	/**
	 * @Description: 属性 get_limit 的get方法 
	 * @return get_limit
	 */
	public int getGet_limit() {
		return get_limit;
	}
	/**
	 * @Description: 属性 get_limit 的set方法 
	 * @param get_limit 
	 */
	public void setGet_limit(int get_limit) {
		this.get_limit = get_limit;
	}
	/**
	 * @Description: 属性 can_share 的get方法 
	 * @return can_share
	 */
	public Boolean getCan_share() {
		return can_share;
	}
	/**
	 * @Description: 属性 can_share 的set方法 
	 * @param can_share 
	 */
	public void setCan_share(Boolean can_share) {
		this.can_share = can_share;
	}
	/**
	 * @Description: 属性 can_give_friend 的get方法 
	 * @return can_give_friend
	 */
	public Boolean getCan_give_friend() {
		return can_give_friend;
	}
	/**
	 * @Description: 属性 can_give_friend 的set方法 
	 * @param can_give_friend 
	 */
	public void setCan_give_friend(Boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
	}
	/**
	 * @Description: 属性 sub_merchant_info 的get方法 
	 * @return sub_merchant_info
	 */
	public SubMerchantInfo getSub_merchant_info() {
		return sub_merchant_info;
	}
	/**
	 * @Description: 属性 sub_merchant_info 的set方法 
	 * @param sub_merchant_info 
	 */
	public void setSub_merchant_info(SubMerchantInfo sub_merchant_info) {
		this.sub_merchant_info = sub_merchant_info;
	}
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-16 下午9:31:04 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateCardBaseInfo [logo_url=" + logo_url + ", code_type=" + code_type + ", brand_name=" + brand_name + ", title=" + title + ", sub_title=" + sub_title
				+ ", color=" + color + ", notice=" + notice + ", description=" + description + ", sku=" + sku + ", date_info=" + date_info + ", use_custom_code=" + use_custom_code
				+ ", bind_openid=" + bind_openid + ", service_phone=" + service_phone + ", location_id_list=" + Arrays.toString(location_id_list) + ", source=" + source
				+ ", custom_url_name=" + custom_url_name + ", custom_url=" + custom_url + ", custom_url_sub_title=" + custom_url_sub_title + ", promotion_url_name="
				+ promotion_url_name + ", promotion_url=" + promotion_url + ", promotion_url_sub_title=" + promotion_url_sub_title + ", get_limit=" + get_limit + ", can_share="
				+ can_share + ", can_give_friend=" + can_give_friend + ", sub_merchant_info=" + sub_merchant_info + "]";
	}
	

}
