/**
* @Company 青鸟软通   
* @Title: BasePayTestCase.java 
* @Package org.bana.wechat 
* @author Liu Wenjie   
* @date 2015-9-17 下午6:53:35 
* @version V1.0   
*/ 
package org.bana.wechat;

import org.bana.common.util.basic.StringUtils;
import org.bana.wechat.pay.common.WechatPayParam;

/** 
 * @ClassName: BasePayTestCase 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 *  
 */
public class BasePayTestCase {

	protected String appId = "wx9ea95f1dc1ba973f"; 
	
	protected String mch_id = "1265342501";
	
	protected String apiKey = "6ae764186a5eb74c649526dd59330114";
	
	protected String secret = "361f8886c4fe4f178e772eac6c7f1c65";
	
	protected String certPassword = "1265342501";
	
	protected void initPayParam (WechatPayParam param){
		param.setAppid(appId);
		param.setMch_id(mch_id);
		param.setNonce_str(StringUtils.getRandomStr());
	}
}
