/**
 * @Company Elink
 * @Title: MenuMpInfoParam.java
 * @Package org.bana.wechat.mp.menu.param
 * @author zhang zhichao
 * @date 2019年8月16日 上午17:41:28
 * @version V1.0
 */
package org.bana.wechat.mp.menu.param;

import java.util.List;

import org.bana.wechat.mp.common.WeChatMpParam;
import org.bana.wechat.mp.menu.model.MenuMpModel;

/**
 * @ClassName: MenuMpInfoParam
 * @Description: 
 * @author zhang zhichao
 */
public class MenuMpInfoParam extends WeChatMpParam{

	private static final long serialVersionUID = 3634339155934782082L;
	
	private List<MenuMpModel> button; //必填，一级菜单数组，个数应为1~3个

	public List<MenuMpModel> getButton() {
		return button;
	}
	public void setButton(List<MenuMpModel> button) {
		this.button = button;
	}
}
