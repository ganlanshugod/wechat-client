/**
* @Company 青鸟软通   
* @Title: MpnewsMessage.java 
* @Package org.bana.wechat.qy.message.param.mpnews 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:35:20 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message.param.mpnews;

import java.util.List;

/** 
 * @ClassName: MpnewsMessage 
 * @Description: mpnews消息
 *  
 */
public class MpnewsMessage {

	private List<Article> articles;

	/**
	 * @Description: 属性 article 的get方法 
	 * @return article
	 */
	public List<Article> getArticles() {
		return articles;
	}

	/**
	 * @Description: 属性 article 的set方法 
	 * @param article 
	 */
	public void setArticles(List<Article> article) {
		this.articles = article;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:38:30 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "MpnewsMessage [articles=" + articles + "]";
	}
	
}
