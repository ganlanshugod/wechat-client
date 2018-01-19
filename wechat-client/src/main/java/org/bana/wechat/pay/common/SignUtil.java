/**
* @Company 青鸟软通   
* @Title: SignUtil.java 
* @Package org.bana.wechat.pay.common 
* @author Liu Wenjie   
* @date 2015-9-17 下午7:58:19 
* @version V1.0   
*/ 
package org.bana.wechat.pay.common;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.bana.common.util.basic.BeanToMapUtil;
import org.bana.common.util.basic.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: SignUtil 
 * @Description: 生成签名的工具类
 *  
 */
public class SignUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(SignUtil.class);

	/** 
	* @Description: 根据参数生成签名
	* @author Liu Wenjie   
	* @date 2015-9-17 下午7:59:19 
	* @param params
	* @return  
	*/ 
	public static String getSign(Object params,String apiKey){
		Map<String, Object> convertBean = BeanToMapUtil.convertBean(params);
		return getSign(convertBean, apiKey);
	}
	
	
	/** 
	* @Description: 根据Map 获取附件签名
	* @author Liu Wenjie   
	* @date 2015-9-22 下午2:33:29 
	* @param params
	* @param apiKey
	* @return  
	*/ 
	public static String getSign(Map<String, Object> convertBean,String apiKey){
		Set<String> keySet = convertBean.keySet();
		String[] a = new String[keySet.size()];
		String[] array = keySet.toArray(a);
		Arrays.sort(array);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			String key = array[i];
			Object object = convertBean.get(key);
			if(object != null){
				if(!(object instanceof String) || !StringUtils.isEmpty((String)object)){
					sb.append(key).append("=").append(object).append("&");
				}
			}
		}
		sb.append("key=").append(apiKey);
		LOG.info("加密前拼接的字符串为：" + sb.toString());
		String md5 = MD5Util.getMD5(sb.toString());
		return md5.toUpperCase();
	}
}
