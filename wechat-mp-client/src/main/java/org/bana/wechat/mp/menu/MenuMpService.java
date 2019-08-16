/**
 * @Company Elink
 * @Title: MessageMpService.java
 * @Package org.bana.wechat.mp.message
 * @author Zhang Zhichao
 * @date 2018年9月4日 下午1:46:25
 * @version V1.0
 */
package org.bana.wechat.mp.menu;

import org.bana.wechat.mp.menu.param.MenuMpInfoParam;
import org.bana.wechat.mp.menu.result.MenuMpResult;

/**
 * @ClassName: MenuMpService
 * @Description: 服务号：自定义菜单
 * @author Zhang Zhichao
 */
public interface MenuMpService {
	
	/** 
	* @Description: 创建菜单
	* @author zhangzhichao   
	* @date 2019-08-16 17:37:50 
	* @param menuParam  
	*/ 
	public MenuMpResult createMenu(MenuMpInfoParam menuParam);
	
	/** 
	* @Description: 查询菜单
	* @author zhangzhichao   
	* @date 2019-08-16 18:05:00 
	* @return  
	*/ 
	public MenuMpResult findAllMenus(String appId);
	
	/** 
	* @Description: 获取自定义菜单配置
	* @author zhangzhichao   
	* @date 2019-08-16 19:52:12 
	* @param appId
	* @return  
	*/ 
	public MenuMpResult findCurrMenus(String appId);
	
	/** 
	* @Description: 删除菜单
	* @author zhangzhichao   
	* @date 2019-08-16 18:05:00 
	* @return  
	*/ 
	public MenuMpResult deleteMenus(String appId);
}
