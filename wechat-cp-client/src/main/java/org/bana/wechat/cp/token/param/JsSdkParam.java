/**
 * @Company JBINFO
 * @Title: JsSdkParam.java
 * @Package org.bana.wechat.cp.token.domain
 * @author Liu Wenjie
 * @date 2018年1月30日 下午3:25:56
 * @version V1.0
 */
package org.bana.wechat.cp.token.param;

import org.bana.wechat.cp.common.WeChatCPParam;

/**
 * @ClassName: JsSdkParam
 * @Description: 获取jsSdk的参数对象
 * @author Liu Wenjie
 */
public class JsSdkParam extends WeChatCPParam{

	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = -5241982013353372241L;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "JsSdkParam [url=" + url + ", corpId=" + corpId + ", agentId=" + agentId + "]";
	}
	
}
