/**
* @Company 全域旅游
* @Title: ComponentTest.java 
* @Package org.bana.wechat.mp.component 
* @author liuwenjie   
* @date Sep 17, 2020 10:25:20 AM 
* @version V1.0   
*/
package org.bana.wechat.mp.component;

import java.util.List;
import java.util.stream.Collectors;

import org.bana.wechat.common.HttpHelper;
import org.bana.wechat.mp.component.common.WechatMpComponentConfig;
import org.bana.wechat.mp.component.common.impl.InMermeryWechatMpComponentManager;
import org.bana.wechat.mp.component.common.impl.InMermeryWechatMpComponentTicketStore;
import org.bana.wechat.mp.component.impl.SimpleComponentTokenServiceImpl;
import org.bana.wechat.mp.component.result.AuthorizationInfo;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

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
		store.putComponentVerifyTicket(appId,
				"B2a4lzyqLq74xcCWMld_YHJlqmuiTSTiMoVIM2dTQu9YohGWsOGYiNdOHYu8FEbV0I2k7d0tCmt13y81YY6P0g");
		serviceImpl.setWechatMpComponentTicketStore(store);
		tokenService = serviceImpl;
	}

	@Test
	public void testGetToken() {
		String componentToken = tokenService.getComponentToken(appId);
		// 37_vrVfwtnOxcx3shLDz2PrKSbxFHykCL5o7h8h-puki0LlzSwqwF7XZr9ffX4D3Ues_jGQbC2tKYv1u59i4uzTt9SGSIYvJQ0jqFJ8b0kCvuDQdQW22wxGARLrRxUBtriLeJXrB4Oc-ndi2XevFYNiAJAKDS
		System.out.println(componentToken);
	}

	@Test
	public void testAuthInfoFormat() {
		String str = "{\"authorization_info\":{\"authorizer_appid\":\"wxf8b4f85f3a794e77\",\"authorizer_access_token\":\"QXjUqNqfYVH0yBE1iI_7vuN_9gQbpjfK7hYwJ3P7xOa88a89-Aga5x1NMYJyB8G2yKt1KCl0nPC3W9GJzw0Zzq_dBxc8pxIGUNi_bFes0qM\",\"expires_in\":7200,\"authorizer_refresh_token\":\"dTo-YCXPL4llX-u1W1pPpnp8Hgm4wpJtlR6iV0doKdY\",\"func_info\":[{\"funcscope_category\":{\"id\":1}},{\"funcscope_category\":{\"id\":2}},{\"funcscope_category\":{\"id\":3}}]}}";
		JSONObject parseObject = JSONObject.parseObject(str);
		AuthorizationInfo javaObject = parseObject.getJSONObject("authorization_info")
				.toJavaObject(AuthorizationInfo.class);
		System.out.println(javaObject);
		List<String> collect = javaObject.getFuncInfo().stream().map(item -> {
			JSONObject obj = (JSONObject) item;
			return obj.getJSONObject("funcscope_category").getString("id");
		}).collect(Collectors.toList());
		System.out.println(collect);
	}
}
