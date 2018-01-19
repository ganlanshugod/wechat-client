/**
* @Company 艾美伴行   
* @Title: UseCondition.java 
* @Package org.bana.wechat.mp.card.param.create.avancedinfo 
* @author liuwenjie   
* @date 2016-6-15 下午3:04:09 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.avancedinfo;

/** 
 * @ClassName: UseCondition 
 * @Description: 使用门槛
 *  
 */
public class UseCondition {

	private String accept_category;//	指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写指定xx可用	否
	private String reject_category;//	指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写指定xx不可用。	是
	private Integer least_cost;//	满减门槛字段，可用于兑换券和代金券，填入后将在全面拼写消费满xx元可用。	是
	private String object_use_for;//	购买xx可用类型门槛，仅用于兑换，填入后自动拼写购买xxx可用。	是
	private Boolean can_use_with_other_discount;//	不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写不可与其他优惠共享，默认为true	是
	/**
	 * @Description: 属性 accept_category 的get方法 
	 * @return accept_category
	 */
	public String getAccept_category() {
		return accept_category;
	}
	/**
	 * @Description: 属性 accept_category 的set方法 
	 * @param accept_category 
	 */
	public void setAccept_category(String accept_category) {
		this.accept_category = accept_category;
	}
	/**
	 * @Description: 属性 reject_category 的get方法 
	 * @return reject_category
	 */
	public String getReject_category() {
		return reject_category;
	}
	/**
	 * @Description: 属性 reject_category 的set方法 
	 * @param reject_category 
	 */
	public void setReject_category(String reject_category) {
		this.reject_category = reject_category;
	}
	/**
	 * @Description: 属性 least_cost 的get方法 
	 * @return least_cost
	 */
	public Integer getLeast_cost() {
		return least_cost;
	}
	/**
	 * @Description: 属性 least_cost 的set方法 
	 * @param least_cost 
	 */
	public void setLeast_cost(Integer least_cost) {
		this.least_cost = least_cost;
	}
	/**
	 * @Description: 属性 object_use_for 的get方法 
	 * @return object_use_for
	 */
	public String getObject_use_for() {
		return object_use_for;
	}
	/**
	 * @Description: 属性 object_use_for 的set方法 
	 * @param object_use_for 
	 */
	public void setObject_use_for(String object_use_for) {
		this.object_use_for = object_use_for;
	}
	/**
	 * @Description: 属性 can_use_with_other_discount 的get方法 
	 * @return can_use_with_other_discount
	 */
	public Boolean getCan_use_with_other_discount() {
		return can_use_with_other_discount;
	}
	/**
	 * @Description: 属性 can_use_with_other_discount 的set方法 
	 * @param can_use_with_other_discount 
	 */
	public void setCan_use_with_other_discount(Boolean can_use_with_other_discount) {
		this.can_use_with_other_discount = can_use_with_other_discount;
	}
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午3:10:22 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "UseCondition [accept_category=" + accept_category + ", reject_category=" + reject_category + ", least_cost=" + least_cost + ", object_use_for=" + object_use_for
				+ ", can_use_with_other_discount=" + can_use_with_other_discount + "]";
	}

	
}
