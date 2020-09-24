/**
* @Company 全域旅游
* @Title: ComponentServiceTest.java 
* @Package org.bana.wechat.mp.component 
* @author liuwenjie   
* @date Sep 23, 2020 12:31:09 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.common.page.PageResult;
import org.bana.wechat.mp.component.common.WechatMpComponentConfig;
import org.bana.wechat.mp.component.common.impl.InMermeryWechatMpComponentManager;
import org.bana.wechat.mp.component.common.impl.InMermeryWechatMpComponentTicketStore;
import org.bana.wechat.mp.component.impl.SimpleComponentTokenServiceImpl;
import org.bana.wechat.mp.component.impl.WechatMpComponentServiceImpl;
import org.bana.wechat.mp.component.result.SimpleAuthorizer;
import org.junit.Before;
import org.junit.Test;

/** 
* @ClassName: ComponentServiceTest 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author liuwenjie   
*/
public class ComponentServiceTest {

	private ComponentTokenService tokenService;

	private String appId = "wxe35ec229c4f65cd9";
	
	private ComponentService componentService;

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
		store.putComponentVerifyTicket(appId,
				"ticket@@@DA28sOIJicY44G0w-ArhWontOeXdqprbV_9_djqC42Z65aQ1uHIFEhffPHfIhvCfi2SjZIUowo9HGbg0VN2Q0g");
		serviceImpl.setWechatMpComponentTicketStore(store);
		tokenService = serviceImpl;
		
		WechatMpComponentServiceImpl componentServiceImpl = new WechatMpComponentServiceImpl();
		componentServiceImpl.setComponentTokenService(serviceImpl);
		componentService = componentServiceImpl;
	}
	
	@Test
	public void testFindAuthList() {
		PageResult<SimpleAuthorizer> authorizerList = componentService.getAuthorizerList(appId, 0, 10);
		System.out.println(authorizerList.getTotalCount());
		System.out.println(authorizerList.getList());
	}
	
}
