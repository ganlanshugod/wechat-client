/**
* @Company 艾美伴行   
* @Title: CreateCashCard.java 
* @Package org.bana.wechat.mp.card.param.create.cash 
* @author liuwenjie   
* @date 2016-6-15 下午2:49:43 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.cash;

import org.bana.wechat.mp.card.param.create.BaseCard;
import org.bana.wechat.mp.card.param.create.baseinfo.CreateCardBaseInfo;

/** 
 * @ClassName: CreateCashCard 
 * @Description: 代金券参数体
 *  
 */
public class CreateCashCard extends BaseCard{

	private int least_cost;//	是	int	10000	代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0。
	private int reduce_cost;//	是	int	10000	代金券专用，表示减免金额。（单位为分）
	/**
	 * @Description: 属性 base_info 的get方法 
	 * @return base_info
	 */
	public CreateCardBaseInfo getBase_info() {
		return base_info;
	}
	/**
	 * @Description: 属性 base_info 的set方法 
	 * @param base_info 
	 */
	public void setBase_info(CreateCardBaseInfo base_info) {
		this.base_info = base_info;
	}
	/**
	 * @Description: 属性 least_cost 的get方法 
	 * @return least_cost
	 */
	public int getLeast_cost() {
		return least_cost;
	}
	/**
	 * @Description: 属性 least_cost 的set方法 
	 * @param least_cost 
	 */
	public void setLeast_cost(int least_cost) {
		this.least_cost = least_cost;
	}
	/**
	 * @Description: 属性 reduce_cost 的get方法 
	 * @return reduce_cost
	 */
	public int getReduce_cost() {
		return reduce_cost;
	}
	/**
	 * @Description: 属性 reduce_cost 的set方法 
	 * @param reduce_cost 
	 */
	public void setReduce_cost(int reduce_cost) {
		this.reduce_cost = reduce_cost;
	}
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-16 下午9:23:09 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateCashCard [least_cost=" + least_cost + ", reduce_cost=" + reduce_cost + ", base_info=" + base_info + ", advanced_info=" + advanced_info + "]";
	}
	
}
