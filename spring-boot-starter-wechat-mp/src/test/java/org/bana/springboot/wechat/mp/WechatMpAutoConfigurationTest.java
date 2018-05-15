/**
 * @Company JBINFO
 * @Title: WechatMpAutoConfigurationTest.java
 * @Package org.bana.springboot.wechat.mp
 * @author Liu Wenjie
 * @date 2018年5月15日 下午4:44:31
 * @version V1.0
 */
package org.bana.springboot.wechat.mp;

import static org.junit.Assert.*;

import org.bana.wechat.mp.auth.OAuthMpService;
import org.bana.wechat.mp.token.AccessTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: WechatMpAutoConfigurationTest
 * @Description: 
 * @author Liu Wenjie
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes={WechatMpAutoConfiguration.class})
public class WechatMpAutoConfigurationTest {

	@Autowired private AccessTokenService accessTokenService;
	
	@Autowired private OAuthMpService oauthMpService;
	
	@Test
	public void test() {
		assertNotNull(accessTokenService);
		assertNotNull(oauthMpService);
	}

}
