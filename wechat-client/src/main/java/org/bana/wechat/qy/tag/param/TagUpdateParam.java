/**
* @Company 青鸟软通   
* @Title: TagUpdateParam.java 
* @Package org.bana.wechat.qy.tag.param 
* @author Liu Wenjie   
* @date 2015-5-11 下午10:37:13 
* @version V1.0   
*/ 
package org.bana.wechat.qy.tag.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: TagUpdateParam 
 * @Description: 更新标签的参数
 *  
 */
public class TagUpdateParam extends WeChatParam {

	private String tagid;
	private String tagname;
	/**
	 * @Description: 属性 tagid 的get方法 
	 * @return tagid
	 */
	public String getTagid() {
		return tagid;
	}
	/**
	 * @Description: 属性 tagid 的set方法 
	 * @param tagid 
	 */
	public void setTagid(String tagid) {
		this.tagid = tagid;
	}
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
	* @date 2015-5-11 下午10:38:06 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "TagUpdateParam [tagid=" + tagid + ", tagname=" + tagname + ", access_token=" + access_token + "]";
	}
	
}
