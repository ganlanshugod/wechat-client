/**
 * @Company 青鸟软通   
 * @Title: MessageFilterParam.java 
 * @Package org.bana.wechat.mp.message.param 
 * @author Han Tongyang   
 * @date 2016-3-21 下午6:20:42 
 * @version V1.0   
 */
package org.bana.wechat.mp.message.param;

/**
 * @ClassName: MessageFilterParam
 * @Description: 群发消息Filter参数
 * 
 */
public class MpMessageFilterParam {

	private boolean is_to_all;

	public boolean isIs_to_all() {
		return is_to_all;
	}

	public void setIs_to_all(boolean is_to_all) {
		this.is_to_all = is_to_all;
	}

	/**
	* <p>Description: </p> 
	* @author Han Tongyang   
	* @date 2016-4-5 下午12:21:41 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "MpMessageFilterParam [is_to_all=" + is_to_all + "]";
	}

}
