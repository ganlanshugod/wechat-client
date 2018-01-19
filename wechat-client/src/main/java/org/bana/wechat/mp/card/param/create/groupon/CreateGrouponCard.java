/**
* @Company 艾美伴行   
* @Title: CreateGrouponCard.java 
* @Package org.bana.wechat.mp.card.param.create.groupon 
* @author liuwenjie   
* @date 2016-6-15 下午2:57:31 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.groupon;

import org.bana.wechat.mp.card.param.create.BaseCard;

/** 
 * @ClassName: CreateGrouponCard 
 * @Description: 团购券参数
 *  
 */
public class CreateGrouponCard extends BaseCard{

	private String deal_detail;//	是	string(24)	双人套餐\n -进口红酒一支。\n孜然牛肉一份。	团购券专用，团购详情。

	/**
	 * @Description: 属性 deal_detail 的get方法 
	 * @return deal_detail
	 */
	public String getDeal_detail() {
		return deal_detail;
	}

	/**
	 * @Description: 属性 deal_detail 的set方法 
	 * @param deal_detail 
	 */
	public void setDeal_detail(String deal_detail) {
		this.deal_detail = deal_detail;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-16 下午9:25:12 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateGrouponCard [deal_detail=" + deal_detail + ", base_info=" + base_info + ", advanced_info=" + advanced_info + "]";
	}

}
