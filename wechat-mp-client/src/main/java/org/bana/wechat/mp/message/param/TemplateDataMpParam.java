/**
 * @Company Elink
 * @Title: TemplateDataMpParam.java
 * @Package org.bana.wechat.mp.message.param
 * @author Zhang Zhichao
 * @date 2018年9月4日 下午2:19:17
 * @version V1.0
 */
package org.bana.wechat.mp.message.param;

/**
 * @ClassName: TemplateDataMpParam
 * @Description: 模板消息参数
 * @author Zhang Zhichao
 */
public class TemplateDataMpParam {
	
	private String value;
	private String color; //模板内容字体颜色，不填默认为黑色，例如：#173177
	
	public TemplateDataMpParam() {
		super();
	}
	public TemplateDataMpParam(String value) {
		super();
		this.value = value;
	}

	public TemplateDataMpParam(String value, String color) {
		super();
		this.value = value;
		this.color = color;
	}
	


	public String getValue() {
		return value;
	}
	public String getColor() {
		return color;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "TemplateDataMpParam [value=" + value + ", color=" + color + "]";
	}
}
