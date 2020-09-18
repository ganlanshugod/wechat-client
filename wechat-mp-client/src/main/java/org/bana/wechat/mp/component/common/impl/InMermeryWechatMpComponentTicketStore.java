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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
* @ClassName: InMermeryWechatMpComponentTicketStore 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author liuwenjie   
*/
public class InMermeryWechatMpComponentTicketStore implements WechatMpComponentTicketStore{
	private static final Logger LOG = LoggerFactory.getLogger(InMermeryWechatMpComponentTicketStore.class);

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
		LOG.info("使用内存中后去ticket=="+appId);
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
		LOG.info("使用内存保存ticket=="+appId+","+ticket);
		cacheMap.put(appId, ticket);
	}

}
