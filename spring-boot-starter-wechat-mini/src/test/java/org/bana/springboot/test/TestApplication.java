package org.bana.springboot.test;

import static org.junit.Assert.*;

import org.bana.wechat.mini.media.MediaMiniService;
import org.bana.wechat.mini.token.AccessTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes=WechatMiniApplication.class)
@RunWith(SpringRunner.class)
public class TestApplication {
	
	@Autowired private AccessTokenService accessTokenService;
	@Autowired private MediaMiniService mediaMpService;

	@Test
	public void testInit(){
		assertNotNull(accessTokenService);
		assertNotNull(mediaMpService);
	}

}
