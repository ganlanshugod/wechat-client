/**
 * @Company 青鸟软通   
 * @Title: MediaNewsParam.java 
 * @Package org.bana.wechat.mp.media.param 
 * @author Han Tongyang   
 * @date 2016-3-21 下午4:18:55 
 * @version V1.0   
 */
package org.bana.wechat.mp.media.param;

import java.util.List;

import org.bana.wechat.mp.common.WeChatMpParam;

/**
 * @ClassName: MediaNewsParam
 * @Description: 多媒体图文消息素材
 * 
 */
public class MediaNewsParam extends WeChatMpParam{
	
	private List<Article> articles; //图文消息，一个图文消息支持1到8条图文

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
