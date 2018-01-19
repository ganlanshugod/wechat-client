/**
 * @Company 青鸟软通   
 * @Title: CardParam.java 
 * @Package org.bana.wechat.mp.card.param 
 * @author Han Tongyang   
 * @date 2015-10-28 下午5:21:41 
 * @version V1.0   
 */
package org.bana.wechat.mp.card.param;

import java.io.Serializable;

/**
 * @ClassName: CardParam
 * @Description: 卡券参数
 * 
 */
public class CardParam implements Serializable {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = -6091880640530496540L;

	private String code; // 卡券Code码,use_custom_code字段为true的卡券必须填写，非自定义code不必填写。。
	private String card_id; // 卡券ID。
	private String openid; // 指定领取者的openid，只有该用户能领取。bind_openid字段为true的卡券必须填写，非指定openid不必填写。
	private Integer expire_seconds; // 指定二维码的有效时间，范围是60 ~ 1800秒。不填默认为永久有效。
	private boolean is_unique_code; // 指定下发二维码，生成的二维码随机分配一个code，领取后不可再次扫描。填写true或false。默认false。
	private int outer_id; // 领取场景值，用于领取渠道的数据统计，默认值为0，字段类型为整型，长度限制为60位数字。用户领取卡券后触发的事件推送中会带上此自定义场景值。

	/**
	 * @Description: 属性 code 的get方法
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @Description: 属性 code 的set方法
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @Description: 属性 card_id 的get方法
	 * @return card_id
	 */
	public String getCard_id() {
		return card_id;
	}

	/**
	 * @Description: 属性 card_id 的set方法
	 * @param card_id
	 */
	public void setCard_id(String card_id) {
		this.card_id = card_id;
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
	 * @Description: 属性 expire_seconds 的get方法
	 * @return expire_seconds
	 */
	public Integer getExpire_seconds() {
		return expire_seconds;
	}

	/**
	 * @Description: 属性 expire_seconds 的set方法
	 * @param expire_seconds
	 */
	public void setExpire_seconds(Integer expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	/**
	 * @Description: 属性 is_unique_code 的get方法
	 * @return is_unique_code
	 */
	public boolean isIs_unique_code() {
		return is_unique_code;
	}

	/**
	 * @Description: 属性 is_unique_code 的set方法
	 * @param is_unique_code
	 */
	public void setIs_unique_code(boolean is_unique_code) {
		this.is_unique_code = is_unique_code;
	}

	/**
	 * @Description: 属性 outer_id 的get方法
	 * @return outer_id
	 */
	public int getOuter_id() {
		return outer_id;
	}

	/**
	 * @Description: 属性 outer_id 的set方法
	 * @param outer_id
	 */
	public void setOuter_id(int outer_id) {
		this.outer_id = outer_id;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Han Tongyang
	 * @date 2015-10-28 下午5:22:22
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CardParam [code=" + code + ", card_id=" + card_id + ", openid="
				+ openid + ", expire_seconds=" + expire_seconds
				+ ", is_unique_code=" + is_unique_code + ", outer_id="
				+ outer_id + "]";
	}

}
