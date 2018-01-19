/**
* @Company 艾美伴行   
* @Title: FixTimeRangeDateInfo.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 下午1:50:49 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.baseinfo;

import org.bana.wechat.mp.common.Constants;

/** 
 * @ClassName: FixTimeRangeDateInfo 
 * @Description: 固定时长的时间参数
 *  
 */
public class FixTimeRangeDateInfo extends DateInfo {

	private long begin_timestamp;//	否	unsigned int	14300000	type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数，最终需转换为字符串形态传入。（东八区时间，单位为秒）
	private long end_timestamp;//	否	unsigned int	15300000	type为DATE_TYPE_FIX_TIME_RANGE时专用，表示结束时间，建议设置为截止日期的23:59:59过期。（东八区时间，单位为秒）
	
	/** 
	 * <p>Description: </p> 
	 * @author liuwenjie   
	 * @date 2016-6-15 下午1:51:28  
	 */
	public FixTimeRangeDateInfo() {
		setType(Constants.卡券时间_固定时间段.getValue());
	}

	/**
	 * @Description: 属性 begin_timestamp 的get方法 
	 * @return begin_timestamp
	 */
	public long getBegin_timestamp() {
		return begin_timestamp;
	}

	/**
	 * @Description: 属性 begin_timestamp 的set方法 
	 * @param begin_timestamp 
	 */
	public void setBegin_timestamp(long begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}

	/**
	 * @Description: 属性 end_timestamp 的get方法 
	 * @return end_timestamp
	 */
	public long getEnd_timestamp() {
		return end_timestamp;
	}

	/**
	 * @Description: 属性 end_timestamp 的set方法 
	 * @param end_timestamp 
	 */
	public void setEnd_timestamp(long end_timestamp) {
		this.end_timestamp = end_timestamp;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午1:51:37 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "FixTimeRangeDateInfo [begin_timestamp=" + begin_timestamp + ", end_timestamp=" + end_timestamp + "]";
	}
	
}
