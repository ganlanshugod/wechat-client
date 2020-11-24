/**
 * @Company 
 * @Title: UserMpListResult.java
 * @Package org.bana.wechat.mp.auth.result
 * @author zzc
 * @date 2020年11月18日 上午10:40:09
 * @version V1.0
 */
package org.bana.wechat.mp.auth.result;

import java.io.Serializable;
import java.util.Arrays;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: UserMpListResult
 * @Description: 已关注用户列表
 * @author Liu Wenjie
 * {
    "total":2,
    "count":2,
    "data":{
    	"openid":["OPENID1","OPENID2"]
    	},
    "next_openid":"NEXT_OPENID"
   }
 */
public class UserMpListResult implements Serializable {
	private static final long serialVersionUID = -3722824954155150797L;
	
	private Long total; // 关注该公众账号的总用户数
	private Long count; // 拉取的OPENID个数，最大值为10000
	private UserMpListData data; // 列表数据，OPENID的列表
	@JSONField(name="next_openid")
	private String nextOpenid; // 拉取列表的最后一个用户的OPENID
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public UserMpListData getData() {
		return data;
	}
	public void setData(UserMpListData data) {
		this.data = data;
	}
	public String getNextOpenid() {
		return nextOpenid;
	}
	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}
	@Override
	public String toString() {
		return "UserMpListResult [total=" + total + ", count=" + count + ", data=" + data + ", nextOpenid=" + nextOpenid
				+ "]";
	}
	
}
