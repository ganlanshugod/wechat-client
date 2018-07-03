package org.bana.wechat.pay.common;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.github.wxpay.sdk.WXPayUtil;

/**
 * 自定义微信支付工具类
 * @author Liu Wenjie
 *
 */
public class WxPayUtil {
	
	private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS5Padding";
	private static final String ALGORITHM = "AES";  

	public static boolean decodeRefundMessage(Map<String, String> notifyMap,String apiKey){
		if(notifyMap == null || !"SUCCESS".equals(notifyMap.get("return_code"))){
			return false;
		}
		String data = notifyMap.get("req_info");
		//解码
		try {
			//apiKey 取MD5
			byte[] key = WXPayUtil.MD5(apiKey).toLowerCase().getBytes();
			Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);  
	        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, ALGORITHM));
	        String decodeStr = new String(cipher.doFinal(new Base64().decode(data)));
//	        System.out.println(decodeStr);
	        Map<String, String> xmlToMap = WXPayUtil.xmlToMap(decodeStr);
	        notifyMap.putAll(xmlToMap);
			return true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
