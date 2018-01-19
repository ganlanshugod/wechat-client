/**
* @Company 青鸟软通   
* @Title: MenuClient.java 
* @Package org.bana.wechat.qy.menu 
* @author Liu Wenjie   
* @date 2015-5-15 下午10:53:40 
* @version V1.0   
*/ 
package org.bana.wechat.qy.menu;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.Constants;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.menu.domain.Button;
import org.bana.wechat.qy.menu.domain.Menu;
import org.bana.wechat.qy.menu.param.MenuCreateParam;
import org.bana.wechat.qy.menu.param.MenuGetParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: MenuClient 
 * @Description: 自定义菜单的接口访问方法
 *  
 */
public class MenuClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(MenuClient.class);

	/** 
	* @Description: 获取菜单列表
	* @author Liu Wenjie   
	* @date 2015-5-15 下午11:03:30 
	* @param getParam
	* @return  
	*/ 
	public static Menu get(MenuGetParam getParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(getParam);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.get(Constants.获取菜单列表.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		// 将结果进行转换
		if (WeChatConnection.isSuccess(json)) {
			JSONObject menu = json.getJSONObject("menu");
			JsonConfig config = new JsonConfig();
			config.setRootClass(Menu.class);
			Map<String,Object> classMap = new HashMap<String, Object>();
			classMap.put("button",Button.class);
			classMap.put("sub_button", Button.class);
			config.setClassMap(classMap);
			Menu bean = (Menu) JSONObject.toBean(menu, config);
			LOG.info("转化后获取的菜单为 " + bean);
			return bean;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
	
	/** 
	* @Description: 创建应用菜单
	* @author Liu Wenjie   
	* @date 2015-5-15 下午11:33:32 
	* @param createParam
	* @return  
	*/ 
	public static void create(MenuCreateParam createParam){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(createParam);
		String agentid = (String)convertBean.get("agentid");
		String access_token = (String)convertBean.get("access_token");
		String url = Constants.创建应用菜单.getValue() + "?access_token="+access_token+"&agentid="+agentid;
		convertBean.put("agentid", null);
		convertBean.put("access_token", null);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(url, convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		// 将结果进行转换
		if (WeChatConnection.isSuccess(json)) {
			LOG.info("创建菜单成功 ");
		}else{
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
