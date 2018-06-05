package org.bana.wechat.pay.common;

public enum WxPayConstants {

	不支持信用卡支付("no_credit"),
	公众号DeviceInfo("WEB"),
	标价币种_人民币("CNY"),
	交易类型_公众号支付("JSAPI"),
	交易类型_扫码支付("NATIVE"),
	交易类型_APP支付("APP");
	
	private String value;
	private WxPayConstants(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
