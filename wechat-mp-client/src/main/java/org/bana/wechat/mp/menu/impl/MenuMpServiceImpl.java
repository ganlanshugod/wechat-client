/**
* @Company Elink   
* @Title: MenuMpServiceImpl.java 
* @Package org.bana.wechat.mp.menu.impl 
* @author zhangzhichao   
* @date Aug 16, 2019 5:38:32 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.menu.impl;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.common.WeChatMpParam;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.common.WechatMpService;
import org.bana.wechat.mp.menu.MenuMpService;
import org.bana.wechat.mp.menu.param.MenuMpInfoParam;
import org.bana.wechat.mp.menu.result.MenuMpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/** 
* @ClassName: MenuMpServiceImpl 
* @Description: 服务号：自定义菜单 
* @author zhangzhichao   
*/
public class MenuMpServiceImpl extends WechatMpService implements MenuMpService {
	private static final Logger LOG = LoggerFactory.getLogger(MenuMpServiceImpl.class);
	/**
	* <p>Description: </p> 
	* @author zhangzhichao   
	* @date Aug 16, 2019 5:38:32 PM 
	* @param menuParam 
	* @see org.bana.wechat.mp.menu.MenuMpService#createMenu(org.bana.wechat.mp.menu.param.MenuMpInfoParam) 
	*/
	@Override
	public MenuMpResult createMenu(MenuMpInfoParam menuParam) {
		// 非空校验
		if(StringUtils.isBlank(menuParam.getAppId())){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"createMenu时参数不能为空,appId=,"+menuParam.getAppId());
		}
		if(menuParam.getButton()==null || menuParam.getButton().isEmpty()) {
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"createMenu时button参数不能为空");
		}
		String url = this.addAccessToken(Constants.创建自定义菜单.getValue(), menuParam);
		JSONObject resultObject = this.getHttpHelper().httpPost(url, menuParam);
		return WechatMpResultHandler.handleResult(resultObject,MenuMpResult.class);
	}
	
	/**
	* <p>Description: 查询所有菜单</p> 
	* @author zhangzhichao   
	* @date Aug 16, 2019 6:05:53 PM 
	* @param appId
	* @return 
	* @see org.bana.wechat.mp.menu.MenuMpService#findAllMenus(java.lang.String) 
	*/ 
	@Override
	public MenuMpResult findAllMenus(String appId) {
		return operatorMenus(appId, "findAllMenus");
	}
	
	/**
	* <p>Description: 获取自定义菜单配置</p> 
	* @author zhangzhichao   
	* @date Aug 16, 2019 7:52:40 PM 
	* @param appId
	* @return 
	* @see org.bana.wechat.mp.menu.MenuMpService#findCurrMenus(java.lang.String) 
	*/ 
	@Override
	public MenuMpResult findCurrMenus(String appId) {
		return operatorMenus(appId, "findCurrMenus");
	}
	
	private MenuMpResult operatorMenus(String appId,String type) {
		// 非空校验
		if(StringUtils.isBlank(appId)){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,type+"时参数不能为空,appId=,"+appId);
		}
		WeChatMpParam param = new WeChatMpParam();
		param.setAppId(appId);
		String preUrl = "";
		if("findCurrMenus".equals(type)) {
			preUrl = Constants.获取自定义菜单配置.getValue();
		}else if("deleteMenus".equals(type)) {
			preUrl = Constants.删除自定义菜单.getValue();
		}else {
			preUrl = Constants.查询自定义菜单.getValue();
		}
		String url = this.addAccessToken(preUrl, param);
		JSONObject resultObject = this.getHttpHelper().httpGet(url);
		return WechatMpResultHandler.handleResult(resultObject,MenuMpResult.class);
	}
	
	/**
	* <p>Description: 删除菜单</p> 
	* @author zhangzhichao   
	* @date Aug 16, 2019 7:02:44 PM 
	* @param appId
	* @return 
	* @see org.bana.wechat.mp.menu.MenuMpService#deleteMenus(java.lang.String) 
	*/ 
	@Override
	public MenuMpResult deleteMenus(String appId) {
		return operatorMenus(appId, "deleteMenus");
	}

}
