/**
 * @Company Elink
 * @Title: JSApiMpService.java
 * @Package org.bana.wechat.mp.token
 * @author Huang Nana
 * @date 2018年5月16日 上午9:47:58
 * @version V1.0
 */
package org.bana.wechat.mini.message;

import org.bana.wechat.mini.message.result.MsgCheckResult;

/**
 * @ClassName: MessageMiniService
 * @Description: 小程序相关接口
 * @author zhang zhichao
 */
public interface MessageMiniService {

	/**
	 * Description: 小程序：内容安全：文字
	 * @author Zhang Zhichao
	 * @date 2019年6月3日 下午3:53:19
	 * @param code
	 * @return
	 */
	MsgCheckResult checkMsgSec(String accessToken,String content);
}
