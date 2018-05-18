package org.bana.springboot.test;

import static org.junit.Assert.*;

import org.bana.wechat.mp.media.MediaMpService;
import org.bana.wechat.mp.token.AccessTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes=WechatMpApplication.class)
@RunWith(SpringRunner.class)
public class TestApplication {
	
	@Autowired private AccessTokenService accessTokenService;
	@Autowired private MediaMpService mediaMpService;

	@Test
	public void testInit(){
		assertNotNull(accessTokenService);
		assertNotNull(mediaMpService);
	}

}
