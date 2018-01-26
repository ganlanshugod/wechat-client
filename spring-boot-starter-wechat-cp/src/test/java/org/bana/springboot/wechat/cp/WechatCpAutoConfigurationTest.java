/**
 * @Company JBINFO
 * @Title: WechatCpAutoConfigurationTest.java
 * @Package org.bana.springboot.wechat.cp
 * @author Liu Wenjie
 * @date 2018年1月26日 下午2:10:13
 * @version V1.0
 */
package org.bana.springboot.wechat.cp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: WechatCpAutoConfigurationTest
 * @Description: 测试企业号的自动注入配置
 * @author Liu Wenjie
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={WechatCpTestConfig.class,WechatCpAutoConfiguration.class})
public class WechatCpAutoConfigurationTest {
	
	@Autowired
	private WechatCpProperties wechatCpPropertes;
	
	@Test
	public void test() {
		System.out.println(wechatCpPropertes.getAgentId());
	}

}
