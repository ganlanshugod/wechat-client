/**
 * @Company Elink
 * @Title: JSApiMpServiceImpl.java
 * @Package org.bana.wechat.mp.token.impl
 * @author Huang Nana
 * @date 2018年5月16日 上午9:58:10
 * @version V1.0
 */
package org.bana.wechat.mp.token.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.mp.common.WeChatMpException;
import org.bana.wechat.mp.token.JSApiMpService;
import org.bana.wechat.mp.token.JsApiTicketMpService;
import org.bana.wechat.mp.token.param.JsSdkMpParam;
import org.bana.wechat.mp.token.result.JSSDKMpConfig;

/**
 * @ClassName: JSApiMpServiceImpl
 * @Description: 
 * @author Huang Nana
 */
public class JSApiMpServiceImpl implements JSApiMpService {

	private JsApiTicketMpService jsApiTicketMpService;
	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月30日 下午3:31:21
	 * @param jsSkdParam
	 * @return
	 * @see org.bana.wechat.cp.token.JSApiTicketService#getJsSdkConfig(org.bana.wechat.cp.token.param.JsSdkParam)
	 */
	@Override
	public JSSDKMpConfig getJsSdkConfig(JsSdkMpParam jsSdkParam) {
		if(jsSdkParam == null || StringUtils.isBlank(jsSdkParam.getAppId())){
			throw new WeChatMpException(WeChatMpException.JSSKD_ERROR1, "appId参数不能为空");
		}
		String appId = jsSdkParam.getAppId();
		String ticket = jsApiTicketMpService.getJsApiTicket(appId);
		String url = jsSdkParam.getUrl();
		String timestamp = String.valueOf(new Date().getTime()/1000);
		String noncestr = StringUtils.getRandomStr();
		StringBuffer sb = new StringBuffer("jsapi_ticket=").append(ticket)
				.append("&noncestr=").append(noncestr)
				.append("&timestamp=").append(timestamp)
				.append("&url=").append(url);
		String signature = getSHA1(sb.toString());
		JSSDKMpConfig jssdkConfing = new JSSDKMpConfig();
		jssdkConfing.setAppId(appId);
		jssdkConfing.setNonceStr(noncestr);
		jssdkConfing.setSignature(signature);
		jssdkConfing.setTimestamp(timestamp);
		return jssdkConfing;
	}
	
	/**
	 * Description: 加密签名算法
	 * @author Liu Wenjie
	 * @date 2018年1月30日 下午4:00:47
	 * @param str
	 * @return
	 */
	private static String getSHA1(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("加密微信签名出错",e);
		}
	}

	public void setJsApiTicketMpService(JsApiTicketMpService jsApiTicketMpService) {
		this.jsApiTicketMpService = jsApiTicketMpService;
	}
}
