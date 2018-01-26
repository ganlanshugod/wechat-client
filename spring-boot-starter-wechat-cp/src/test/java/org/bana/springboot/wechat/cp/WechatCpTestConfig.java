/**
 * @Company JBINFO
 * @Title: WechatCpTestConfig.java
 * @Package org.bana.springboot.wechat.cp
 * @author Liu Wenjie
 * @date 2018年1月26日 下午2:27:35
 * @version V1.0
 */
package org.bana.springboot.wechat.cp;

import org.bana.springboot.wechat.cp.callback.listner.TestSuiteTicketEventListener;
import org.bana.wechat.cp.callback.listener.SuiteTicketEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: WechatCpTestConfig
 * @Description: 
 * @author Liu Wenjie
 */
@Configuration
@PropertySource(value={"classpath:/wechat.properties"})
public class WechatCpTestConfig {

	@Bean
	public SuiteTicketEventListener suiteTicketListener(){
		return new TestSuiteTicketEventListener();
	}
}
