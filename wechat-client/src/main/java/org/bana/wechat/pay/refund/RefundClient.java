/**
* @Company 青鸟软通   
* @Title: RefundClient.java 
* @Package org.bana.wechat.pay.refund 
* @author Liu Wenjie   
* @date 2015-9-23 下午3:36:57 
* @version V1.0   
*/ 
package org.bana.wechat.pay.refund;

import java.util.HashMap;
import java.util.Map;

import org.bana.common.util.basic.BeanXmlUtil;
import org.bana.wechat.pay.common.Constants;
import org.bana.wechat.pay.refund.param.RefundParam;
import org.bana.wechat.pay.refund.param.RefundQueryParam;
import org.bana.wechat.pay.refund.result.RefundQueryResult;
import org.bana.wechat.pay.refund.result.RefundResult;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.common.WeChatConnection.HttpType;
import org.bana.wechat.qy.common.WeChatConnection.ParamType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: RefundClient 
 * @Description: 退款相关的接口
 *  
 */
public class RefundClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(RefundClient.class);

	/** 
	* @Description: 申请退款
	* @author Liu Wenjie   
	* @date 2015-9-24 上午10:55:28 
	* @param param
	* @param certLocalPath
	* @param certPassword
	* @return  
	*/ 
	public static RefundResult refund(RefundParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = new HashMap<String, Object>();
		convertBean.put(WeChatConnection.XML_PARAM, param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.申请退款.getValue(), convertBean,ParamType.XML,HttpType.HTTPS);
		RefundResult bean = BeanXmlUtil.xmlToBean(result, RefundResult.class);
		if(WeChatConnection.isSuccess(bean)){
			LOG.info("获得的结果对象为" + result);
			return bean;
		}else{
			String return_code = BanaWeChatException.PAY_ERROR_CODE;
			String return_msg = "";
			if(bean != null){
				return_code = bean.getReturn_code();
				return_msg = bean.getReturn_msg();
			}
			throw new BanaWeChatException(return_code, return_msg);
		}
	}
	
	/** 
	* @Description: 查询退款的方法
	* @author Liu Wenjie   
	* @date 2015-9-24 下午12:04:08 
	* @return  
	*/ 
	public static RefundQueryResult queryRefund(RefundQueryParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = new HashMap<String, Object>();
		convertBean.put(WeChatConnection.XML_PARAM, param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.查询退款.getValue(), convertBean,ParamType.XML);
		RefundQueryResult bean = BeanXmlUtil.xmlToBean(result, RefundQueryResult.class);
		if(WeChatConnection.isSuccess(bean)){
			LOG.info("获得的结果对象为" + result);
			return bean;
		}else{
			String return_code = BanaWeChatException.PAY_ERROR_CODE;
			String return_msg = "";
			if(bean != null){
				return_code = bean.getReturn_code();
				return_msg = bean.getReturn_msg();
			}
			throw new BanaWeChatException(return_code, return_msg);
		}
	}
	
}
