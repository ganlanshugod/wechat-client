/**
* @Company Elink   
* @Title: WxacodeUnlimitedParam.java 
* @Package org.bana.wechat.mini.qrcode.param 
* @author ChuLinpeng   
* @date 2021年1月27日 下午4:47:18 
* @version V1.0   
*/ 
package org.bana.wechat.mini.qrcode.param;

import org.bana.wechat.mini.common.WeChatMiniParam;

/** 
* @ClassName: WxacodeUnlimitedParam 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author ChuLinpeng   
*/
public class WxacodeUnlimitedParam extends WeChatMiniParam {
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 32170762593718497L;

	/** 
	* @Fields scene : 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，
	* 其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
	*/ 
	private String scene;
	/** 
	* @Fields path : 扫码进入的小程序页面路径，最大长度 128 字节，不能为空；
	* 对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"，
	* 即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}。 
	*/ 
	private String page;
	
	/** 
	* @Fields width : 二维码的宽度，单位 px。最小 280px，最大 1280px
	* 默认值：430
	*/ 
	private int width = 430;
	
	/**
	 * @Fields autoColor : 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调 默认值：false
	 */
	private boolean autoColor = false;

	/** 
	* @Fields lineColor : auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
	* 默认值：{"r":0,"g":0,"b":0}
	*/ 
	private LineColor lineColor = new LineColor(0, 0, 0);

	/**
	 * @Fields isHyaline : 是否需要透明底色，为 true 时，生成透明底色的小程序码 默认值：false
	 */
	private boolean isHyaline = false;
	
	

	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean isAutoColor() {
		return autoColor;
	}

	public void setAutoColor(boolean autoColor) {
		this.autoColor = autoColor;
	}

	public LineColor getLineColor() {
		return lineColor;
	}

	public void setLineColor(LineColor lineColor) {
		this.lineColor = lineColor;
	}

	public boolean isHyaline() {
		return isHyaline;
	}

	public void setHyaline(boolean isHyaline) {
		this.isHyaline = isHyaline;
	}

	@Override
	public String toString() {
		return "QrcodeUnlimitedParam [scene=" + scene + "]";
	}
}
