/**
 * @Company JBINFO
 * @Title: WeChatCPSuiteParam.java
 * @Package org.bana.wechat.cp.common
 * @author Zhang Zhichao
 * @date 2018年1月29日 下午1:16:39
 * @version V1.0
 */
package org.bana.wechat.cp.common;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: WeChatCPSuiteParam
 * @Description: 访问微信第三方接口的通用参数类
 * @author Zhang Zhichao
 */
public class WeChatCPSuiteParam implements Serializable {

	private static final long serialVersionUID = -3083463202654690710L;
	
	/**
	 * @Fields suiteId : 微信套件id
	 */
	@JSONField(serialize=false)
	private String suiteId;

	/**
	 * @Description: 属性 suiteId 的get方法 
	 * @return suiteId
	 */
	public String getSuiteId() {
		return suiteId;
	}

	/**
	 * @Description: 属性 suiteId 的set方法 
	 * @param suiteId
	 */
	public void setSuiteId(String suiteId) {
		this.suiteId = suiteId;
	}
	
}
