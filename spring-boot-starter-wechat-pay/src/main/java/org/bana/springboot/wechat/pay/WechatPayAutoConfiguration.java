package org.bana.springboot.wechat.pay;

import org.bana.springboot.wechat.pay.factory.InitWechatPayFactory;
import org.bana.springboot.wechat.pay.factory.WxPayProxyFactory;
import org.bana.wechat.common.log.WechatLogger;
import org.bana.wechat.common.log.WechatLoggerFactory;
import org.bana.wechat.common.log.mongo.MongoWechatLogger;
import org.bana.wechat.pay.WechatPayService;
import org.bana.wechat.pay.app.WechatPayAppManager;
import org.bana.wechat.pay.app.WxPayFactory;
import org.bana.wechat.pay.impl.WechatPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/** 
* @ClassName: WechatPayAutoConfiguration 
* @Description: 微信支付的自动配置类
* @author liuwenjie   
*/ 
@Configuration
@EnableConfigurationProperties(WechatPayProperties.class)
public class WechatPayAutoConfiguration {
	
	@Autowired
	private WechatPayProperties wechatPayProperties;
	
	/** 
	* @Description: 默认的使用内存管理的wechatPayAppManager
	* @author liuwenjie   
	* @date May 18, 2020 4:11:08 PM 
	* @return  
	*/ 
	@Bean
	@ConditionalOnMissingBean
	public WechatPayAppManager wechatPayAppManager() {
		return InitWechatPayFactory.getWechatPayAppManager(wechatPayProperties);
	}
	
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnBean(WechatPayAppManager.class)
	@ConditionalOnProperty(prefix=WechatPayProperties.WECHAT_PAY_PREFIX,name="log",havingValue="false",matchIfMissing=true)
	public WxPayFactory wxPayFactory(WechatPayAppManager wechatPayAppManager) {
		WxPayFactory wxPayFactory = new WxPayFactory();
		wxPayFactory.setWechatPayAppManager(wechatPayAppManager);
		// 可以自定义缓存wxPay对象的方式，默认的方法是没有缓存的。也就是每次调用微信支付的接口都会新生成一个wxPay对象
//		wxPayFactory.setWxPayCache(wxPayCache);  
		return wxPayFactory;
	}
	
	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnBean(WechatPayAppManager.class)
	@ConditionalOnProperty(prefix=WechatPayProperties.WECHAT_PAY_PREFIX,name="log",havingValue="true",matchIfMissing=false)
	public WxPayFactory wxPayLogFactory(WechatPayAppManager wechatPayAppManager) {
		WxPayProxyFactory wxPayFactory = new WxPayProxyFactory();
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
	
	
	@ConditionalOnClass(MongoTemplate.class)
	@ConditionalOnBean(MongoTemplate.class)
	@Configuration
	public class LogConfig{
		@Bean
		@ConditionalOnMissingBean
		public WechatLogger mongoWechatLogger(MongoTemplate logMongoTemplate) {
			MongoWechatLogger logger = new MongoWechatLogger();
			logger.setMongoTemplate(logMongoTemplate);
			WechatLoggerFactory.setCls(MongoWechatLogger.class,logger);
			return logger;
		}
	}
}
