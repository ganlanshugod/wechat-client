/**
* @Company 青鸟软通   
* @Title: ReturnT二十天下天.java 
* @Package org.bana.wechat.qy.message.param.text 
* @author Liu Wenjie   
* @date 2015-11-1 下午2:24:53 
* @version V1.0   
*/ 
package org.bana.wechat.qy.message.param.text;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bana.wechat.qy.message.param.BaseReturnMessage;

/** 
 * @ClassName: ReturnT二十天下天 
 * @Description: 返回的纯文本信息
 *  
 */
@XmlRootElement(name="xml")
public class ReturnTextMessage extends BaseReturnMessage{

	private String content;

	/**
	 * @Description: 属性 content 的get方法 
	 * @return content
	 */
	@XmlElement(name="Content")
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
	* @date 2015-11-1 下午2:26:37 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "ReturnTextMessage [content=" + content + ", getToUserName()=" + getToUserName() + ", getFromUserName()=" + getFromUserName() + ", getCreateTime()="
				+ getCreateTime() + ", getMsgType()=" + getMsgType() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
