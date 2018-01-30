/**
 * @Company JBINFO
 * @Title: SuiteCPServiceImpl.java
 * @Package org.bana.wechat.cp.suite.impl
 * @author Zhang Zhichao
 * @date 2018年1月29日 上午11:18:17
 * @version V1.0
 */
package org.bana.wechat.cp.suite.impl;

import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.cp.common.WeChatCPSuiteParam;
import org.bana.wechat.cp.common.WechatCpResultHandler;
import org.bana.wechat.cp.common.WechatCpService;
import org.bana.wechat.cp.suite.SuiteCPService;
import org.bana.wechat.cp.suite.domain.PermanentCode;
import org.bana.wechat.cp.suite.domain.PreAuthCode;
import org.bana.wechat.cp.suite.param.PermanentCodeParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: SuiteCPServiceImpl
 * @Description: 第三方应用相关接口
 * @author Zhang Zhichao
 */
public class SuiteCPServiceImpl extends WechatCpService implements SuiteCPService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SuiteCPServiceImpl.class);
	
	/**
	 * <p>Description: 获取永久授权码</p>
	 * @author Zhang Zhichao
	 * @date 2018年1月29日 下午1:27:16
	 * @param param
	 * @return
	 * @see org.bana.wechat.cp.suite.SuiteCPService#getPermanentCode(org.bana.wechat.cp.suite.param.PermanentCodeParam)
	 */
	@Override
	public PermanentCode getPermanentCode(PermanentCodeParam param) {
		JSONObject result = this.post(Constants.获取企业号的永久授权码.getValue(), param);
		PermanentCode permanentCode = WechatCpResultHandler.handleResult(result,PermanentCode.class);
		LOG.info("获取到的永久授权码为： " + permanentCode);
		return permanentCode;
	}
	
	/**
	 * <p>Description:获取预授权码 </p>
	 * @author Zhang Zhichao
	 * @date 2018年1月30日 下午5:38:36
	 * @param suiteId
	 * @return
	 * @see org.bana.wechat.cp.suite.SuiteCPService#getPreAuthCode(java.lang.String)
	 */
	@Override
	public PreAuthCode getPreAuthCode(String suiteId) {
		WeChatCPSuiteParam param = new WeChatCPSuiteParam();
		param.setSuiteId(suiteId);
		JSONObject result = this.get(Constants.获取预授权码.getValue(), param);
		PreAuthCode preAuthCode = WechatCpResultHandler.handleResult(result, PreAuthCode.class);
		LOG.info("获取到的永久授权码为： " + preAuthCode.toString());
		return preAuthCode;
	}
}
