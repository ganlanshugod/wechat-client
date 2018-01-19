/**
* @Company 艾美伴行   
* @Title: CreateDiscountCardParam.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 上午11:14:14 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.discount;

import org.bana.wechat.mp.card.param.create.CreateCardParam;
import org.bana.wechat.mp.common.Constants;

/** 
 * @ClassName: CreateDiscountCardParam 
 * @Description: 创建折扣券的参数
 *  
 */
public class CreateDiscountCardParam extends CreateCardParam {

	private CreateDiscountCard discount;

	/** 
	 * <p>Description: </p> 
	 * @author liuwenjie   
	 * @date 2016-6-15 上午11:15:18  
	 */
	public CreateDiscountCardParam() {
		setCard_type(Constants.折扣券.getValue());
	}

	/**
	 * @Description: 属性 discount 的get方法 
	 * @return discount
	 */
	public CreateDiscountCard getDiscount() {
		return discount;
	}

	/**
	 * @Description: 属性 discount 的set方法 
	 * @param discount 
	 */
	public void setDiscount(CreateDiscountCard discount) {
		this.discount = discount;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午2:56:45 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateDiscountCardParam [discount=" + discount + ", card_type=" + card_type + ", access_token=" + access_token + "]";
	}

}
