/**
* @Company 青鸟软通   
* @Title: WeChatExtAttr.java 
* @Package org.bana.wechat.qy.common 
* @author Liu Wenjie   
* @date 2015-5-11 下午4:19:04 
* @version V1.0   
*/ 
package org.bana.wechat.cp.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bana.wechat.common.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

/** 
 * @ClassName: WeChatExtAttr 
 * @Description: 微信的扩展属性对象
 *  
 */
public class WeChatExtAttr {
	
	private List<AttrObject> attrs;
	
	/** 
	 * <p>Description: </p> 
	 * @author Liu Wenjie   
	 * @date 2015-5-11 下午5:44:54  
	 */
	public WeChatExtAttr() {
		attrs = new ArrayList<AttrObject>();
	}
	
	
	public void put(String name,String value){
		this.remove(name);
		AttrObject a = new AttrObject();
		a.setName(name);
		a.setValue(value);
		attrs.add(a);
	}
	
	/**
	* @Description: 删除一个属性元素
	* @author Liu Wenjie   
	* @date 2015-5-11 下午5:47:17 
	* @param name
	* @return
	 */
	public boolean remove(String name){
		if(StringUtils.isBlank(name)){
			return false;
		}
		AttrObject a = new AttrObject();
		a.setName(name);
		return attrs.remove(a);
	}

	
	/**
	 * @Description: 属性 attrs 的get方法 
	 * @return attrs
	 */
	public List<AttrObject> getAttrs() {
		return attrs;
	}


	/**
	 * @Description: 属性 attrs 的set方法 
	 * @param attrs 
	 */
	public void setAttrs(List<AttrObject> attrs) {
		this.attrs = attrs;
	}


	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午8:57:00 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		Map<String,List<AttrObject>> map = new HashMap<String,List<AttrObject>>();
		if(this.attrs==null || this.attrs.isEmpty()){
			map.put("attrs", new ArrayList<AttrObject>());
		}else{
			map.put("attrs", this.attrs);
		}
		Object  jsonObj = JSONObject.toJSON(map);
		return jsonObj.toString();
	}
	
	public WeChatExtAttr append(String name,String value){
		getAttrs().add(new AttrObject(name,value));
		return this;
	}
	
}
