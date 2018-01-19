/**
* @Company 艾美伴行   
* @Title: CreateDefaultCard.java 
* @Package org.bana.wechat.mp.card.param.create.defaultcard 
* @author liuwenjie   
* @date 2016-6-15 下午2:52:32 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.defaultcard;

import org.bana.wechat.mp.card.param.create.BaseCard;

/** 
 * @ClassName: CreateDefaultCard 
 * @Description: 优惠券的创建参数
 *  
 */
public class CreateDefaultCard extends BaseCard{

	private String default_detail;//	是	string(3072)	音乐木盒。	优惠券专用，填写优惠详情。；

	/**
	 * @Description: 属性 default_detail 的get方法 
	 * @return default_detail
	 */
	public String getDefault_detail() {
		return default_detail;
	}

	/**
	 * @Description: 属性 default_detail 的set方法 
	 * @param default_detail 
	 */
	public void setDefault_detail(String default_detail) {
		this.default_detail = default_detail;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-16 下午9:23:57 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateDefaultCard [default_detail=" + default_detail + ", base_info=" + base_info + ", advanced_info=" + advanced_info + "]";
	}

}
