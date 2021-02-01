/**
* @Company Elink   
* @Title: QrcodeMiniAutoConfig.java 
* @Package org.bana.springboot.wechat.mini.qrcode 
* @author ChuLinpeng   
* @date 2021年1月27日 下午5:07:35 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mini.qrcode;

import org.bana.wechat.mini.qrcode.QrCodeMiniService;
import org.bana.wechat.mini.qrcode.impl.QrCodeMiniServiceImpl;
import org.bana.wechat.mini.token.AccessTokenService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 
* @ClassName: QrcodeMiniAutoConfig 
* @Description: 
* @author ChuLinpeng   
*/
@Configuration
public class QrcodeMiniAutoConfig {

	/** 
	* @Description: 生成二维码需要使用的ServiceBean自动注入
	* @author ChuLinpeng   
	* @date 2021年1月27日 下午5:09:23 
	* @param accessTokenService
	* @return  
	*/ 
	@Bean
	@ConditionalOnMissingBean
	public QrCodeMiniService qrCodeMiniService(AccessTokenService accessTokenService) {
		QrCodeMiniServiceImpl impl = new QrCodeMiniServiceImpl();
		impl.setAccessTokenService(accessTokenService);
		return impl;
	}
}
