/**
 * @Company JBINFO
 * @Title: AccessTokenService.java
 * @Package org.bana.wechat.cp.common
 * @author Liu Wenjie
 * @date 2018年1月19日 下午1:17:39
 * @version V1.0
 */
package org.bana.wechat.cp.token;

/**
 * @ClassName: AccessTokenService
 * @Description: AccessTokenService方法
 * @author Liu Wenjie
 */
public interface AccessTokenService {

	/**
	 * Description: 根据企业号id和应用id获取token字符串，缓存功能需要在内部实现
	 * @author Liu Wenjie
	 * @date 2018年1月19日 下午1:18:25
	 * @param corpId
	 * @param agentId
	 * @return
	 */
	String getAccessToken(String corpId,String agentId);
	
}
