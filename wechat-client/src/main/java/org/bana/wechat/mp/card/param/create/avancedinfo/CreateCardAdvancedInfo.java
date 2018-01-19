/**
* @Company 艾美伴行   
* @Title: CreateCardAdvancedInfo.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 下午2:37:10 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.avancedinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @ClassName: CreateCardAdvancedInfo 
 * @Description: 高级配置信息
 *  
 */
public class CreateCardAdvancedInfo {

	private UseCondition use_condition;//	使用门槛（条件）字段	否
	//	private String abstract	;//封面摘要结构体名称	是
	private AbstractObject abstractObject;
	private List<TextImage> text_image_list;//	图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表	是
	private List<String> business_service;//	商家服务类型： BIZ_SERVICE_DELIVER;外卖服务；BIZ_SERVICE_FREE_PARK 停车位；BIZ_SERVICE_WITH_PET 可带宠物；BIZ_SERVICE_FREE_WIFI 免费wifi，可多选

	private TimeLimit time_limit;//	使用时段限制	否
	
	public Map<String,Object> toMap(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("use_condition", use_condition);
		map.put("abstract", abstractObject.toMap());
		map.put("text_image_list", text_image_list);
		map.put("business_service", business_service);
		map.put("time_limit", time_limit);
		return map;
	}

	/**
	 * @Description: 属性 use_condition 的get方法 
	 * @return use_condition
	 */
	public UseCondition getUse_condition() {
		return use_condition;
	}

	/**
	 * @Description: 属性 use_condition 的set方法 
	 * @param use_condition 
	 */
	public void setUse_condition(UseCondition use_condition) {
		this.use_condition = use_condition;
	}

	/**
	 * @Description: 属性 text_image_list 的get方法 
	 * @return text_image_list
	 */
	public List<TextImage> getText_image_list() {
		return text_image_list;
	}

	/**
	 * @Description: 属性 text_image_list 的set方法 
	 * @param text_image_list 
	 */
	public void setText_image_list(List<TextImage> text_image_list) {
		this.text_image_list = text_image_list;
	}

	/**
	 * @Description: 属性 business_service 的get方法 
	 * @return business_service
	 */
	public List<String> getBusiness_service() {
		return business_service;
	}

	/**
	 * @Description: 属性 business_service 的set方法 
	 * @param business_service 
	 */
	public void setBusiness_service(List<String> business_service) {
		this.business_service = business_service;
	}

	/**
	 * @Description: 属性 time_limit 的get方法 
	 * @return time_limit
	 */
	public TimeLimit getTime_limit() {
		return time_limit;
	}

	/**
	 * @Description: 属性 time_limit 的set方法 
	 * @param time_limit 
	 */
	public void setTime_limit(TimeLimit time_limit) {
		this.time_limit = time_limit;
	}

	/**
	 * @Description: 属性 abstractObject 的get方法 
	 * @return abstractObject
	 */
	public AbstractObject getAbstractObject() {
		return abstractObject;
	}

	/**
	 * @Description: 属性 abstractObject 的set方法 
	 * @param abstractObject 
	 */
	public void setAbstractObject(AbstractObject abstractObject) {
		this.abstractObject = abstractObject;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午3:09:26 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateCardAdvancedInfo [use_condition=" + use_condition + ", text_image_list=" + text_image_list + ", business_service=" + business_service + ", time_limit="
				+ time_limit + "]";
	}
	
	
}
