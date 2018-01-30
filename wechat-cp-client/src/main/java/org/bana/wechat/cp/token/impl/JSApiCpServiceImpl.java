/**
 * @Company JBINFO
 * @Title: JSApiTicketServiceImpl.java
 * @Package org.bana.wechat.cp.token.impl
 * @author Liu Wenjie
 * @date 2018年1月30日 下午3:31:21
 * @version V1.0
 */
package org.bana.wechat.cp.token.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.bana.wechat.common.util.StringUtils;
import org.bana.wechat.cp.common.WechatCpException;
import org.bana.wechat.cp.token.AccessTokenService;
import org.bana.wechat.cp.token.JSApiCpService;
import org.bana.wechat.cp.token.domain.JSSDKCpConfig;
import org.bana.wechat.cp.token.param.JsSdkParam;

/**
 * @ClassName: JSApiTicketServiceImpl
 * @Description: 获取JsSdk的注册配置信息接口
 * @author Liu Wenjie
 */
public class JSApiCpServiceImpl implements JSApiCpService {
	
	private AccessTokenService accessTokenService;

	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月30日 下午3:31:21
	 * @param jsSkdParam
	 * @return
	 * @see org.bana.wechat.cp.token.JSApiTicketService#getJsSdkConfig(org.bana.wechat.cp.token.param.JsSdkParam)
	 */
	@Override
	public JSSDKCpConfig getJsSdkConfig(JsSdkParam jsSkdParam) {
		if(jsSkdParam == null || StringUtils.isBlank(jsSkdParam.getCorpId(),jsSkdParam.getAgentId())){
			throw new WechatCpException(WechatCpException.JSSKD_ERROR1, "corpId 和 agentId参数不能为空");
		}
		String corpId = jsSkdParam.getCorpId();
		String agentId = jsSkdParam.getAgentId();
		String ticket = accessTokenService.getJsApiTicket(corpId, agentId);
		String url = jsSkdParam.getUrl();
		String timestamp = String.valueOf(new Date().getTime()/1000);
		String noncestr = StringUtils.getRandomStr();
		StringBuffer sb = new StringBuffer("jsapi_ticket=").append(ticket)
				.append("&noncestr=").append(noncestr)
				.append("&timestamp=").append(timestamp)
				.append("url=").append(url);
		String signature = getSHA1(sb.toString());
		JSSDKCpConfig jssdkConfing = new JSSDKCpConfig();
		jssdkConfing.setAppId(corpId);
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

	
	public void setAccessTokenService(AccessTokenService accessTokenService) {
		this.accessTokenService = accessTokenService;
	}

}
