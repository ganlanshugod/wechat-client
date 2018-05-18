/**
 * @Company JBINFO
 * @Title: CacheJsApiTicketServiceImpl.java
 * @Package org.bana.springboot.wechat.cp.token.impl
 * @author Liu Wenjie
 * @date 2018年1月31日 下午1:06:09
 * @version V1.0
 */
package org.bana.springboot.wechat.mp.token.impl;

import org.bana.wechat.mp.token.impl.SimpleJsApiTicketMpService;
import org.springframework.cache.annotation.Cacheable;

/**
 * @ClassName: CacheJsApiTicketServiceImpl
 * @Description: 
 * @author Liu Wenjie
 */
public class CacheJsApiTicketMpServiceImpl extends SimpleJsApiTicketMpService {

	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月30日 下午4:34:21
	 * @param corpId
	 * @param agentId
	 * @return
	 * @see org.bana.wechat.cp.token.impl.SimpleAccessTokenServiceImpl#getJsApiTicket(java.lang.String, java.lang.String)
	 */
	@Override
	// @Cacheable(value="MPToken",key="methodName+#appId")
	public String getJsApiTicket(String appId) {
		return super.getJsApiTicket(appId);
	}
}
