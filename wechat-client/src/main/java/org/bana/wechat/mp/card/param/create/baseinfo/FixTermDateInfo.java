/**
* @Company 艾美伴行   
* @Title: FixTermDateInfo.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 下午1:53:21 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.baseinfo;

import org.bana.wechat.mp.common.Constants;

/** 
 * @ClassName: FixTermDateInfo 
 * @Description: 固定时长类型的时间格式
 *  
 */
public class FixTermDateInfo extends DateInfo {

	private int fixed_term;//	否	int	15	type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。
	private int fixed_begin_term;//	否	int	0	type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。（单位为天）
	private long end_timestamp; //可用于DATE_TYPE_FIX_TERM时间类型，表示卡券统一过期时间，建议设置为截止日期的23:59:59过期。（东八区时间，单位为秒），设置了fixed_term卡券，当时间达到end_timestamp时卡券统一过期
	
	
	/** 
	 * <p>Description: </p> 
	 * @author liuwenjie   
	 * @date 2016-6-15 下午1:53:37  
	 */
	public FixTermDateInfo() {
		setType(Constants.卡券时间_固定时长.getValue());
	}

	/**
	 * @Description: 属性 fixed_term 的get方法 
	 * @return fixed_term
	 */
	public int getFixed_term() {
		return fixed_term;
	}

	/**
	 * @Description: 属性 fixed_term 的set方法 
	 * @param fixed_term 
	 */
	public void setFixed_term(int fixed_term) {
		this.fixed_term = fixed_term;
	}

	/**
	 * @Description: 属性 fixed_begin_term 的get方法 
	 * @return fixed_begin_term
	 */
	public int getFixed_begin_term() {
		return fixed_begin_term;
	}

	/**
	 * @Description: 属性 fixed_begin_term 的set方法 
	 * @param fixed_begin_term 
	 */
	public void setFixed_begin_term(int fixed_begin_term) {
		this.fixed_begin_term = fixed_begin_term;
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
	* @date 2017-1-19 下午4:58:15 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "FixTermDateInfo [fixed_term=" + fixed_term + ", fixed_begin_term=" + fixed_begin_term + ", end_timestamp=" + end_timestamp + "]";
	}

}
