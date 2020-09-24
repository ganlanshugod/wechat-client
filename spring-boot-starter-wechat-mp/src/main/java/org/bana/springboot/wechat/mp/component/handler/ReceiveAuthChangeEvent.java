/**
* @Company 全域旅游
* @Title: ReceiveAuthChangeEvent.java 
* @Package org.bana.springboot.wechat.mp.component.handler 
* @author liuwenjie   
* @date Sep 23, 2020 2:09:26 PM 
* @version V1.0   
*/ 
package org.bana.springboot.wechat.mp.component.handler;

import org.bana.wechat.mp.component.param.ReceiveAuthChange;
import org.springframework.context.ApplicationEvent;

/** 
* @ClassName: ReceiveAuthChangeEvent 
* @Description: 授权变更接口
* @author liuwenjie   
*/
public class ReceiveAuthChangeEvent extends ApplicationEvent{

	private ReceiveAuthChange receiveAuthChange;
	
	/** 
	* <p>Description: </p> 
	* @author liuwenjie   
	* @date Sep 23, 2020 2:10:02 PM 
	* @param source 
	*/ 
	public ReceiveAuthChangeEvent(Object source,ReceiveAuthChange authChange) {
		super(source);
		this.receiveAuthChange = authChange;
	}

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = -1321364926391232013L;

	public ReceiveAuthChange getReceiveAuthChange() {
		return receiveAuthChange;
	}

	public void setReceiveAuthChange(ReceiveAuthChange receiveAuthChange) {
		this.receiveAuthChange = receiveAuthChange;
	}

}
