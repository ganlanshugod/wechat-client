/**
 * @Company JBINFO
 * @Title: WechatMpAutoConfigurationTest.java
 * @Package org.bana.springboot.wechat.mp
 * @author Liu Wenjie
 * @date 2018年5月15日 下午4:44:31
 * @version V1.0
 */
package org.bana.springboot.wechat.mini;

import static org.junit.Assert.assertNotNull;

import org.bana.springboot.wechat.mini.WechatMiniAutoConfiguration;
import org.bana.springboot.wechat.mini.WechatMiniProperties;
import org.bana.wechat.mini.media.MediaMiniService;
import org.bana.wechat.mini.token.AccessTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: WechatMpAutoConfigurationTest
 * @Description: 
 * @author Liu Wenjie
 */
/**
 * @author Liu Wenjie
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={WechatMiniTestConfig.class,WechatMiniAutoConfiguration.class})
//@PropertySource(value={"classpath:/wechat.properties"})
@EnableConfigurationProperties(WechatMiniProperties.class)
public class WechatMpAutoConfigurationTest {

	@Autowired private AccessTokenService accessTokenService;
	
	@Autowired private MediaMiniService mediaMiniService;
	
	@Autowired
	private WechatMiniProperties wechatMiniPropertes;
	
	@Test
	public void test() {
		assertNotNull(accessTokenService);
		assertNotNull(mediaMiniService);
		assertNotNull(wechatMiniPropertes);
		System.out.println(wechatMiniPropertes);
	}

}
