/**
* @Company 艾美伴行   
* @Title: DateInfo.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 上午10:45:42 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.baseinfo;

/** 
 * @ClassName: DateInfo 
 * @Description: 日期格式内容
 *  
 */
public abstract class DateInfo {

	protected String type;//	是	string	DATE_TYPE_FIX_TIME_RANGE 表示固定日期区间，DATE_TYPE_FIX_TERM表示固定时长（自领取后按天算。	使用时间的类型，旧文档采用的1和2依然生效。
	
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
	protected void setType(String type) {
		this.type = type;
	}
	
}
