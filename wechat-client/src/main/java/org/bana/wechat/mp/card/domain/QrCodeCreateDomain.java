/**
 * @Company 青鸟软通   
 * @Title: QrCodeCreateDomain.java 
 * @Package org.bana.wechat.mp.card.domain 
 * @author Han Tongyang   
 * @date 2015-10-28 下午5:06:18 
 * @version V1.0   
 */
package org.bana.wechat.mp.card.domain;

import java.io.Serializable;

/**
 * @ClassName: QrCodeCreateDomain
 * @Description: 投放卡券-生成二维码实体
 * 
 */
public class QrCodeCreateDomain implements Serializable {

	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = 5422713548234842071L;

	private String errcode; // 错误码
	private String errmsg; // 错误信息
	private String ticket; // 获取的二维码ticket，凭借此ticket调用通过ticket换取二维码接口可以在有效时间内换取二维码。
	private String url; // 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	private String show_qrcode_url; // 二维码显示地址，点击后跳转二维码页面

	/**
	 * @Description: 属性 errcode 的get方法
	 * @return errcode
	 */
	public String getErrcode() {
		return errcode;
	}

	/**
	 * @Description: 属性 errcode 的set方法
	 * @param errcode
	 */
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	/**
	 * @Description: 属性 errmsg 的get方法
	 * @return errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * @Description: 属性 errmsg 的set方法
	 * @param errmsg
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	/**
	 * @Description: 属性 ticket 的get方法
	 * @return ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @Description: 属性 ticket 的set方法
	 * @param ticket
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @Description: 属性 url 的get方法
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @Description: 属性 url 的set方法
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @Description: 属性 show_qrcode_url 的get方法
	 * @return show_qrcode_url
	 */
	public String getShow_qrcode_url() {
		return show_qrcode_url;
	}

	/**
	 * @Description: 属性 show_qrcode_url 的set方法
	 * @param show_qrcode_url
	 */
	public void setShow_qrcode_url(String show_qrcode_url) {
		this.show_qrcode_url = show_qrcode_url;
	}

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author Han Tongyang
	 * @date 2015-10-28 下午5:08:18
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QrCodeCreateDomain [errcode=" + errcode + ", errmsg=" + errmsg
				+ ", ticket=" + ticket + ", url=" + url + ", show_qrcode_url="
				+ show_qrcode_url + "]";
	}

}
