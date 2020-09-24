/**
* @Company 全域旅游
* @Title: BasicReceiveMsgHandler.java 
* @Package org.bana.wechat.mp.component.impl 
* @author liuwenjie   
* @date Sep 23, 2020 2:01:10 PM 
* @version V1.0   
*/
package org.bana.springboot.wechat.mp.component.handler.impl;

import java.util.Date;

import org.bana.springboot.wechat.mp.component.handler.ReceiveAuthChangeEvent;
import org.bana.springboot.wechat.mp.component.handler.ReceiveMsgHandler;
import org.bana.wechat.mp.app.WechatMpComponentAuthAppManager;
import org.bana.wechat.mp.component.ComponentService;
import org.bana.wechat.mp.component.common.ReceiveInfoType;
import org.bana.wechat.mp.component.param.ReceiveAuthChange;
import org.bana.wechat.mp.component.result.AuthDetailInfo;
import org.bana.wechat.mp.component.result.AuthorizationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @ClassName: BasicReceiveMsgHandler
 * @Description:
 * @author liuwenjie
 */
public class BasicReceiveMsgHandler implements ReceiveMsgHandler {

	private static final Logger LOG = LoggerFactory.getLogger(BasicReceiveMsgHandler.class);

	@Autowired
	private WechatMpComponentAuthAppManager wechatMpAuthAppManager;

	@Autowired
	private ComponentService componentService;
	
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author liuwenjie
	 * @date Sep 23, 2020 2:01:10 PM
	 * @param authChange
	 * @see org.bana.wechat.mp.component.ReceiveMsgHandler#handleReceiveAuthChange(org.bana.wechat.mp.component.param.ReceiveAuthChange)
	 */
	@Override
	public void handleReceiveAuthChange(ReceiveAuthChange authChange) {
		String infoType = authChange.getInfoType();
		String componentAppId = authChange.getAppId();
		long createTime = authChange.getCreateTime();
		Date createDate = new Date(createTime * 1000);
		String authorizerAppid = authChange.getAuthorizerAppid();
		if (ReceiveInfoType.授权成功通知.getValue().equalsIgnoreCase(infoType)) {
			String authCode = authChange.getAuthorizationCode();
			AuthorizationInfo queryAuth = componentService.queryAuth(componentAppId, authCode);
			AuthDetailInfo authorizerInfo = componentService.getAuthorizerInfo(componentAppId, authorizerAppid);
			wechatMpAuthAppManager.createComponentAppConfig(componentAppId, queryAuth,
					authorizerInfo.getAuthorizerInfo(), createDate);
		} else if (ReceiveInfoType.授权更新通知.getValue().equalsIgnoreCase(infoType)) {
			String authCode = authChange.getAuthorizationCode();
			AuthorizationInfo queryAuth = componentService.queryAuth(componentAppId, authCode);
			AuthDetailInfo authorizerInfo = componentService.getAuthorizerInfo(componentAppId, authorizerAppid);
			wechatMpAuthAppManager.updateComponentAppConfig(componentAppId, queryAuth,
					authorizerInfo.getAuthorizerInfo(), createDate);
		} else if (ReceiveInfoType.取消授权通知.getValue().equalsIgnoreCase(infoType)) {
			wechatMpAuthAppManager.deleteComponentAppConfig(componentAppId, authorizerAppid, createDate);
		} else {
			LOG.warn("====没有处理的不确定的infoType====" + authChange);
		}
		applicationContext.publishEvent(new ReceiveAuthChangeEvent(this,authChange));

	}

	public void setWechatMpAuthAppManager(WechatMpComponentAuthAppManager wechatMpAuthAppManager) {
		this.wechatMpAuthAppManager = wechatMpAuthAppManager;
	}

	public void setComponentService(ComponentService componentService) {
		this.componentService = componentService;
	}

}
