/**
* @Company 艾美伴行   
* @Title: CreateGrouponCardParam.java 
* @Package org.bana.wechat.mp.card.param.create 
* @author liuwenjie   
* @date 2016-6-15 上午11:05:50 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create.groupon;

import org.bana.wechat.mp.card.param.create.CreateCardParam;
import org.bana.wechat.mp.common.Constants;

/** 
 * @ClassName: CreateGrouponCardParam 
 * @Description: 团购券类型的创建参数 
 *  
 */
public class CreateGrouponCardParam extends CreateCardParam {

	private CreateGrouponCard groupon;
	
	/** 
	 * <p>Description: </p> 
	 * @author liuwenjie   
	 * @date 2016-6-15 上午11:06:27  
	 */
	public CreateGrouponCardParam() {
		setCard_type(Constants.团购券.getValue());
	}

	/**
	 * @Description: 属性 groupon 的get方法 
	 * @return groupon
	 */
	public CreateGrouponCard getGroupon() {
		return groupon;
	}

	/**
	 * @Description: 属性 groupon 的set方法 
	 * @param groupon 
	 */
	public void setGroupon(CreateGrouponCard groupon) {
		this.groupon = groupon;
	}

	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午2:58:22 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateGrouponCardParam [groupon=" + groupon + ", card_type=" + card_type + ", access_token=" + access_token + "]";
	}
	
}
