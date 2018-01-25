/**
 * @Company JBINFO
 * @Title: UserCPServiceTest.java
 * @Package org.bana.wechat.cp.user
 * @author Liu Wenjie
 * @date 2018年1月19日 下午3:32:52
 * @version V1.0
 */
package org.bana.wechat.cp.user;

import java.util.Arrays;

import org.bana.wechat.cp.BaseCPTest;
import org.bana.wechat.cp.common.WeChatExtAttr;
import org.bana.wechat.cp.user.impl.UserCPServiceImpl;
import org.bana.wechat.cp.user.param.UserCreateParam;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName: UserCPServiceTest
 * @Description: 用户的测试
 * @author Liu Wenjie
 */
public class UserCPServiceTest extends BaseCPTest{
	
	private UserCPService userCpService;
	
	@Before
	public void init(){
		UserCPServiceImpl userCpServiceImpl = new UserCPServiceImpl();
		userCpServiceImpl.setAccessTokenService(tokenService);
		userCpService = userCpServiceImpl;
	}

	/**
	 * Test method for {@link org.bana.wechat.cp.user.UserCPService#create(org.bana.wechat.cp.user.param.UserCreateParam)}.
	 */
	@Test
	public void testCreate() {
		UserCreateParam param = new UserCreateParam();
		param.setCorpId(corpId);
		param.setAgentId(agentId);
		param.setName("刘文杰的家长");
		param.setUserId("liuwenjie2");
		param.setMobile("18678953252");
		param.setDepartment(Arrays.asList(5));
		param.setOrder(Arrays.asList(10));
		param.setPosition("产品经理");
		param.setEmail("liuwenjie@e12349.com");
		param.setIsleader("1");
//		param.setEnable(1);
		param.setExtattr(new WeChatExtAttr()
				.append("爱好","旅游")
				.append("卡号", "1234567234"));
		userCpService.create(param);
	}

}
