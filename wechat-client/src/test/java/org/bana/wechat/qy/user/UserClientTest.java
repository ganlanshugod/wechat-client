/**
* @Company 青鸟软通   
* @Title: UserClient.java 
* @Package org.bana.wechat.qy.user 
* @author Liu Wenjie   
* @date 2015-5-9 下午9:20:37 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.bana.wechat.BaseTestCase;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.connection.GetToken;
import org.bana.wechat.qy.connection.domain.AccessToken;
import org.bana.wechat.qy.connection.domain.SuiteAccessToken;
import org.bana.wechat.qy.login.domain.WechatLoginUser;
import org.bana.wechat.qy.login.param.LoginInfoParam;
import org.bana.wechat.qy.suite.SuiteClient;
import org.bana.wechat.qy.suite.param.GetCorpTokenParam;
import org.bana.wechat.qy.user.domain.CurrentUserInfo;
import org.bana.wechat.qy.user.domain.OpenIdUser;
import org.bana.wechat.qy.user.domain.SimpleUser;
import org.bana.wechat.qy.user.domain.User;
import org.bana.wechat.qy.user.param.CovertToOpenIdParam;
import org.bana.wechat.qy.user.param.CovertToUserIdParam;
import org.bana.wechat.qy.user.param.GetCurrentUserParam;
import org.bana.wechat.qy.user.param.UserCreateParam;
import org.bana.wechat.qy.user.param.UserGetParam;
import org.bana.wechat.qy.user.param.UserListParam;
import org.junit.Test;

import net.sf.json.JSONObject;

/** 
 * @ClassName: UserClient 
 * @Description: 测试成员管理的接口
 *  
 */
public class UserClientTest extends BaseTestCase{
	
	@Test
	public void testGet() {
//		String accessToken = GetToken.getAccessToken(cropId, secret).getAccess_token();
		UserGetParam param = new UserGetParam();
		param.setAccess_token(accessToken);
		param.setUserid("liuwenjie");
		User result = UserClient.get(param);
		assertNotNull(result);
	}
	
	@Test
	public void testConvertToUserId(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		CovertToUserIdParam param = new CovertToUserIdParam();
		param.setAccess_token(accessToken.getAccess_token());
		param.setOpenid("oDP0bwO6zOYw6pf-tbuh7r-qLmRA");
		String userId = UserClient.convertToUserId(param);
		System.out.println(userId);
	}
	
	@Test
	public void testConvertToOpenId(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		CovertToOpenIdParam param = new CovertToOpenIdParam();
		param.setAccess_token(accessToken.getAccess_token());
		param.setUserid("Z0007");
		OpenIdUser openId = UserClient.convertToOpenIdUser(param);
		System.out.println(openId);
	}
	
	@Test
	public void testSimpleList(){
//		String accessToken = GetToken.getAccessToken(cropId, secret).getAccess_token();
		UserListParam param = new UserListParam();
//		param.setDepartment_id(48);
		param.setAccess_token(accessToken);
		param.setFetch_child("1");
		param.setStatus("0");
		List<SimpleUser> simpleList = UserClient.simpleList(param);
		assertNotNull(simpleList);
	}
	
	@Test
	public void testList(){
		String accessToken = "rw3R-b7bdh9ZWajTsTb5nY4ndCWAG7SFRPH65u2iAOZC6FT4qWx7PusqJXeEMgE-Jwk8t21K-GWabdHUhsac8DPXioDqPeTXvSK0V7KEyptEAINQDj_iZIrGscR6176Ggt_w2FyGHGsFmUt5gJHi8xCL4ohgljZ_nSSWKPkLupB0nZvn9jPp9oKpGNQRjDxwd4QL1OR8sqVKVM2Wng2J7iA0_pEJq7nEeABAI8qcZ3KUexLVNMtn3j43jcIeF1dsA3uWle8SkJXRs1tFwDcTisgAApHmswfHq82vhOlQiGE";
		UserListParam param = new UserListParam();
		param.setDepartment_id(1);
		param.setAccess_token(accessToken);
		param.setFetch_child("1");
		param.setStatus("0");
		List<User> list = UserClient.list(param);
		assertNotNull(list);
	}
	
	@Test
	public void testCreate(){
//		AccessToken accessToken = GetToken.getAccessToken(cropId, secret).getAccess_token();
		UserCreateParam param = new UserCreateParam();
		param.setAccess_token(accessToken);
		param.setName("于小佳的家长");
		param.setUserid("QY626701_YXJ_1493801484054");
		param.setMobile("18678953252");
		param.setDepartment(Arrays.asList(5));
		JSONObject fromObject = JSONObject.fromObject(param);
		System.out.println(fromObject.toString());
		try {
			UserClient.create(param);
		} catch (BanaWeChatException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCurrentUser(){
		SuiteAccessToken suiteToken = GetToken.getSuiteToken(suite_id, suite_secret, suite_ticket);
		GetCorpTokenParam tokenParam = new GetCorpTokenParam();
		tokenParam.setSuite_access_token(suiteToken.getSuite_access_token());
		tokenParam.setSuite_id(suite_id);
		tokenParam.setPermanent_code(permanentCode);
		tokenParam.setAuth_corpid(cropId);
		AccessToken corpToken = SuiteClient.getCorpToken(tokenParam);
		GetCurrentUserParam userParam = new GetCurrentUserParam();
		userParam.setAccess_token(corpToken.getAccess_token());
		userParam.setAgentid("5");
		userParam.setCode("937dad3e3bef466054939162d00beff7");
		CurrentUserInfo userInfo = UserClient.getUserInfo(userParam);
		assertNotNull(userInfo);
	}
	@Test
	public void testgetLoginInfo(){
		LoginInfoParam param = new LoginInfoParam();
		param.setAccess_token("rWxSMikGVJOtvv7SI8c7nYLTdkuuspySjzkebPR94XE372AjRMN6ojldoMiCPo56");
		param.setAuth_code("9ba0d3f5b5b8ca82c9503ad189bca4fa");
		WechatLoginUser loginInfo = UserClient.getLoginInfo(param);
		assertNotNull(loginInfo);
	}
}
