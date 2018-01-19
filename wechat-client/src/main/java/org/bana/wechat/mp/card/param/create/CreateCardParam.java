/**
* @Company 艾美伴行   
* @Title: CreateCardParam.java 
* @Package org.bana.wechat.mp.card.param 
* @author liuwenjie   
* @date 2016-6-15 上午10:29:41 
* @version V1.0   
*/ 
package org.bana.wechat.mp.card.param.create;

import org.bana.wechat.mp.common.WeChatMpParam;

/** 
 * @ClassName: CreateCardParam 
 * @Description: 创建卡券的通用参数对象
 *  
 */
public class CreateCardParam extends WeChatMpParam {

	protected String card_type;
	
	/**
	 * @Description: 属性 card_type 的get方法 
	 * @return card_type
	 */
	public String getCard_type() {
		return card_type;
	}

	/**
	 * @Description: 属性 card_type 的set方法 
	 * @param card_type 
	 */
	protected void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	
	/**
	* Description: 
	* @author liuwenjie   
	* @date 2016-6-15 下午2:11:35 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "CreateCardParam [card_type=" + card_type + ", access_token=" + access_token + "]";
	}

}
