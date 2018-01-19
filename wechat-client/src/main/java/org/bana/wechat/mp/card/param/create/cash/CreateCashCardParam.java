/**
* @Company 艾美伴行   
* @Title: CreateCashCardParam.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 上午11:10:55 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.cash;

import org.bana.wechat.mp.card.param.create.CreateCardParam;
import org.bana.wechat.mp.common.Constants;

/** 
 * @ClassName: CreateCashCardParam 
 * @Description: 创建现金券参数 
 *  
 */
public class CreateCashCardParam extends CreateCardParam {
	
	private CreateCashCard cash ;
	
	/** 
	 * <p>Description: </p> 
	 * @author liuwenjie   
	 * @date 2016-6-15 上午11:12:01  
	 */
	public CreateCashCardParam() {
		setCard_type(Constants.代金券.getValue());
	}

	/**
	 * @Description: 属性 cash 的get方法 
	 * @return cash
	 */
	public CreateCashCard getCash() {
		return cash;
	}

	/**
	 * @Description: 属性 cash 的set方法 
	 * @param cash 
	 */
	public void setCash(CreateCashCard cash) {
		this.cash = cash;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午2:51:24 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateCashCardParam [cash=" + cash + ", card_type=" + card_type + ", access_token=" + access_token + "]";
	}
	
}
