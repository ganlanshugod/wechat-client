/**
* @Company 青鸟软通   
* @Title: Tag.java 
* @Package org.bana.wechat.qy.user.domain 
* @author Liu Wenjie   
* @date 2015-5-12 下午4:57:44 
* @version V1.0   
*/ 
package org.bana.wechat.qy.user.domain;

/** 
 * @ClassName: Tag 
 * @Description: 保存tag对象
 *  
 */
public class Tag {

	private Integer tagid;
	private String tagname;
	/**
	 * @Description: 属性 tagid 的get方法 
	 * @return tagid
	 */
	public Integer getTagid() {
		return tagid;
	}
	/**
	 * @Description: 属性 tagid 的set方法 
	 * @param tagid 
	 */
	public void setTagid(Integer tagid) {
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
	* @date 2015-5-12 下午4:58:39 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "Tag [tagid=" + tagid + ", tagname=" + tagname + "]";
	}
	
}
