/**
* @Company 青鸟软通   
* @Title: TagGetParam.java 
* @Package org.bana.wechat.qy.tag.param 
* @author Liu Wenjie   
* @date 2015-5-11 下午10:43:59 
* @version V1.0   
*/ 
package org.bana.wechat.qy.tag.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: TagGetParam 
 * @Description: 获取标签成员的方法
 *  
 */
public class TagGetParam extends WeChatParam {

	private String tagid;

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
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午10:45:38 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "TagGetParam [tagid=" + tagid + ", access_token=" + access_token + "]";
	}
	
}
