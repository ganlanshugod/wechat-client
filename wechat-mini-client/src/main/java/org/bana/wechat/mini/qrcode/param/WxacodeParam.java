/**
* @Company Elink   
* @Title: WxacodeParam.java 
* @Package org.bana.wechat.mini.qrcode.param 
* @author ChuLinpeng   
* @date 2021年1月27日 下午4:39:00 
* @version V1.0   
*/
package org.bana.wechat.mini.qrcode.param;

/**
 * @ClassName: WxacodeParam
 * @Description:
 * @author ChuLinpeng
 */
public class WxacodeParam extends Wxaqrcode {
	/**
	 * @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = -4695510580347773974L;

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
		return "WxacodeParam [autoColor=" + autoColor + ", lineColor=" + lineColor + ", isHyaline=" + isHyaline + "]";
	}
}
