/**
* @Company 青鸟软通   
* @Title: MenuClientTest.java 
* @Package org.bana.wechat.qy.menu 
* @author Liu Wenjie   
* @date 2015-5-15 下午11:18:27 
* @version V1.0   
*/ 
package org.bana.wechat.qy.menu;

import static org.junit.Assert.assertNotNull;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.bana.wechat.BaseTestCase;
import org.bana.wechat.cp.token.domain.AccessToken;
import org.bana.wechat.cp.token.domain.SuiteAccessToken;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.connection.GetToken;
import org.bana.wechat.qy.menu.domain.Button;
import org.bana.wechat.qy.menu.domain.Menu;
import org.bana.wechat.qy.menu.param.MenuCreateParam;
import org.bana.wechat.qy.menu.param.MenuGetParam;
import org.bana.wechat.qy.suite.SuiteClient;
import org.bana.wechat.qy.suite.param.GetCorpTokenParam;
import org.junit.Before;
import org.junit.Test;

/** 
 * @ClassName: MenuClientTest 
 * @Description: 测试自定义菜单
 *  
 */
public class MenuClientTest extends BaseTestCase{

	private AccessToken corpToken;
	
	@Before
	public void init(){
		SuiteAccessToken suiteToken = GetToken.getSuiteToken(suite_id, suite_secret, suite_ticket);
		GetCorpTokenParam tokenParam = new GetCorpTokenParam();
		tokenParam.setSuite_access_token(suiteToken.getSuiteAccessToken());
		tokenParam.setSuite_id(suite_id);
		tokenParam.setPermanent_code(permanentCode);
		tokenParam.setAuth_corpid(cropId);
		corpToken = SuiteClient.getCorpToken(tokenParam);
	}
	/**
	 * Test method for {@link org.bana.wechat.qy.menu.MenuClient#get(org.bana.wechat.qy.menu.param.MenuGetParam)}.
	 */
	@Test
	public void testGet() {
		String agentId = "20";
		MenuGetParam getParam = new MenuGetParam();
		getParam.setAccess_token(corpToken.getAccessToken());
		getParam.setAgentid(agentId);
		Menu menu = MenuClient.get(getParam);
		assertNotNull(menu);
		//update 增加新的菜单// http://wechat.i3618.com.cn/wechat-web/wechatcorp/test/moments?corpId=${corpid}&agentId=${agentid}
		MenuCreateParam createParam = new MenuCreateParam();
		createParam.setAccess_token(corpToken.getAccessToken());
		createParam.setAgentid(agentId);
		List<Button> buttonList = menu.getButton();
		Button subButton2 = new Button();
		subButton2.setType("view");
		subButton2.setName("圈子");
		subButton2.setUrl("http://iwechat.i3618.com.cn/wechat-web/wechatcorp/test/moments?" + "corpId=" + cropId + "&agentId=" + agentId);
//		buttonList.remove(0);
		buttonList.add(0,subButton2);
		createParam.setButton(buttonList);
		MenuClient.create(createParam);
	}
	
	@Test
	public void testCreate() {
		MenuCreateParam createParam = new MenuCreateParam();
		createParam.setAccess_token(corpToken.getAccessToken());
		createParam.setAgentid("5");
		//创建Menu
		List<Button> buttonList = new ArrayList<Button>();
		Button button1 = new Button();
		button1.setName("今日歌曲");
		button1.setKey("V1001_TODAY_MUSIC");
		button1.setType("click");
		buttonList.add(button1);
		
		Button button2 = new Button();
		button2.setName("菜单");
		
		Button subButton = new Button();
		subButton.setType("view");
		subButton.setName("搜索");
		subButton.setUrl("http://www.baidu.com");
		Button subButton2 = new Button();
		subButton2.setType("view");
		subButton2.setName("微信链接用户");
		subButton2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=" + cropId + "&redirect_uri=" + URLEncoder.encode("http://manager.i3618.com.cn/wechat/suite/callBack") + "&response_type=code&scope=snsapi_base&state="+cropId + "#wechat_redirect");
		Button subButton3 = new Button();
		subButton3.setType("view");
		subButton3.setName("自己的链接");
		subButton3.setUrl("http://wechat.i3618.com.cn/wechat-web/wechatcorp/test/login?corpId=" + cropId + "&agentId=" + 5);
		
		List<Button> subList = new ArrayList<Button>();
		subList.add(subButton);
		subList.add(subButton2);
		subList.add(subButton3);
		button2.setSub_button(subList);
		
		buttonList.add(button2);
		createParam.setButton(buttonList);
		
		MenuClient.create(createParam);
	}
	
	@Test
	public void testRedirectConnect(){
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf53fe967743802e4&redirect_uri=http://manager.i3618.com.cn/wechat/suite/callBack&response_type=code&scope=snsapi_base&state=wxf53fe967743802e4&connect_redirect=1#wechat_redirect";
		String string = WeChatConnection.get(url, null);
		System.out.println(string);
	}

}
