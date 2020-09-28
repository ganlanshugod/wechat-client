/**
* @Company 全域旅游
* @Title: ReceiveMsgHandler.java 
* @Package org.bana.wechat.mp.component 
* @author liuwenjie   
* @date Sep 23, 2020 1:58:25 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.component.handler;

import org.bana.wechat.mp.component.param.ReceiveAuthChange;

/** 
* @ClassName: ReceiveMsgHandler 
* @Description: 接受的第三方推送事件处理方法
* @author liuwenjie   
*/
public interface ReceiveMsgHandler {

	/**
	* @Description: 处理授权事件
	* @author liuwenjie   
	* @date Sep 23, 2020 1:59:17 PM
	 */
	public void handleReceiveAuthChange(ReceiveAuthChange authChange);
	
	
}
