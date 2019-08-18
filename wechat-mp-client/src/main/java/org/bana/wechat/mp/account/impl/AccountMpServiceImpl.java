/**
* @Company Elink   
* @Title: AccountMpServiceImpl.java 
* @Package org.bana.wechat.mp.account.impl 
* @author zhangzhichao   
* @date Aug 18, 2019 3:06:23 PM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.account.impl;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.account.AccountMpService;
import org.bana.wechat.mp.account.param.QrcodeMpParam;
import org.bana.wechat.mp.account.result.QrcodeMpResult;
import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.common.WechatMpResultHandler;
import org.bana.wechat.mp.common.WechatMpService;

import com.alibaba.fastjson.JSONObject;

/** 
* @ClassName: AccountMpServiceImpl 
* @Description: 服务号账号管理
* @author zhangzhichao   
*/
public class AccountMpServiceImpl extends WechatMpService implements AccountMpService {

	/**
	* <p>Description: </p> 
	* @author zhangzhichao   
	* @date Aug 18, 2019 3:06:23 PM 
	* @param param
	* @return 
	* @see org.bana.wechat.mp.account.AccountMpService#getAutoReplyInfo(org.bana.wechat.mp.account.param.QrcodeMpParam) 
	*/
	@Override
	public QrcodeMpResult generateQrcode(QrcodeMpParam param) {
		// 非空校验
		if(param == null || StringUtils.isBlank(param.getAppId())){
			throw new WeChatMpException(WeChatMpException.PARAM_ERROR,"generateQrcode时参数不能为空 param=" + param.toString());
		}
		String url = this.addAccessToken(Constants.账号管理_生成二维码.getValue(), param);
		JSONObject resultObject = this.getHttpHelper().httpPost(url, param);
		return WechatMpResultHandler.handleResult(resultObject,QrcodeMpResult.class);
	}

}
