/**
 * @Company JBINFO
 * @Title: CacheSuiteAccessTokenServiceImpl.java
 * @Package org.bana.springboot.wechat.cp.token.impl
 * @author Liu Wenjie
 * @date 2018年1月31日 下午1:05:15
 * @version V1.0
 */
package org.bana.springboot.wechat.cp.token.impl;

import org.bana.wechat.cp.token.impl.SimpleSuiteAccessTokenServiceImpl;
import org.springframework.cache.annotation.Cacheable;

/**
 * @ClassName: CacheSuiteAccessTokenServiceImpl
 * @Description: 
 * @author Liu Wenjie
 */
public class CacheSuiteAccessTokenServiceImpl extends SimpleSuiteAccessTokenServiceImpl {

	/**
	 * <p>Description: </p>
	 * @author Liu Wenjie
	 * @date 2018年1月30日 下午4:34:16
	 * @param suiteId
	 * @return
	 * @see org.bana.wechat.cp.token.impl.SimpleAccessTokenServiceImpl#getSuiteAccessToken(java.lang.String)
	 */
	@Override
	@Cacheable(value="CPToken",key="methodName+#suiteId")
	public String getSuiteAccessToken(String suiteId) {
		return super.getSuiteAccessToken(suiteId);
	}
	
}
