/**
* @Company 全域旅游
* @Title: InitWechatPayFactory.java 
* @Package org.bana.springboot.wechat.pay.init 
* @author liuwenjie   
* @date May 19, 2020 3:44:34 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.pay.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.bana.springboot.wechat.pay.WechatPayProperties;
import org.bana.wechat.pay.app.WechatPayAppManager;
import org.bana.wechat.pay.app.impl.InMemeryWechatPayAppManager;
import org.bana.wechat.pay.common.WeChatPayException;
import org.bana.wechat.pay.common.WechatPayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

/** 
* @ClassName: InitWechatPayFactory 
* @Description: 初始化加载通过properties文件加载
* @author liuwenjie   
*/
public class InitWechatPayFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(InitWechatPayFactory.class);

	/** 
	* @Description: 初始化wechatPayAppManager
	* @author liuwenjie   
	* @date May 19, 2020 3:48:03 PM 
	* @param wechatPayProperties
	* @return  
	*/ 
	public static WechatPayAppManager getWechatPayAppManager(WechatPayProperties wechatPayProperties) {
		InMemeryWechatPayAppManager appManager = new InMemeryWechatPayAppManager();
		WechatPayConfig payConfig = new WechatPayConfig();
		payConfig.setAppID(wechatPayProperties.getAppID());
		payConfig.setMchID(wechatPayProperties.getMchID());
		payConfig.setKey(wechatPayProperties.getKey());
		String certPath = wechatPayProperties.getCertPath();
		try {
			File file = ResourceUtils.getFile(certPath);
			if(file.exists()) {
				LOG.info(file.getPath() + "文件存在，加载微信认证文件");
			}else {
				LOG.warn(file.getPath() + "微信文件不存在，不合法的微信支付配置"+certPath);
				throw new WeChatPayException(WeChatPayException.APP_PARAM_ERROR1,"微信文件不存在，不合法的微信支付配置"+certPath);
			}
			FileInputStream certStream = new FileInputStream(file);
			byte[] certData = new byte[(int) certStream.available()];
			certStream.read(certData);
			certStream.close();
			payConfig.setCertData(certData);
			appManager.addWechatPayConfig(payConfig);
			return appManager;
		} catch (IOException e) {
			LOG.error("读取文件" + certPath + "error",e);
			throw new WeChatPayException(WeChatPayException.APP_PARAM_ERROR1,"读取文件" + certPath + "error",e);
		}
	}

	
}
