/**
* @Company Elink   
* @Title: UserMpListData.java 
* @Package org.bana.wechat.mp.auth.result 
* @author zhangzhichao   
* @date Nov 18, 2020 9:48:16 AM 
* @version V1.0   
*/ 
package org.bana.wechat.mp.auth.result;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: UserMpListData 
* @Description: 关注用户openid列表
* @author zhangzhichao   
*/
public class UserMpListData implements Serializable{
	private static final long serialVersionUID = 7861237994043513132L;
	
	private List<String> openid;

	public List<String> getOpenid() {
		return openid;
	}

	public void setOpenid(List<String> openid) {
		this.openid = openid;
	}

	@Override
	public String toString() {
		return "UserMpListData [openid=" + openid + "]";
	}
	
}
