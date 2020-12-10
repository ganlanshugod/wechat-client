/**
* @Company 全域旅游
* @Title: ArticleCallBackResult.java 
* @Package org.bana.wechat.mp.callback.result 
* @author liuwenjie   
* @date Sep 28, 2020 3:37:26 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.callback.result;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.mp.message.param.news.Article;

/** 
* @ClassName: ArticleCallBackResult 
* @Description: 
* @author liuwenjie   
*/
@XmlRootElement(name="xml")
public class ArticleCallBackResult extends CallBackResult {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -4670380117111374655L;
	
	private long articleCount;
	
	private List<Article> articles;

	@XmlElement(name="ArticleCount")
	public long getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(long articleCount) {
		this.articleCount = articleCount;
	}

	@XmlElementWrapper(name="Articles")
	@XmlElement(name="item")
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
