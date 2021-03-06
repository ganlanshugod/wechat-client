/**
 * @Company Elink
 * @Title: MenuMpInfoParam.java
 * @Package org.bana.wechat.mp.menu.param
 * @author zhang zhichao
 * @date 2019年8月16日 上午17:41:28
 * @version V1.0
 */
package org.bana.wechat.mp.menu.model;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: MenuMpModel
 * @Description: 菜单基本信息
 * @author zhang zhichao
 */
public class MenuMpModel implements Serializable{

	private static final long serialVersionUID = -3289552461306603087L;

	private String type; // 必填，菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
	private String name; // 必填，菜单标题，不超过16个字节，子菜单不超过60个字节
	private String key; // click等点击类型必须，菜单KEY值，用于消息接口推送，不超过128字节
	private String url;	// view、miniprogram类型必须，网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url。
	@JSONField(name="media_id")
	private String mediaId; // media_id类型和view_limited类型必须，调用新增永久素材接口返回的合法media_id
	private String appid; // miniprogram类型必须，小程序的appid（仅认证公众号可配置）
	private String pagepath; // miniprogram类型必须，小程序的页面路径
	@JSONField(name="sub_button")
	private List<MenuMpModel> subButton; // 二级菜单数组，个数应为1~5个
	
	/*******************get,set************************/
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getPagepath() {
		return pagepath;
	}
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	public List<MenuMpModel> getSubButton() {
		return subButton;
	}
	public void setSubButton(List<MenuMpModel> subButton) {
		this.subButton = subButton;
	}
}
