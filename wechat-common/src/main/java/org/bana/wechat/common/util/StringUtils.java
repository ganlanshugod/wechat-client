/**
 * @Company JBINFO
 * @Title: StringUtils.java
 * @Package org.bana.wechat.common.util
 * @author Liu Wenjie
 * @date 2018年1月25日 下午5:48:08
 * @version V1.0
 */
package org.bana.wechat.common.util;

import java.util.Random;

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
	
	/** 
	* @Description: 获取一个随机的英文字符串
	* @author Liu Wenjie   
	* @date 2015-7-1 下午5:18:09 
	* @return  
	*/ 
	public static String getRandomStr() {
		return getRandomStr(16);
	}
	
	/** 
	* @Description: 获取指定长度的随机字符串
	* @author liuwenjie   
	* @date 2017-1-20 下午1:18:08 
	* @param num
	* @return  
	*/ 
	public static String getRandomStr(int num){
		if(num <= 0){
			num = 16;
		}
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
