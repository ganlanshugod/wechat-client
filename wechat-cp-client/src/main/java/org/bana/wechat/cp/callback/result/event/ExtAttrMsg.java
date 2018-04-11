/**
 * @Company JBINFO
 * @Title: ExtAttrMsg.java
 * @Package org.bana.wechat.cp.callback.result.event
 * @author Zhang Zhichao
 * @date 2018年4月11日 上午10:19:06
 * @version V1.0
 */
package org.bana.wechat.cp.callback.result.event;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: ExtAttrMsg
 * @Description: 成员的扩展属性
 * @author Zhang Zhichao
 */
@XmlRootElement(name="Item")
public class ExtAttrMsg implements Serializable{

	private static final long serialVersionUID = 4585647403234759654L;
	
	private String name;
	private String value;
	
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
	 * @author Zhang Zhichao
	 * @date 2018年4月11日 上午10:21:37
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExtAttrMsg [name=" + name + ", value=" + value + "]";
	}
	
}
