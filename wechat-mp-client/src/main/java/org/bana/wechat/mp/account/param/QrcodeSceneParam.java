/**
* @Company Elink   
* @Title: MaterialPageParam.java 
* @Package org.bana.wechat.mp.message.param 
* @author zhangzhichao   
* @date Aug 18, 2019 1:49:57 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.account.param;

import java.io.Serializable;

import org.bana.wechat.mp.common.WeChatMpParam;

import com.alibaba.fastjson.annotation.JSONField;

/** 
* @ClassName: QrcodeMpParam 
* @Description: 二维码
* @author zhangzhichao   
*/
public class QrcodeSceneParam implements Serializable {
	
	private static final long serialVersionUID = -3093329910350052400L;
	
	@JSONField(name="scene_id")
	private Integer sceneId; // 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	@JSONField(name="scene_str")
	private String sceneStr; // 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
	
	public Integer getSceneId() {
		return sceneId;
	}
	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}
	public String getSceneStr() {
		return sceneStr;
	}
	public void setSceneStr(String sceneStr) {
		this.sceneStr = sceneStr;
	}
}
