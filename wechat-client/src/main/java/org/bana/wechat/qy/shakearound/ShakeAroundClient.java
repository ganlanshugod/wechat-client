/**
* @Company 青鸟软通   
* @Title: ShakeAroundClient.java 
* @Package org.bana.wechat.qy.shakearound 
* @author Liu Wenjie   
* @date 2015-9-16 上午11:38:08 
* @version V1.0   
*/ 
package org.bana.wechat.qy.shakearound;

import java.util.HashMap;
import java.util.Map;

import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.wechat.cp.common.Constants;
import org.bana.wechat.qy.common.BanaWeChatException;
import org.bana.wechat.qy.common.WeChatConnection;
import org.bana.wechat.qy.shakearound.domain.BeaconInfo;
import org.bana.wechat.qy.shakearound.domain.ShakeInfoDomain;
import org.bana.wechat.qy.shakearound.param.GetShakeInfoParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/** 
 * @ClassName: ShakeAroundClient 
 * @Description: 摇一摇周边的接口
 *  
 */
public class ShakeAroundClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(ShakeAroundClient.class);

	/** 
	* @Description: 获取shakeInfo
	* @author Liu Wenjie   
	* @date 2015-9-16 上午11:50:13 
	* @param param
	* @return  
	*/ 
	public static ShakeInfoDomain getShakeInfo(GetShakeInfoParam param){
		// 转化为Map对象
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(param);
		// 访问微信接口得到json返回值对象
		String result = WeChatConnection.post(Constants.获取摇周边的设备及用户信息.getValue(), convertBean);
		// 将结果进行转换
		JSONObject json = JSONObject.fromObject(result);
		if (WeChatConnection.isSuccess(json)) {
			JsonConfig config = new JsonConfig();
			config.setRootClass(ShakeInfoDomain.class);
			Map<String,Object> classMap = new HashMap<String, Object>();
			classMap.put("beacon_info",BeaconInfo.class);
			config.setClassMap(classMap);
			ShakeInfoDomain bean = (ShakeInfoDomain)JSONObject.toBean(json.getJSONObject("data"), config);
			LOG.info("获取摇周边的设备及用户信息的返回值 为  " + bean);
			return bean;
		} else {
			String errcode = json.getString(Constants.返回码.getValue());
			String errmsg = json.getString(Constants.返回信息.getValue());
			throw new BanaWeChatException(errcode, errmsg);
		}
	}
	
}
