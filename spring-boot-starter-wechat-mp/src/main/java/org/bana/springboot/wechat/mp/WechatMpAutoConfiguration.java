/**
 * @Company JBINFO
 * @Title: WechatMpAutoConfiguration.java
 * @Package org.bana.springboot.wechat.mp
 * @author Liu Wenjie
 * @date 2018年5月15日 下午4:30:11
 * @version V1.0
 */
package org.bana.springboot.wechat.mp;

import org.bana.springboot.wechat.mp.callback.WechatMpCallBackConfig;
import org.bana.springboot.wechat.mp.callback.WechatMpCallbackProperties;
import org.bana.springboot.wechat.mp.component.WechatMpComponetConfig;
import org.bana.springboot.wechat.mp.media.MediaMpAutoConfig;
import org.bana.springboot.wechat.mp.menu.MenuMpAutoConfig;
import org.bana.springboot.wechat.mp.message.MessageMpAutoConfig;
import org.bana.springboot.wechat.mp.oauth.OAuthAutoConfig;
import org.bana.springboot.wechat.mp.token.MpTokenCacheConfig;
import org.bana.springboot.wechat.mp.token.MpTokenServiceAutoConfig;
import org.bana.wechat.common.log.WechatLogger;
import org.bana.wechat.common.log.WechatLoggerFactory;
import org.bana.wechat.common.log.mongo.MongoWechatLogger;
import org.bana.wechat.mp.account.AccountMpService;
import org.bana.wechat.mp.account.impl.AccountMpServiceImpl;
import org.bana.wechat.mp.token.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @ClassName: WechatMpAutoConfiguration
 * @Description: Mp的自动控制类
 * @author Liu Wenjie
 */
@Configuration
@EnableCaching
@AutoConfigureAfter(RedisAutoConfiguration.class)
@Import({MpTokenServiceAutoConfig.class,OAuthAutoConfig.class,MediaMpAutoConfig.class,MessageMpAutoConfig.class,MenuMpAutoConfig.class,
	WechatMpCallBackConfig.class,
	WechatMpComponetConfig.class})
@EnableConfigurationProperties({WechatMpProperties.class,WechatMpCallbackProperties.class})
public class WechatMpAutoConfiguration {
	
	@Bean
	@ConditionalOnMissingBean
	public AccountMpService accountMpService(AccessTokenService accessTokenService){
		AccountMpServiceImpl impl = new AccountMpServiceImpl();
		impl.setAccessTokenService(accessTokenService);
		return impl;
	}
	
	/**
	 * @param redisTemplate
	 * @return
	 * 如果环境中存在redis环境则使用redis加载cache方法
	 */
	@ConditionalOnClass(RedisConnectionFactory.class)
	@Configuration
	@Import(MpTokenCacheConfig.class)
	public class CacheConfig {
		
	}
	
	@ConditionalOnClass(MongoTemplate.class)
	@ConditionalOnBean(MongoTemplate.class)
	@Configuration
	public class LogConfig{
		@Bean(name="mongoWechatLogger")
		@ConditionalOnMissingBean(name="mongoWechatLogger")
		@ConditionalOnBean(name="logMongoTemplate")
		public WechatLogger mongoWechatLogger(@Autowired @Qualifier("logMongoTemplate")MongoTemplate logMongoTemplate) {
			MongoWechatLogger logger = new MongoWechatLogger();
			logger.setMongoTemplate(logMongoTemplate);
			WechatLoggerFactory.setCls(MongoWechatLogger.class,logger);
			return logger;
		}
		
		@Bean(name="mongoWechatLogger")
		@ConditionalOnMissingBean(name="mongoWechatLogger")
		@ConditionalOnBean(name="mongoTemplate")
		public WechatLogger mongoWechatLogger2(@Autowired @Qualifier("mongoTemplate")MongoTemplate logMongoTemplate) {
			MongoWechatLogger logger = new MongoWechatLogger();
			logger.setMongoTemplate(logMongoTemplate);
			WechatLoggerFactory.setCls(MongoWechatLogger.class,logger);
			return logger;
		}
		
	}
	
	
	
}
