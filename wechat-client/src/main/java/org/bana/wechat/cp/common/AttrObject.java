/**
* @Company 青鸟软通   
* @Title: AttrObject.java 
* @Package org.bana.wechat.qy.common 
* @author Liu Wenjie   
* @date 2015-5-11 下午4:20:50 
* @version V1.0   
*/ 
package org.bana.wechat.cp.common;

import javax.xml.bind.annotation.XmlElement;

/** 
 * @ClassName: AttrObject 
 * @Description: 扩展属性对象
 *  
 */
public class AttrObject {

	private String name; //属性名
	private String value; //属性值
	
	public AttrObject() {
	}
	public AttrObject(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	/**
	 * @Description: 属性 name 的get方法 
	 * @return name
	 */
	@XmlElement(name="Name")
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
	 * @Description: 属性 value 的get方法 
	 * @return value
	 */
	@XmlElement(name="Value")
	public String getValue() {
		return value;
	}
	/**
	 * @Description: 属性 value 的set方法 
	 * @param value 
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午5:45:47 
	* @return 
	* @see java.lang.Object#hashCode() 
	*/ 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午5:45:47 
	* @param obj
	* @return 
	* @see java.lang.Object#equals(java.lang.Object) 
	*/ 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttrObject other = (AttrObject) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-11 下午5:45:55 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "AttrObject [name=" + name + ", value=" + value + "]";
	}
	
	
}
