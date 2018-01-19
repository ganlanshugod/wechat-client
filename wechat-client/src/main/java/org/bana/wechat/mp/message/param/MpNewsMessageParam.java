/**
* @Company 青鸟软通   
* @Title: MpNewsMessageParam.java 
* @Package org.bana.wechat.mp.message.param 
* @author Han Tongyang   
* @date 2016-3-21 下午6:26:47 
* @version V1.0   
*/ 
package org.bana.wechat.mp.message.param;

/** 
 * @ClassName: MpNewsMessageParam 
 * @Description: 
 *  
 */
public class MpNewsMessageParam {
	private String media_id;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	/**
	* <p>Description: </p> 
	* @author Han Tongyang   
	* @date 2016-4-5 下午12:21:20 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "MpNewsMessageParam [media_id=" + media_id + "]";
	}
	
}
