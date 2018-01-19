/**
* @Company 青鸟软通   
* @Title: TagCreateParam.java 
* @Package org.bana.wechat.qy.tag.param 
* @author Liu Wenjie   
* @date 2015-5-11 下午10:23:15 
* @version V1.0   
*/ 
package org.bana.wechat.qy.tag.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: TagCreateParam 
 * @Description: 创建标签的方法
 *  
 */
public class TagCreateParam extends WeChatParam {
	
	private String tagname; //标签名称，长度为1~64个字符，标签名不可与其他标签重名。

	/**
	 * @Description: 属性 tagname 的get方法 
	 * @return tagname
	 */
	public String getTagname() {
		return tagname;
	}

	/**
	 * @Description: 属性 tagname 的set方法 
	 * @param tagname 
	 */
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午10:28:44 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "TagCreateParam [tagname=" + tagname + "]";
	}
	
	
}
