/**
 * @Company Elink
 * @Title: TemplateMessageResult.java
 * @Package org.bana.wechat.mp.message.result
 * @author Zhang Zhichao
 * @date 2018年9月4日 下午2:23:07
 * @version V1.0
 */
package org.bana.wechat.mp.menu.result;

import java.io.Serializable;

import org.bana.wechat.mp.menu.model.MenuMpInfoModel;

/**
 * @ClassName: MenuMpResult
 * @Description: 自定义菜单
 * @author Zhang Zhichao
 */
public class MenuMpResult implements Serializable {
	
	private static final long serialVersionUID = -4210505334034482316L;
	private String errcode;
	private String errmsg;
	private MenuMpInfoModel menu;
	private MenuMpInfoModel conditionalmenu;
	
	public String getErrcode() {
		return errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public MenuMpInfoModel getMenu() {
		return menu;
	}
	public void setMenu(MenuMpInfoModel menu) {
		this.menu = menu;
	}
	public MenuMpInfoModel getConditionalmenu() {
		return conditionalmenu;
	}
	public void setConditionalmenu(MenuMpInfoModel conditionalmenu) {
		this.conditionalmenu = conditionalmenu;
	}
	@Override
	public String toString() {
		return "MenuMpResult [errcode=" + errcode + ", errmsg=" + errmsg + ", menu=" + menu + ", conditionalmenu="
				+ conditionalmenu + "]";
	}
	
}
