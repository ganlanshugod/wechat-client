/**
* @Company 艾美伴行   
* @Title: AbstractObject.java 
* @Package org.bana.wechat.mp.card.param.create.avancedinfo 
* @author liuwenjie   
* @date 2016-6-16 下午9:10:02 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.avancedinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @ClassName: AbstractObject 
 * @Description: 封面摘要结构体名称
 *  
 */
public class AbstractObject {

	private String abstractSummary;//	封面摘要简介。	否
	private List<String> icon_url_list;//	封面图片列表，仅支持填入一个封面图片链接，上传图片接口上传获取图片获得链接，填写非CDN链接会报错，并在此填入。建议图片尺寸像素850*350	是
	
	public Map<String,Object> toMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("abstract", abstractSummary);
		map.put("icon_url_list", icon_url_list);
		return map;
	}
	
	
	/**
	 * @Description: 属性 abstractSummary 的get方法 
	 * @return abstractSummary
	 */
	public String getAbstractSummary() {
		return abstractSummary;
	}
	/**
	 * @Description: 属性 abstractSummary 的set方法 
	 * @param abstractSummary 
	 */
	public void setAbstractSummary(String abstractSummary) {
		this.abstractSummary = abstractSummary;
	}
	
	/**
	 * @Description: 属性 icon_url_list 的get方法 
	 * @return icon_url_list
	 */
	public List<String> getIcon_url_list() {
		return icon_url_list;
	}


	/**
	 * @Description: 属性 icon_url_list 的set方法 
	 * @param icon_url_list 
	 */
	public void setIcon_url_list(List<String> icon_url_list) {
		this.icon_url_list = icon_url_list;
	}


	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-16 下午9:16:35 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AbstractObject [abstractSummary=" + abstractSummary + ", icon_url_list=" + icon_url_list + "]";
	}

	
}
