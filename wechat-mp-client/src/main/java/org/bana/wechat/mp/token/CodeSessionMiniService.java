/**
 * @Company Elink
 * @Title: JSApiMpService.java
 * @Package org.bana.wechat.mp.token
 * @author Huang Nana
 * @date 2018年5月16日 上午9:47:58
 * @version V1.0
 */
package org.bana.wechat.mp.token;

import org.bana.wechat.mp.token.result.Code2SessionInfo;

/**
 * @ClassName: CodeSessionMiniService
 * @Description: 小程序相关接口
 * @author Huang Nana
 */
public interface CodeSessionMiniService {

	/**
	 * Description: 小程序：根据登录时获取的 code，获取session_key等信息
	 * @author Zhang Zhichao
	 * @date 2019年6月3日 下午3:53:19
	 * @param code
	 * @return
	 */
	Code2SessionInfo getSessionInfo(String appId,String code);
}
