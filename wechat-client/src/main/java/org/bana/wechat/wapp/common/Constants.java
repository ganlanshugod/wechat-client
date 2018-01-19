/**
* @Company 青鸟软通   
* @Title: Constants.java 
* @Package org.bana.wechat.qy.connection 
* @author Liu Wenjie   
* @date 2015-5-9 下午3:25:40 
* @version V1.0   
*/ 
package org.bana.wechat.wapp.common;

/** 
 * @ClassName: Constants 
 * @Description: 定义企业号访问的一些公共变量
 *  
 */
public enum Constants {
	/*接口地址的公共*/
	接口根路径("https://api.weixin.qq.com"),
	/*===========获取open_id及session_key的接口=================*/
	获取open_id及session_key(接口根路径.value + "/sns/jscode2session"),
	/*返回值属性的设置*/
	返回码("errcode"),
	返回信息("errmsg");
	
	
	private String value;
	
	private Constants(String value){
		this.value = value;
	}
	/**
	 * @Description: 属性 value 的get方法 
	 * @return value
	 */
	public String getValue() {
		return value;
	}
	
}
