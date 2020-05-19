package org.bana.springboot.test;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.pay.WechatPayService;
import org.bana.wechat.pay.app.WechatPayAppManager;
import org.bana.wechat.pay.app.WxPayFactory;
import org.bana.wechat.pay.app.WxPayParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes=WechatPayApplication.class)
@RunWith(SpringRunner.class)
public class TestApplication {
	
	@Autowired private WechatPayService wechatPayService;
	@Autowired private WxPayFactory mediaPayService;
	@Autowired private WechatPayAppManager wechatPayAppManager;
	
	private String appID = "wx5bc259b375eb9572";
    private String mchID = "1486632612";

	@Test
	public void testInit() throws Exception{
		assertNotNull(wechatPayService);
		assertNotNull(mediaPayService);
		assertNotNull(wechatPayAppManager);
		WxPayParam param = new WxPayParam(appID, mchID);
		Map<String,String> reqData = new HashMap<>();
		wechatPayService.unifiedOrder(param, reqData);
	}

}
