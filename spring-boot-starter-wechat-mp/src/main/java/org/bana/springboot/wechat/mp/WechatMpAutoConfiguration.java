/**
 * @Company JBINFO
 * @Title: WechatMpAutoConfiguration.java
 * @Package org.bana.springboot.wechat.mp
 * @author Liu Wenjie
 * @date 2018年5月15日 下午4:30:11
 * @version V1.0
 */
package org.bana.springboot.wechat.mp;

import org.bana.springboot.wechat.mp.oauth.OAuthAutoConfig;
import org.bana.springboot.wechat.mp.token.MpTokenServiceAutoConfig;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName: WechatMpAutoConfiguration
 * @Description: Mp的自动控制类
 * @author Liu Wenjie
 */
@Configuration
@EnableCaching
@AutoConfigureAfter(RedisAutoConfiguration.class)
@ConditionalOnBean(RedisTemplate.class)
@Import({MpTokenServiceAutoConfig.class,OAuthAutoConfig.class})
public class WechatMpAutoConfiguration {

	
}
