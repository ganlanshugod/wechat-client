/**
* @Company 全域旅游
* @Title: WechatMpComponentTicketStore.java 
* @Package org.bana.wechat.mp.component.common 
* @author liuwenjie   
* @date Sep 17, 2020 9:59:00 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.common;

/** 
* @ClassName: WechatMpComponentTicketStore 
* @Description: WechatMpComponentTicket 的存储类接口，可以保存对应的ticket存储位置
* @author liuwenjie   
*/
public interface WechatMpComponentTicketStore {

	/** 
	* @Description: 根据第三方平台appId获取推送的ticket内容
	* @author liuwenjie   
	* @date Sep 17, 2020 10:01:44 AM 
	* @param appId
	* @return  
	*/ 
	String getComponentVerifyTicket(String appId);
	
	
	/** 
	* @Description: 更新appId对应的ComponentVerifyTicket
	* @author liuwenjie   
	* @date Sep 17, 2020 10:03:26 AM 
	* @param appId
	* @param ticket
	* @return  返回的是当前的ticket
	*/ 
	void putComponentVerifyTicket(String appId,String ticket);
}
