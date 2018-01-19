/**
* @Company 艾美伴行   
* @Title: MpEventEnum.java 
* @Package org.bana.wechat.mp.common 
* @author liuwenjie   
* @date 2017-1-20 下午4:04:34 
* @version V1.0   
*/ 
package org.bana.wechat.mp.common;

/** 
 * @ClassName: MpEventEnum 
 * @Description: 服务号的回调时间枚举类
 *  
 */
public enum MpEventEnum {

	领取卡券("user_get_card"),核销卡券("user_consume_card"),赠送卡券("user_gifting_card"),
	其他("other");
	
	private String value;
	private MpEventEnum(String value){
		this.value = value;
	}
	
	public static MpEventEnum getInstance(String value){
		for (MpEventEnum event : values()) {
			if(event.value.equals(value)){
				return event;
			}
		}
		return 其他;
	}
}
