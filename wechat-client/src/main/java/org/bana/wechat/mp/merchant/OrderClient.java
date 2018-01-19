/**
* @Company 艾美伴行   
* @Title: OrderClient.java 
* @Package org.bana.wechat.mp.merchant 
* @author liuwenjie   
* @date 2016-6-16 下午7:00:09 
* @version V1.0   
*/ 
package org.bana.wechat.mp.merchant;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.bana.wechat.mp.common.Constants;
import org.bana.wechat.mp.merchant.domain.Order;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: OrderClient 
 * @Description: 订单的接口
 *  
 */
public class OrderClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderClient.class);

	/** 
	* @Description: 根据订单id获取订单详情
	* @author liuwenjie   
	* @date 2016-6-16 下午7:05:15 
	* @param token
	* @param orderId
	* @return  
	*/ 
	public static Order getById(String token,String orderId){
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("access_token", token);
		paramMap.put("order_id", orderId);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.获取订单详情接口.getValue(), paramMap);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			Order order = (Order)JSONObject.toBean(json.getJSONObject("order"), Order.class);
			LOG.info("获取的订单详情为" + order);
			return order;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
}
