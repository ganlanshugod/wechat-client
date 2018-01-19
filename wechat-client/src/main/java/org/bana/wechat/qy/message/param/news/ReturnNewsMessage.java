/**
* @Company 青鸟软通   
* @Title: ReturnNewsMessage.java 
* @Package org.bana.wechat.qy.message.param.news 
* @author Liu Wenjie   
* @date 2015-11-1 下午4:54:19 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message.param.news;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.qy.message.param.BaseReturnMessage;

/** 
 * @ClassName: ReturnNewsMessage 
 * @Description: 
 *  
 */
@XmlRootElement(name="xml")
public class ReturnNewsMessage extends BaseReturnMessage{
	
	private int articleCount;
	
	private List<Article> Articles;

	/**
	 * @Description: 属性 articleCount 的get方法 
	 * @return articleCount
	 */
	@XmlElement(name="ArticleCount")
	public int getArticleCount() {
		return articleCount;
	}

	/**
	 * @Description: 属性 articleCount 的set方法 
	 * @param articleCount 
	 */
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	/**
	 * @Description: 属性 articles 的get方法 
	 * @return articles
	 */
	@XmlElementWrapper(name="Articles")
	@XmlElement(name="item")
	public List<Article> getArticles() {
		return Articles;
	}

	/**
	 * @Description: 属性 articles 的set方法 
	 * @param articles 
	 */
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-11-1 下午4:58:27 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "ReturnNewsMessage [articleCount=" + articleCount + ", Articles=" + Articles + ", getToUserName()=" + getToUserName() + ", getFromUserName()=" + getFromUserName()
				+ ", getCreateTime()=" + getCreateTime() + ", getMsgType()=" + getMsgType() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	
}
