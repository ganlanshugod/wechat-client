/**
* @Company Elink   
* @Title: QrCodeResult.java 
* @Package org.bana.wechat.mini.qrcode.result 
* @author ChuLinpeng   
* @date 2021年1月27日 下午4:30:29 
* @version V1.0   
*/ 
package org.bana.wechat.mini.qrcode.result;

import java.io.Serializable;

/** 
* @ClassName: QrCodeResult 
* @Description: 
* @author ChuLinpeng   
*/
public class QrCodeResult implements Serializable {
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -5050875359732484456L;
	
	private String buffer;
	
	public String getBuffer() {
		return buffer;
	}

	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}
}
