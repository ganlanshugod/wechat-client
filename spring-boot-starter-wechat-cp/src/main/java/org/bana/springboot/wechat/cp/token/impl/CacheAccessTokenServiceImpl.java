/**
 * @Company JBINFO
 * @Title: CacheAccessTokenServiceImpl.java
 * @Package org.bana.springboot.wechat.cp.token.service.impl
 * @author Liu Wenjie
 * @date 2018年1月30日 下午4:33:27
 * @version V1.0
 */
package org.bana.springboot.wechat.cp.token.impl;

import org.bana.wechat.cp.token.impl.SimpleAccessTokenServiceImpl;
import org.springframework.cache.annotation.Cacheable;

/**
 * @ClassName: CacheAccessTokenServiceImpl
 * @Description: 基于spring的可缓存的token方法
 * @author Liu Wenjie
 */
public class CacheAccessTokenServiceImpl extends SimpleAccessTokenServiceImpl {

	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月30日 下午4:34:08
	 * @param corpId
	 * @param agentId
	 * @return
	 * @see org.bana.wechat.cp.token.impl.SimpleAccessTokenServiceImpl#getAccessToken(java.lang.String, java.lang.String)
	 */
	@Override
	@Cacheable(value="CPToken",key="methodName+#corpId+#agentId")
	public String getAccessToken(String corpId, String agentId) {
		return super.getAccessToken(corpId, agentId);
	}
	
}
