/**
 * @Company Elink
 * @Title: TemplateMessageMpParam.java
 * @Package org.bana.wechat.mp.message.param
 * @author Zhang Zhichao
 * @date 2018年9月4日 下午1:59:55
 * @version V1.0
 */
package org.bana.wechat.mp.message.param;

import java.util.Map;

import org.bana.wechat.mp.common.WeChatMpParam;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: TemplateMessageMpParam
 * @Description: 发送模板消息
 * @author Zhang Zhichao
 */
public class TemplateMessageMpParam extends WeChatMpParam {

	private static final long serialVersionUID = 3588304645131872261L;
	
	private String touser; // 接收者openid
	@JSONField(name="template_id")
	private String templateId; // 模板ID
	private String url; // 模板跳转链接
	private MiniprogramMpParam miniprogram; // 跳小程序所需数据，不需跳小程序可不用传该数据
	private Map<String,TemplateDataMpParam> data; // 模板数据
	
	
	public String getTouser() {
		return touser;
	}
	public String getTemplateId() {
		return templateId;
	}
	public String getUrl() {
		return url;
	}
	public MiniprogramMpParam getMiniprogram() {
		return miniprogram;
	}
	public Map<String, TemplateDataMpParam> getData() {
		return data;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setMiniprogram(MiniprogramMpParam miniprogram) {
		this.miniprogram = miniprogram;
	}
	public void setData(Map<String, TemplateDataMpParam> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "TemplateMessageMpParam [touser=" + touser + ", templateId=" + templateId + ", url=" + url
				+ ", miniprogram=" + miniprogram + ", data=" + data + "]";
	}
	
}
