/**
* @Company 青鸟软通   
* @Title: NewsMessageParam.java 
* @Package org.bana.wechat.qy.message.param.news 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:30:37 
* @version V1.0   
*/ 
package org.bana.wechat.cp.message.param.news;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.message.param.MessageParam;

/** 
 * @ClassName: NewsMessageParam 
 * @Description: news消息
 *  
 */
public class NewsMessageParam extends MessageParam {


	private static final long serialVersionUID = 2230935836812548077L;
	private NewsMessage news;
	
	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2015-5-27 下午9:43:06  
	 */
	public NewsMessageParam() {
		setMsgtype(Constants.news消息.getValue());
	}

	/**
	 * @Description: 属性 news 的get方法 
	 * @return news
	 */
	public NewsMessage getNews() {
		return news;
	}

	/**
	 * @Description: 属性 news 的set方法 
	 * @param news 
	 */
	public void setNews(NewsMessage news) {
		this.news = news;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:33:59 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "NewsMessageParam [news=" + news + ", touser=" + touser + ", toparty=" + toparty + ", totag=" + totag + ", msgtype=" + msgtype + ", agentid=" + agentid + ", safe="
				+ safe + "]";
	}
	
}
