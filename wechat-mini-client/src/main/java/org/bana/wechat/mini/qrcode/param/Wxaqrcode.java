/**
* @Company Elink   
* @Title: Wxaqrcode.java 
* @Package org.bana.wechat.mini.qrcode.param 
* @author ChuLinpeng   
* @date 2021年1月27日 下午5:41:57 
* @version V1.0   
*/ 
package org.bana.wechat.mini.qrcode.param;

import org.bana.wechat.mini.common.WeChatMiniParam;

/** 
* @ClassName: Wxaqrcode 
* @Description: 
* @author ChuLinpeng   
*/
public class Wxaqrcode extends WeChatMiniParam {
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 7932272425429423952L;

	/** 
	* @Fields path : 扫码进入的小程序页面路径，最大长度 128 字节，不能为空；
	* 对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"，
	* 即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}。 
	*/ 
	private String path;
	
	/** 
	* @Fields width : 二维码的宽度，单位 px。最小 280px，最大 1280px
	* 默认值：430
	*/ 
	private int width = 430;
	
	


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
	
	@Override
	public String toString() {
		return "Wxaqrcode [path=" + path + ", width=" + width + "]";
	}
}
