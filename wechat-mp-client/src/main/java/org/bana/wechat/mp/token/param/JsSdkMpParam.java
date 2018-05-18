/**
 * @Company Elink
 * @Title: JsSdkMpParam.java
 * @Package org.bana.wechat.mp.token.param
 * @author Huang Nana
 * @date 2018年5月16日 上午9:51:45
 * @version V1.0
 */
package org.bana.wechat.mp.token.param;

import org.bana.wechat.mp.common.WeChatMpParam;

/**
 * @ClassName: JsSdkMpParam
 * @Description: 获取jssdkconfig的参数
 * @author Huang Nana
 */
public class JsSdkMpParam extends WeChatMpParam {

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
		return "JsSdkMpParam [url=" + url + "]";
	}
}
