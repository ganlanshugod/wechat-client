/**
* @Company 艾美伴行  
* @Title: receiver.java 
* @Package org.bana.wechat.qy.kefu.param 
* @author Yang Shuangshuang   
* @date 2016-5-5 12:45:30 
* @version V1.0   
*/ 
package org.bana.wechat.qy.kefu.param;


/** 
 * @ClassName: receiver 
 * @Description:
 *  
 */
public class Receiver{

	

	protected String type; 
	protected String id; 
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	* <p>Description: </p> 
	* @author Yang Shuangshuang   
	* @date 2016-5-5 下午12:45:24 
	* @return 
	* @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Receiver [type=" + type + ", id=" + id +  "]";
	}
	
}
