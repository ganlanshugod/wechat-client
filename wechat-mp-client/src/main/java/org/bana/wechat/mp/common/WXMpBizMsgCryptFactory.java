package org.bana.wechat.mp.common;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.app.WechatMpConfig;
import org.bana.wechat.mp.app.WechatMpManager;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

public class WXMpBizMsgCryptFactory {
	
	private WechatMpManager wechatMpManager;
	
	private Map<String,WXBizMsgCrypt> cacheMap = new HashMap<>();

	public WXBizMsgCrypt getWxBizMsgCrypt(String appId) {
		WXBizMsgCrypt wxBizMsgCrypt = cacheMap.get(appId);
		if(wxBizMsgCrypt == null) {
			WechatMpConfig config = wechatMpManager.getAppConfig(appId);
			if(config == null) {
				throw new RuntimeException("没有找到appId="+appId+ "对应的公众号配置信息");
			}else {
				if(StringUtils.isBlank(config.getToken(),config.getEncodingAESKey())) {
					throw new RuntimeException("appId="+appId+"的公众号没有配置加解密需要的参数"+config);
				}
			}
			wxBizMsgCrypt = new WXBizMsgCrypt(config.getToken(),config.getEncodingAESKey(),appId);
			cacheMap.put(appId, wxBizMsgCrypt);
		}
		return wxBizMsgCrypt;
	}

	public void setWechatMpManager(WechatMpManager wechatMpManager) {
		this.wechatMpManager = wechatMpManager;
	}

}