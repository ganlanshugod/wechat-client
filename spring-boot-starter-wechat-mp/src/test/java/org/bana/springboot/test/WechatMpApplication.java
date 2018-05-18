package org.bana.springboot.test;

import org.bana.wechat.mp.media.MediaMpService;
import org.bana.wechat.mp.token.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WechatMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(WechatMpApplication.class, args);
	}
	
	
}
