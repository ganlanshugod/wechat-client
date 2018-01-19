/**
* @Company 艾美伴行   
* @Title: CreateDefaultCardParam.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 上午11:19:26 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.defaultcard;

import org.bana.wechat.mp.card.param.create.CreateCardParam;
import org.bana.wechat.mp.common.Constants;

/** 
 * @ClassName: CreateDefaultCardParam 
 * @Description: 创建优惠券的参数方法 
 *  
 */
public class CreateDefaultCardParam extends CreateCardParam {
	
	private  CreateDefaultCard general_coupon;

	/** 
	 * <p>Description: </p> 
	 * @author liuwenjie   
	 * @date 2016-6-15 上午11:19:43  
	 */
	public CreateDefaultCardParam() {
		setCard_type(Constants.优惠券.getValue());
	}

	/**
	 * @Description: 属性 general_coupon 的get方法 
	 * @return general_coupon
	 */
	public CreateDefaultCard getGeneral_coupon() {
		return general_coupon;
	}

	/**
	 * @Description: 属性 general_coupon 的set方法 
	 * @param general_coupon 
	 */
	public void setGeneral_coupon(CreateDefaultCard general_coupon) {
		this.general_coupon = general_coupon;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午2:54:51 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateDefaultCardParam [general_coupon=" + general_coupon + ", card_type=" + card_type + ", access_token=" + access_token + "]";
	}
	
}
