/**
* @Company 青鸟软通   
* @Title: BeaconInfo.java 
* @Package org.bana.wechat.qy.shakearound.domain 
* @author Liu Wenjie   
* @date 2015-9-16 上午11:45:53 
* @version V1.0   
*/ 
package org.bana.wechat.qy.shakearound.domain;

/** 
 * @ClassName: BeaconInfo 
 * @Description: beacon设备的信息
 *  
 */
public class BeaconInfo {
	private Integer distance;//: 55.00620700469034,
    private Integer major;//": 10001,
    private Integer minor;//": 19007,
    private String uuid; //": "FDA50693-A4E2-4FB1-AFCF-C6EB07647825"
	/**
	 * @Description: 属性 distance 的get方法 
	 * @return distance
	 */
	public Integer getDistance() {
		return distance;
	}
	/**
	 * @Description: 属性 distance 的set方法 
	 * @param distance 
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	/**
	 * @Description: 属性 major 的get方法 
	 * @return major
	 */
	public Integer getMajor() {
		return major;
	}
	/**
	 * @Description: 属性 major 的set方法 
	 * @param major 
	 */
	public void setMajor(Integer major) {
		this.major = major;
	}
	/**
	 * @Description: 属性 minor 的get方法 
	 * @return minor
	 */
	public Integer getMinor() {
		return minor;
	}
	/**
	 * @Description: 属性 minor 的set方法 
	 * @param minor 
	 */
	public void setMinor(Integer minor) {
		this.minor = minor;
	}
	/**
	 * @Description: 属性 uuid 的get方法 
	 * @return uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @Description: 属性 uuid 的set方法 
	 * @param uuid 
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-9-16 上午11:47:05 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "BeaconInfo [distance=" + distance + ", major=" + major + ", minor=" + minor + ", uuid=" + uuid + "]";
	}

}
