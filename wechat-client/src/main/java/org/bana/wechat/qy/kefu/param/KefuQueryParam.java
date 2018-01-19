/**
* @Company 艾美伴行  
* @Title: KefuQueryParam.java 
* @Package org.bana.wechat.qy.kefu.param 
* @author Yang Shuangshuang   
* @date 2016-5-10 下午3:44:30 
* @version V1.0   
*/ 
package org.bana.wechat.qy.kefu.param;

import org.bana.wechat.qy.common.WeChatParam;

/** 
 * @ClassName: KefuQueryParam 
 * @Description: 客服列表查询参数 
 *  
 */
public class KefuQueryParam extends WeChatParam {

	private String type; //客服类型
	
	/**
	* <p>Description: </p> 
	* @author Liu Wenjie   
	* @date 2015-5-27 下午9:09:39 
	* @return 
	* @see java.lang.Object#toString() 
	*/ 
	@Override
	public String toString() {
		return "KefuQueryParam [type=" + type +  ", access_token=" + access_token + "]";
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
}
