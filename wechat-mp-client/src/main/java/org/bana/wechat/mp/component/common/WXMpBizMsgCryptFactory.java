/**
* @Company 全域旅游
* @Title: WXBizMsgCryptFactory.java 
* @Package org.bana.wechat.mp.component.common 
* @author liuwenjie   
* @date Sep 17, 2020 11:59:19 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.common;

import java.util.HashMap;
import java.util.Map;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/** 
* @ClassName: WXBizMsgCryptFactory 
* @Description: WXBizMsgCrypt方法
* @author liuwenjie   
*/
public class WXMpBizMsgCryptFactory {
	
	private WechatMpComponentManager wechatMpComponentManager;
	
	private Map<String,WXBizMsgCrypt> cacheMap = new HashMap<>();

	public WXBizMsgCrypt getWxBizMsgCrypt(String appId) {
		WXBizMsgCrypt wxBizMsgCrypt = cacheMap.get(appId);
		if(wxBizMsgCrypt == null) {
			WechatMpComponentConfig config = wechatMpComponentManager.getConfig(appId);
			wxBizMsgCrypt = new WXBizMsgCrypt(config.getComponentToken(),config.getEncodingAESKey(),appId);
			cacheMap.put(appId, wxBizMsgCrypt);
		}
		return wxBizMsgCrypt;
	}

	public void setWechatMpComponentManager(WechatMpComponentManager wechatMpComponentManager) {
		this.wechatMpComponentManager = wechatMpComponentManager;
	}
	
}
