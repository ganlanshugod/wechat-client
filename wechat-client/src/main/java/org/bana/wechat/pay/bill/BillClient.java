/**
* @Company 青鸟软通   
* @Title: BillClient.java 
* @Package org.bana.wechat.pay.bill 
* @author Liu Wenjie   
* @date 2015-9-24 下午2:12:01 
* @version V1.0   
*/ 
package org.bana.wechat.pay.bill;

import java.util.HashMap;
import java.util.Map;

import org.bana.wechat.pay.bill.param.DownBillParam;
import org.bana.wechat.pay.common.Constants;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.common.WeChatConnection.ParamType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: BillClient 
 * @Description: 账单的客户端
 *  
 */
public class BillClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(BillClient.class);

	/** 
	* @Description: 下载bill账单的接口方法
	* @author Liu Wenjie   
	* @date 2015-9-24 下午2:13:03 
	* @param param  
	*/ 
	public static String downloadbill(DownBillParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = new HashMap<String, Object>();
		convertBean.put(WeChatConnection.XML_PARAM, param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.下载对账单.getValue(), convertBean,ParamType.XML);
		return result;
//		RefundQueryResult bean = BeanXmlUtil.xmlToBean(result, RefundQueryResult.class);
//		if(WeChatConnection.isSuccess(bean)){
//			LOG.info("获得的结果对象为" + result);
//			return bean;
//		}else{
//			String return_code = BanaWeChatException.PAY_ERROR_CODE;
//			String return_msg = "";
//			if(bean != null){
//				return_code = bean.getReturn_code();
//				return_msg = bean.getReturn_msg();
//			}
//			throw new BanaWeChatException(return_code, return_msg);
//		}
	}
}
