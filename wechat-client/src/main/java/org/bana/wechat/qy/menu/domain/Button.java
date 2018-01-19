/**
 * @Company 青鸟软通   
 * @Title: Button.java 
 * @Package org.bana.wechat.qy.menu.domain 
 * @author Liu Wenjie   
 * @date 2015-5-15 下午11:09:37 
 * @version V1.0   
 */
package org.bana.wechat.qy.menu.domain;

import java.util.List;

/**
 * @ClassName: Button
 * @Description: 一级菜单
 * 
 */
public class Button {

	private String name;// 是 菜单标题，不超过16个字节，子菜单不超过40个字节
	private String type;// 是 菜单的响应动作类型
	private String key;// click等点击类型必须 菜单KEY值，用于消息接口推送，不超过128字节
	private String url;// view类型必须 网页链接，成员点击菜单可打开链接，不超过256字节
	private List<Button> sub_button;

	/**
	 * @Description: 属性 name 的get方法
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @Description: 属性 name 的set方法
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @Description: 属性 type 的get方法
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @Description: 属性 type 的set方法
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @Description: 属性 key 的get方法
	 * @return key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @Description: 属性 key 的set方法
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @Description: 属性 sub_button 的get方法
	 * @return sub_button
	 */
	public List<Button> getSub_button() {
		return sub_button;
	}

	/**
	 * @Description: 属性 sub_button 的set方法
	 * @param sub_button
	 */
	public void setSub_button(List<Button> sub_button) {
		this.sub_button = sub_button;
	}
	
	

	/**
	 * @Description: 属性 url 的get方法 
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @Description: 属性 url 的set方法 
	 * @param url 
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-15 下午11:15:32 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "Button [name=" + name + ", type=" + type + ", key=" + key + ", url=" + url + ", sub_button=" + sub_button + "]";
	}

}
