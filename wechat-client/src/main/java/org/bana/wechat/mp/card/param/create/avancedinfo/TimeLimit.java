/**
* @Company 艾美伴行   
* @Title: TimeLimit.java 
* @Package org.bana.wechat.mp.card.param.create.avancedinfo 
* @author liuwenjie   
* @date 2016-6-15 下午3:08:05 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.avancedinfo;

/** 
 * @ClassName: TimeLimit 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class TimeLimit {

	private String type;//	限制类型枚举值：支持填入
	private String MONDAY;// 周一 TUESDAY 周二 WEDNESDAY 周三 THURSDAY 周四 FRIDAY 周五 SATURDAY 周六 SUNDAY 周日 此处只控制显示，不控制实际使用逻辑，不填默认不显示

	private String begin_hour;//	当前type类型下的起始时间（小时），如当前结构体内填写了MONDAY，此处填写了10，则此处表示周一 10:00可用	否
	private String begin_minute;//	当前type类型下的起始时间（分钟），如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59可用	否
	private String end_hour	;//当前type类型下的结束时间（小时），如当前结构体内填写了MONDAY，此处填写了20，则此处表示周一 10:00-20:00可用	否
	private String end_minute;//	当前type类型下的结束时间（分钟），如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59-00:59可用
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
	 * @Description: 属性 mONDAY 的get方法 
	 * @return mONDAY
	 */
	public String getMONDAY() {
		return MONDAY;
	}
	/**
	 * @Description: 属性 mONDAY 的set方法 
	 * @param mONDAY 
	 */
	public void setMONDAY(String mONDAY) {
		MONDAY = mONDAY;
	}
	/**
	 * @Description: 属性 begin_hour 的get方法 
	 * @return begin_hour
	 */
	public String getBegin_hour() {
		return begin_hour;
	}
	/**
	 * @Description: 属性 begin_hour 的set方法 
	 * @param begin_hour 
	 */
	public void setBegin_hour(String begin_hour) {
		this.begin_hour = begin_hour;
	}
	/**
	 * @Description: 属性 begin_minute 的get方法 
	 * @return begin_minute
	 */
	public String getBegin_minute() {
		return begin_minute;
	}
	/**
	 * @Description: 属性 begin_minute 的set方法 
	 * @param begin_minute 
	 */
	public void setBegin_minute(String begin_minute) {
		this.begin_minute = begin_minute;
	}
	/**
	 * @Description: 属性 end_hour 的get方法 
	 * @return end_hour
	 */
	public String getEnd_hour() {
		return end_hour;
	}
	/**
	 * @Description: 属性 end_hour 的set方法 
	 * @param end_hour 
	 */
	public void setEnd_hour(String end_hour) {
		this.end_hour = end_hour;
	}
	/**
	 * @Description: 属性 end_minute 的get方法 
	 * @return end_minute
	 */
	public String getEnd_minute() {
		return end_minute;
	}
	/**
	 * @Description: 属性 end_minute 的set方法 
	 * @param end_minute 
	 */
	public void setEnd_minute(String end_minute) {
		this.end_minute = end_minute;
	}
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午3:10:12 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "TimeLimit [type=" + type + ", MONDAY=" + MONDAY + ", begin_hour=" + begin_hour + ", begin_minute=" + begin_minute + ", end_hour=" + end_hour + ", end_minute="
				+ end_minute + "]";
	}

}
