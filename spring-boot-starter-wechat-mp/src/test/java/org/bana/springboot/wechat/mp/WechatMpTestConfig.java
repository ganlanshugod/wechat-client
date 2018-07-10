/**
 * @Company JBINFO
 * @Title: WechatCpTestConfig.java
 * @Package org.bana.springboot.wechat.cp
 * @author Liu Wenjie
 * @date 2018年1月26日 下午2:27:35
 * @version V1.0
 */
package org.bana.springboot.wechat.mp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: WechatCpTestConfig
 * @Description: 
 * @author Liu Wenjie
 */
@Configuration
@PropertySource(value={"classpath:/application.yml"})
public class WechatMpTestConfig {

}
