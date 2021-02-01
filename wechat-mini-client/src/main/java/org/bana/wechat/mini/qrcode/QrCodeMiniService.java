/**
* @Company Elink   
* @Title: QrCodeMiniService.java 
* @Package org.bana.wechat.mini.qrcode 
* @author ChuLinpeng   
* @date 2021年1月27日 下午4:24:48 
* @version V1.0   
*/ 
package org.bana.wechat.mini.qrcode;

import org.bana.wechat.mini.qrcode.param.WxacodeParam;
import org.bana.wechat.mini.qrcode.param.WxacodeUnlimitedParam;
import org.bana.wechat.mini.qrcode.param.Wxaqrcode;

/** 
* @ClassName: QrCodeMiniService 
* @Description: 小程序二维码相关接口
* @author ChuLinpeng   
*/
public interface QrCodeMiniService {
	
	/** 
	* @Description: 获取小程序二维码Base64，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制
	* @author ChuLinpeng   
	* @date 2021年1月27日 下午5:45:44 
	* @param param
	* @return  
	*/ 
	String createWxaqrcode(Wxaqrcode param);
	
	/** 
	* @Description: 获取小程序二维码ByteArray，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制
	* @author ChuLinpeng   
	* @date 2021年1月29日 上午10:43:12 
	* @param param
	* @return  
	*/ 
	byte[] createWxaqrcodeByteArray(Wxaqrcode param);
	
	/** 
	* @Description: 获取小程序码Base64，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制
	* @author ChuLinpeng 
	* @date 2021年1月27日 下午4:45:41 
	* @param param
	* @return  
	*/ 
	String getWxaqrcode(WxacodeParam param);
	
	/** 
	* @Description: 获取小程序码ByteArray，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制
	* @author ChuLinpeng   
	* @date 2021年1月29日 上午10:47:56 
	* @param param
	* @return  
	*/ 
	byte[] getWxaqrcodeByteArray(WxacodeParam param);
	
	/** 
	* @Description: 获取小程序码Base64，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。
	* @author ChuLinpeng   
	* @date 2021年1月27日 下午4:50:05 
	* @param param
	* @return  
	*/ 
	String getUnlimited(WxacodeUnlimitedParam param);
	
	/** 
	* @Description: 获取小程序码ByteArray，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。
	* @author ChuLinpeng   
	* @date 2021年1月29日 上午10:49:22 
	* @param param
	* @return  
	*/ 
	byte[] getUnlimitedByteArray(WxacodeUnlimitedParam param);
}
