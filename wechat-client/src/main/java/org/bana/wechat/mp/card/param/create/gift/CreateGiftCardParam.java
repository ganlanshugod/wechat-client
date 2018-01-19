/**
* @Company 艾美伴行   
* @Title: CreateGiftCardParam.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 上午11:17:28 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.gift;

import org.bana.wechat.mp.card.param.create.CreateCardParam;
import org.bana.wechat.mp.common.Constants;

/** 
 * @ClassName: CreateGiftCardParam 
 * @Description: 创建礼品券的参数
 *  
 */
public class CreateGiftCardParam extends CreateCardParam {

	private CreateGiftCard gift;
	
//	private String gift;//	是	string(3072)	可兑换音乐木盒一个。	礼品券专用，填写礼品的名称。；
	
	/** 
	 * <p>Description: </p> 
	 * @author liuwenjie   
	 * @date 2016-6-15 上午11:18:07  
	 */
	public CreateGiftCardParam() {
		setCard_type(Constants.礼品券.getValue());
	}

	/**
	 * @Description: 属性 gift 的get方法 
	 * @return gift
	 */
	public CreateGiftCard getGift() {
		return gift;
	}

	/**
	 * @Description: 属性 gift 的set方法 
	 * @param gift 
	 */
	public void setGift(CreateGiftCard gift) {
		this.gift = gift;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午2:39:41 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateGiftCardParam [gift=" + gift + ", card_type=" + card_type + ", access_token=" + access_token + "]";
	}

}
