/**
* @Company 全域旅游
* @Title: BusinessInfo.java 
* @Package org.bana.wechat.mp.component.result 
* @author liuwenjie   
* @date Sep 18, 2020 4:06:03 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.result;

import java.io.Serializable;

/** 
* @ClassName: BusinessInfo 
* @Description: 业务信息对象
* @author liuwenjie   
*/
public class BusinessInfo implements Serializable{

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -7315474018781760581L;
	private String open_store;//	是否开通微信门店功能
	private String open_scan;	//是否开通微信扫商品功能
	private String open_pay;//	是否开通微信支付功能
	private String open_card;//	是否开通微信卡券功能
	private String open_shake;//	是否开通微信摇一摇功能
	public String getOpen_store() {
		return open_store;
	}
	public void setOpen_store(String open_store) {
		this.open_store = open_store;
	}
	public String getOpen_scan() {
		return open_scan;
	}
	public void setOpen_scan(String open_scan) {
		this.open_scan = open_scan;
	}
	public String getOpen_pay() {
		return open_pay;
	}
	public void setOpen_pay(String open_pay) {
		this.open_pay = open_pay;
	}
	public String getOpen_card() {
		return open_card;
	}
	public void setOpen_card(String open_card) {
		this.open_card = open_card;
	}
	public String getOpen_shake() {
		return open_shake;
	}
	public void setOpen_shake(String open_shake) {
		this.open_shake = open_shake;
	}
	@Override
	public String toString() {
		return "BusinessInfo [open_store=" + open_store + ", open_scan=" + open_scan + ", open_pay=" + open_pay
				+ ", open_card=" + open_card + ", open_shake=" + open_shake + "]";
	}
	
}
