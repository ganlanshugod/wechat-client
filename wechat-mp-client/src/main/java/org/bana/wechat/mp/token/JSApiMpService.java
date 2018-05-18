/**
 * @Company Elink
 * @Title: JSApiMpService.java
 * @Package org.bana.wechat.mp.token
 * @author Huang Nana
 * @date 2018年5月16日 上午9:47:58
 * @version V1.0
 */
package org.bana.wechat.mp.token;

import org.bana.wechat.mp.token.param.JsSdkMpParam;
import org.bana.wechat.mp.token.result.JSSDKMpConfig;

/**
 * @ClassName: JSApiMpService
 * @Description: js相关接口
 * @author Huang Nana
 */
public interface JSApiMpService {

	/**
	 * Description: 生成jssdkconfig
	 * @author Huang Nana
	 * @date 2018年5月16日 上午9:56:34
	 * @param jsSkdParam
	 * @return
	 */
	JSSDKMpConfig getJsSdkConfig(JsSdkMpParam jsSdkParam);
}
