/**
 * @Company JBINFO
 * @Title: SuiteAccessTokenService.java
 * @Package org.bana.wechat.cp.token
 * @author Liu Wenjie
 * @date 2018年1月31日 下午12:00:48
 * @version V1.0
 */
package org.bana.wechat.cp.token;

/**
 * @ClassName: SuiteAccessTokenService
 * @Description: suite_access_token的配置类
 * @author Liu Wenjie
 */
public interface SuiteAccessTokenService {

	/**
	 * Description: 根据企业微信的suiteId获取套件的suite_access_token
	 * @author Zhang Zhichao
	 * @date 2018年1月25日 下午2:16:55
	 * @param suiteId
	 * @return
	 */
	String getSuiteAccessToken(String suiteId);
}
