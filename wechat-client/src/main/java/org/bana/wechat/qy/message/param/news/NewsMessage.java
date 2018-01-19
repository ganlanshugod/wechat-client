/**
* @Company 青鸟软通   
* @Title: NewsMessage.java 
* @Package org.bana.wechat.qy.message.param.news 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:31:07 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message.param.news;

import java.util.List;

/** 
 * @ClassName: NewsMessage 
 * @Description: news消息
 *  
 */
public class NewsMessage {

	private List<Article> articles;

	/**
	 * @Description: 属性 articles 的get方法 
	 * @return articles
	 */
	public List<Article> getArticles() {
		return articles;
	}

	/**
	 * @Description: 属性 articles 的set方法 
	 * @param articles 
	 */
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:33:41 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "NewsMessage [articles=" + articles + "]";
	}
	
}
