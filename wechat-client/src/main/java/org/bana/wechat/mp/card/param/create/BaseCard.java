/**
* @Company 艾美伴行   
* @Title: BaseCard.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-16 下午9:22:00 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create;

import java.util.Map;

import org.bana.wechat.mp.card.param.create.baseinfo.CreateCardBaseInfo;

/** 
 * @ClassName: BaseCard 
 * @Description: 
 *  
 */
public class BaseCard {

	protected CreateCardBaseInfo base_info; 
	protected Map<String,Object> advanced_info;
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
	 * @Description: 属性 advanced_info 的get方法 
	 * @return advanced_info
	 */
	public Map<String, Object> getAdvanced_info() {
		return advanced_info;
	}
	/**
	 * @Description: 属性 advanced_info 的set方法 
	 * @param advanced_info 
	 */
	public void setAdvanced_info(Map<String, Object> advanced_info) {
		this.advanced_info = advanced_info;
	}
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-16 下午9:22:32 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "BaseCard [base_info=" + base_info + ", advanced_info=" + advanced_info + "]";
	}
	
	
	
}
