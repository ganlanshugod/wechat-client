package org.bana.springboot.wechat.pay;

import org.bana.wechat.pay.WechatPayService;
import org.bana.wechat.pay.app.WechatPayAppManager;
import org.bana.wechat.pay.app.WxPayFactory;
import org.bana.wechat.pay.app.impl.InMemeryWechatPayAppManager;
import org.bana.wechat.pay.impl.WechatPayServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 
* @ClassName: WechatPayAutoConfiguration 
* @Description: 微信支付的自动配置类
* @author liuwenjie   
*/ 
@Configuration
@EnableConfigurationProperties(WechatPayProperties.class)
public class WechatPayAutoConfiguration {
	
	/** 
	* @Description: 默认的使用内存管理的wechatPayAppManager
	* @author liuwenjie   
	* @date May 18, 2020 4:11:08 PM 
	* @return  
	*/ 
	@Bean
	@ConditionalOnMissingBean
	public WechatPayAppManager wechatPayAppManager() {
		return new InMemeryWechatPayAppManager();
	}
	
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnBean(WechatPayAppManager.class)
	public WxPayFactory wxPayFactory(WechatPayAppManager wechatPayAppManager) {
		WxPayFactory wxPayFactory = new WxPayFactory();
		wxPayFactory.setWechatPayAppManager(wechatPayAppManager);
		// 可以自定义缓存wxPay对象的方式，默认的方法是没有缓存的。也就是每次调用微信支付的接口都会新生成一个wxPay对象
//		wxPayFactory.setWxPayCache(wxPayCache);  
		return wxPayFactory;
	}
    
	//wechatPayService
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnBean(WxPayFactory.class)
	public WechatPayService wechatPayService(WxPayFactory wxPayFactory) {
		WechatPayServiceImpl wechatPayService = new WechatPayServiceImpl();
		wechatPayService.setWxPayFactory(wxPayFactory);
		return wechatPayService;
	}
}
