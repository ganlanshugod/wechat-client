/**
 * @Company JBINFO
 * @Title: SuiteCPService.java
 * @Package org.bana.wechat.cp.suite
 * @author Zhang Zhichao
 * @date 2018年1月29日 上午11:17:35
 * @version V1.0
 */
package org.bana.wechat.cp.suite;

import org.bana.wechat.cp.suite.domain.PermanentCode;
import org.bana.wechat.cp.suite.domain.PreAuthCode;
import org.bana.wechat.cp.suite.param.PermanentCodeParam;

/**
 * @ClassName: SuiteCPService
 * @Description: 第三方应用相关接口
 * @author Zhang Zhichao
 */
public interface SuiteCPService {
	
	/**
	 * Description: 获取永久授权码
	 * @author Zhang Zhichao
	 * @date 2018年1月29日 下午1:26:45
	 * @param param
	 * @return
	 */
	PermanentCode getPermanentCode(PermanentCodeParam param);
	
	/**
	 * Description: 获取预授权码
	 * @author Zhang Zhichao
	 * @date 2018年1月30日 下午5:37:23
	 * @param suiteId
	 * @return
	 */
	PreAuthCode getPreAuthCode(String suiteId);
}
