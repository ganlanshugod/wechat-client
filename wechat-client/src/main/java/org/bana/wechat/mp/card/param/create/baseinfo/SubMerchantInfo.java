/**
* @Company 艾美伴行   
* @Title: SubMerchantInfo.java 
* @Package org.bana.wechat.mp.card.param.create.baseinfo 
* @author liuwenjie   
* @date 2016-6-16 下午9:29:07 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.baseinfo;

/** 
 * @ClassName: SubMerchantInfo 
 * @Description: 子商户卡券
 *  
 */
public class SubMerchantInfo {

	private Integer merchant_id;

	/**
	 * @Description: 属性 merchant_id 的get方法 
	 * @return merchant_id
	 */
	public Integer getMerchant_id() {
		return merchant_id;
	}

	/**
	 * @Description: 属性 merchant_id 的set方法 
	 * @param merchant_id 
	 */
	public void setMerchant_id(Integer merchant_id) {
		this.merchant_id = merchant_id;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-16 下午9:29:48 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "SubMerchantInfo [merchant_id=" + merchant_id + "]";
	}
	
}
