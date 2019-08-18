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
public class QrcodeActionInfoParam implements Serializable {
	private static final long serialVersionUID = -1863179021288287516L;
	
	private QrcodeSceneParam scene;

	public QrcodeSceneParam getScene() {
		return scene;
	}

	public void setScene(QrcodeSceneParam scene) {
		this.scene = scene;
	}
	
}
