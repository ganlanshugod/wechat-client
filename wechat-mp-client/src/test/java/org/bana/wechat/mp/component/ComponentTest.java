/**
* @Company 全域旅游
* @Title: ComponentTest.java 
* @Package org.bana.wechat.mp.component 
* @author liuwenjie   
* @date Sep 17, 2020 10:25:20 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.mp.component.common.WechatMpComponentConfig;
import org.bana.wechat.mp.component.common.impl.InMermeryWechatMpComponentManager;
import org.bana.wechat.mp.component.common.impl.InMermeryWechatMpComponentTicketStore;
import org.bana.wechat.mp.component.impl.SimpleComponentTokenServiceImpl;
import org.junit.Before;
import org.junit.Test;

/** 
* @ClassName: ComponentTest 
* @Description: 
* @author liuwenjie   
*/
public class ComponentTest {
	private ComponentTokenService tokenService;
	
	private String appId = "wxe35ec229c4f65cd9";

	@Before
	public void init() {
		SimpleComponentTokenServiceImpl serviceImpl = new SimpleComponentTokenServiceImpl();
		InMermeryWechatMpComponentManager inMermeryWechatMpComponentManager = new InMermeryWechatMpComponentManager();
		WechatMpComponentConfig config = new WechatMpComponentConfig();
		config.setComponentAppid(appId);
		config.setComponentAppsecret("02006bac6d8e59c8bba8164562a35437");
		inMermeryWechatMpComponentManager.add(config);
		HttpHelper httpHelper = new HttpHelper();
		serviceImpl.setHttpHelper(httpHelper);
		serviceImpl.setWechatMpComponentManager(inMermeryWechatMpComponentManager);
		InMermeryWechatMpComponentTicketStore store = new InMermeryWechatMpComponentTicketStore();
		store.putComponentVerifyTicket(appId, "5f62d3e3-374f972b-4701135d");
		serviceImpl.setWechatMpComponentTicketStore(store);
		tokenService = serviceImpl;
	}
	
	@Test
	public void testGetToken() {
		String componentToken = tokenService.getComponentToken(appId);
		System.out.println(componentToken);
	}
}
