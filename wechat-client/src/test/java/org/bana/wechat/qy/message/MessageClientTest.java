/**
* @Company 青鸟软通   
* @Title: MessageClientTest.java 
* @Package org.bana.wechat.qy.message 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:46:20 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

import org.bana.wechat.BaseTestCase;
import org.bana.wechat.qy.connection.GetToken;
import org.bana.wechat.qy.connection.domain.AccessToken;
import org.bana.wechat.qy.connection.domain.SuiteAccessToken;
import org.bana.wechat.qy.message.param.news.Article;
import org.bana.wechat.qy.message.param.news.NewsMessage;
import org.bana.wechat.qy.message.param.news.NewsMessageParam;
import org.bana.wechat.qy.message.param.text.TextMessage;
import org.bana.wechat.qy.message.param.text.TextMessageParam;
import org.bana.wechat.qy.suite.SuiteClient;
import org.bana.wechat.qy.suite.param.GetCorpTokenParam;
import org.junit.Before;
import org.junit.Test;

/** 
 * @ClassName: MessageClientTest 
 * @Description: 测试发消息 
 *  
 */
public class MessageClientTest extends BaseTestCase{

	private AccessToken corpToken;
	
	@Before
	public void init(){
//		SuiteAccessToken suiteToken = GetToken.getSuiteToken(suite_id, suite_secret, suite_ticket);
//		GetCorpTokenParam tokenParam = new GetCorpTokenParam();
//		tokenParam.setSuite_access_token(suiteToken.getSuite_access_token());
//		tokenParam.setSuite_id(suite_id);
//		tokenParam.setPermanent_code(permanentCode);
//		tokenParam.setAuth_corpid(cropId);
//		corpToken = SuiteClient.getCorpToken(tokenParam);
		corpToken = GetToken.getAccessToken(cropId, secret);
	}
	/**
	 * Test method for {@link org.bana.wechat.qy.message.MessageClient#send(org.bana.wechat.qy.message.param.MessageParam)}.
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void testSend() throws UnsupportedEncodingException {
		NewsMessageParam message = new NewsMessageParam();
		message.setAccess_token(corpToken.getAccess_token());
		message.setAgentid("253");
		message.setTouser("QY71_lxjj_1434013153877");
		NewsMessage news = new NewsMessage();
		Article article = new Article();
		article.setDescription("家长朋友们，请带领孩子们登陆安全教育平台&nbsp;完成上面的学习任务和作业&nbsp;，尤其是防溺水主题教育活动");
		article.setPicurl("http://d.hiphotos.baidu.com/image/pic/item/d0c8a786c9177f3eac56279c73cf3bc79e3d56c5.jpg");
		article.setUrl("http://www.sina.com");
//		article.setTitle(URLEncoder.encode("各位家长同学们，本周四下午2点，51中校长来校为六年级家长开小初调研会！机会难得，名额有限，每班15人！请大家积极参加，谢谢配合！找我报名吧！\u0014\u0012","utf-8"));
		article.setTitle("安全教育平台作业");
		news.setArticles(Arrays.asList(article));
		message.setNews(news);
		MessageClient.send(message);
	}
	
	@Test
	public void testSendMessage() {
		TextMessageParam message = new TextMessageParam();
		message.setAccess_token(corpToken.getAccess_token());
		message.setAgentid("4");
		message.setTouser("liuwenjie");
		TextMessage text = new TextMessage();
		text.setContent("测试发送");
		message.setText(text);
		MessageClient.send(message);
	}
	
	@Test
	public void testSendMessageH5(){
		AccessToken accessToken = GetToken.getAccessToken(cropId, secret);
		TextMessageParam message = new TextMessageParam();
		message.setAccess_token(accessToken.getAccess_token());
		message.setAgentid("141");
		message.setTouser("@all");
		TextMessage text = new TextMessage();
		text.setContent("测试是生死是测试是生死是测试是生死是测试是生死是测试是生死是测试是生死是测试是生死是测试是生死是测试是生死是");
		message.setText(text);
		MessageClient.send(message);
	}

}
