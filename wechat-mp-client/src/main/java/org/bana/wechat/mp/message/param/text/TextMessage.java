package org.bana.wechat.mp.message.param.text;

import org.bana.wechat.mp.message.param.MessageParam;

/** 
* @ClassName: TextMessage 
* @Description: 文本消息
*  
*/ 
public class TextMessage extends MessageParam {
	/**
	 * 回复的消息内容
	 */
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TextMessage [content=" + content + "]";
	}

}