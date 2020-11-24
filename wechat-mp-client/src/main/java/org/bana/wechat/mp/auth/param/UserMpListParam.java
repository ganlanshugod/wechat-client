/**
 * @Company JBINFO
 * @Title: UserMpInfoParam.java
 * @Package org.bana.wechat.mp.auth.param
 * @author Liu Wenjie
 * @date 2018年5月15日 上午10:41:28
 * @version V1.0
 */
package org.bana.wechat.mp.auth.param;

import org.bana.wechat.mp.common.WeChatMpParam;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: UserMpListParam
 * @Description: 
 * @author zzc
 */
public class UserMpListParam extends WeChatMpParam{
	private static final long serialVersionUID = -1493414258003634141L;
	
	@JSONField(name="next_openid")
	private String nextOpenid;

	public String getNextOpenid() {
		return nextOpenid;
	}

	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}
	
}
