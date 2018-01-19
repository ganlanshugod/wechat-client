/**
* @Company 艾美伴行   
* @Title: CreateGiftCard.java 
* @Package org.bana.wechat.mp.card.param.create.cash 
* @author liuwenjie   
* @date 2016-6-15 下午2:34:46 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.gift;

import org.bana.wechat.mp.card.param.create.BaseCard;

/** 
 * @ClassName: CreateGiftCard 
 * @Description: 
 *  
 */
public class CreateGiftCard extends BaseCard{

	private String gift;//	是	string(3072)	可兑换音乐木盒一个。	礼品券专用，填写礼品的名称。；

	/**
	 * @Description: 属性 gift 的get方法 
	 * @return gift
	 */
	public String getGift() {
		return gift;
	}

	/**
	 * @Description: 属性 gift 的set方法 
	 * @param gift 
	 */
	public void setGift(String gift) {
		this.gift = gift;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-16 下午9:24:52 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateGiftCard [gift=" + gift + ", base_info=" + base_info + ", advanced_info=" + advanced_info + "]";
	}
	
	
}
