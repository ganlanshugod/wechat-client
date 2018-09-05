/**
 * @Company Elink
 * @Title: MiniprogramMpParam.java
 * @Package org.bana.wechat.mp.message.param
 * @author Zhang Zhichao
 * @date 2018年9月4日 下午2:10:10
 * @version V1.0
 */
package org.bana.wechat.mp.message.param;

/**
 * @ClassName: MiniprogramMpParam
 * @Description: 小程序参数
 * @author Zhang Zhichao
 */
public class MiniprogramMpParam {
	
	private String appid; // 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
	private String pagepath; // 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），暂不支持小游戏
	
	
	public String getAppid() {
		return appid;
	}
	public String getPagepath() {
		return pagepath;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	@Override
	public String toString() {
		return "MiniprogramMpParam [appid=" + appid + ", pagepath=" + pagepath + "]";
	}
	
}
