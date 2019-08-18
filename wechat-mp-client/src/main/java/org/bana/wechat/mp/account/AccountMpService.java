/**
 * @Company Elink
 * @Title: MessageMpService.java
 * @Package org.bana.wechat.mp.message
 * @author Zhang Zhichao
 * @date 2018年9月4日 下午1:46:25
 * @version V1.0
 */
package org.bana.wechat.mp.account;

import org.bana.wechat.mp.account.param.QrcodeMpParam;
import org.bana.wechat.mp.account.result.QrcodeMpResult;

/**
 * @ClassName: AccountMpService
 * @Description: 服务号账号管理
 * @author Zhang Zhichao
 */
public interface AccountMpService {
	
	/** 
	* @Description: 生成带参数的二维码
	* @author zhangzhichao   
	* @date 2019-08-17 10:24:37 
	* @param appId  
	*/ 
	public QrcodeMpResult generateQrcode(QrcodeMpParam param);
	
}
