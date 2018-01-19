/**
* @Company 青鸟软通   
* @Title: GetShakeInfoParam.java 
* @Package org.bana.wechat.qy.shakearound 
* @author Liu Wenjie   
* @date 2015-9-16 上午11:37:57 
* @version V1.0   
*/ 
package org.bana.wechat.qy.shakearound.domain;


/** 
 * @ClassName: GetShakeInfoParam 
 * @Description: 获取摇一摇周边的用户信息的参数
 *  
 */
public class ShakeInfoDomain {

	 private Integer page_id;
	 private BeaconInfo beacon_info;
	 private String openid;
	/**
	 * @Description: 属性 page_id 的get方法 
	 * @return page_id
	 */
	public Integer getPage_id() {
		return page_id;
	}
	/**
	 * @Description: 属性 page_id 的set方法 
	 * @param page_id 
	 */
	public void setPage_id(Integer page_id) {
		this.page_id = page_id;
	}
	/**
	 * @Description: 属性 beacon_info 的get方法 
	 * @return beacon_info
	 */
	public BeaconInfo getBeacon_info() {
		return beacon_info;
	}
	/**
	 * @Description: 属性 beacon_info 的set方法 
	 * @param beacon_info 
	 */
	public void setBeacon_info(BeaconInfo beacon_info) {
		this.beacon_info = beacon_info;
	}
	/**
	 * @Description: 属性 openid 的get方法 
	 * @return openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * @Description: 属性 openid 的set方法 
	 * @param openid 
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-16 上午11:47:43 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "ShakeInfoDomain [page_id=" + page_id + ", beacon_info=" + beacon_info + ", openid=" + openid + "]";
	}
	 
}
