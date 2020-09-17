/**
* @Company 全域旅游
* @Title: InMermeryWechatMpComponentTicketStore.java 
* @Package org.bana.wechat.mp.component.common.impl 
* @author liuwenjie   
* @date Sep 17, 2020 11:05:26 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.mp.component.common.WechatMpComponentTicketStore;

/** 
* @ClassName: InMermeryWechatMpComponentTicketStore 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author liuwenjie   
*/
public class InMermeryWechatMpComponentTicketStore implements WechatMpComponentTicketStore{

	private Map<String,String> cacheMap = new HashMap<>();
	
	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 17, 2020 11:05:57 AM 
	* @param appId
	* @return 
	* @see org.bana.wechat.mp.component.common.WechatMpComponentTicketStore#getComponentVerifyTicket(java.lang.String) 
	*/ 
	@Override
	public String getComponentVerifyTicket(String appId) {
		return cacheMap.get(appId);
	}

	/**
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 17, 2020 11:05:57 AM 
	* @param appId
	* @param ticket 
	* @see org.bana.wechat.mp.component.common.WechatMpComponentTicketStore#putComponentVerifyTicket(java.lang.String, java.lang.String) 
	*/ 
	@Override
	public void putComponentVerifyTicket(String appId, String ticket) {
		cacheMap.put(appId, ticket);
	}

}
