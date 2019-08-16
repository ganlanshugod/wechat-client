/**
 * @Company Elink
 * @Title: MenuMpInfoParam.java
 * @Package org.bana.wechat.mp.menu.param
 * @author zhang zhichao
 * @date 2019年8月16日 上午17:41:28
 * @version V1.0
 */
package org.bana.wechat.mp.menu.model;

import java.util.List;

import org.bana.wechat.mp.common.WeChatMpParam;
import org.bana.wechat.mp.menu.model.MenuMpModel;

/**
 * @ClassName: MenuMpInfoModel
 * @Description: 
 * @author zhang zhichao
 */
public class MenuMpInfoModel extends WeChatMpParam{

	private static final long serialVersionUID = -283461694097172480L;
	
	private List<MenuMpModel> button;

	public List<MenuMpModel> getButton() {
		return button;
	}
	public void setButton(List<MenuMpModel> button) {
		this.button = button;
	}
}
