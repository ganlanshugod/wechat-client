/**
* @Company 青鸟软通   
* @Title: TagDeleteParam.java 
* @Package org.bana.wechat.qy.tag.param 
* @author Liu Wenjie   
* @date 2015-5-11 下午10:41:04 
* @version V1.0   
*/ 
package org.bana.wechat.qy.tag.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: TagDeleteParam 
 * @Description: 删除标签的参数
 *  
 */
public class TagDeleteParam extends WeChatParam {

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
	* @date 2015-5-11 下午10:41:43 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "TagDeleteParam [tagid=" + tagid + ", access_token=" + access_token + "]";
	}
	
}
