/**
* @Company 艾美伴行   
* @Title: CreateDiscountCard.java 
* @Package org.bana.wechat.mp.card.param.create.discount 
* @author liuwenjie   
* @date 2016-6-15 下午2:55:44 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.discount;

import org.bana.wechat.mp.card.param.create.BaseCard;

/** 
 * @ClassName: CreateDiscountCard 
 * @Description: 折扣券的内容
 *  
 */
public class CreateDiscountCard extends BaseCard{

	private int discount;//	是	int	30	折扣券专用，表示打折额度（百分比）。填30就是七折；

	/**
	 * @Description: 属性 discount 的get方法 
	 * @return discount
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * @Description: 属性 discount 的set方法 
	 * @param discount 
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-16 下午9:24:31 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateDiscountCard [discount=" + discount + ", base_info=" + base_info + ", advanced_info=" + advanced_info + "]";
	}

}
