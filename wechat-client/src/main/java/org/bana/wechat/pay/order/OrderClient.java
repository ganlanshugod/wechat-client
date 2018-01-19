/**
* @Company 青鸟软通   
* @Title: OrderClient.java 
* @Package org.bana.wechat.pay.order 
* @author Liu Wenjie   
* @date 2015-9-22 下午9:27:08 
* @version V1.0   
*/ 
package org.bana.wechat.pay.order;

import java.util.HashMap;
import java.util.Map;

import org.bana.common.util.basic.BeanXmlUtil;
import org.bana.wechat.pay.common.Constants;
import org.bana.wechat.pay.order.domain.CloseOrderResult;
import org.bana.wechat.pay.order.domain.OrderQueryDomain;
import org.bana.wechat.pay.order.domain.UnifiedOrderDomain;
import org.bana.wechat.pay.order.param.CloseOrderParam;
import org.bana.wechat.pay.order.param.OrderQueryParam;
import org.bana.wechat.pay.order.param.UnifiedOrderParam;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.common.WeChatConnection.ParamType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: OrderClient 
 * @Description: 订单相关的接口方法
 *  
 */
public class OrderClient {

	private static final Logger LOG = LoggerFactory.getLogger(OrderClient.class);
	/** 
	* @Description: 调用微信支付的统一下单接口
	* @author Liu Wenjie   
	* @date 2015-9-17 下午5:45:43 
	* @param param
	* @return  
	*/ 
	public static UnifiedOrderDomain unifiedOrder(UnifiedOrderParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = new HashMap<String, Object>();
		convertBean.put(WeChatConnection.XML_PARAM, param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.统一下单.getValue(), convertBean,ParamType.XML);
		UnifiedOrderDomain bean = BeanXmlUtil.xmlToBean(result, UnifiedOrderDomain.class);
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
	* @Description: 獲取微信訂單信息
	* @author Liu Wenjie   
	* @date 2015-9-22 下午8:54:55 
	* @param param
	* @return  
	*/ 
	public static OrderQueryDomain queryOrder(OrderQueryParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = new HashMap<String, Object>();
		convertBean.put(WeChatConnection.XML_PARAM, param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.查看订单.getValue(), convertBean,ParamType.XML);
		OrderQueryDomain bean = BeanXmlUtil.xmlToBean(result, OrderQueryDomain.class);
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
	* @Description: 关闭订单的接口
	* @author Liu Wenjie   
	* @date 2015-9-22 下午9:23:21 
	* @param param
	* @return  
	*/ 
	public static CloseOrderResult closeOrder(CloseOrderParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = new HashMap<String, Object>();
		convertBean.put(WeChatConnection.XML_PARAM, param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.关闭订单.getValue(), convertBean,ParamType.XML);
		CloseOrderResult bean = BeanXmlUtil.xmlToBean(result, CloseOrderResult.class);
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
