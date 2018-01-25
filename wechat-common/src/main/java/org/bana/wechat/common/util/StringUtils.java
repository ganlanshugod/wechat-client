/**
 * @Company JBINFO
 * @Title: StringUtils.java
 * @Package org.bana.wechat.common.util
 * @author Liu Wenjie
 * @date 2018年1月25日 下午5:48:08
 * @version V1.0
 */
package org.bana.wechat.common.util;

/**
 * @ClassName: StringUtils
 * @Description: StringUtils扩展方法
 * @author Liu Wenjie
 */
public class StringUtils extends org.apache.commons.lang.StringUtils{

	/** 
	* @Description: 判断一组字符串是否为空白，有一个为空白则返回true
	* @author Liu Wenjie   
	* @date 2014-10-27 下午1:22:55 
	* @param strs
	* @return  
	*/ 
	public static boolean isBlank(String... strs){
		if(strs == null || strs.length == 0){
			return true;
		}
		for (String string : strs) {
			if(org.apache.commons.lang.StringUtils.isBlank(string)){
				return true;
			}
		}
		return false;
	}
}
