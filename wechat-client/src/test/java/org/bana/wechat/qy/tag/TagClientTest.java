/**
* @Company 青鸟软通   
* @Title: TagClientTest.java 
* @Package org.bana.wechat.qy.tag 
* @author Liu Wenjie   
* @date 2015-5-11 下午10:57:08 
* @version V1.0   
*/ 
package org.bana.wechat.qy.tag;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.bana.wechat.BaseTestCase;
import org.bana.wechat.qy.common.WeChatParam;
import org.bana.wechat.qy.connection.GetToken;
import org.bana.wechat.qy.connection.domain.AccessToken;
import org.bana.wechat.qy.tag.domain.GetTagUserResult;
import org.bana.wechat.qy.tag.domain.ManagerTagUserResult;
import org.bana.wechat.qy.tag.param.TagCreateParam;
import org.bana.wechat.qy.tag.param.TagGetParam;
import org.bana.wechat.qy.tag.param.TagUserParam;
import org.bana.wechat.qy.user.domain.SimpleUser;
import org.bana.wechat.qy.user.domain.Tag;
import org.junit.Test;

/** 
 * @ClassName: TagClientTest 
 * @Description: 测试标签管理的微信接口
 *  
 */
public class TagClientTest extends BaseTestCase{

	/**
	 * Test method for {@link org.bana.wechat.qy.tag.TagClient#get(org.bana.wechat.qy.tag.param.TagGetParam)}.
	 */
	@Test
	public void testGet() {
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		TagGetParam getParam = new TagGetParam();
		getParam.setAccess_token(accessToken.getAccess_token());
		getParam.setTagid("1");
		GetTagUserResult tagUserResult = TagClient.get(getParam);
		assertNotNull(tagUserResult);
		List<SimpleUser> userlist = tagUserResult.getUserlist();
		for (int l = 0; l < userlist.size(); l++) {
			SimpleUser simpleUser = userlist.get(l);
			System.out.println(simpleUser);
		}
			
	}
	
	@Test
	public void testCreate(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		TagCreateParam createParam = new TagCreateParam();
		createParam.setTagname("i3618测试微信标签");
		createParam.setAccess_token(accessToken.getAccess_token());
		
		String create = TagClient.create(createParam);
		assertNotNull(create);
		System.out.println(create);
	}

	
	@Test
	public void testAddTagUsers(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		TagUserParam userParam = new TagUserParam();
		userParam.setAccess_token(accessToken.getAccess_token());
		userParam.setTagid("2");
		List<String> userList = new ArrayList<String>();
		userList.add("lijiaxiu");
		userList.add("liuwenjie");
		userParam.setUserlist(userList);
		ManagerTagUserResult addTagUsers = TagClient.addTagUsers(userParam);
		assertNotNull(addTagUsers);
	}
	
	@Test
	public void testDelTagUsers(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		TagUserParam userParam = new TagUserParam();
		userParam.setAccess_token(accessToken.getAccess_token());
		userParam.setTagid("2");
		List<String> userList = new ArrayList<String>();
		userList.add("lijiaxiu");
		userList.add("liuwenjie");
		userParam.setUserlist(userList);
		ManagerTagUserResult addTagUsers = TagClient.delTagUsers(userParam);
		assertNotNull(addTagUsers);
	}
	
	@Test
	public void testList(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		WeChatParam userParam = new WeChatParam();
		userParam.setAccess_token(accessToken.getAccess_token());
		List<Tag> list = TagClient.list(userParam);
		assertNotNull(list);
	}
	
}
