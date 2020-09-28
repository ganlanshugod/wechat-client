package org.bana.wechat.mp.callback;

import java.util.ArrayList;
import java.util.List;

import org.bana.wechat.common.util.BeanXmlUtil;
import org.bana.wechat.mp.callback.result.ArticleCallBackResult;
import org.bana.wechat.mp.callback.result.CallBackResult;
import org.bana.wechat.mp.message.param.image.ImageMessage;
import org.bana.wechat.mp.message.param.news.Article;
import org.junit.Test;

/** 
* @ClassName: TestBeanXmlUtil 
* @Description: 
* @author liuwenjie   
*/
public class TestBeanXmlUtil {

	@Test
	public void testCallBackResult() {
		CallBackResult callBackResult = new CallBackResult();
		callBackResult.setFromUserName("appId");
		callBackResult.setToUserName("openId");
		callBackResult.setCreateTime(System.currentTimeMillis()/1000 + "");
		callBackResult.setMsgType("text");
		callBackResult.setResult("hello2");
		String beanToXml = BeanXmlUtil.beanToXml(callBackResult);
		System.out.println(beanToXml);
		callBackResult.setMsgType("image");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setMediaId("hello");
		callBackResult.setResult(imageMessage);
		System.out.println(BeanXmlUtil.beanToXml(callBackResult));
	}
	
	@Test
	public void testArticleCallBackResult() {
		ArticleCallBackResult callBackResult = new ArticleCallBackResult();
		callBackResult.setFromUserName("appId");
		callBackResult.setToUserName("openId");
		callBackResult.setCreateTime(System.currentTimeMillis()/1000 + "");
		callBackResult.setMsgType("news");
		callBackResult.setArticleCount(1);
		List<Article> articles = new ArrayList<>();
		Article news = new Article();
		news.setDescription("description");
		news.setPicUrl("picUrl");
		news.setTitle("title");
		news.setUrl("url");
		articles.add(news);
		callBackResult.setArticles(articles);
		System.out.println(BeanXmlUtil.beanToXml(callBackResult));
	}
}
