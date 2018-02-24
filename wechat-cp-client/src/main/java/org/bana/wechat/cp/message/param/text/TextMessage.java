/**
* @Company 青鸟软通   
* @Title: TestMessage.java 
* @Package org.bana.wechat.qy.message.param.text 
* @author Liu Wenjie   
* @date 2015-5-27 下午9:12:28 
* @version V1.0   
*/ 
package org.bana.wechat.cp.message.param.text;

/** 
 * @ClassName: TestMessage 
 * @Description: 测试消息
 *  
 */
public class TextMessage {

	/** 
	* @Fields content : 消息内容
	*/ 
	public String content;

	/**
	 * @Description: 属性 content 的get方法 
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @Description: 属性 content 的set方法 
	 * @param content 
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:15:24 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "TestMessage [content=" + content + "]";
	}
	
}
